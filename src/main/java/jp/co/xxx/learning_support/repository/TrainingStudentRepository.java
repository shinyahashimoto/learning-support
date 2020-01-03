package jp.co.xxx.learning_support.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TrainingStudentRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public void insert(Integer trainingId, Integer studentId) {
		String sql = "INSERT INTO training_student(training_id, student_id) VALUES(:trainingId, :studentId)";
		SqlParameterSource param = new MapSqlParameterSource().addValue("trainingId", trainingId).addValue("studentId", studentId);
		template.update(sql, param);
	}
}
