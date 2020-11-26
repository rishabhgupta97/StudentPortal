

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditReal
 */
@WebServlet("/EditReal")
public class EditReal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditReal() {
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
		out.println("<style>\r\n" + 
				".tab {\r\n" + 
				"    display: inline-block;\r\n" + 
				"    margin-left: 500px;\r\n" + 
				"}\r\n" + 
				"intput[type=radio] {\r\n" + 
				"  padding-top: 500%;\r\n" + 
				"  padding-bottom: 500%;\r\n" + 
				"}\r\n" + 
				"input[type=submit] {\r\n" + 
				"  background-color: gray;\r\n" + 
				"  border: none;\r\n" + 
				"  color: white;\r\n" + 
				"  text-decoration: none;\r\n" + 
				"  margin-left: 60px;\r\n" + 
				"  \r\n" + 
				"  cursor: pointer;\r\n" + 
				"  box-sizing: border-box;\r\n" + 
				"  padding: 12px 20px;\r\n" + 
				"  width: 100%;\r\n" + 
				"}\r\n" + 
				"select,input[type=text],[type=password],[type=number],[type=email],[type=tel] {\r\n" + 
				"  width: 100%;\r\n" + 
				"  padding: 12px 20px;\r\n" + 
				"  margin: 8px 0;\r\n" + 
				"  box-sizing: border-box;  \r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</style>");
		out.println("<body><h1 align=\"center\">Update Student</h1>");  
		String sid=request.getParameter("id");    
		LoginDao ldao=new LoginDao();
		int id=Integer.parseInt(sid);
		Student s=ldao.getStudent(id); 
		out.print("<form action='EditAndSave' method='post'>");  
        out.print("<table align=\"center\">");  
        out.print("<tr><td>Roll no</td><td><input type='text' name='id' value='"+s.getNo()+"' readonly/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+s.getName()+"'/></td></tr>"); 
        out.print("<tr><td>Stream</td><td><select name=\"stream\">\r\n" + 
        		"<option value=\"Select Stream\">Select Stream</option>\r\n" + 
        		"  <option value=\"Computer Science\" selected>Computer Science</option>\r\n" + 
        		"  <option value=\"Information Technology\">Information Technology</option>\r\n" + 
        		"  <option value=\"Electrical\">Electrical</option>\r\n" + 
        		"  <option value=\"Electroncs and Communication\">Electroncs and Communication</option>\r\n" + 
        		"  <option value=\"Civil\">Civil</option>\r\n" + 
        		"</select></td></tr>");
        out.print("<tr><td>UserName:</td><td><input type='text' name='uname' value='"+s.getUname()+"'/></td></tr>");
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+s.getPassword()+"'/></td></tr>");
        out.print("<tr><td> Gender</td> <td><input type=\"radio\" name=\"gender\" value=\"male\"> Male\r\n" + 
        		"  <input type=\"radio\" name=\"gender\" value=\"female\" checked> Female\r\n" + 
        		"  <input type=\"radio\" name=\"gender\" value=\"other\"> Other</td></tr>");
        out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+s.getEmail()+"'/></td></tr>");
        out.print("<tr><td>Contact:</td><td><input type='text' name='contact' value='"+s.getContact()+"'/></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form><a href=\"View\" class=\"tab\" >Go Back </a></body>");
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
