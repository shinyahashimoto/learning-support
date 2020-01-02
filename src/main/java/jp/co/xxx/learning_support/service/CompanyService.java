package jp.co.xxx.learning_support.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.xxx.learning_support.domain.Company;
import jp.co.xxx.learning_support.repository.CompanyRepository;

@Service
@Transactional
public class CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	public void registerCompany(Company company) {
		repository.insert(company);
	}
	
	public List<Company> showCompanyList(){
		return repository.findAll();
	}
	
}
