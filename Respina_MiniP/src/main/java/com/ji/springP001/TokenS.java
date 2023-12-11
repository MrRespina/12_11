package com.ji.springP001;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TokenS {
	
	public static void makeTokenS(HttpServletRequest req) {
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
		String token = sdf.format(d);
		req.setAttribute("token", token);
		
	}

}
