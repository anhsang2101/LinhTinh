package GUI;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;

public class VehicleGUIad {
	JFrame frame = new JFrame("Vehical management for Admin");
	private JTextField tfOwnerName;
	private JTextField tfIdentityCard;
	private JTextField tfLicensePlate;
	private JTextField tfChassisNumber;
	private JTextField tfEngineNumber;
	private JTextField tfBrand;
	
	public VehicleGUIad() {
		frame.getContentPane().setLayout(new GridLayout(9,1));
		
		JPanel panelTitle = new JPanel();
		frame.getContentPane().add(panelTitle);
		
		JLabel lblTitle = new JLabel("Vehicle Management");
		panelTitle.add(lblTitle);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitle.setForeground(Color.RED);
		
		JPanel panelName = new JPanel();
		frame.getContentPane().add(panelName);
		
		JLabel lbOwnerName = new JLabel("Owner Name");
		panelName.add(lbOwnerName);
		
		tfOwnerName = new JTextField();
		panelName.add(tfOwnerName);
		tfOwnerName.setColumns(50);
		
		JPanel panelIdentityCard = new JPanel();
		frame.getContentPane().add(panelIdentityCard);
		
		JLabel lbIdentityCard = new JLabel("Identity Card");
		panelIdentityCard.add(lbIdentityCard);
		
		tfIdentityCard = new JTextField();
		panelIdentityCard.add(tfIdentityCard);
		tfIdentityCard.setColumns(50);
		
		JPanel panelVehicleTypeAndLicensePlate = new JPanel();
		frame.getContentPane().add(panelVehicleTypeAndLicensePlate);
		
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
		frame.getContentPane().add(panelChassisNumber);
		
		JLabel lbChassisNumber = new JLabel("Chassis Number");
		panelChassisNumber.add(lbChassisNumber);
		
		tfChassisNumber = new JTextField();
		panelChassisNumber.add(tfChassisNumber);
		tfChassisNumber.setColumns(49);
		
		JPanel panelEngineNumber = new JPanel();
		frame.getContentPane().add(panelEngineNumber);
		
		JLabel lbEngineNumber = new JLabel("Engine Number");
		panelEngineNumber.add(lbEngineNumber);
		
		tfEngineNumber = new JTextField();
		panelEngineNumber.add(tfEngineNumber);
		tfEngineNumber.setColumns(50);
		
		JPanel panelButton = new JPanel();
		frame.getContentPane().add(panelButton);
		
		JButton btnNewButton_3 = new JButton("New button");
		panelButton.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("New button");
		panelButton.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("New button");
		panelButton.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panelButton.add(btnNewButton_1);
		
		JPanel panelTable = new JPanel();
		frame.getContentPane().add(panelTable);
		panelTable.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1},
			},
			new String[] {
				"Owner Name", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTable.add(scrollPane);
		scrollPane.add(table);
		
		
		JPanel panelFunction = new JPanel();
		frame.getContentPane().add(panelFunction);
		
		JButton btnNewButton_7 = new JButton("New button");
		panelFunction.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("New button");
		panelFunction.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("New button");
		panelFunction.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("New button");
		panelFunction.add(btnNewButton_4);
		
		frame.pack();
		frame.setLocation(200,30);
		frame.setSize(800,700);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new VehicleGUIad();
	}
}
