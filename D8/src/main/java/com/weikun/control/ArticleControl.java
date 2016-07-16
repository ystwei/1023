package com.weikun.control;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.weikun.vo.BBSUser;
import com.weikun.vo.PageBean;

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
		
		PageBean pb=null;
		switch (action) {
		case "del":{//根据主帖rootid查询所有从贴
			String id=request.getParameter("id");//要删除帖子的id
			String rootid=request.getParameter("rootid");//主帖id
			
			String json=service.deleteCtById(Integer.parseInt(id), Integer.parseInt(rootid));
			
			response.setCharacterEncoding("utf-8");			
			response.setContentType("text/html");			
			
			PrintWriter out=response.getWriter();
			
			out.println(json);
			
			out.flush();
			
			return;
		}
		case "queryid":{//根据主帖rootid查询所有从贴
			
			String rootid=request.getParameter("id");//主帖id
			String json=service.queryCTById(Integer.parseInt(rootid));			
			response.setCharacterEncoding("utf-8");			
			response.setContentType("text/html");			
			
			PrintWriter out=response.getWriter();
			
			out.println(json);
			
			out.flush();
			
			out.close();
			return;
		}
		
		case "query":{
			String page=request.getParameter("page");
			int userid= request.getSession().getAttribute("user")==null?999:((BBSUser)request.getSession().getAttribute("user")).getId();
			pb=service.queryArticles(Integer.parseInt(page),userid);
			
			
			break;
		}
		case "delete":{
			String id1=request.getParameter("id");
			pb=service.deleteArticle(Integer.parseInt(id1));
		
			 
			break;
		}
		case "reply":{//加回贴
			Article a=new Article();
			String title=request.getParameter("title");
			String rootid=request.getParameter("rootid");
			String content=request.getParameter("content");
			String uid=request.getParameter("userid");
			BBSUser user=new BBSUser();
			user.setId(Integer.parseInt(uid));
			a.setUser(user);
			a.setTitle(title);
			a.setContent(content);
			a.setRootid(Integer.parseInt(rootid));
			service.addArticle(a);
						
			
			
			dispatcher=request.getRequestDispatcher("article?action=queryid&id="+rootid);
			dispatcher.forward(request, response);
			
			
			
			return;
		}
		case "add":{//加主贴
			Article a=new Article();
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			String uid=request.getParameter("userid");
			BBSUser user=new BBSUser();
			user.setId(Integer.parseInt(uid));
			a.setUser(user);
			a.setTitle(title);
			a.setContent(content);
			a.setRootid(0);
			pb=service.addArticle(a);
						
			break;
		}
		default:
			break;
		}
		request.setAttribute("pb", pb);
		dispatcher=request.getRequestDispatcher("show.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
