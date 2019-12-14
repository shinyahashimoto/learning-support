package jp.co.xxx.learning_support.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.co.xxx.learning_support.domain.Instructor;

public class InstructorRepository {

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

	
	
	
}
