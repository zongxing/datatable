package com.mashensoft.service;

import org.junit.Test;

public class DataServiceTest {

	@Test
	public void testGetData() {
		DataService ds = new DataService();
		String str = ds.getData(0, 1, 4);
		System.out.println(str);
	}

}
