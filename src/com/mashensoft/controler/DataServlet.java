package com.mashensoft.controler;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.mashensoft.model.DataTablesRequest;
import com.mashensoft.service.DataService;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Scanner scanner = new Scanner(request.getInputStream());
		StringBuffer sb = new StringBuffer(); 
		while(scanner.hasNextLine()){
			sb.append(scanner.nextLine());
		}
		scanner.close();
		System.out.println(sb.toString());
		DataTablesRequest jsonRequest = JSON.parseObject(sb.toString(),DataTablesRequest.class);
		System.out.println("从这里开始："+jsonRequest.getStart());
		System.out.println("每页多少条："+jsonRequest.getLength());
		System.out.println("第几次请求："+jsonRequest.getDraw());
		
		//目标：获取页面传过来的，当前在第几页,start,
		//limit 开始的行数,需要多少行
		//select * person limit 0,length
		DataService dataService = new DataService();
		int draw = (int)jsonRequest.getDraw();
		int start = jsonRequest.getStart();
		int length = jsonRequest.getLength();
		
		String jsonString = dataService.getData(draw, start, length);
		response.getWriter().append(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
