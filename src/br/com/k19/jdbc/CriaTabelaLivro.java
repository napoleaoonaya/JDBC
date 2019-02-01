package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CriaTabelaLivro {
	
public static void main(String[] args) throws Exception  {
		
		String url = "jdbc:mysql://localhost:3306/Livraria";
		String user = "root";
		String password = "162130";
		
		System.out.println("Abrindo conexão com o banco...");
		
		Connection connection = DriverManager.getConnection(url,user,password);
		
		System.out.println("Conexão aberta!!");
		
		System.out.println("\n");
		
		System.out.println("Criando a tabela Livro...");
		String sql = "CREATE TABLE Livro("
				+ "id BIGINT NOT NULL AUTO_INCREMENT,"
				+ "titulo VARCHAR(255)NOT NULL,"
				+ "preco DECIMAL(10,2)NOT NULL,"
				+ "editora_id BIGINT NOT NULL,"
				+ "PRIMARY KEY(id),"
				+ "CONSTRAINT fk_editora_id FOREIGN KEY(editora_id) REFERENCES Editora (id)"
				+ "ON UPDATE CASCADE ON DELETE RESTRICT"
				+ ")engine=InnoDB charset=latin1;";
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.execute();
		pstmt.close();
		
		System.out.println("\n");
		System.out.println("Fechando a conexão com o banco de dados!");
		connection.close();

	}

}
