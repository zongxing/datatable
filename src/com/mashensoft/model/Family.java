package com.mashensoft.model;

import java.util.ArrayList;
import java.util.List;

public class Family {
	String houseOwnerName;
	String sex;
	Wife wife;
	List<Son> sonList = new ArrayList<>();
	List<Daughter> daughterList = new ArrayList<>();
	// 省略get set 方法
	public String getHouseOwnerName() {
		return houseOwnerName;
	}
	public void setHouseOwnerName(String houseOwnerName) {
		this.houseOwnerName = houseOwnerName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	public List<Son> getSonList() {
		return sonList;
	}
	public void setSonList(List<Son> sonList) {
		this.sonList = sonList;
	}
	public List<Daughter> getDaughterList() {
		return daughterList;
	}
	public void setDaughterList(List<Daughter> daughterList) {
		this.daughterList = daughterList;
	}
}
