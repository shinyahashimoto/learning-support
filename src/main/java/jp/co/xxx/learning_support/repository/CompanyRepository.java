package jp.co.xxx.learning_support.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.xxx.learning_support.domain.Company;
import jp.co.xxx.learning_support.domain.CompanyMember;

@Repository
public class CompanyRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public static final ResultSetExtractor<List<Company>> COMPANY_EXTRACTOR = (rs) -> {
		int preId = 0;
		List<Company> companyList = new ArrayList<>();
		List<CompanyMember> companyMemberList = null;
		
		while(rs.next()) {
			if(rs.getInt("id") != preId) {
				Company company = new Company();
				company.setId(rs.getInt("id"));
				company.setName(rs.getString("name"));
				company.setKana(rs.getString("kana"));
				company.setRemarks(rs.getString("remarks"));
				companyMemberList = new ArrayList<>();
				company.setCompanyMemberList(companyMemberList);
				companyList.add(company);
				preId = company.getId();

			}
			if(rs.getInt("cm_company_id") != 0) {
				CompanyMember companyMember = new CompanyMember();
				companyMember.setId(rs.getInt("cm_id"));
				companyMember.setName(rs.getString("cm_name"));
				companyMember.setKana(rs.getString("cm_kana"));
				companyMember.setEmail(rs.getString("cm_email"));
				companyMember.setPassword(rs.getString("cm_password"));
				companyMember.setCompanyId(rs.getInt("cm_company_id"));
				companyMemberList.add(companyMember);
			}
		}
		return companyList;
	};
	
	public void insert(Company company) {
		String sql = "INSERT INTO companies(name, remarks) VALUES(:name, :remarks)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(company);
		template.update(sql, param);
	}
	
	public List<Company> findAll(){
		String sql = "SELECT c.id, c.name, c.kana, c.remarks, cm.id AS cm_id, cm.name AS cm_name, cm.kana AS cm_kana, cm.email AS cm_email, cm.password AS cm_password, cm.company_id AS cm_company_id FROM companies AS c LEFT JOIN company_members cm ON c.id = cm.company_id ORDER BY c.id DESC";
		return template.query(sql, COMPANY_EXTRACTOR);
	}
	
}
