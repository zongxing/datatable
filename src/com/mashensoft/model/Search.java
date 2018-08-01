package com.mashensoft.model;

public class Search {
	private String value;
	private boolean regex;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isRegex() {
		return regex;
	}
	public void setRegex(boolean regex) {
		this.regex = regex;
	}
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Search(String value, boolean regex) {
		super();
		this.value = value;
		this.regex = regex;
	}

}
