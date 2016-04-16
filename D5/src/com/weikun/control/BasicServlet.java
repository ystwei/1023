package com.weikun.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasicServlet
 */
@WebServlet(name="/BasicServlet",urlPatterns={"/h4","/h5"},
initParams={
		@WebInitParam(name="FIRST",value="first.jsp"),
		@WebInitParam(name="SECOND",value="second.jsp")
		
	})
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String,String> map=new HashMap<String,String>();
    private static final String FIRST="FIRST";
    private static final String SECOND="SECOND";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map.put(FIRST, config.getInitParameter(FIRST));
		map.put(SECOND, config.getInitParameter(SECOND));
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
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
		String key=request.getParameter("key");
		String path=map.get(key.toUpperCase());
		request.setAttribute("key", "ok");
		request.getSession().setAttribute("key", "ok");
		//response.sendRedirect(path);//重定向，不能用在request上面
		RequestDispatcher dispatcher=request.getRequestDispatcher(path);//转向
		dispatcher.forward(request, response);//<jsp:forward
		
		
		/*System.out.println("dopost");
		response.setContentType("text/html");
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1>我是哈尔滨人！</h1>");
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();*/
		
	}

}
