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
@Table(name="classeffect")
public class ClassEffect {

	@Id
	private int num;
	
	@Column(name="classname")
	private String className;
	
	@Column(name="member")
	private int member;
	
	@Column(name="effect")
	private String effect;
}
