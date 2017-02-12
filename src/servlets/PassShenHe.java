package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Users;
import biz.UsersBiz;

/**报名审核通过
 * @author yyming
 * @version1.0
 * 2017-02-10
 * Servlet implementation class LoginServlet
 */
public class PassShenHe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassShenHe() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = request.getParameter("uid");
		UsersBiz bz = new UsersBiz();
		int temp = -1;
		temp = bz.passShenHe(uid);
		String err = null;
		if(temp==1){
			err = "<font color='red'>操作成功！</font>";
		}else{
			err = "<font color='red'>操作失败！请重新尝试</font>";
		}
		request.setAttribute("err", err);
		request.getRequestDispatcher("viewusers?uid="+uid).forward(request, response);
	}

	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}
