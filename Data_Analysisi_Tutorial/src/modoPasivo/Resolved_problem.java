package modoPasivo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;

public class Resolved_problem {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resolved_problem window = new Resolved_problem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Resolved_problem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 538, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txt_Statement = new JTextArea();
		txt_Statement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_Statement.setBounds(20, 82, 208, 200);
		frame.getContentPane().add(txt_Statement);
		
		JLabel lblPasiveMode = new JLabel("PASIVE MODE");
		lblPasiveMode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPasiveMode.setBounds(29, 21, 110, 14);
		frame.getContentPane().add(lblPasiveMode);
		
		JLabel lblNewLabel = new JLabel("Statement");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(30, 57, 76, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea txt_src_code = new JTextArea();
		txt_src_code.setBounds(252, 81, 243, 200);
		frame.getContentPane().add(txt_src_code);
		
		JLabel lblSrcCode = new JLabel("Source code");
		lblSrcCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSrcCode.setBounds(252, 58, 76, 14);
		frame.getContentPane().add(lblSrcCode);
		
		JButton btnResolve = new JButton("Resolve");
		btnResolve.setBounds(386, 297, 89, 23);
		frame.getContentPane().add(btnResolve);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(241, 297, 89, 23);
		frame.getContentPane().add(btnCancel);
	}
}
