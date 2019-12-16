package jp.co.xxx.learning_support.repository;

import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.xxx.learning_support.domain.DailyReport;

/**
 * 日報の情報を操作するリポジトリ.
 * 
 * @author hiraokayuri
 *
 */
@Repository
public class DailyReportRepository {
	
	private static final RowMapper<DailyReport>DAILYREPORT_ROW_MAPPER = (rs,i)->{
	DailyReport dailyReport = new DailyReport();
	dailyReport.setId(rs.getInt("id"));
	//サーバー上のdate方をlocalDate型に変換する
	dailyReport.setDate(rs.getDate("date").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	dailyReport.setTrainingId(rs.getInt("training_id"));
	dailyReport.setStudentId(rs.getInt("student_id"));
	dailyReport.setContent(rs.getString("content"));
	dailyReport.setIntelligibility(rs.getInt("intelligibility"));
	dailyReport.setDetailIntelligibility(rs.getString("detailIntelligibility"));
	dailyReport.setAboutInstructor(rs.getInt("aboutInstructor"));
	dailyReport.setQuestion(rs.getString("question"));
	return dailyReport;
	
	};
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 日報の情報を登録する.
	 * 
	 * @param dailyReport
	 */
	public void Insert(DailyReport dailyReport) {
		String insertSql = "insert into daily_reports(date,training_id,student_id,content,intellibility,detailIntelligibility,aboutInstructor,question)"
				           + "value(:date,:trainingId,:studantId,:content,:intelligibility,:detailIntelligibility,:aboutInstructor,:question)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(dailyReport);
		template.update(insertSql, param);
		
	}
	
	/**
	 * 学生番号を使って日報の情報を取得する.
	 * 
	 * @param studanteId　学生番号
	 * @return dailyReportList 日報 （日報の情報がない場合はnullを返す）.
	 */
	public List<DailyReport> findBystudanteId(Integer studentId){
		String sql = "select id,date,training_id,student_id,content,intelligibility,detailIntelligibility,aboutInstructor,question from daily_reports order by date where student_id =:studentId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("studantId",studentId);
		List<DailyReport> dailyReportList = template.query(sql, param,DAILYREPORT_ROW_MAPPER);
		if(dailyReportList.size()== 0) {
			return null;
		}
		return dailyReportList;
		
	}
	
	
	
}
