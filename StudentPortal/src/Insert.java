

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
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
		//MultipartRequest m=new MultipartRequest(request,"C:\\eclipse\\StudentPortal\\WebContent\\images");  
		// TODO Auto-generated method stub
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String stream=request.getParameter("stream");
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		
		Student student=new Student(name, stream, uname, password, gender, email, contact, state, city,Integer.parseInt(no));
		LoginDao lDao=new LoginDao();
		lDao.insert(student);
		
		RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
		rd.include(request,response);
		
	}

}
