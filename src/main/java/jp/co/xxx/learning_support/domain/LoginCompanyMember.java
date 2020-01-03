package jp.co.xxx.learning_support.domain;

import java.util.Collection;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

public class LoginCompanyMember extends User{

	private static final long serialVersionUID = 1L;
	private final CompanyMember companyMember;
	
	/**
	 * 通常の管理者情報に加え、認可用ロールを設定する。
	 * 
	 * @param User　管理者情報
	 * @param authorityList 権限情報が入ったリスト
	 */
	public LoginCompanyMember(CompanyMember companyMember, Collection<GrantedAuthority> authorityList) {
		super(companyMember.getEmail(), companyMember.getPassword(), authorityList);
		this.companyMember = companyMember;
	}

	public CompanyMember getCompanyMember() {
		return companyMember;
	}
}