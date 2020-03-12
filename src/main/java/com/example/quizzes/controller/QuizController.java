package com.example.quizzes.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizzes.dto.QuizQuestionsAssigning;
import com.example.quizzes.exception.DBExceptions;
import com.example.quizzes.exception.ServiceExceptions;
import com.example.quizzes.model.Category;
import com.example.quizzes.model.Level;
import com.example.quizzes.model.Quiz;
import com.example.quizzes.model.Quiz_Question;
import com.example.quizzes.service.IQuizService;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/Quizzes")
public class QuizController {
	@Autowired
	IQuizService quizservice;

	@GetMapping(value = "/getAllQuizzes")
	public List<Quiz> getAllQuizze() throws ServiceExceptions, DBExceptions {
		List<Quiz> quizzes = null;
		try {
			quizzes = quizservice.getAllQuizzes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quizzes;
	}

	@GetMapping(value = "/getQuizByID/{id}")
	public List<Quiz> getQuizById(@PathVariable int id) throws ServiceExceptions, DBExceptions {
		System.out.print("from Controller");
		List<Quiz> quizzesList = quizservice.getQuizByID(id);
		return quizzesList;
	}

	@PostMapping(value = "/doCreateQuiz")
	public Quiz doCreateQuiz(@RequestBody Quiz quiz) throws ServiceExceptions, DBExceptions {
		quiz = quizservice.createQuiz(quiz);
		return quiz;
	}

	@PutMapping(value = "/doActiveDeactiveQuiz/{qid}")
	public int doDeactiveQuiz(@PathVariable int qid) throws ServiceExceptions, DBExceptions {
		int id = quizservice.activeDeactiveQuiz(qid);
		return id;
	}

	@DeleteMapping(value = "/doDeleteByID/{qid}")
	public int doDeleteByID(@PathVariable int qid) throws ServiceExceptions, DBExceptions {
		return quizservice.DeleteById(qid);
	}

	@PutMapping(value = "/doUpdateQuiz")
	public Quiz doUpdateQuiz(@RequestBody Quiz quiz) throws ServiceExceptions, DBExceptions {
		return quizservice.UpdateById(quiz);
	}

	@PostMapping(value = "/doClone")
	public Quiz doClone(@RequestBody Quiz quiz) throws ServiceExceptions, DBExceptions {
		return quizservice.cloneQuiz(quiz);
	}

	@GetMapping(value = "/getpoolquestions/{qid}/{poolname}")
	public List<Quiz_Question> getPoolQuestions(@PathVariable int qid, @PathVariable String poolname)
			throws DBExceptions, ServiceExceptions {
		return (List<Quiz_Question>) quizservice.getPoolQuestions(qid, poolname);
	}
	
	@GetMapping(value = "/getCategories")
	public List<Category> getCategory()throws ServiceExceptions, DBExceptions{
		return quizservice.getCategory();		
	}
	
	@GetMapping(value = "/getLevels")
	public List<Level> getLevel()throws ServiceExceptions, DBExceptions{
		return quizservice.getLevel();		
	}
}
