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
@Table(name="synergy")
public class Synergy {
	
//	@Id
//	private int originNum;

	@Id
	@Column(name="korname") //-> kornname 으로 인식
//	@Column(name="korName") //-> kor_name 으로 인식
	private String korname;
	
	@Column(name="explan")
	private String explan;
	
	@Column(name="type")
	private String type;

}
