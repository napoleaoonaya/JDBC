package br.com.k19.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.k19.jdbc.model.Editora;

public class InsereEditora {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/Livraria";
		String user = "root";
		String password = "162130";
		
		System.out.println("Abrindo conexão com o banco...");
		
		Connection connection = DriverManager.getConnection(url,user,password);
		
		System.out.println("Conexão aberta!!");
		
		System.out.println("\n");
		
		Scanner teclado = new Scanner(System.in);
		
		Editora editora = new Editora();
		
		
		System.out.println("Digite o nome da editora: ");
		editora.setNome(teclado.nextLine());

		System.out.println("Digite o email da editora: ");
		editora.setEmail(teclado.nextLine());

		String sql = "INSERT INTO Editora (nome,email)"
				+ "values(?,?)";
		
		System.out.println("Executando o comando...");
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1,editora.getNome());
		pstmt.setString(2,editora.getEmail());
		pstmt.execute();
		pstmt.close();
		

		
		System.out.println("Fechando a conexão!");
		connection.close();
		
	}

}
