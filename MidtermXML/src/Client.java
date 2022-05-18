import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Client {

	JFrame frame = new JFrame();
	private JTextField tfName;
	private JTextField tfAddress;
	private JComboBox cbGender;
	private JTable table;
	
	private InetAddress host;
	private int port;
	
	public Client(InetAddress host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public static void main(String[] args) {
		try {
			new Client(InetAddress.getLocalHost(), 7000).execute();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void execute() {
		frame.getContentPane().setLayout(null);
		
		JLabel lbName = new JLabel("Name");
		lbName.setBounds(28, 53, 46, 14);
		frame.getContentPane().add(lbName);
		
		JLabel lbGender = new JLabel("Gender");
		lbGender.setBounds(28, 99, 46, 14);
		frame.getContentPane().add(lbGender);
		
		JLabel lbAddress = new JLabel("Address");
		lbAddress.setBounds(28, 148, 46, 14);
		frame.getContentPane().add(lbAddress);
		
		tfName = new JTextField();
		tfName.setBounds(121, 50, 243, 20);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(121, 145, 243, 20);
		frame.getContentPane().add(tfAddress);
		
		cbGender = new JComboBox();
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setBounds(121, 95, 243, 22);
		frame.getContentPane().add(cbGender);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student s = new Student(tfName.getText(), cbGender.getSelectedItem().toString(), tfAddress.getText());
				StringBuilder builder = new StringBuilder();
				builder.append(s.getXMLString());
				
				String body = builder.toString();
				String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
						+ "<list>\n"
						+ body
						+ "\n</list>";
				
				
				try {				
					
					Socket client = new Socket(host, port);
					ReadClient read = new ReadClient(client);
					read.start();
					WriteClient write = new WriteClient(client, xml);
					write.start();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				finally {
					try {
						
					} catch (Exception e3) {
						// TODO: handle exception
					}
				}
				

				
				
			}
		});
		btnSend.setBounds(416, 72, 89, 23);
		frame.getContentPane().add(btnSend);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 530, 136);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Gender", "Address"
			}
		));
		scrollPane.setViewportView(table);
		frame.setResizable(false);
		
		
		frame.setSize(567,375);
		frame.setVisible(true);
		
		
	}
	
	
	public void fillDataTableProduct() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		
	}
	
}

class ReadClient extends Thread{
	private Socket client;

	public ReadClient(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		DataInputStream dis = null;
		
		try {
//			dis = new DataInputStream(client.getInputStream());
//			
//			while(true) {
//				String xml = dis.readUTF();
//				System.out.println(xml);
//			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
}

class WriteClient extends Thread{
	private Socket client;
	private String xml;

	public WriteClient(Socket client, String xml) {
		this.client = client;
		this.xml = xml;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(client.getOutputStream());
			dos.writeUTF(xml);
			System.out.println("Client da gui");
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
