package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	
	private final static String DRIVER= "com.mysql.cj.jdbc.Driver";
	private final static String URL="jdbc:mysql://localhost:3306/sepdec_base";
	private final static String ROOT = "root";
	private final static String PASSWORD= "1234";
	
	public static Connection getConnection() throws SQLException {
     try {
	     Class.forName(DRIVER);
         return DriverManager.getConnection(URL, ROOT, PASSWORD);} 
     catch (ClassNotFoundException e) {
	     throw new SQLException("Driver do MySQL não encontrado!", e);
	        }
	    };
	
	public static void closeConnection(Connection conexao) {
		try {
			if(conexao != null) {
			conexao.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
	 public static void main(String[] args) throws SQLException {
      try {
	        Connection conexao = getConnection();
            System.out.println("Conexão realizada com sucesso!");
            closeConnection(conexao);
     } catch (SQLException e) {
	            System.out.println("Erro ao conectar com o banco!");
	            e.printStackTrace();
	        }
	 }
};
