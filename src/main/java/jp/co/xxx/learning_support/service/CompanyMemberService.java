package jp.co.xxx.learning_support.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.xxx.learning_support.domain.CompanyMember;
import jp.co.xxx.learning_support.repository.CompanyMemberRepository;

@Service
@Transactional
public class CompanyMemberService {

	@Autowired
	private CompanyMemberRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * 企業担当者を新規登録します.
	 * 
	 * @param form 新規登録に必要な情報
	 */
	public void registerCompanyMember(CompanyMember companyMember) {
		repository.insert(companyMember);
	}

	/**
	 * 企業担当者情報を取得します.
	 * 
	 * @param companymember
	 * @return
	 */
	public CompanyMember findCompanyMember(CompanyMember companymember) {
		String email = companymember.getEmail();
		String password = companymember.getPassword();
		return repository.findByEmailAndPassword(email, password);
	}

	/**
	 * 企業担当者のpasswordを変更します.
	 * 
	 * @param companyMember
	 */
	public void changePassWord(CompanyMember companyMember) {
		companyMember.setPassword(passwordEncoder.encode(companyMember.getPassword()));		
		repository.save(companyMember);
	}

}
