package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import vo.Users;
import biz.UsersBiz;

/**
 * 查看报名学员详细信息
 * @author yyming
 * @version1.0
 * 2017-02-10
 */
public class ViewUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uid = (String)request.getParameter("uid");
		System.out.println("ViewUserServlet--------------------------uid :"+uid);
		UsersBiz biz=new UsersBiz();
		Users bMUser = biz.searchBM(uid);
		request.setAttribute("bMUser", bMUser);
		request.getRequestDispatcher("index.jsp?page=showBMUsers").forward(request, response);
	}
}

