package jp.co.xxx.learning_support.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.xxx.learning_support.domain.DailyReport;
import jp.co.xxx.learning_support.domain.Student;
import jp.co.xxx.learning_support.form.DailyReportForm;
import jp.co.xxx.learning_support.repository.DailyReportRepository;

/**
 * 受講生情報を操作するサービスクラス.
 * 
 * @author hiraokayuri
 *
 */
@Service
@Transactional
public class StudentService {
	@Autowired
	private DailyReportRepository dailyReportRepository;

	/**
	 * 日報情報を登録する.
	 * 
	 * @param dailyReport 日報
	 */
	//受講生ID使って研修受講生の情報を持ってくる？？
	//研修IDはどこで持ってくる？hiddenで値を持ってくる？？？
	 //日報情報を受け取りDBに登録を行うメソッド.
	public void insertDailyReport(DailyReportForm form , Student student) {
		Date date = new Date();
		DailyReport dailyReport = new DailyReport();
		dailyReport.setDate(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		//dailyReport.setTrainingId(form.getTrainingId); hidden?
		dailyReport.setStudentId(student.getId());
		dailyReport.setContent(form.getContent());
		dailyReport.setIntelligibility(form.getIntIntelligibility());
		dailyReport.setDetailIntelligibility(form.getDetailIntelligibillity());
		dailyReport.setAboutInstructor(form.getIntAboutInstructo());	

		dailyReportRepository.Insert(dailyReport);

	}

}
