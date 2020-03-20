package com.example.quizzes.service;

import java.util.List;

import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.exception.ServiceExceptions;
import com.example.quizzes.model.Question;

public interface IQuestionService {
	Question createQuestion(Question question) throws DBExceptions, ServiceExceptions;

	List<Question> getAllQuestions() throws ServiceExceptions, DBExceptions;
}
