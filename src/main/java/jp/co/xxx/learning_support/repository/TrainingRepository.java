package jp.co.xxx.learning_support.repository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import jp.co.xxx.learning_support.domain.Training;

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
		
		
		return null;
	};
	
	public List<Training> findAll(Integer companyId){
		String sql = "SELECT FROM trainings tr INNER JOIN training_students ts ON";
		
		return null;
	}
	
	public Training insert(Training training) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(training);
		Number key = insert.executeAndReturnKey(param);
		training.setId(key.intValue());
		return training;
	}
	
}
