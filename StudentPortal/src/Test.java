

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String uname=request.getParameter("id");
		LoginDao ldao=new LoginDao();
		Student s=ldao.getStudentByUname(uname);
		out.println("<style>\r\n" + 
				"h1 {text-align: center;}\r\n" + 
				".tab {\r\n" + 
				"    display: inline-block;\r\n" + 
				"    margin-left: 100px;\r\n" + 
				"}\r\n" + 
				"</style><body>\r\n");
		out.println("<p style=\"font-size:40px\" align=\"center\" >Reset Password</p>\r\n" + 
				"\r\n" + 
				"<form action ='Update' method=\"post\">\r\n" + 
				"<table align=\"center\">\r\n" + 
				"<tr><td> Username</td> <td><input type=\"text\" name='name' value='"+uname+"' required></td></tr>\r\n" + 
				"<tr><td>Set Password</td> <td><input type='password' name='pass'></td></tr><tr> <td><input type=\"submit\" value=\"Update\"></td></tr>\r\n" + 
				"</table>\r\n" + 
				"</form>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
