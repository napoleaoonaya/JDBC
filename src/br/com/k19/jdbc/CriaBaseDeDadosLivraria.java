package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriaBaseDeDadosLivraria {

	public static void main(String[] args) throws Exception  {
		
		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "162130";
		
		System.out.println("Abrindo conexão com o banco...");
		
		Connection connection = DriverManager.getConnection(url,user,password);
		
		System.out.println("Conexão aberta!!");
		
		System.out.println("\n");
		
		System.out.println("Apagando à base de dados se existir!");
		String sql = "DROP DATABASE IF EXISTS Livraria";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.execute();
		pstmt.close();
		
		System.out.println("\n");
		
		System.out.println("Criando a base de dados!");
		String sql2 = "CREATE DATABASE Livraria";
		PreparedStatement pstmt2 = connection.prepareStatement(sql2);
		pstmt2.execute();
		pstmt2.close();
		
		System.out.println("\n");
		System.out.println("Fechando a conexão com o banco de dados!");
		connection.close();
		
		
	}

}
