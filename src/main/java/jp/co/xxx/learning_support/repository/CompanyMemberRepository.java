package jp.co.xxx.learning_support.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.co.xxx.learning_support.domain.CompanyMember;

public class CompanyMemberRepository {
	
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

	
	
}
