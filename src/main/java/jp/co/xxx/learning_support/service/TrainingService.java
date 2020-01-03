package jp.co.xxx.learning_support.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.xxx.learning_support.domain.Instructor;
import jp.co.xxx.learning_support.domain.Training;
import jp.co.xxx.learning_support.repository.InstructorRepository;
import jp.co.xxx.learning_support.repository.TrainingRepository;
import jp.co.xxx.learning_support.repository.TrainingStudentRepository;

@Service
@Transactional
public class TrainingService {

	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private TrainingStudentRepository trainingStudentRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	public Training insertTraining(Training training) {
		return trainingRepository.insert(training);
	}
	
	public void insertTrainingStudent(Integer trainingId, Integer studentId) {
		trainingStudentRepository.insert(trainingId, studentId);
	}
	
	public List<Instructor> findAll(){
		return instructorRepository.findAll();
	}
}
