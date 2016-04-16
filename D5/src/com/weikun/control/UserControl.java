package com.weikun.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weikun.service.IUserService;
import com.weikun.service.UserServiceImpl;
import com.weikun.vo.MyUser;

/**
 * Servlet implementation class UserControl
 */
@WebServlet(
		name="/UserControl",urlPatterns={"/user"},
		initParams={
				@WebInitParam(name="success",value="success.jsp"),
				@WebInitParam(name="invalid",value="index.jsp")
		}
		
	)
public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService service=new UserServiceImpl();  
    private Map <String,String> map=new HashMap<String,String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map.put("success",config.getInitParameter("success"));
		map.put("invalid",config.getInitParameter("invalid"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//服务方法
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		MyUser user=new MyUser();
		user.setUsername(username);
		user.setPwd(pwd);
		RequestDispatcher dispatcher=null;
		if(service.login(user)){			
			request.getSession().setAttribute("username", username);			
			dispatcher=request.getRequestDispatcher(map.get("success"));
		
			//response.sendRedirect();
		}else{
			dispatcher=request.getRequestDispatcher(map.get("invalid"));
			
			
		}
		dispatcher.forward(request, response);
	}

}
