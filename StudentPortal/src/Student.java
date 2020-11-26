
public class Student implements Comparable<Student> {
	private String name,stream,uname , password ,gender,email ,contact,state,city;
	private int no;
	 
	public Student() {
		super();
	}

	public Student(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}

	public Student(String name, String stream, String uname, String password, String gender, String email,
			String contact, String state, String city, int no) {
		super();
		this.name = name;
		this.stream = stream;
		this.uname = uname;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.contact = contact;
		this.state = state;
		this.city = city;
		this.no = no;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.no, o.no);
	}


	
}
