package com.example.quizzes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizzes.dao.IQuestionDAO;
import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.exception.ServiceExceptions;
import com.example.quizzes.model.Question;


@Service
public class QuestionServiceImp implements IQuestionService{
	@Autowired
	IQuestionDAO iQuestionDAO;
	
	@Override
	public Question createQuestion(Question question) throws DBExceptions, ServiceExceptions {
		return iQuestionDAO.createQuestion(question);
	}

	@Override
	public List<Question> getAllQuestions() throws ServiceExceptions, DBExceptions{
		try {
		return iQuestionDAO.getAllQuestions();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}