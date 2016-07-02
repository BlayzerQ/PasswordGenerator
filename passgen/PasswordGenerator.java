package blayzer.passgen;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class PasswordGenerator extends JFrame {

	private static final long serialVersionUID = 1L;
	private String generatedpassword = "Нажмите\n `Сгенерировать пароль`";
	private JTextPane length = new JTextPane();

	public PasswordGenerator() {
		super("Easy Password Generator");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		setLayout(new GridLayout(3, 1));
		
		JTextPane password = new JTextPane();
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		StyleConstants.setFontSize(attribs, 20);
		password.setParagraphAttributes(attribs, true);
		password.setText(generatedpassword);
		password.setBackground(Color.LIGHT_GRAY);
		password.setEditable(false);
		panel.add(password);
		
		JButton button = new JButton("Сгенерировать пароль");
		button.setBackground(Color.GRAY);
		button.addActionListener(action -> {
			String valid = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			StringBuilder pass = new StringBuilder();
			Random random = new Random();
			for (int i=0; i<Integer.parseInt(length.getText()); i++){
				char randchar = valid.charAt(random.nextInt(valid.length()));
			 pass.append(randchar);
			}
			password.setText(pass.toString());
		});
		panel.add(button);
		
		JButton back = new JButton("Назад");
		back.setBackground(Color.GRAY);
		back.addActionListener(action -> {
			setContentPane(panel);
		});
		
		JButton settings = new JButton("Настройки");
		length.setText("16");
		settings.setBackground(Color.GRAY);
		settings.addActionListener(action -> {
			JPanel panel2 = new JPanel();
			panel2.setLayout(new GridLayout(2, 1));

			length.setParagraphAttributes(attribs, true);
			panel2.add(length);
			panel2.add(back);
			
			setContentPane(panel2);
			setVisible(true);
		});
		panel.add(settings);
		
		setContentPane(panel);
	}

	public static void main(String[] args){
		PasswordGenerator app = new PasswordGenerator();
		app.setVisible(true);
	}
}
