

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMail() {
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
	String name, subject, email, msg;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
       
        email = request.getParameter("email");
        name=request.getParameter("name");
       

        final String username = "rishabh15203492@gmail.com";//your email id
        final String password = "Rishabh#97";// your password
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
            message.setContent("<!DOCTYPE html><html><body><a href='http://localhost:8087/StudentPortal/Test?id="+name+"'>Click on this to reset password</a></body></html>", "text/html" );
//            MimeBodyPart textPart = new MimeBodyPart();
//            Multipart multipart = new MimeMultipart();
//            String final_Text = "Message: " + msg+"<!DOCTYPE html><html><body><a href='Test?id="+name+"'>Click on this to reset password</a><body><html>";
//            textPart.setText(final_Text);
//            message.setSubject(subject);
//            multipart.addBodyPart(textPart);
//            message.setContent(multipart,"text/html");
//            message.setSubject("Contact Details");
            
            
            
            //out.println("Sending");
            Transport.send(message);
            out.println("<center><h2 style='color:green;'>Email Sent Successfully.</h2>");
            out.println("Thank you " + name + ", your message has been submitted to us.</center>");
            
            out.println("<a href='default.jsp'>Go back to login page</a>");
        } catch (Exception e) {
            out.println(e);
        }
	}

}
