
public class Student {

	
	private String name;
	private String gender;
	private String address;
	
	
	
	public Student(String name, String gender, String address) {
		this.name = name;
		this.gender = gender;
		this.address = address;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getXMLString() {
		return "	<student>\n"
				+ "		<name>"+name+"</name>\n"
				+ "		<gender>"+gender+"</gender>\n"
				+ "		<address>"+address+"</address>\n"
				+ "	</student>\r";
	}
	
}
