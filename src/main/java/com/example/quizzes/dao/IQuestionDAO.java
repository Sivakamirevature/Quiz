package com.example.quizzes.dao;

import java.util.List;

import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.model.Question;

public interface IQuestionDAO {
	Question createQuestion(Question question)throws DBExceptions;
	List<Question> getAllQuestions() throws DBExceptions;
}