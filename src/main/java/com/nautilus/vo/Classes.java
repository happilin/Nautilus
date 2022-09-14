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

//	@Id
//	private int classNum;
	
	@Id
	@Column(name="korname")
	private String korName;
	
	@Column(name="classexplan")
	private String classExplan;
	
//	@Column(name="member_num")
//	private int memberNum;
//	
//	@Column(name="class_effect")
//	private String classEffect;
}
