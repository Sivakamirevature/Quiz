package com.example.quizzes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.exception.ServiceExceptions;
import com.example.quizzes.model.Question;
import com.example.quizzes.service.IQuestionService;

@CrossOrigin
@RestController
@RequestMapping("/questions")
public class QuestionController {
	@Autowired
	IQuestionService questionService;

	@PostMapping(value="/doCreateQuiz")
	public Question doCreateQuiz(@RequestBody Question question) throws ServiceExceptions, DBExceptions {
		question = questionService.createQuestion(question);
		 return question;
	}
	
@GetMapping(value="/showAllQuestions")
public List<Question> getAllQuestions()throws Exception{
	List<Question> questions =null;
	questions = questionService.getAllQuestions();
	return questions;
	}
}