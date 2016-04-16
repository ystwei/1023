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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(name="/HelloServlet",urlPatterns={"/h1","/h2"},
initParams={
		@WebInitParam(name="FIRST",value="first.jsp"),
		@WebInitParam(name="SECOND",value="second.jsp")

})
public class HelloServlet extends HttpServlet {
	public static final String FIRST="FIRST";
	public static final String SECOND="SECOND";
	private static final long serialVersionUID = 1L;
    private HashMap<String,String> map=new HashMap<String,String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {//1创建servlet实例
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //3
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//3
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page=request.getParameter("page");
		
		
		request.setAttribute("key", "OK");
		
		//servlet协作
		RequestDispatcher dispatcher=request.getRequestDispatcher(map.get(page.toUpperCase()));
		dispatcher.forward(request, response);
		//response.sendRedirect(map.get(page.toUpperCase()));//跳转
		
		
//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		
//		PrintWriter out=response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>");
//		out.println("</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>我很帅！</h1>");
//		out.println("</body>");
//		out.println("</html>");
//		
//		out.flush();
//		out.close();
//		
	}
	@Override
	public void destroy() {//4
		// TODO Auto-generated method stub
		super.destroy();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map.put(FIRST, config.getInitParameter(FIRST));
		map.put(SECOND, config.getInitParameter(SECOND));
	}
}
