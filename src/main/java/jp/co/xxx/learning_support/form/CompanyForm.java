package jp.co.xxx.learning_support.form;

public class CompanyForm {

	private String name;
	private String remarks;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "CompanyForm [name=" + name + ", remarks=" + remarks + "]";
	}
}
