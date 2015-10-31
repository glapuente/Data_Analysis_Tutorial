package modoPasivo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Pasive_selection {

	private JFrame frame;
	private static String[] option;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pasive_selection window = new Pasive_selection();
					window.frame.setVisible(true);
					window.frame.setTitle("Choose the problem to test");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pasive_selection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPasiveMode = new JLabel("PASIVE MODE");
		lblPasiveMode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPasiveMode.setBounds(10, 11, 110, 14);
		frame.getContentPane().add(lblPasiveMode);
		
		JButton btnOpt1 = new JButton("S1MaxLike");
		btnOpt1.setBounds(146, 38, 110, 23);
		frame.getContentPane().add(btnOpt1);
		btnOpt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				option = new String[1];
				option[0] = "op1";
				
				Resolved_problem rP = new Resolved_problem(option);
				rP.main(option);
				
			}
		});
		
		JButton btnOpt2 = new JButton("S2Distrib");
		btnOpt2.setBounds(146, 114, 110, 23);
		frame.getContentPane().add(btnOpt2);
		btnOpt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				option = new String[1];
				option[0] = "op2";
				
				Resolved_problem rP = new Resolved_problem(option);
				rP.main(option);
				
			}
		});
		
		JButton btnOpt3 = new JButton("S3Lsq");
		btnOpt3.setBounds(146, 204, 110, 23);
		frame.getContentPane().add(btnOpt3);
		btnOpt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				option = new String[1];
				option[0] = "op3";
				
				Resolved_problem rP = new Resolved_problem(option);
				rP.main(option);
				
			}
		});
	}
}
