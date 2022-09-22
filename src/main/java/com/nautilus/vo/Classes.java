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
@Table(name="classes")
public class Classes {
	
	@Id
	@Column(name="korname")
	private String korname;
	
	@Column(name="explan")
	private String explan;
	
	@Column(name="type")
	private String type;
	
}
