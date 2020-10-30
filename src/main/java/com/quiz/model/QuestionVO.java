package com.quiz.model;

import lombok.Data;

@Data
public class QuestionVO {
	@SuppressWarnings("unused")
	private long id;
	
	@SuppressWarnings("unused")
	private String question_body;
	
	@SuppressWarnings("unused")
	private String selection_title;
}
