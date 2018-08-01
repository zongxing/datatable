package com.mashensoft.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.mashensoft.model.Person;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public JsonServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("username"));
//		Scanner scanner = new Scanner(request.getInputStream());
//		StringBuffer sb = new StringBuffer(); 
//		while(scanner.hasNextLine()){
//			sb.append(scanner.nextLine());
//		}
//		scanner.close();
//		System.out.println(sb.toString());
//		response.getWriter().append(sb.toString());
		
		Person p = new Person("mashensoft","123456");
		String jsonString = JSON.toJSONString(p);
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
