package com.ji.springP001.Board;

import java.util.Date;


public class Board {

	private int b_no;		
	private String b_owner;	
	private String b_text;
	private Date b_when;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	
	public Board(int b_no, String b_owner, String b_text, Date b_when) {
		super();
		this.b_no = b_no;
		this.b_owner = b_owner;
		this.b_text = b_text;
		this.b_when = b_when;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_owner() {
		return b_owner;
	}

	public void setB_owner(String b_owner) {
		this.b_owner = b_owner;
	}

	public String getB_text() {
		return b_text;
	}

	public void setB_text(String b_text) {
		this.b_text = b_text;
	}

	public Date getB_when() {
		return b_when;
	}

	public void setB_when(Date b_when) {
		this.b_when = b_when;
	}
	
	
}
