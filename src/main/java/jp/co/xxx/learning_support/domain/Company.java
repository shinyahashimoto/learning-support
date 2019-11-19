package jp.co.xxx.learning_support.domain;

public class Company {

	private Integer id;
	private String name;
	private String kana;
	private String remarks;
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", kana=" + kana + ", remarks=" + remarks + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKana() {
		return kana;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
