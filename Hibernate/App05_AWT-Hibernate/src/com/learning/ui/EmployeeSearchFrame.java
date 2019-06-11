package com.learning.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.learning.entity.Employee;
import com.learning.factory.EmployeeServiceFactory;
import com.learning.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeSearchFrame extends Frame implements ActionListener {

	Label l;
	TextField tf;
	Button b;
	Employee emp;

	public EmployeeSearchFrame() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Employee Search Frame");
		this.setLayout(new FlowLayout());
		this.setBackground(Color.gray);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		l = new Label("Employee Number");
		tf = new TextField(20);
		b = new Button("Search");
		b.addActionListener(this);

		Font font = new Font("consolas", Font.BOLD, 20);
		l.setFont(font);
		tf.setFont(font);
		b.setFont(font);

		this.add(l);
		this.add(tf);
		this.add(b);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int eno = Integer.parseInt(tf.getText());
			EmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
			emp = employeeService.search(eno);
			repaint();
		} catch (Exception excep) {
			excep.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		Font font = new Font("consolas", Font.BOLD, 20);
		g.setFont(font);
		if (emp == null) {
			g.drawString("Employee does not Exist", 50, 250);
		} else {
			g.drawString("Employee Number: " + emp.getEno(), 50, 200);
			g.drawString("Employee Name: " + emp.getEname(), 50, 250);
			g.drawString("Employee Salary: " + emp.getEsal(), 50, 300);
			g.drawString("Employee Address: " + emp.getEaddr(), 50, 350);
		}
	}

}
