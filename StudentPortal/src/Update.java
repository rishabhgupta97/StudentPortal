

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String uname=request.getParameter("name");
		String pass=request.getParameter("pass");
		LoginDao ldao=new LoginDao();
		Student s=ldao.getStudentByUname(uname);
		ldao.update(s,uname,pass);
		
//		RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
//		rd.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String uname=request.getParameter("name");
		String pass=request.getParameter("pass");
		LoginDao ldao=new LoginDao();
		Student s=ldao.getStudentByUname(uname);
		ldao.update(s,uname,pass);
		//out.println(uname);
//		ldao.Update(uname,pass);
//		
//		RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
//		rd.include(request,response);
	}

}
