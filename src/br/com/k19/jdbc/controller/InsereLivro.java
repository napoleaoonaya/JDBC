package br.com.k19.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import br.com.k19.jdbc.model.Livro;

public class InsereLivro {
	
	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/Livraria";
		String user = "root";
		String password = "162130";
		
		System.out.println("Abrindo conexão com o banco...");
		
		Connection connection = DriverManager.getConnection(url,user,password);
		
		System.out.println("Conexão aberta!!");
		
		System.out.println("\n");
		
		Scanner teclado = new Scanner(System.in);
		
		Livro livro = new Livro();
		
		System.out.println("Digite o título do livro: ");
		livro.setTitulo(teclado.nextLine());
		
		System.out.println("Digite o preço do livro: ");
		livro.setPreco(teclado.nextDouble());
		
		teclado.nextLine();
		
		System.out.println("Digite o id da editora: ");
		livro.setEditora_id(teclado.nextLong());
		
		teclado.close();
		
		String sql = "INSERT INTO Livro (titulo,preco,editora_id)"
				+ "VALUES('"+livro.getTitulo()+","+livro.getPreco()+","+livro.getEditora_id()+"')";
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.execute();
		pstmt.close();
		
		System.out.println("Fechando conexão com o banco de dados!");
		connection.close();
		
	}
	
}
