package jp.co.xxx.learning_support.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.xxx.learning_support.domain.Student;

/**
 * 受講者情報を操作するリポジトリクラス.
 * 
 * @author hiraokayuri
 *
 */
@Repository
public class StudentRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	
	
	
	
	/**
	 * 受講者情報を登録する.
	 * 
	 * @param student 受講者
	 */
	public void registerStudent(Student student) {
		String sql = "INSERT INTO students(name,kana,email,password,company_id)VALUE(:name,:kana,:email,:password,:companyId)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(student);
		template.update(sql, param);
	}
}
	

