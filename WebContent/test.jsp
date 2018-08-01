<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.net.*,java.io.*"%>
    <%
    System.out.println("WebAuth被调用");
	// TODO Auto-generated method stub
	System.out.println("response_type:"+request.getParameter("response_type"));
	System.out.println("scope:"+request.getParameter("scope"));
	System.out.println("state:"+request.getParameter("state"));
	System.out.println("openid:"+request.getParameter("openid"));
	System.out.println("code:"+request.getParameter("code"));
	response.getWriter().append("Served at: ").append(request.getContextPath());
	//第二步
	String code = request.getParameter("code");
	String content = "";
	try {
		String str = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxf6fb8ff3c8b39016&secret=0ed4879c99620c5814091bbfea572887&code="+code+"&grant_type=authorization_code";
			URL url = new URL(str);
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
				String tempStr = s.nextLine();
				content+=tempStr;
				System.out.println(tempStr);
			}
			
			s.close();
			os.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	//第四步，获取用户信息
	
	String access_token = "";
	String openid = "";
		String a = content.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\"", "");
		System.out.println("a:::::"+a);
		String[] arr = a.split(",");
		for(String d:arr){
			System.out.println("d:::::"+d);
			String[] result = d.split(":");
			if(result.length!=0){
				if(result[0].equals("access_token")){
					System.out.println("access_token:::"+result[1]);
					access_token = result[1];
				}
				if(result[0].equals("openid")){
					System.out.println("openid:::"+result[1]);
					openid = result[1];
				}
			}
		}
				
		try {
			
			String str = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
			System.out.println("url:"+str);
			//String str = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxc8c9e8d5b7cd7820&secret=b9140e159da0da66674d37653fcbb726&code="+code+"&grant_type=authorization_code";
				URL url = new URL(str);
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
 %>