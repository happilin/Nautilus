package com.nautilus.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Entity
@Table(name="champions")
public class Champion {

	
	@Column(name="championnum")
	private int championNum;
	
	//챔피언 이름 계열 길드
	@Id
	@Column(name="korname")
	private String korname;
	
	@Column(name="engname")
	private String engname;
	
	@Column(name="synergy1")
	private String synergy1;
	
	@Column(name="synergy2")
	private String synergy2;
	
	@Column(name="synergy3")
	private String synergy3;
	
	@Column(name="type")
	private String type;
}
