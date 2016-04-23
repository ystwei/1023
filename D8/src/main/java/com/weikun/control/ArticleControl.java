package com.weikun.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weikun.service.ArticleServiceImpl;
import com.weikun.service.IArticleService;
import com.weikun.vo.Article;

/**
 * Servlet implementation class ArticleControl
 */
@WebServlet(name="/ac",urlPatterns={"/article"})
public class ArticleControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IArticleService service=new ArticleServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleControl() {
      
        // TODO Auto-generated constructor stub
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
		RequestDispatcher dispatcher=null;
		String action=request.getParameter("action");
		switch (action) {
		case "query":
			List<Article> list=service.queryArticles();
			request.setAttribute("alist", list);
			break;

		default:
			break;
		}
		dispatcher=request.getRequestDispatcher("show.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
