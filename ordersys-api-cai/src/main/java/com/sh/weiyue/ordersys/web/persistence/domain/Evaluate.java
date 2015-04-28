package com.sh.weiyue.ordersys.web.persistence.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Evaluate.findAll", query="SELECT e FROM Evaluate e")
public class Evaluate implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer evaluateId;

	@Column(name="score")
	private Integer evaluateScore;
	
	@Column(name="dishId")
	private Integer evaluateDishId;
	
	public Evaluate() {
	}
	
	public Evaluate( Integer dishId, Integer score) {
		this.evaluateDishId = dishId;
		this.evaluateScore = score;
	}
	
	public Integer getEvaluateId() {
		return evaluateId;
	}

	public void setEvaluateId(Integer evaluateId) {
		this.evaluateId = evaluateId;
	}

	public Integer getEvaluateScore() {
		return evaluateScore;
	}

	public void setEvaluateScore(Integer evaluateScore) {
		this.evaluateScore = evaluateScore;
	}

	public Integer getEvaluateDishId() {
		return evaluateDishId;
	}

	public void setEvaluateDishId(Integer evaluateDishId) {
		this.evaluateDishId = evaluateDishId;
	}

}
