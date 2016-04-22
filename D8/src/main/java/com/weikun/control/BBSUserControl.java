package com.weikun.control;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weikun.service.BBSUserServiceImpl;
import com.weikun.service.IBBSUserService;
import com.weikun.vo.BBSUser;

/**
 * Servlet implementation class BBSUserControl
 */
@WebServlet(name="/bbsuser",urlPatterns={"/user"})
public class BBSUserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBBSUserService service=new BBSUserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSUserControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		//仅仅是控制登录的
		String action=request.getParameter("action");
		switch (action) {
		case "login":
			login(request, response);
			break;
		case "readpic":
			readpic(request, response);
			break;	
		default:
			break;
		}
		
		
	}

	private void readpic(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		InputStream is=service.readPIC(Integer.parseInt(id));
		ServletOutputStream out=null;
		try {
			out=response.getOutputStream();
			byte[] buffer=new byte[1024];
			int n=-1;
			while(  (n=is.read(buffer))!=-1  ){
				out.write(buffer, 0, n);				
			}
			out.flush();
			out.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		BBSUser user=new BBSUser();
		user.setUsername(username);
		user.setPassword(password);
		RequestDispatcher dispatcher=null;
		BBSUser user1=service.login(user);
		if(user1!=null){//登录成功,而且放到Cookie中
			request.getSession().setAttribute("user", user1);
			Cookie uc=new Cookie("papaoku",username);
			uc.setMaxAge(3600*7*24);
			Cookie pc=new Cookie("papaokp",password);
			pc.setMaxAge(3600*7*24);			
			
			response.addCookie(uc);
			response.addCookie(pc);
			
			
		}else{
			request.setAttribute("error", "用户名和密码错误，请重新登录！");
		}
		dispatcher=request.getRequestDispatcher("show.jsp");
		dispatcher.forward(request, response);
	}

}
