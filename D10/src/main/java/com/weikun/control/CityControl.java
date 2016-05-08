package com.weikun.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weikun.service.CityService;
@WebServlet(name="/cityControl",urlPatterns={"/city"})
public class CityControl extends HttpServlet {
	private CityService service=new CityService();
	public CityControl() {
		// TODO Auto-generated constructor stub
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pro=req.getParameter("pro");//ln
		
//		String citys=service.makeCityXML(pro);
//		resp.setContentType("text/xml");
		String citys=service.makeCityJSON(pro);
		System.out.println(citys);
		resp.setContentType("text/html");//json
		resp.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		out.println(citys);		
		out.flush();
		out.close();		
	}
}
