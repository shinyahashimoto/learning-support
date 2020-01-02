package jp.co.xxx.learning_support.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.xxx.learning_support.domain.CompanyMember;
import jp.co.xxx.learning_support.repository.CompanyMemberRepository;

@Service
@Transactional
public class CompanyMemberService {

	@Autowired
	private CompanyMemberRepository repository;
	
	/**
	 * 企業担当者を新規登録します.
	 * 
	 * @param form 新規登録に必要な情報
	 */
	public void registerCompanyMember(CompanyMember companyMember) {
		repository.insert(companyMember);
	}

	
}
