package jp.co.xxx.learning_support.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.xxx.learning_support.domain.Instructor;
import jp.co.xxx.learning_support.domain.WeeklyReport;

/**
 * 講師情報を操作するリポジトリクラス.
 * 
 * @author hiraokayuri
 *
 */
@Repository
public class InstructorRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Instructor> INSTRUCTOR_ROW_MAPPER = (rs, i) -> {
		Instructor instructor = new Instructor();
		instructor.setId(rs.getInt("id"));
		instructor.setName(rs.getString("name"));
		instructor.setKane(rs.getString("kana"));
		instructor.setEmail(rs.getString("email"));
		instructor.setPassword(rs.getString("password"));
		instructor.setAffiliation(rs.getString("affiliation"));
		instructor.setRemarks(rs.getString("remarks"));
		
		return instructor;
	};

	
	public List<Instructor> findAll(){
		String sql = "SELECT id, name, kana, email, password, affiliation, remarks FROM instructors ORDER BY id DESC";
		return template.query(sql, INSTRUCTOR_ROW_MAPPER);
	}

	public void insert(Instructor instructor) {
		String sql = "INSERT INTO instructors(name, email, password, affiliation, remarks) VALUES(:name, :email, 'kari', :affiliation, :remarks)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(instructor);
		template.update(sql, param);
	}
	
	public Instructor findByEmailAndPassword(String email, String password) {
		String sql = "SELECT * FROM instructors WHERE email = :email, password = :password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password", password);
		List<Instructor> instructorList = template.query(sql, param, INSTRUCTOR_ROW_MAPPER);
		if (instructorList == null) {
			return null;
		}
		return instructorList.get(0);
	}
	
	public void save(Instructor instructor) {
		String sql = "UPDATE instructors SET password = :password WHERE email = :email";
		SqlParameterSource param = new BeanPropertySqlParameterSource(instructor);
		template.update(sql, param);
	}

	
}
