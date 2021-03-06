

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String sno=request.getParameter("no");
		int no=Integer.parseInt(sno);
		LoginDao ldao=new LoginDao();
		Student s=ldao.getStudent(no);
		PrintWriter out = response.getWriter();
		out.println("<style>\r\n" + 
				"h1 {text-align: center;}\r\n" + 
				".tab {\r\n" + 
				"    display: inline-block;\r\n" + 
				"    margin-left: 100px;\r\n" + 
				"}\r\n" + 
				"</style><body>\r\n");
		out.println("<h1>Details</h1>\r\n" + 
				"\r\n" + 
				"Logged in as:"+s.getUname()+"\r\n" + 
				"<a href='logout' class='tab'>Logout</a>\r\n" + 
				"<hr><br>\r\n" + 
				"<table align=\"center\">\r\n" + 
				"<tr><td>Roll No : </td><td>"+s.getNo()+"</td></tr>\r\n" + 
				"<tr><td>Name : </td><td>"+s.getName()+"</td></tr>\r\n" + 
				"<tr><td>Stream : </td><td>"+s.getStream()+"</td></tr>\r\n" + 
				"<tr><td>Gender : </td><td>"+s.getGender()+"</td></tr>\r\n" + 
				"<tr><td>Email : </td><td>"+s.getEmail()+"</td></tr>\r\n" + 
				"<tr><td>Contact : </td><td>"+s.getContact()+"</td></tr>\r\n" + 
				"<tr><td>State : </td><td>"+s.getState()+"</td></tr>\r\n" + 
				"<tr><td>City : </td><td>"+s.getCity()+"</td></tr>\r\n" + 
				"<tr><td><br><br><a href='admin.jsp' class='tab' >Go Back to admin home</a></td></tr>\r\n" + 
				"</table>\r\n" + 
				"</body>");
		
		out.close();
	}

}
