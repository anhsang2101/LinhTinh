

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Server {
	
	private int port;

	public Server(int port) {
		this.port = port;
	}
	
	private void execute() {
		
		try {
			ServerSocket server = new ServerSocket(port);
			
			System.out.println("Server is listening...");
			while(true) {
				Socket socket = server.accept();
				System.out.println("Connected with " + socket);
				ReadServer read = new ReadServer(socket);
				read.start();
				WriteServer write = new WriteServer(socket);
				write.start();
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		Server s = new Server(7000);
		s.execute();
	}
	
	class ReadServer extends Thread{
		private Socket socket;
		XMLToDB c;

		public ReadServer(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			DataInputStream dis = null;
			FileOutputStream fos = null;
			
			try {
				dis = new DataInputStream(socket.getInputStream());
				
				String xml = dis.readUTF();
				System.out.println("Server da nhan");
				
				File f = new File("C:\\Users\\DELL\\Desktop\\Document\\ki2\\Eclipse\\MidtermXML\\src\\Student.xml");
				
				fos = new FileOutputStream(f);
				
				byte[] data = xml.getBytes();
				
				fos.write(data);
				
				c = new XMLToDB(f);
				c.sendXMLtoDB();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				try {
					fos.close();
				} catch (Exception e3) {
					// TODO: handle exception
				}
			}
		}
		
			
	}

	class WriteServer extends Thread{
		
		private Socket socket;
		private String xml;


		public WriteServer(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			DataOutputStream dos = null;
			try {
				
//					
//				dos = new DataOutputStream(socket.getOutputStream());
//				dos.writeUTF("Server: " + xml);
//				
					
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
