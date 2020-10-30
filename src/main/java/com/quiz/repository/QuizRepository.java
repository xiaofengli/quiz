package com.quiz.repository;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.quiz.model.QuestionVO;

//public interface QuitzRepository extends JpaRepository<QuestionVO, Integer> {

@Repository
public class QuizRepository {
	
	  @Autowired
	    private JdbcTemplate jdbcTemplate;
/*
	@Query(value ="select * from gain_loss_closed_position where hash_code = ?1", nativeQuery = true)
	FidelityClosedPositionRecord findByHashCode(String hashCode);
	
	@Query(value ="SELECT * FROM fidelity.gain_loss_closed_position", nativeQuery = true)
	ArrayList<FidelityClosedPositionRecord> getEarningYTDAllAccounts();
	
	public final String earningsBySymbolSortByTotalEarning = "SELECT symbol, round(sum(short_term) + sum(long_term),2) as total_earning, sum(quantity) as total_shares, round((sum(short_term) + sum(long_term))/sum(quantity),2) as earning_per_share FROM fidelity.gain_loss_closed_position group by symbol order by total_earning desc";
	@Query(value =earningsBySymbolSortByTotalEarning, nativeQuery = true)
	ArrayList<?> getEarningsBySymbolOrderByTotalEarning();
	
	public final String earningsBySymbolSortByEarningPerShare = "SELECT symbol, round(sum(short_term) + sum(long_term),2) as total_earning, sum(quantity) as total_shares, round((sum(short_term) + sum(long_term))/sum(quantity),2) as earning_per_share FROM fidelity.gain_loss_closed_position group by symbol order by earning_per_share desc";
	@Query(value =earningsBySymbolSortByEarningPerShare, nativeQuery = true)
	ArrayList<?> getEarningsBySymbolOrderByEarningPerShare();
	
	public final String getEarningByDate = "SELECT date_sold, round(sum(short_term)+sum(long_term)) FROM fidelity.gain_loss_closed_position group by date_sold order by date_sold asc";
	@Query(value = getEarningByDate, nativeQuery = true)
	ArrayList<?> getEarningBySoldDate();
	
	public final String totalEarning = "SELECT min(date_sold) as start_date, max(date_sold) as end_date, round(sum(short_term)) as short_term, round(sum(long_term)) as long_term_total, round(sum(short_term)+ sum(long_term)) as total FROM fidelity.gain_loss_closed_position";
	@Query(value = totalEarning, nativeQuery = true)
	ArrayList<?> getTotalEarningSummary();
	*/

	public List<Map<String, Object>> getQuestionById(int id) {
		BeanPropertyRowMapper rowMapper = BeanPropertyRowMapper.newInstance(QuestionVO.class);
		 return jdbcTemplate.queryForList(
	                "SELECT question_meta.id, question.title FROM quizdb.question_meta, question\\r\\n\" + \r\n" + 
	                "			\"where question_meta.id = question.question_meta_id and\\r\\n\" + \r\n" + 
	                "			\"question_meta.id = ?;", new Object[] {id},
	                rowMapper
	        );
	}
}