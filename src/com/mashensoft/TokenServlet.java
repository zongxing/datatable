package com.mashensoft;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TokenServlet
 */
@WebServlet("/TokenServlet")
public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TokenServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("hello");
		System.out.println("hello 222");
		
		
		
		System.out.println(request.getParameter("companyId"));
		// TODO Auto-generated method stub
		String echostr = request.getParameter("echostr");
		System.out.println(echostr);
		System.out.println(request.getRequestURL());
		System.out.println(request.getRemotePort());
		response.getWriter().append(echostr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("companyId"));
		// TODO Auto-generated method stub
		// doGet(request, response);

		Scanner s = new Scanner(request.getInputStream());
		while (s.hasNextLine()) {
			System.out.println(s.nextLine());
			/**
			 * <xml><ToUserName><![CDATA[gh_b8b7273c86cb]]></ToUserName>
			 * <FromUserName><![CDATA[ox2qiuA8131YkGvWQXfqKqkx81oo]]>
			 * </FromUserName> <CreateTime>1513657521</CreateTime>
			 * <MsgType><![CDATA[text]]></MsgType>
			 * <Content><![CDATA[Fff]]></Content>
			 * <MsgId>6501109550472402456</MsgId> </xml>
			 */
		}
		//s.close();
		//String msg = "<xml> <ToUserName>< ![CDATA[ox2qiuA8131YkGvWQXfqKqkx81oo] ]></ToUserName> <FromUserName>< ![CDATA[gh_b8b7273c86cb] ]></FromUserName> <CreateTime>12345678</CreateTime> <MsgType>< ![CDATA[text] ]></MsgType> <Content>< ![CDATA[你好] ]></Content> </xml>";
		String msg = "";
		msg+="<xml>";
		msg+="<ToUserName><![CDATA[ox2qiuA8131YkGvWQXfqKqkx81oo]]></ToUserName>";
		msg+="<FromUserName><![CDATA[gh_b8b7273c86cb]]></FromUserName>";
		msg+="<CreateTime>12345678</CreateTime>";
		msg+="<MsgType><![CDATA[text]]></MsgType>";
		msg+="<Content><![CDATA[你好]]></Content>";
		msg+="</xml>";
		
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-control","no-cache");
		response.getWriter().print(msg);
		System.out.println(msg);
	}

}
