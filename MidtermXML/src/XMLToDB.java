import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLToDB {

	public static final String connectionURL = "jdbc:sqlserver://SANG\\SQLEXPRESS:1433;databaseName=sendXML;user=sa;password=1234";
	File f;
	
	public XMLToDB(File fileXML) {
		this.f = fileXML;
	}
	
	
	public static Connection getDBConnect() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionURL);
			return con;
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Where is driver?");
			System.out.println(e.toString());
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		return null;
	}
	
	
	
	public void sendXMLtoDB() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document doc = documentBuilder.parse(f);
			doc.getDocumentElement().normalize();
			
			// root
			System.out.println(doc.getDocumentElement().getNodeName());

			NodeList listOfStudent = doc.getElementsByTagName("student");
			for (int i = 0; i < listOfStudent.getLength(); i++) {
				Node student = listOfStudent.item(i);

				if (student.getNodeType() == Node.ELEMENT_NODE) {
					Element studentEle = (Element) student;

					NodeList nameList = studentEle.getElementsByTagName("name");
					Element nameEle = (Element) nameList.item(i);
					NodeList textName = nameEle.getChildNodes();
					String name = ((Node) textName.item(0)).getNodeValue().trim();

					NodeList genderList = studentEle.getElementsByTagName("gender");
					Element genderEle = (Element) genderList.item(i);
					NodeList textGender = genderEle.getChildNodes();
					String gender = ((Node) textGender.item(0)).getNodeValue().trim();

					NodeList addressList = studentEle.getElementsByTagName("address");
					Element addressEle = (Element) addressList.item(i);
					NodeList textAddress = addressEle.getChildNodes();
					String address = ((Node) textAddress.item(0)).getNodeValue().trim();
	  
					// sendXML
	          
	          
	          
					Connection conn = null;
					PreparedStatement sttm = null;
					try {
						String sql = "insert into Student values(?,?,?)";
						conn = getDBConnect();
						sttm = conn.prepareStatement(sql);
						sttm.setString(1, name);
						sttm.setString(2, gender);
						sttm.setString(3, address);
						if(sttm.executeUpdate() > 0) {
							System.out.println("Insert thanh cong");
						}
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.toString());
					} finally {
						try {
							sttm.close();
							conn.close();
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
	          
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}
	
	public static void main(String[] args) {
		File f = new File("C:\\Users\\DELL\\Desktop\\Document\\ki2\\Eclipse\\MidtermXML\\src\\Student.xml");
		XMLToDB c = new XMLToDB(f);
		c.sendXMLtoDB();
	}
	
}
