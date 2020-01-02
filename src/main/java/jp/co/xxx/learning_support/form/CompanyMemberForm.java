package jp.co.xxx.learning_support.form;

public class CompanyMemberForm {

	private String name;
	private String email;
	private Integer companyId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	@Override
	public String toString() {
		return "CompanyMemberForm [name=" + name + ", email=" + email + ", companyId=" + companyId + "]";
	}
	
}
