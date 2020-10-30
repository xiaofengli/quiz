English Quiz System

# SQL for a generic question system


## create tables

```
create database quizdb;
use  quizdb;
drop table question_meta;
CREATE TABLE `question_meta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `date_created` timestamp NOT NULL,
  `last_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

drop table `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL auto_increment,
  `question_meta_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `date_created` timestamp NOT NULL,
  `last_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

drop table `question_answer`;

CREATE TABLE `question_answer` (
`id` int(11) NOT NULL auto_increment,
  `question_meta_id` int(11) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `date_created` timestamp NOT NULL,
  `last_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

```

# Create dummy data

```

insert into question_meta (`id`, `title`, `description`, `category`, `date_created`, `last_updated`) 
values (null, 'Question 1', 'select the right letter', 'single_selection',now(), now());

insert into question (`id`,`question_meta_id`, `title`, `content`, `date_created`, `last_updated`) 
values (null, 1, 'A', 'you select A',now(), now());

insert into question (`id`,`question_meta_id`, `title`, `content`, `date_created`, `last_updated`) 
values (null, 1, 'B', 'you select B',now(), now());

insert into question (`id`, `question_meta_id`, `title`, `content`, `date_created`, `last_updated`) 
values (null, 1, 'C', 'you select C',now(), now());

insert into question_answer (`id`, `question_meta_id`, `answer`,`comment`,  `date_created`, `last_updated`) 
values (null, 1, 'C', 'this is the right ansewr ',now(), now());

```

# Backend and API Design

* This query will provide and generate all the questions,

SELECT * FROM quizdb.question_meta;

* The first query will get the options to render for question 1.

SELECT question_meta.id, question.title FROM quizdb.question_meta, question
where question_meta.id = question.question_meta_id and
question_meta.id = 1;

* The following API will provide the answer

SELECT question_meta.id as question_id ,question_answer.answer  as question_answer FROM quizdb.question_meta, question_answer
where question_meta.id = question_answer.question_meta_id and
question_meta.id = 1;
