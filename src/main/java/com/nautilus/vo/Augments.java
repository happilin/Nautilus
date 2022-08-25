package com.nautilus.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="Augments")
public class Augments
{
	@Id
	private String name;
	
	private String consonant;
	private Integer agmLevel;
	private String explanation;
}
