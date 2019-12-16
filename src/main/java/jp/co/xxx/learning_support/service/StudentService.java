package jp.co.xxx.learning_support.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.xxx.learning_support.domain.DailyReport;
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
	public void insertDailyReport(DailyReport dailyReport) {
		dailyReportRepository.Insert(dailyReport);

	}

}
