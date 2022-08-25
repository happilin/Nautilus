package com.nautilus.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Entity
@Table(name="origineffect")
public class OriginEffect {

	@Id
	private int num;
	
	@Column(name="originname")
	private String originName;
	
	@Column(name="member")
	private int member;
	
	@Column(name="effect")
	private String effect;
}