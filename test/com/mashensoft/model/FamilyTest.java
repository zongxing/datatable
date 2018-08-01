package com.mashensoft.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class FamilyTest {

	@Test
	public void test() {
		Family f = new Family();
		f.setWife(new Wife("moulu"));
		f.setHouseOwnerName("wangsen");
		List<Son> sonList = new ArrayList<>();
		sonList.add(new Son("xiaosen1"));
		sonList.add(new Son("xiaosen2"));
		List<Daughter> daughterList = new ArrayList<>();
		daughterList.add(new Daughter("xiaohua1"));
		daughterList.add(new Daughter("xiaohua2"));
		f.setSonList(sonList);
		f.setDaughterList(daughterList);
		System.out.println(JSON.toJSONString(f));
		
	}

}
