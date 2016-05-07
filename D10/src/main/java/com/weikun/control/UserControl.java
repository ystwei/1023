package com.weikun.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="/useControl" ,urlPatterns={"/user"})
public class UserControl extends HttpServlet {
	private String names[]={"weikun","json","veny"};
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
		String username=req.getParameter("username");
		boolean flag=false;
		for(String user:names){
			if(username.equals(user)){
				flag=true;
				break;
			}
		}
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out =resp.getWriter();
		
		out.println(  flag?"true":"false" );
		
		out.flush();
		out.close();
		
	}
}
