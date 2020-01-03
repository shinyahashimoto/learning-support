package jp.co.xxx.learning_support.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import jp.co.xxx.learning_support.domain.Instructor;
import jp.co.xxx.learning_support.domain.Student;
import jp.co.xxx.learning_support.domain.Training;
import jp.co.xxx.learning_support.domain.TrainingStudent;

@Repository
public class TrainingRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private SimpleJdbcInsert insert;
	
	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("trainings");
		insert = withTableName.usingGeneratedKeyColumns("id");
	}
	
	public static final ResultSetExtractor<List<Training>> TRAINING_EXTRACTOR = (rs) -> {
		Integer preId = null;
		List<Training> trainingList = new LinkedList<Training>();
		List<Student> studentList = null;
		
		while(rs.next()) {
//			if(preId != rs.getInt("id")) {
				Training training = new Training();
//				training.setId(rs.getInt("id"));
				training.setStartDate(rs.getDate("start_date").toLocalDate());
				training.setEndDate(rs.getDate("end_date").toLocalDate());
				training.setName(rs.getString("name"));
				training.setInstructorId(rs.getInt("instructor_id"));
				training.setSubInstructorId1(rs.getInt("sub_instructor_id1"));
				training.setSubInstructorId2(rs.getInt("sub_instructor_id2"));
				training.setStudentList(studentList);
				
				Instructor instructor = new Instructor();
				instructor.setId(rs.getInt("ins_id"));
				instructor.setName(rs.getString("ins_name"));
				instructor.setEmail(rs.getString("ins_email"));
				instructor.setPassword(rs.getString("ins_password"));
				instructor.setAffiliation(rs.getString("affiliation"));
				instructor.setRemarks(rs.getString("remarks"));
				training.setInstructor(instructor);

				trainingList.add(training);
				
//				preId = rs.getInt("id");
//			}
			
			if(rs.getInt("ts_training_id") != 0) {
				TrainingStudent trainingStudent = new TrainingStudent();
				trainingStudent.setTrainingId(rs.getInt("ts_training_id"));
				trainingStudent.setStudentId(rs.getInt("ts_student_id"));
			}
			
			if(rs.getInt("st_id") != 0) {
				Student student = new Student();
				student.setId(rs.getInt("st_id"));
				student.setName(rs.getString("st_name"));
				student.setEmail(rs.getString("st_email"));
				student.setPassword(rs.getString("st_password"));
				student.setCompanyId(rs.getInt("st_company_id"));
				student.setTrainignList(trainingList);
				
				studentList = new ArrayList<>();
				studentList.add(student);
			}
		}
		return trainingList;
	};
	
	public List<Training> findAll(Integer companyId){
		String sql = "SELECT" + 
				" tr.id, tr.start_date, tr.end_date, tr.name, tr.instructor_id, tr.sub_instructor_id1, tr.sub_instructor_id2," + 
				" ins.id AS ins_id, ins.name AS ins_name, ins.email AS ins_email, ins.password AS ins_password, ins.affiliation, ins.remarks," + 
				" ts.training_id AS ts_training_id, ts.student_id AS ts_student_id," + 
				" st.id AS st_id, st.name AS st_name, st.email AS st_email, st.password AS st_password, st.company_id AS st_company_id" + 
				" FROM trainings tr" + 
				" INNER JOIN training_student ts ON tr.id = ts.training_id" + 
				" INNER JOIN students st ON ts.student_id = st.id" + 
				" INNER JOIN instructors ins ON tr.instructor_id = ins.id" + 
				" WHERE st.company_id = :companyId";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("companyId", companyId);
		return template.query(sql, param, TRAINING_EXTRACTOR);
	}
	
	public Training insert(Training training) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(training);
		Number key = insert.executeAndReturnKey(param);
		training.setId(key.intValue());
		return training;
	}
	
}
