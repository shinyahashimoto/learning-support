package jp.co.xxx.learning_support.domain;

public class Instructor {

	/** 講師ID */
	private Integer id;
	/** 氏名 */
	private String name;
	/** かな */
	private String kane;
	/** メールアドレス */
	private String email;
	/** パスワード */
	private String password;
	/** 所属 */
	private String affiliation;
	/** 備考 */
	private String remarks;

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

	public String getKane() {
		return kane;
	}

	public void setKane(String kane) {
		this.kane = kane;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Instructor [id=" + id + ", name=" + name + ", kane=" + kane + ", email=" + email + ", password="
				+ password + ", affiliation=" + affiliation + ", remarks=" + remarks + "]";
	}

}
