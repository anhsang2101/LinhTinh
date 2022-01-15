package GUI;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import Model.Vehicle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DB.ConnectDB;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class VehicleGUIad {
	JFrame frame = new JFrame("Vehical management for Admin");
	private JTextField tfOwnerName;
	private JTextField tfIdentityCard;
	private JTextField tfLicensePlate;
	private JTextField tfChassisNumber;
	private JTextField tfEngineNumber;
	private JTextField tfBrand;
	JTable table;
	ResultSet rs;
	ResultSetMetaData rstmeta;
	Vector vData=null, vTitle=null; 
	public VehicleGUIad() {
		frame.getContentPane().setLayout(new GridLayout(2,1));
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(8,1));
		frame.getContentPane().add(mainPanel);
		
		
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
		
		
		
		JPanel panelTitle = new JPanel();
		mainPanel.add(panelTitle);
		
		JLabel lblTitle = new JLabel("Vehicle Management");
		panelTitle.add(lblTitle);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitle.setForeground(Color.RED);
		
		JPanel panelName = new JPanel();
		mainPanel.add(panelName);
		
		JLabel lbOwnerName = new JLabel("Owner Name");
		panelName.add(lbOwnerName);
		
		tfOwnerName = new JTextField();
		panelName.add(tfOwnerName);
		tfOwnerName.setColumns(50);
		
		JPanel panelIdentityCard = new JPanel();
		mainPanel.add(panelIdentityCard);
		
		JLabel lbIdentityCard = new JLabel("Identity Card");
		panelIdentityCard.add(lbIdentityCard);
		
		tfIdentityCard = new JTextField();
		panelIdentityCard.add(tfIdentityCard);
		tfIdentityCard.setColumns(50);
		
		JPanel panelVehicleTypeAndLicensePlate = new JPanel();
		mainPanel.add(panelVehicleTypeAndLicensePlate);
		
		JLabel lbVehicleType = new JLabel("Vehicle Type");
		panelVehicleTypeAndLicensePlate.add(lbVehicleType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Car", "Motobike"}));
		
		panelVehicleTypeAndLicensePlate.add(comboBox);
		
		JPanel space = new JPanel();
		panelVehicleTypeAndLicensePlate.add(space);
		
		JLabel lbLicensePlate = new JLabel("License Plate");
		panelVehicleTypeAndLicensePlate.add(lbLicensePlate);
		
		tfLicensePlate = new JTextField();
		panelVehicleTypeAndLicensePlate.add(tfLicensePlate);
		tfLicensePlate.setColumns(15);
		
		JPanel space1 = new JPanel();
		panelVehicleTypeAndLicensePlate.add(space1);
		
		JLabel lbBrand = new JLabel("Brand");
		panelVehicleTypeAndLicensePlate.add(lbBrand);
		
		tfBrand = new JTextField();
		panelVehicleTypeAndLicensePlate.add(tfBrand);
		tfBrand.setColumns(13);
		
		JPanel panelChassisNumber = new JPanel();
		mainPanel.add(panelChassisNumber);
		
		JLabel lbChassisNumber = new JLabel("Chassis Number");
		panelChassisNumber.add(lbChassisNumber);
		
		tfChassisNumber = new JTextField();
		panelChassisNumber.add(tfChassisNumber);
		tfChassisNumber.setColumns(49);
		
		JPanel panelEngineNumber = new JPanel();
		mainPanel.add(panelEngineNumber);
		
		JLabel lbEngineNumber = new JLabel("Engine Number");
		panelEngineNumber.add(lbEngineNumber);
		
		tfEngineNumber = new JTextField();
		panelEngineNumber.add(tfEngineNumber);
		tfEngineNumber.setColumns(50);
		
		JPanel panelButton = new JPanel();
		mainPanel.add(panelButton);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public boolean validateForm() {
				if(tfLicensePlate.getText().isEmpty() || tfIdentityCard.getText().isEmpty()) {
					return false;
				}
				return true;
			}
			public void actionPerformed(ActionEvent e) {
				if(validateForm()) {
					ConnectDB connectDB = new ConnectDB();
					int record = connectDB.ExcuteUpdate("Insert into Vehicle values('"+tfOwnerName.getText()+"','"+tfIdentityCard.getText()+"','"+comboBox.getSelectedItem().toString()+"','"+tfLicensePlate.getText()+"','"+tfBrand.getText()+"','"+tfChassisNumber.getText()+"','"+tfEngineNumber.getText()+"')");
			    	if(record>0) JOptionPane.showMessageDialog(null, "Success");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill in the required fields");
				}
		    	
			}
		});
		panelButton.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		panelButton.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		panelButton.add(btnDelete);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VehicleGUIad v = new VehicleGUIad();
			}
		});
		panelButton.add(btnRefresh);
		
		JPanel panelFunction = new JPanel();
		mainPanel.add(panelFunction);
		
		JButton btnSearch = new JButton("Search");
		panelFunction.add(btnSearch);
		
		JButton btnArrange = new JButton("Arrange");
		panelFunction.add(btnArrange);
		
		JButton btnNewButton_5 = new JButton("New button");
		panelFunction.add(btnNewButton_5);
		
		JButton btnSignOut = new JButton("Sign Out");
		panelFunction.add(btnSignOut);
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sign out successfully");
				frame.dispose();
				LoginGUI log = new LoginGUI();
			}
		});
		
		JPanel panelTable = new JPanel();
		frame.getContentPane().add(panelTable);
		panelTable.setLayout( new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, " View Table ");
		panelTable.setBorder(titleBorder);
		
		this.table = new JTable(vData, vTitle);
		JScrollPane tableResult = new JScrollPane(this.table);
		panelTable.add(tableResult);
		
		
		frame.pack();
		frame.setLocation(100,30);
		frame.setSize(1200,600);
		frame.setVisible(true);
	}
	
	public List<Vehicle> getAllVehicle(){
		List<Vehicle> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			String sql = "Select [Owner Name], [Identity Card], [Vehicle Type], [License Plate], [Brand], [Chassis Number], [Engine Number] From Vehicle";
			ConnectDB c = new ConnectDB();
			rs = c.SelectDB(sql);
			while(rs.next()) {
				Vehicle v = new Vehicle();
				v.setOwnerName(rs.getString(1));
				v.setIdentityCard(rs.getInt(2));
				v.setType(rs.getString(3));
				v.setLicensePlate(rs.getString(4));
				v.setBrand(rs.getString(5));
				v.setChassisNumber(rs.getString(6));
				v.setEngineNumber(rs.getString(7));
				list.add(v);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public static void main(String[] args) {
		VehicleGUIad v = new VehicleGUIad();
		System.out.println(v.getAllVehicle());
	}
}
