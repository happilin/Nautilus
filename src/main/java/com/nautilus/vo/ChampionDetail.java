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
@Table(name="championdetail")
public class ChampionDetail 
{
	@Id
	@Column(name="korname")
	private String korname;
	
	@Column(name="engname")
	private String engname;
	
	@Column(name="cost1")
	private int cost1;
	
	@Column(name="cost2")
	private String cost2;
	
	@Column(name="origins1")
	private String origins1;
	
	@Column(name="classes1")
	private String classes1;
	
	@Column(name="origins2")
	private String origins2;
	
	@Column(name="classes2")
	private String classes2;
	
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
	
	@Column(name="skilltype")
	private String skilltype;
	
	@Column(name="mana")
	private String mana;
	
	@Column(name="skillcontent")
	private String skillcontent;
	
	@Column(name="skilleffect")
	private String skilleffect;
}
