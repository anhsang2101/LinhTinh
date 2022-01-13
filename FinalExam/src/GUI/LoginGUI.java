package GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DB.ConnectDB;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoginGUI {
	JFrame frame = new JFrame("Login");
	private JTextField tfUsername;
	private JPasswordField passwordField;
	
	
	public LoginGUI(){
		frame.getContentPane().setLayout(new GridLayout(4,1));
		
		JLabel lbUsername = new JLabel("User Name");
		frame.getContentPane().add(lbUsername);
		
		tfUsername = new JTextField();
		frame.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lbPassword = new JLabel("Password");
		frame.getContentPane().add(lbPassword);
		
		passwordField = new JPasswordField();
		frame.getContentPane().add(passwordField);
		
		JLabel lbRole = new JLabel("Role");
		frame.getContentPane().add(lbRole);
		
		JComboBox Role = new JComboBox();
		Role.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
		frame.getContentPane().add(Role);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = tfUsername.getText();
                String password = passwordField.getText();
				try {
					ConnectDB connect = new ConnectDB();
					ResultSet rs = connect.SelectDB("Select * from Account where role='"+Role.getSelectedItem().toString()+"'and username='"+tfUsername.getText()+"' and password='"+passwordField.getText()+"'");
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Sign in successfully");
						frame.dispose();
						if(Role.getSelectedItem().toString()=="Admin") {
							VehicleGUIad vAd = new VehicleGUIad();
						}
						else {
							VehicleGUIus vUs = new VehicleGUIus();
						}
					}	
					else
						JOptionPane.showMessageDialog(null, "Wrong password or username");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		frame.getContentPane().add(btnSignIn);
		
		
		
		frame.pack();
		frame.setLocation(400,200);
		frame.setSize(500,150);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new LoginGUI();
	}
}
