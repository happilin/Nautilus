package com.nautilus.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="augments")
public class Augments
{
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="consonant")
	private String consonant;
	
	@Column(name="agmlevel")
	private Integer agmlevel;
	
	@Column(name="explanation")
	private String explanation;
}
