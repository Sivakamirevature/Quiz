package com.example.quizzes.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.model.Question;

@Repository
public class QuestionDAOImp implements IQuestionDAO {
	Question question = new Question();
	DBExceptions dbExceptions = new DBExceptions();
	@Autowired
	SessionFactory sessionFactory;
	Transaction transaction;

	@Override
	public Question createQuestion(Question question) throws DBExceptions {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		question.setCreated_on(ts);
		session.save(question);
		return question;
	}

	@Override
	public List<Question> getAllQuestions() throws DBExceptions {
		List<Question> questions = null;
		try {
			return (List<Question>)sessionFactory.getCurrentSession().createCriteria(Question.class).list();
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}
}
