package com.weikun.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weikun.service.IMessageService;
import com.weikun.service.MessageServiceImpl;
import com.weikun.vo.Message;

@WebServlet(name="/messageControl",urlPatterns={"/message"})
public class MessageControl extends HttpServlet {
	private IMessageService service=new MessageServiceImpl();
	
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
		String action=req.getParameter("action");
		RequestDispatcher dispatcher=null;
		if(action.equals("add")){
			req.setCharacterEncoding("utf-8");
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String title=req.getParameter("title");

			String content=req.getParameter("content");

			Message message=new Message();
			message.setName(name);
			message.setEmail(email);
			message.setTitle(title);
			message.setContent(content);
			
			if(service.addMessage(message)){
				
				List<Message> list=service.viewMessage();
				req.setAttribute("list", list);
				dispatcher=req.getRequestDispatcher("showmessage.jsp");
				
				
			}else{
				dispatcher=req.getRequestDispatcher("index.jsp");
			}
			
		}else if(action.equals("view")){
			
			List<Message> list=service.viewMessage();
			req.setAttribute("list", list);
			dispatcher=req.getRequestDispatcher("showmessage.jsp");
		}else if(action.equals("del")){
			String id=req.getParameter("id");
			if(service.delMessage(Integer.parseInt(id))){
				dispatcher=req.getRequestDispatcher("message?action=view");
			}
			
			
		}
		dispatcher.forward(req, resp);
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

}
