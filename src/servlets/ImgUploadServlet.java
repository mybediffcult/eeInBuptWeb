package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


/*
 * function 上传头像
 * time     2017/2/4
 * author   Yu Yinming
 */
public class ImgUploadServlet extends HttpServlet {
	private ServletConfig config;
	final public void init(ServletConfig config) throws ServletException {
		this.config = config;
		}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("gbk");
		int count = 0;
		SmartUpload mySmartUpload = new SmartUpload(null);
		String path = "/images/Upload";
		String fileName = null;
		String img = null;
			mySmartUpload.initialize(config, request, response);
			try {
				mySmartUpload.upload();
			    
				for (int i = 0; i < mySmartUpload.getFiles().getCount(); i++) {
					com.jspsmart.upload.SmartFile myfile = mySmartUpload.getFiles().getFile(i);
					fileName = myfile.getFileName();
					count = mySmartUpload.save(path);
					
				}
				img = path + "/" + fileName;
				request.setAttribute("img", img);
				
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			
			out.println("<script>JavaScript:window.parent.location.href = window.opener.location.href;window.close();</script>");
			
			request.getRequestDispatcher("../upload.jsp").forward(request, response);
			
			

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}

