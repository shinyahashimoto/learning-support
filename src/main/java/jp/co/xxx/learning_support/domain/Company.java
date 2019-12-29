package jp.co.xxx.learning_support.domain;

import java.util.List;

public class Company {

	/** 企業ID */
	private Integer id;
	/** 企業名 */
	private String name;
	/** かな */
	private String kana;
	/** 備考 */
	private String remarks;
	/** 企業担当者リスト */
	private List<CompanyMember> companyMemberList;
	
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", kana=" + kana + ", remarks=" + remarks
				+ ", companyMemberList=" + companyMemberList + "]";
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
	public List<CompanyMember> getCompanyMemberList() {
		return companyMemberList;
	}
	public void setCompanyMemberList(List<CompanyMember> companyMemberList) {
		this.companyMemberList = companyMemberList;
	}



}