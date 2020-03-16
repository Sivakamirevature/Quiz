package com.example.quizzes.service;

import java.util.List;
import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.exception.ServiceExceptions;
import com.example.quizzes.model.Category;
import com.example.quizzes.model.Level;
import com.example.quizzes.model.Pool;
import com.example.quizzes.model.Quiz;
import com.example.quizzes.model.Quiz_Question;



public interface IQuizService {

	List<Quiz> getAllQuizzes() throws ServiceExceptions, DBExceptions;

	List<Quiz> getQuizByID(int id) throws ServiceExceptions, DBExceptions;

	Quiz createQuiz(Quiz quiz) throws ServiceExceptions, DBExceptions;

	int activeDeactiveQuiz(int qid) throws ServiceExceptions, DBExceptions;

	int DeleteById(int qid) throws ServiceExceptions, DBExceptions;

	Quiz UpdateById(Quiz quiz) throws ServiceExceptions, DBExceptions;

	List<Quiz_Question> getPoolQuestions(int qid, String poolname) throws ServiceExceptions, DBExceptions;

	Quiz cloneQuiz(Quiz quiz) throws ServiceExceptions, DBExceptions;

	List<Category> getCategory()throws ServiceExceptions, DBExceptions;

	List<Level> getLevel()throws ServiceExceptions, DBExceptions;

	List<Pool> getPool() throws ServiceExceptions, DBExceptions;
}