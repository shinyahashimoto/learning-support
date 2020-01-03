package jp.co.xxx.learning_support.form;

public class InstructorForm {

	private String name;
	private String email;
	private String affiliation;
	private String remarks;

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

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "InstructorForm [name=" + name + ", email=" + email + ", affiliation=" + affiliation + ", remarks="
				+ remarks + "]";
	}

}
