package com.example.quizzes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "quiz_questions")
public class Quiz_Question {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="quiz_id")
	private Quiz quiz;
	
	@ManyToOne
	@JoinColumn(name = "question_id", referencedColumnName = "id")
	private Question question;

	@ManyToOne
	@JoinColumn(name ="pool_id", referencedColumnName = "id")
	private Pool pool;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Pool getPool() {
		return pool;
	}

	public void setPool(Pool pool) {
		this.pool = pool;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
}