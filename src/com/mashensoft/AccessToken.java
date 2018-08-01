package com.mashensoft;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class AccessToken {
	public static void main(String[] args) {
		// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		// appID wxc8c9e8d5b7cd7820

		// appsecret b9140e159da0da66674d37653fcbb726

		String str = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc8c9e8d5b7cd7820&secret=b9140e159da0da66674d37653fcbb726";
		URL url;
		try {
			url = new URL(str);
			Scanner s = new Scanner(url.openStream());
			while (s.hasNextLine()) {
				System.out.println(s.nextLine());

				// {"access_token":"5_tVJcQHuAKg0ECH5yjosb9JLckW4rEJDiRMCDdcchk8BC9EmA4ZYe07SaFGqrMRk8z72suVwP2r7Wl45vIOtPERGhUUDX7cAP3z3L4U33D3wt8yHvl2WiiWlQele978IOo-4hfBUYBv3sN4_oDZLhAFATPB","expires_in":7200}
				// {"access_token":"5_jELnrICs3PpB9VR3fLFkgqwouNcikEKQvgg6mlEh3BspT6dUh7D9NL_4ect8HDsnIxRqC5OCaoATxmwcKLfgqJoVFuRjxyrUxI9qP0GeTlO7ZhaVbaQxSnjvpiPQbJS-vw1kfynBn6AEHiGRDYXaAIASNM","expires_in":7200}

			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
