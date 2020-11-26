import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginDao {

	private String dburl="jdbc:mysql://localhost:3306/studentdatabase";
	private String dbuname="root";
	private String dbpassword="root";
	private String dbdriver="com.mysql.jdbc.Driver";
	public Connection getConnection() throws ClassNotFoundException {
		Class.forName(dbdriver);
		Connection con=null;
		try {
			con=DriverManager.getConnection(dburl, dbuname, dbpassword);
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public void insert(Student student)  {
		JFrame f=new JFrame(); 
		try {
			Connection con=getConnection();
			String sql="Insert into loginstudent values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,student.getNo());
			ps.setString(2,student.getName());
			ps.setString(3,student.getStream());
			ps.setString(4,student.getUname());
			ps.setString(5, student.getPassword());
			ps.setString(6,student.getGender());
			ps.setString(7, student.getEmail());
			ps.setString(8, student.getContact());
			ps.setString(9,student.getState());
			ps.setString(10,student.getCity());
			ps.setString(11,"image");
			ps.executeLargeUpdate();
			 
	        JOptionPane.showMessageDialog(f,"Successfully inserted");  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(f,"Error Occured");
		}

		
	}
	public void update(Student s,String uname,String pass)  {
		JFrame f=new JFrame(); 
		try {
			Connection con=getConnection();
			String sql="Update loginstudent set password=? where username=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,pass);
			ps.setString(2, uname);
			
			ps.executeLargeUpdate();
			 
	        JOptionPane.showMessageDialog(f,"Successfully Updated");  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(f,"Error Occured");
		}

		
	}

	public boolean isValidated(Student student) {
		boolean status=false;
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from loginstudent where username=? and password=?");
			ps.setString(1,student.getUname());
			ps.setString(2, student.getPassword());

			ResultSet rs=ps.executeQuery();
			status=rs.next();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}
	public ArrayList<Student> getAllStudent(){  
		ArrayList<Student> list=new ArrayList<Student>();  

		try{  
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from loginstudent");  
			ResultSet rs=ps.executeQuery();  
			while(rs.next()){  
				Student s=new Student();  
				s.setNo(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setStream(rs.getString(3));
				s.setUname(rs.getString(4));  
				s.setPassword(rs.getString(5));
				s.setGender(rs.getString(6));
				s.setEmail(rs.getString(7));
				s.setContact(rs.getString(8));
				s.setState(rs.getString(9));
				s.setCity(rs.getString(10));
				list.add(s);  
			}  
			con.close();  
		}catch(Exception e){e.printStackTrace();}  

		return list;  
	}  

	public int delete(int id){  
		int status=0;  
		try{  
			Connection con=getConnection();  
			PreparedStatement ps=con.prepareStatement("delete from loginstudent where no=?");  
			ps.setInt(1,id);  
			status=ps.executeUpdate();  

			con.close();  
		}catch(Exception e){e.printStackTrace();}  

		return status;  
	}  
	public Student getStudent(int id){  
		Student s=new Student(); 

		try{  
			Connection con=getConnection();  
			PreparedStatement ps=con.prepareStatement("select * from loginstudent where no=?");  
			ps.setInt(1,id);  
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){  
				s.setNo(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setStream(rs.getString(3));
				s.setUname(rs.getString(4));
				s.setPassword(rs.getString(5));
				s.setGender(rs.getString(6));
				s.setEmail(rs.getString(7));
				s.setContact(rs.getString(8));
				s.setState(rs.getString(9));
				s.setCity(rs.getString(10));
			}  
			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return s;  
	} 
	public int update(Student s){  
		int status=0;  
		try{  
			Connection con=getConnection();  
			PreparedStatement ps=con.prepareStatement("update loginstudent set username=?,password=?,email=?,contact=?,name=?,gender=?,stream=? where no=?");  
			 
			ps.setString(1,s.getUname());
			ps.setString(2,s.getPassword());  
			ps.setString(3,s.getEmail()); 
			ps.setString(4,s.getContact()); 
			ps.setString(5,s.getName());
			ps.setString(6,s.getGender());
			ps.setString(7,s.getStream());
			ps.setInt(8,s.getNo()); 
			status=ps.executeUpdate();  

			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return status;  
	}  
	
	public Student getStudentByUname(String uname){  
		Student s=new Student(); 

		try{  
			Connection con=getConnection();  
			PreparedStatement ps=con.prepareStatement("select * from loginstudent where username=?");  
			ps.setString(1,uname);  
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){  
				s.setNo(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setStream(rs.getString(3));
				s.setUname(rs.getString(4));
				s.setPassword(rs.getString(5));
				s.setGender(rs.getString(6));
				s.setEmail(rs.getString(7));
				s.setContact(rs.getString(8));
				s.setState(rs.getString(9));
				s.setCity(rs.getString(10));
			}  
			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return s;  
	} 
}
