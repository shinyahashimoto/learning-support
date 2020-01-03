package jp.co.xxx.learning_support.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.xxx.learning_support.domain.Instructor;
import jp.co.xxx.learning_support.repository.InstructorRepository;

/**
 * @author hashimotoshinya
 *
 */
@Service
@Transactional
public class InstructorService {

	@Autowired
	private InstructorRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void register(Instructor instructor) {
		repository.insert(instructor);
	}

	/**
	 * 講師情報を取得します.
	 * 
	 * @param instructor
	 * @return
	 */
	public Instructor findInstructor(Instructor instructor) {
		String email = instructor.getEmail();
		String password = instructor.getPassword();
		return repository.findByEmailAndPassword(email, password);
	}

	/**
	 * 講師情報のパスワードを変更します.
	 * 
	 * 
	 * @param instructor
	 */
	public void changePassWord(Instructor instructor) {
		instructor.setPassword(passwordEncoder.encode(instructor.getPassword()));
		repository.save(instructor);
	}
}
