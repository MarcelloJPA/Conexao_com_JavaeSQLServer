package jdbc;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TestaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static JTextField login;
	public static JPasswordField senha;
	public JButton btnLogar, btnCancelar;

	public TestaLogin() {
		setTitle("Acessar Sistema");
		setSize(300, 250);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(99, 98, 32));
		GridLayout g1 = new GridLayout(3, 2, 1, 1);
		getContentPane().setLayout(g1);
		
		JLabel labelLogin = new JLabel("Login: ");
		add(labelLogin);
		
		JLabel labelSenha = new JLabel("Senha");
		add(labelSenha);
		
		login = new JTextField();
		add(login);
		
		senha = new JPasswordField();
		add(senha);
		
		btnLogar = new JButton("Logar");
		add(btnLogar);
		btnLogar.addActionListener(this);
		
		btnCancelar = new JButton("Sair");
		add(btnCancelar);
		btnCancelar.addActionListener(this);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogar) {
			  try {
				  ConectaBanco.getConexao(login.getText(), String.valueOf(senha.getPassword()));
			  }
			  catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e1) {
				  e1.printStackTrace();
			  }
		}
	}

	public static void main(String[] args) {
		new TestaLogin();
	}

}
