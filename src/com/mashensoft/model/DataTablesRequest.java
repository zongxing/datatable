package com.mashensoft.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTablesRequest {
	private int draw;
	private int start;
	private int length;
	private Search search;
	private List<Order> order;
	private List<Column> columns;
	private Map<String,Object> searchColumns=new HashMap<String,Object>();
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Search getSearch() {
		return search;
	}
	public void setSearch(Search search) {
		this.search = search;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public Map<String, Object> getSearchColumns() {
		return searchColumns;
	}
	public void setSearchColumns(Map<String, Object> searchColumns) {
		this.searchColumns = searchColumns;
	}

}
