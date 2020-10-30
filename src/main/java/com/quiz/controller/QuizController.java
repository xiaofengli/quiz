package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.AnswerVO;
import com.quiz.model.QuestionVO;
import com.quiz.repository.QuizRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class QuizController {
	@Autowired
	QuizRepository quizRepo;

	@GetMapping("/quiz/question/{id}/selections")
	@ApiOperation(value = "get question info")
	public ResponseEntity<?> getQuestionSelectionsById(@PathVariable int id) {
		List<QuestionVO> questions = quizRepo.getQuestionSelectionsById(id);
		//List<Map<String, Object>> account = new ArrayList<>();
		//HashMap<String, Object> response = new HashMap<>();
		//response.put("Options", account);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	@GetMapping("/quiz/question/{id}/answer")
	@ApiOperation(value = "get question info")
	public ResponseEntity<?> getAnswerById(@PathVariable int id) {
		AnswerVO answers = quizRepo.getAnswerByQuestionId(id);
		return new ResponseEntity<>(answers, HttpStatus.OK);
	}

}