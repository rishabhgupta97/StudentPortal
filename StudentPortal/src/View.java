

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        out.println("<h1 align='center'>Student List</h1>");  
        LoginDao lDao=new LoginDao();
        ArrayList<Student> list=lDao.getAllStudent(); 
        
        out.println("<style>.tab {\r\n" + 
        		"    display: inline-block; align='center';\r\n" + 
        		"    margin-left: 500px;\r\n" + 
        		"}</style>");
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Roll No</th><th>Name</th><th>User name</th><th>Password</th><th>Email</th><th>contact</th><th>Edit</th><th>Delete</th></tr>");  
        for(Student s:list){  
        // out.print("<tr><td>"+s.getNo()+"</td><td>"+s.getName()+"</td><td>"+s.getUname()+"</td><td>"+s.getPassword()+"</td><td>"+s.getEmail()+"</td><td>"+s.getContact()+"</td><td><a href='EditReal?id="+s.getNo()+"'>edit</a></td><td><a href='DeleteServlet?id="+s.getNo()+"'>delete</a></td></tr>");   
        	out.print("<tr><td>"+s.getNo()+"</td><td>"+s.getName()+"</td><td><a href='WelcomeServlet?uname="+s.getUname()+"'>"+s.getUname()+"</a></td><td>"+s.getPassword()+"</td><td>"+s.getEmail()+"</td><td>"+s.getContact()+"</td><td><a href='EditReal?id="+s.getNo()+"'>edit</a></td><td><a href='DeleteServlet?id="+s.getNo()+"'>delete</a></td></tr>");   
            
        }  
        out.print("</table><br><a href='insert.jsp' class='tab'>Add New Student</a><br><br><a href=\"admin.jsp\" class=\"tab\" >Go Back to admin home</a>");  
        
        out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
	}

}
