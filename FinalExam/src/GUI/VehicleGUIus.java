package GUI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DB.ConnectDB;

import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VehicleGUIus {
	JFrame frame = new JFrame("Vehical management for User");
	ResultSet rs;
	ResultSetMetaData rstmeta;
	Vector vData=null, vTitle=null; 
	JTable table;
	public VehicleGUIus() {
		frame.getContentPane().setLayout(new GridLayout(2,1));
		
		ConnectDB s = new ConnectDB();
	    rs = s.SelectDB("Select * from Vehicle");
	    try {
			rstmeta = rs.getMetaData();
			int num_column = rstmeta.getColumnCount();
			
			 vTitle = new Vector(num_column);
			
			 for (int i=1; i<=num_column;i++){
			 vTitle.add(rstmeta.getColumnLabel(i));
			 }
			 
			 vData = new Vector(10,10);
			
			 while (rs.next()){
			 Vector row = new Vector(num_column);
			 for (int i=1; i<=num_column;i++)				
				 row.add(rs.getString(i));				
				 vData.add(row);
			 }			 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    /*tạo bảng để chứa thông tin truy vấn từ csdl*/
	    
	    JPanel panel = new JPanel();
	    frame.getContentPane().add(panel);
	    
	    
	    JButton btnNewButton_3 = new JButton("New button");
	    panel.add(btnNewButton_3);
	    
	    JButton btnNewButton_1 = new JButton("New button");
	    panel.add(btnNewButton_1);
	    
	    JButton btnNewButton_2 = new JButton("New button");
	    panel.add(btnNewButton_2);
	    
	    JButton btnSignOut = new JButton("Sign Out");
	    btnSignOut.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JOptionPane.showMessageDialog(null, "Sign out successfully");
				frame.dispose();
				LoginGUI log = new LoginGUI();
	    	}
	    });
	    panel.add(btnSignOut);
	    
	    JPanel panelTable = new JPanel();
	    table = new JTable(vData,vTitle);
	    JScrollPane tableResult = new JScrollPane(table);
	    panelTable.setLayout( new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, " View Table ");
		panelTable.setBorder(titleBorder);
		panelTable.add(tableResult);
		
	    frame.getContentPane().add(panelTable);
		frame.pack();
		frame.setLocation(200,30);
		frame.setSize(800,400);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new VehicleGUIus();
	}
}
