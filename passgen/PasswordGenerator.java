package blayzer.passgen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class PasswordGenerator extends JFrame {

	private static final long serialVersionUID = 1L;
	private String generatedpassword = "Нажмитие `Сгенерировать пароль`";
	private int length = 16;

	public PasswordGenerator() {
		super("Easy Password Generator");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2, 1));
		
		JTextPane password = new JTextPane();
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		password.setParagraphAttributes(attribs, true);
		password.setText(generatedpassword);
		password.setBackground(Color.LIGHT_GRAY);
		password.setEditable(false);
		add(password);
		
		JButton button = new JButton("Сгенерировать пароль");
		add(button);
		button.addActionListener(action -> {
			String valid = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			StringBuilder pass = new StringBuilder();
			Random random = new Random();
			for (int i=0; i<length; i++){
			 pass.append(valid.charAt(random.nextInt(valid.length())));
			}
			password.setText(pass.toString());
		});
	}

	public static void main(String[] args){
		PasswordGenerator app = new PasswordGenerator();
		app.setVisible(true);
	}
}
