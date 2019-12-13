package jp.co.xxx.learning_support.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.xxx.learning_support.domain.Admin;

@Repository
public class AdminRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Admin> ADMIN_ROW_MAPPER = (rs,i) -> {
		Admin admin = new Admin();
		admin.setId(rs.getInt("id"));
		admin.setName(rs.getString("name"));
		admin.setKana(rs.getString("kana"));
		admin.setEmail(rs.getString("email"));
		admin.setPassword(rs.getString("password"));
		admin.setCanShowAllCompany(rs.getBoolean("can_show_all_company"));
		
		return admin;
	};
	
	
	public void save(Admin admin) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(admin);
		
		if(admin.getId() == 0) {
			String insertSql = "insert into admins(id,name,kana,email,password,can_show_all_company) values(:id,:name,:kana,:email,:password,:can_show_all_company)";
			template.update(insertSql, param);
		}else {
			String updateSql="update from admins id=:id,name=:name,kana=:kana,email=:email,password=:password,can_show_all_company=:canShowAllCompany";
			template.update(updateSql, param);
		}
	}
}
