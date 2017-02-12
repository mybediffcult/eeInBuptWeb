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

/**登陆验证
 * @author yyming
 * @version1.0
 * 2017-02-09
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	
	
	
	/**暂时没用   将来可用来实现网站在线人数
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		ServletContext application=this.getServletContext();
		String aname=request.getParameter("uid");
		String apass=request.getParameter("upass");
		UsersBiz aBiz=new UsersBiz();
		Users adm=aBiz.login(aname,apass);
		/**
		 * I. 管理员、教师直接进入网站
		 * II.普通用户需进行判断
		 * 1).未报名
		 * 去报名页面(提供返回首页按钮)
		 * 2).已报名
		 * 1.已通过审核
		 * 进入网站
		 * 2.未通过审核
		 * 前往显示“正在审核中....”的审核页面(提供返回首页按钮)
		 * 
		 * 身份权限 ：upower varchar
		 * 0   管理员
		 * 1   普通学生
		 * 10 教师
		 */
		if(adm!=null){
			String upower = adm.getUpower();
			System.out.println("---------------------------------------------");
			System.out.println("用户等级 ："+upower);
			//管理员、教师直接进入网站
			if(upower.equals("0") || upower.equals("10")){
				//进入网站
				System.out.println("进入网站");
				List<String> nameList=(List<String>)application.getAttribute("OnlineNameList");
	            if(!nameList.contains(aname)){
	            	session.setAttribute("users",adm );
	            	session.setAttribute("aname", aname);
	            	nameList.add(aname);
	            	//将网站在线人员名单放入session,那不用放进Application么？
	            	session.setAttribute("OnlineNameList", nameList);
	            	response.sendRedirect("learning/MenuServlet?ms=1");
	            }else{
	            	response.sendRedirect("index.jsp?ms=0");
	            	
	            }
			}
			//普通用户需进行判断
			else{
				String bm = "0";
				if (bm.equals("0")){
					//未报名,去报名页面(提供返回首页按钮)
					response.sendRedirect("index.jsp");
				}
				else{
					//已报名
					String bmShenHe = "0";
					if (bmShenHe.equals("0")){
						//未通过审核,前往显示“正在审核中....”的审核页面(提供返回首页按钮)
						response.sendRedirect("index.jsp");
					}
					else{
						//已通过审核 ,进入网站
						List<String> nameList=(List<String>)application.getAttribute("OnlineNameList");
			            if(!nameList.contains(aname)){
			            	session.setAttribute("users",adm );
			            	session.setAttribute("aname", aname);
			            	nameList.add(aname);
			            	//将网站在线人员名单放入session,那不用放进Application么？
			            	session.setAttribute("OnlineNameList", nameList);
			            	response.sendRedirect("learning/MenuServlet?ms=1");
			            }else{
			            	response.sendRedirect("index.jsp?ms=0");
			            	
			            }
					}
				}
			}
			
	
		}
	}
	
	
	
	
	
	
	/**
	 * 默认执行的方法
	 */

protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	String indexParam = request.getParameter("indexParam");
	System.out.print("========================LoginServlet "+indexParam);
	String name=request.getParameter("uid");
	String pass=request.getParameter("upass");
	UsersBiz biz=new UsersBiz();
	Users users=biz.login(name,pass);
	
	
	if(indexParam==null || indexParam.equals("")){
		//使用登陆按钮进来的登陆
	if(users!=null){   //1
		/**
		 * 正常登陆按钮进来的登陆验证
		 * 
		 * I. 管理员、教师直接进入网站
		 * II.普通用户需进行判断
		 * 1).未报名
		 * 去报名页面(提供返回首页按钮; 查询注册字段并在页面显示出来)
		 * 2).已报名
		 * 1.已通过审核
		 * 进入网站
		 * 2.未通过审核
		 * 前往显示“正在审核中....”的审核页面(提供返回首页按钮)
		 * 
		 * 身份权限 ：upower varchar
		 * 0   管理员
		 * 1   普通学生
		 * 10 教师
		 * 
		 * 报名权限： ubaoming varchar
		 * 0  未报名
		 * 1  已报名
		 * 
		 * 报名审核通过权限： ubmShenHe varchar
		 * 0 未通过审核
		 * 1 已通过审核
		 */
		
		String upower = users.getUpower();
		System.out.println("用户等级 ："+upower);
		//管理员、教师直接进入网站
		if(upower.equals("0") || upower.equals("10")){ //2
			//进入网站
			HttpSession session=request.getSession();
			session.setAttribute("users",users);
			response.sendRedirect("learning/MenuServlet");
            }//2
		
        		//普通用户需进行判断
        		else{//3
        			String ubaoming = "0";
//        			UsersBiz biz2=new UsersBiz();
//        			ubaoming = biz2.baoming(name);
        			ubaoming = users.getUbaoming();
        			System.out.println("--------------------------------------报名状态 :"+ubaoming);
        			if (ubaoming.equals("0")){
        				//未报名,去报名页面(提供返回首页按钮)
        				HttpSession session = request.getSession();
        				session.setAttribute("ubaoming_users", users);
        				response.sendRedirect("signup.jsp");
        			}
        			else{
        				//已报名
        				String ubmShenHe = "0";
//        				UsersBiz biz3=new UsersBiz();
//        				ubmShenHe = biz3.bmShenHe(name);
        				ubmShenHe = users.getUbmShenHe();
        				if (ubmShenHe.equals("0")){
        					//未通过审核,前往显示“正在审核中....”的审核页面(提供返回首页按钮)
        					response.sendRedirect("shenHeMessage.jsp");
        				}
        				else{
        					//已通过审核 ,进入网站
        					HttpSession session=request.getSession();
        					session.setAttribute("users",users);
        					response.sendRedirect("learning/MenuServlet");
        		            }
        				}
        			}//3
            	
          
		}   //1
	else{
		//登陆失败
		response.sendRedirect("index.jsp?msg=10");
	}
  }//使用登陆按钮进来的登陆
	else{
		//使用链接进来的登陆
		/**
		 * 链接进来的登陆的登陆验证
		 * 
		 * I.  使用登陆按钮进来的登陆，按正常逻辑进行登陆判定
		 * II. 使用超链接进来的登陆，要进行链接判定，从而进行不同的逻辑处理
		 * 1).链接判定
		 *  .0           表示该请求来自于“学籍系统”链接
	        .1      表示该请求来自于“学员中心”链接
	        .其他      表示该请求来自于其他链接
	        2).允许登陆的前提下，页面跳转
	            1.链接判定为 0 
	                upower=="0" -->进入学籍系统(按管理员身份登陆即可)   --管理员
	                upower!="0" -->错误提示页（对不起！您没有操作权限） --非管理员
	            2.链接判定为 1
	                upower=="1" -->进入学员中心(按普通学员身份登陆即可)   --普通学员
	                upower!="1" -->错误提示页（对不起！您没有操作权限）   --非普通学员 
		 */
		if(indexParam.equals("0")){
			//链接来自于“学籍系统”
			if(users!=null){   //1
				String upower = users.getUpower();
				System.out.println("用户等级 ："+upower);
				//管理员直接进入网站
				if(upower.equals("0") ){ //2
					//进入网站
					HttpSession session=request.getSession();
					session.setAttribute("users",users);
					response.sendRedirect("learning/MenuServlet");
		            }//2
				else{
					//前往 错误提示页（对不起！您没有操作权限） --非管理员
					request.setAttribute("err", "<font color='red'>对不起！您没有操作权限</font>");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}   //1
			else{
				//登陆失败
				response.sendRedirect("index.jsp?msg=10");
			}
			
		}else if(indexParam.equals("1")){
			//链接来自于“学员中心(在线学习)”
			if(users!=null){   //1
				String upower = users.getUpower();
				System.out.println("用户等级 ："+upower);
				//普通学员直接进入网站
				if(upower.equals("1") ){ //2
	        		//普通用户需进行判断
	        			String ubaoming = "0";
//	        			UsersBiz biz2=new UsersBiz();
//	        			ubaoming = biz2.baoming(name);
	        			ubaoming = users.getUbaoming();
	        			System.out.println("--------------------------------------报名状态 :"+ubaoming);
	        			if (ubaoming.equals("0")){
	        				//未报名,去报名页面(提供返回首页按钮)
	        				HttpSession session = request.getSession();
	        				session.setAttribute("ubaoming_users", users);
	        				response.sendRedirect("signup.jsp");
	        			}
	        			else{
	        				//已报名
	        				String ubmShenHe = "0";
//	        				UsersBiz biz3=new UsersBiz();
//	        				ubmShenHe = biz3.bmShenHe(name);
	        				ubmShenHe = users.getUbmShenHe();
	        				if (ubmShenHe.equals("0")){
	        					//未通过审核,前往显示“正在审核中....”的审核页面(提供返回首页按钮)
	        					response.sendRedirect("shenHeMessage.jsp");
	        				}
	        				else{
	        					//已通过审核 ,进入网站
	        					HttpSession session=request.getSession();
	        					session.setAttribute("users",users);
	        					response.sendRedirect("learning/MenuServlet");
	        		            }
	        				}
		            }//2
				else{
					//前往 错误提示页（对不起！您没有操作权限） --非管理员
					request.setAttribute("err", "<font color='red'>对不起！您没有操作权限</font>");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}   //1
			else{
				//登陆失败
				response.sendRedirect("index.jsp?msg=10");
			}
		}else if(indexParam.equals("10")){
			//该链接来自于班主任管理
			if(users!=null){   //1
				String upower = users.getUpower();
				System.out.println("用户等级 ："+upower);
				//管理员直接进入网站
				if(upower.equals("10") ){ //2
					//进入网站
					HttpSession session=request.getSession();
					session.setAttribute("users",users);
					response.sendRedirect("learning/MenuServlet");
		            }//2
				else{
					//前往 错误提示页（对不起！您没有操作权限） --非管理员
					request.setAttribute("err", "<font color='red'>对不起！您没有操作权限</font>");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}   //1
			else{
				//登陆失败
				response.sendRedirect("index.jsp?msg=10");
			}
		}else{
			//其他链接
			/**
			 * 用于后期扩展
			 */
		}
		
	}
 }
}
