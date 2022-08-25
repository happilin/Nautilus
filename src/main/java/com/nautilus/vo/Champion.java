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

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int championNum;
	
	//챔피언 이름 계열 길드
	@Id
	@Column(name="korname")
	private String korname;
	
	@Column(name="engname")
	private String engName;
	
	@Column(name="synergy1")
	private String synergy1;
	
	@Column(name="synergy2")
	private String synergy2;
	
	@Column(name="synergy3")
	private String synergy3;
	
//	private int cost;
//	private int health;
//	private int attack;
//	private int depen;
//	private int range;
//	private float attack_speed;
//	private int dps;
//	
//	private int skill_num;
//	private String skill_name;
//	
//	private String mana;
}
