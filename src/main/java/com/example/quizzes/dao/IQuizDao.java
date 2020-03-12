package com.example.quizzes.dao;

import java.util.List;

import com.example.quizzes.dto.QuizQuestionsAssigning;
import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.model.Category;
import com.example.quizzes.model.Level;
import com.example.quizzes.model.Quiz;
import com.example.quizzes.model.Quiz_Question;

public interface IQuizDao {

	List<Quiz> getAllQuizzes()throws DBExceptions;

	List<Quiz> getQuizByID(int id)throws DBExceptions;

	Quiz createQuiz(Quiz quiz)throws DBExceptions;

	int deleteById(int qid)throws DBExceptions;

	Quiz updateById(Quiz quiz)throws DBExceptions;

	int activeDeactiveQuiz(int qid)throws DBExceptions;
	
	int DeleteAllQuizzes() throws DBExceptions;

	List<Quiz_Question> getPoolQuestions(int qid, String poolname) throws DBExceptions;

	Quiz cloneQuiz(Quiz quiz)throws DBExceptions;

	List<Category> getCategory()throws DBExceptions;

	List<Level> getLevel()throws DBExceptions;
}