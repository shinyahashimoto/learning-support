package jp.co.xxx.learning_support.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jp.co.xxx.learning_support.domain.Admin;
import jp.co.xxx.learning_support.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;
	
	public void registerOrUpdate(Admin admin) {
		repository.save(admin);
	}
	
}