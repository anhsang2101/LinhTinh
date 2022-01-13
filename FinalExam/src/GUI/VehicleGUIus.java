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

public class VehicleGUIus {
	JFrame frame = new JFrame("Vehical management for User");

	public VehicleGUIus() {
		
		frame.pack();
		frame.setLocation(200,30);
		frame.setSize(800,700);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new VehicleGUIus();
	}
}
