package com.quitz.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


@Data
public class QuestionVO {

	String questionMetaId;
	String questionTitle;
}
