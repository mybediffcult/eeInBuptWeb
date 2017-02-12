package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Users;

import biz.UsersBiz;


/**
 * @Method SignUpServlet()
 * @Description 在线报名模块--处理注册信息
 * @author yym 2017.02.04
 * @return
 */
public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 构造方法
	public SignUpServlet() {
		super();
	}

	// 销毁方法
	public void destroy() {
		super.destroy();
	}

	// doPost方法用doGet（）方法来处理
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// 处理业务逻辑
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String uname = null;
		String uUnit = null;
		String uPhone = null;
		String uMail = null;
		String uMicroMsg = null;
		String uIdCard = null;
//		String imgPath = null;    
		String uUnitPhone = null;
		//头像 add 2017/02/04
		String uIdentification = null;
		//新增性别 ,年龄2017-02-10
		String usex = null;
		String uage = null;
		uname = request.getParameter("username");
		uUnit = request.getParameter("unit");
		uPhone = request.getParameter("phone");
		uMail = request.getParameter("mail");
		uMicroMsg = request.getParameter("microMsg");
		uIdCard = request.getParameter("idCard");
		uIdentification = request.getParameter("img");
		uUnitPhone = request.getParameter("unitphone");
		usex = request.getParameter("usex");
		uage = request.getParameter("uage");
		Users users = (Users) request.getSession().getAttribute("ubaoming_users");
		users.setUname(uname);
		users.setuUnit(uUnit);
		users.setuUnitPhone(uUnitPhone);
		users.setuPhone(uPhone);
		users.setuMail(uMail);
		users.setuMicroMsg(uMicroMsg);
		users.setuIdCard(uIdCard);
		users.setuIdentification(uIdentification);
		users.setUsex(usex);
		users.setUage(Integer.parseInt(uage));
		//设置报名属性为"1"表示已报名
		users.setUbaoming("1");
		UsersBiz biz=new UsersBiz();
		int flag = biz.signup(users);
		
		{
					if (flag == 1) {
						// 注册成功
						request.setAttribute("err",
								"<font color=\"red\">报名成功！</font>");
						RequestDispatcher rd = getServletContext()
								.getRequestDispatcher("/shenHeMessage.jsp");
						rd.forward(request, response);
					} else {
						request.setAttribute("err",
								"<font color=\"red\">出现异常，请重新尝试！</font>");
						RequestDispatcher rd = getServletContext()
								.getRequestDispatcher("/signup.jsp");
						rd.forward(request, response);
					}
		
	}
}

	// 初始化方法
	public void init() throws ServletException {
	}
}
