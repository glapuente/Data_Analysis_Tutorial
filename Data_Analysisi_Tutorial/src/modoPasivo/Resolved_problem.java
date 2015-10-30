package modoPasivo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.javafx.font.Disposer;

import paquete.Selection;
import solutions.S1MaxLike;
import solutions.S2Distrib;
import solutions.S3Lsq;

public class Resolved_problem {

	private JFrame frame;
	private static JTextArea txt_src_code;
	private static JTextArea txt_Statement;
	private static File fileStatement;
	private static File fileSrcCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resolved_problem window = new Resolved_problem(args);
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
	public Resolved_problem(String[] option) {
		switch (option[0]) {
		case "op1":
			fileStatement = new File("Ex1");
			fileSrcCode = new File("src/solutions/S1MaxLike.java");
		break;
		case "op2":
			fileStatement = new File("Ex2");
			fileSrcCode = new File("src/solutions/S2Distrib.java");
		break;
		case "op3":
			fileStatement = new File("Ex3");
			fileSrcCode = new File("src/solutions/S3Lsq");
		break;

		default:
			break;
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 711, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt_Statement = new JTextArea();
		txt_Statement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JScrollPane scrollStatement = new JScrollPane();
		scrollStatement.setBounds(40, 82, 559, 131);
		scrollStatement.setVerticalScrollBarPolicy(scrollStatement.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollStatement);
		
		scrollStatement.setViewportView(txt_Statement);
		
		JLabel lblPasiveMode = new JLabel("PASIVE MODE");
		lblPasiveMode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPasiveMode.setBounds(29, 21, 110, 14);
		frame.getContentPane().add(lblPasiveMode);
		
		JLabel lblNewLabel = new JLabel("Statement");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(30, 57, 76, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txt_src_code = new JTextArea();
		txt_src_code.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JScrollPane scrollSrcCode = new JScrollPane();
		scrollSrcCode.setBounds(40, 274, 559, 171);
		scrollSrcCode.setVerticalScrollBarPolicy(scrollSrcCode.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollSrcCode);
		
		scrollSrcCode.setViewportView(txt_src_code);
		
		JLabel lblSrcCode = new JLabel("Source code");
		lblSrcCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSrcCode.setBounds(40, 249, 76, 14);
		frame.getContentPane().add(lblSrcCode);
		
		JButton btnResolve = new JButton("Resolve");
		btnResolve.setBounds(445, 463, 89, 23);
		frame.getContentPane().add(btnResolve);
		btnResolve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				completeStatement();
				completeSourceCode();
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(334, 463, 89, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Selection s = new Selection();
				s.setVisible(true);
				frame.dispose();
				
			}
		});
		
		JButton btnShowgraphic = new JButton("Show Graphic");
		btnShowgraphic.setBounds(544, 463, 127, 23);
		frame.getContentPane().add(btnShowgraphic);
		btnShowgraphic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (fileStatement.getName()) {
				case "Ex1":
					S1MaxLike graphic1 = new S1MaxLike();
					graphic1.main(new String [0]);
				break;
				case "Ex2":
					S2Distrib graphic2 = new S2Distrib();
					graphic2.main(new String [0]);
				break;
				case "Ex3":
					S3Lsq graphic3 = new S3Lsq();
					graphic3.main(new String [0]);
				break;

				default:
					break;
				}
				
				
				
				
				
				
				
			}
		});
		

	}
	
	private static void completeStatement(){
		ArrayList<String> text = new ArrayList<String>();
		Read_text_from_file rdFromFile = new Read_text_from_file();
		text = rdFromFile.saveLines(fileStatement);
		
		// Write first line of the statement
		txt_Statement.setText(text.get(0));
		
		for(int i=1; i < text.size(); i++){
			txt_Statement.setText(txt_Statement.getText() + "\n"+ text.get(i));
		}
	}
	
	
	private static void completeSourceCode(){
		ArrayList<String> text = new ArrayList<String>();
		Read_text_from_file rdFromFile = new Read_text_from_file();
		text = rdFromFile.saveLines(fileSrcCode);
		
		// Write first line of the statement
		txt_src_code.setText(text.get(0));
		
		for(int i=1; i < text.size(); i++){
			txt_src_code.setText(txt_src_code.getText() + "\n"+ text.get(i));
		}
	}
}
