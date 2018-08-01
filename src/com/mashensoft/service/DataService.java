package com.mashensoft.service;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.mashensoft.dao.DataDaoImpl;
import com.mashensoft.model.Data;
import com.mashensoft.model.JsonResult;

public class DataService {
	public String getJsonString(int draw) {
		List<Data> dataList = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			String a = new Integer(i).toString();
			Data data = new Data(a, a, a, a, a, a);
			dataList.add(data);
		}
		JsonResult result = new JsonResult();
		result.setDraw(draw);
		result.setData(dataList);
		result.setRecordsFiltered(20);
		result.setRecordsTotal(20);
		return JSON.toJSONString(result);
	}

	public String getData(int draw,int start,int length){
		DataDaoImpl dataDao = new DataDaoImpl();
		JsonResult result = new JsonResult();
		String jsonString = "";
		result.setDraw(draw);
		//去数据库查询，获取总记录数
		int count = 0;
		count = dataDao.getTotalCount();
		result.setRecordsFiltered(count);
		result.setRecordsTotal(count);
		
		//获取所有的data数据
		List<Data> dataList = new ArrayList<>();
		dataList = dataDao.getDataList(start, length);
		result.setData(dataList);
		jsonString = JSON.toJSONString(result);
		return jsonString;
	}
}
