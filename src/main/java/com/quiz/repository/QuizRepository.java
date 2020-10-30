package com.quiz.repository;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.quiz.model.AnswerVO;
import com.quiz.model.QuestionVO;

//public interface QuitzRepository extends JpaRepository<QuestionVO, Integer> {

@Repository
public class QuizRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	final String baseQuery = "SELECT question_meta.id AS id, question_meta.title AS question_body, question.title AS question_selection FROM quizdb.question_meta, question "
			+ "WHERE question_meta.id = question.question_meta_id AND question_meta.id = ";
	public List<QuestionVO> getQuestionSelectionsById(int id) {
		String finalQuery = baseQuery + id;
		System.out.println("query is: " + finalQuery);
		List<QuestionVO> res = jdbcTemplate.query(finalQuery, BeanPropertyRowMapper.newInstance(QuestionVO.class));
		System.out.println("id: " + id);
		return res;
	}
	
	final String getAnswerQuery = "SELECT question_meta.id AS question_id,question_answer.answer AS question_answer FROM quizdb.question_meta, question_answer "
			+ "WHERE question_meta.id = question_answer.question_meta_id AND question_meta.id = ?";
	public AnswerVO getAnswerByQuestionId(int id) {
		System.out.println("query is: " + getAnswerQuery);
		AnswerVO res = jdbcTemplate.queryForObject(getAnswerQuery, new Object[] {id}, BeanPropertyRowMapper.newInstance(AnswerVO.class));
		System.out.println("id: " + id);
		return res;
	}
}