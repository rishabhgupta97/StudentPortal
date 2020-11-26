

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class EditAndSave
 */
@WebServlet("/EditAndSave")
public class EditAndSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAndSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
             
        String no=request.getParameter("id");  
        String name=request.getParameter("name");
        String stream=request.getParameter("stream");
        String uname=request.getParameter("uname");
        String password=request.getParameter("password");   
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        String contact=request.getParameter("contact");
          
        Student s=new Student(); 
        s.setNo(Integer.parseInt(no));
        s.setName(name);
        s.setStream(stream);
        s.setUname(uname);
        s.setPassword(password);
        s.setGender(gender);
        s.setContact(contact);
        s.setEmail(email);
        
        LoginDao ldao=new LoginDao();
        int status=ldao.update(s);  
        if(status>0){  
            response.sendRedirect("View"); 
              
        }else{  
            out.println("Record not updated");  
        }  
          
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
