package core;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Scanner;

import javax.swing.JFrame;

public class Driver {


	public static void main(String[] args) {
		JFrame frame = new JFrame ("Lindenmayer System");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		DrawingPanel drawing = new DrawingPanel();
		ControlPanel controls = new ControlPanel(drawing);
		Container contentPane = frame.getContentPane();	
		contentPane.setLayout(new BorderLayout());
		contentPane.add(drawing, BorderLayout.CENTER);
		contentPane.add(controls, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);

	}
}
