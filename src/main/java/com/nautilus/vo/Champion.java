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
@Table(name="champion")
public class Champion 
{
	@Id
	@Column(name="korname")
	private String korname;
	
	@Column(name="engname")
	private String engName;
	
	@Column(name="cost1")
	private int cost1;
	
	@Column(name="cost2")
	private String cost2;
	
	@Column(name="origins")
	private String origins;
	
	@Column(name="classes")
	private String classes;
	
	@Column(name="health")
	private String health;
	
	@Column(name="defence")
	private int defence;
	
	@Column(name="mdefence")
	private int mDefence;
	
	@Column(name="offense")
	private String offense;
	
	@Column(name="attackrange")
	private int attackrange;
	
	@Column(name="attackspeed")
	private float attackSpeed;
	
	@Column(name="skillname")
	private String skillname;
	
	@Column(name="mana")
	private String mana;
}
