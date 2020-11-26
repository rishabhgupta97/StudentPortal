

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	
		PrintWriter out = response.getWriter();
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		Student student=new Student(uname, password);
		LoginDao lDao=new LoginDao();
		boolean result=lDao.isValidated(student);
		request.setAttribute("userName", uname);
		if(result){
			if(uname.equals("admin") && password.equals("admin")) {
				RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
				rd.forward(request,response);
			}else {
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
			rd.forward(request,response);
			}
		}
		else{
			out.print("Login failed.Try again..");
			RequestDispatcher rd=request.getRequestDispatcher("default.jsp");
			rd.include(request,response);
		}
	}

}
