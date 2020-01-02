package jp.co.xxx.learning_support.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.xxx.learning_support.domain.CompanyMember;


@Repository
public class CompanyMemberRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public static final RowMapper<CompanyMember> COMPANY_MEMBER_ROW_MAPPER = (rs, i) -> {
		CompanyMember companyMember = new CompanyMember();
		companyMember.setId(rs.getInt("id"));
		companyMember.setName(rs.getString("name"));
		companyMember.setKana(rs.getString("kana"));
		companyMember.setEmail(rs.getString("email"));
		companyMember.setPassword(rs.getString("password"));
		companyMember.setCompanyId(rs.getInt("company_id"));

		return companyMember;
	};
	
	public CompanyMember findByEmail(String email) {
		String sql = "select id, name, kana, email, password, company_id from company_members where email = :email";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		List<CompanyMember> companyMemberList = template.query(sql, param, COMPANY_MEMBER_ROW_MAPPER);
		if (companyMemberList.isEmpty()) {
			return null;
		}
		return companyMemberList.get(0);
	}

	public CompanyMember findByEmailAndPassword(String email, String password) {
		String sql = "select id, name, kana, email, password, company_id from company_members where email = :email and password = :password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password", password);
		List<CompanyMember> companyMemberList = template.query(sql, param, COMPANY_MEMBER_ROW_MAPPER);
		if (companyMemberList.isEmpty()) {
			return null;
		}
		return companyMemberList.get(0);
	}
	
	public void insert(CompanyMember companyMember) {
		String sql = "INSERT INTO company_members(name, email, password, company_id) VALUES(:name, :email , 'temporary', :companyId)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(companyMember);
		template.update(sql, param);
	}
}
