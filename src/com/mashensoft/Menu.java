package com.mashensoft;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Menu {
	
	//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx841a97238d9e17b2&redirect_uri=175j510a42.iok.la/dp/WebAuth&response_type=code&scope=snsapi_userinfo
	public static void createMenu() {
		String str = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=5_ywZQX0Rz4imAg0GUG9AbaeMH9rstwFAD67C-JDWb875FInCoEZtbWuVs92S-O2haD_eYut-EAvMauF_hjG2TG_Gz38FGvIJpE55J7udvqa7eDA7FawBdH_x6g2z-FBwzfKzqWtUW34TyLJ4BIXGcAAAAPY";
		String content = "";
		content += "{";
		content += "\"button\":[";
		content += "{";
		content += "\"type\":\"view\",";
		content += "\"name\":\"3333\",";
		content += "\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc8c9e8d5b7cd7820&redirect_uri=http://www.mashensoft.com/test/test.jsp&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect\"";
		content += "}]";
		content += "}";
		
		URL url;
		try {
			url = new URL(str);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
			conn.setRequestProperty("Charset", "UTF-8");
			conn.connect();
			OutputStream os = conn.getOutputStream();
			os.write(content.getBytes());
			os.flush();
			os.close();
			
			Scanner s = new Scanner(conn.getInputStream());
			while(s.hasNextLine()){
				System.out.println(s.nextLine());
			}
			
			s.close();
			os.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		createMenu();
	}
}
