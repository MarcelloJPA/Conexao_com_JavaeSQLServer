package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectaBanco {

	
	/* Baixar o driver JDBC para sqlserver no site da microsoft */

	/*
	 * Aqui está o nome e a senha para facilitar a conexao com o banco, mas na
	 * pratica acontece com o inputMessageDialog
	 */


	/* Declarar o driver de conexao */
	private static final String DRIVER_CONEXAO = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	/* Declarar o nome do servidor sql */
	private static final String STR_CONEXAO = "jdbc:sqlserver://DESKTOP-VNM7IIA;"; //

	public static Connection getConexao(String nome, String senha)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Connection conn = null;

		try {
			Class.forName(DRIVER_CONEXAO).getInterfaces();
			/*url recebe o servidor + o nome do banco*/
			String url = STR_CONEXAO + "databaseName = Cliente"; 
			conn = DriverManager.getConnection(url, nome, senha);
			
			JOptionPane.showMessageDialog(null, "Conectado com usuário: " + nome + "\nSenha:" + senha);
			return conn;
		} catch (ClassNotFoundException e) {
			/*SQL SERVER não encontrado*/
			throw new ClassNotFoundException("Driver Sql nao foi encontrado" + e.getMessage());
			/*NOME DO SERVIDOR PODE ESTAR ERRADO*/
		} catch (SQLException e) {
			throw new SQLException("Erro ao conectar com a base de dados" + e.getMessage());
		}

	}

	public static void fechaConexao(Connection conn, PreparedStatement pstm) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstm != null) {
				pstm.close();
				System.out.println("Statement e conexao fechados com sucesso");
			}
		} catch (Exception e) {
			System.out.println("Não foi possível fechar o statement " + e.getMessage());
		}
	}

	public static void fechaConexao(Connection conn, PreparedStatement pstm, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstm != null) {
				pstm.close();

			}
			if (rs != null) {
				rs.close();
				System.out.println("Statement, conexao e ResultSet fechados com sucesso");
			}
		} catch (Exception e) {
			System.out.println("Não foi possível fechar o statement " + e.getMessage());
		}
	}

	public static void main(String s[]) {
		try {
			ConectaBanco.getConexao(null, null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}