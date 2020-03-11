package com.example.quizzes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizzes.dao.IQuizDao;
import com.example.quizzes.dto.QuizQuestionsAssigning;
import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.exception.ServiceExceptions;
import com.example.quizzes.model.Quiz;
import com.example.quizzes.model.Quiz_Question;


@Service
public class QuizServiceImpl implements IQuizService {
	@Autowired
	IQuizDao quizdao;
	@Autowired
	Quiz q;
	public List<Quiz> getAllQuizzes() throws ServiceExceptions, DBExceptions{
		return quizdao.getAllQuizzes();
	}

	@Override
	public List<Quiz> getQuizByID(int id)throws ServiceExceptions, DBExceptions{
		System.out.print("from Controller");
		return quizdao.getQuizByID(id);
	}
	@Override
	public Quiz createQuiz(Quiz quiz) throws ServiceExceptions, DBExceptions{
		q = quizdao.createQuiz(quiz);  
		return q;
	}
	
	@Override
	public int DeleteById(int qid) throws ServiceExceptions, DBExceptions{
		return quizdao.deleteById(qid);	
	}

	@Override
	public Quiz UpdateById(Quiz quiz) throws ServiceExceptions, DBExceptions{
		return quizdao.updateById(quiz);
	}

	@Override
	public int activeDeactiveQuiz(int qid) throws ServiceExceptions, DBExceptions {
		return quizdao.activeDeactiveQuiz(qid);
	}

	@Override
	public List<Quiz_Question> getPoolQuestions(int qid, String poolname) throws DBExceptions {
		return quizdao.getPoolQuestions(qid, poolname);
	}

	@Override
	public Quiz cloneQuiz(Quiz quiz) throws ServiceExceptions, DBExceptions {
		return quizdao.cloneQuiz(quiz);
	}
}