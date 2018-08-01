package com.mashensoft;

public class Tools {
	String s = "sdsd" + "" + "" + "";

	static String str = "{"
			+ "\"access_token\":\"5_OhFRfAcLhO-iXpSKzk_6HzpXtRzDT5DHqYhMDMoBINbSbS5nYKTEBd1c9k2oTfs6o6tLAN0OHO5f7soBLLAOttrBrWNwiyFHc66cnv9Gjkg\","
			+ "\"expires_in\":7200,"
			+ "\"refresh_token\":\"5_UAlmOQx2wSjjoItctm9GlOT30Af_RWgDeaI4YUY_gXMv29lB0msiL-47iMNdcDv2SHLR0S4Q6qgQjjZRVV9M7I7fPvAYfo69lynPc2k3zqE\","
			+ "\"openid\":\"ox2qiuA8131YkGvWQXfqKqkx81oo\",\"scope\":\"snsapi_base\"}";
	public static void main(String[] args) {
		String a = str.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\"", "");
		String[] arr = a.split(",");
		for(String d:arr){
			String[] result = d.split(":");
			if(result.length!=0){
				if(result[0].equals("access_token")){
					System.out.println(result[1]);
				}
				if(result[0].equals("openid")){
					System.out.println(result[1]);
				}
			}
		}
	}
}
