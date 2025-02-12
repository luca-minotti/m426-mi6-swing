package ch.bbzbl.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ch.bbzbl.business.Mi6;
import ch.bbzbl.entity.Agent;

public class Mi6View extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtAlter;
	private JTextField txtName;
	private JTextField txtVorname;
	private JTextField txtCodeName;
	private JCheckBox chkLicenseToKill;
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnSave = new JButton("Save");
	private DefaultListModel<Agent> model = new DefaultListModel<>();
	private JList<Agent> list = new JList<Agent>(model);
	
	private Mi6 mi6 = new Mi6();

	/**
	 * Create the frame.
	 */
	public Mi6View() {
		
		setTitle("Agent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		btnCancel.addActionListener(this);
		pnlSouth.add(btnCancel);
		
		btnSave.addActionListener(this);
		pnlSouth.add(btnSave);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new GridLayout(5, 2, 5, 5));
		
		JLabel lblName = new JLabel("Name:");
		pnlCenter.add(lblName);
		
		txtName = new JTextField();
		pnlCenter.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblFirstname = new JLabel("Vorname:");
		pnlCenter.add(lblFirstname);
		
		txtVorname = new JTextField();
		pnlCenter.add(txtVorname);
		txtVorname.setColumns(10);
		
		JLabel lblCodename = new JLabel("Code-Name:");
		pnlCenter.add(lblCodename);
		
		txtCodeName = new JTextField();
		pnlCenter.add(txtCodeName);
		txtCodeName.setColumns(10);
		
		JLabel lblAge = new JLabel("Alter");
		pnlCenter.add(lblAge);
		
		txtAlter = new JTextField();
		pnlCenter.add(txtAlter);
		txtAlter.setColumns(10);
		
		JLabel lblLicense = new JLabel("Lizenz zum T\u00F6ten:");
		pnlCenter.add(lblLicense);
		
		chkLicenseToKill = new JCheckBox("");
		pnlCenter.add(chkLicenseToKill);
		
		JPanel pnlNorth = new JPanel();
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(0,200));
		pnlNorth.add(scrollPane);
		
		loadAgents();
		
		this.setVisible(true);
	}
	
	private void loadAgents() {
		ArrayList<Agent> agents = mi6.getAgents();
		model.clear();
		for(Agent agent : agents) {
			model.addElement(agent);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnCancel) {
			this.txtName.setText("");
			this.txtVorname.setText("");
			this.txtCodeName.setText("");
			this.chkLicenseToKill.setSelected(false);
			this.txtAlter.setText("");
			
		} else if(e.getSource() == this.btnSave) {
			Agent a = new Agent();
			a.setName(Mi6View.this.txtName.getText());
			a.setFirstName(Mi6View.this.txtVorname.getText());
			a.setCodeName(Mi6View.this.txtCodeName.getText());
			a.setLicenceToKill(Mi6View.this.chkLicenseToKill.isSelected());
			int age;
			try{
				age = Integer.parseInt(Mi6View.this.txtAlter.getText());
			}catch (NumberFormatException nfex){
				age = 0;
			}
			a.setAge(age);
			mi6.addAgent(a);
			
			loadAgents();
		}
	}
}
