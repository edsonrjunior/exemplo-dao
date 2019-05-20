package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Carro;

public class Dao {

	Connection con = getConnection() ;
	
	public void insertCarro(Carro carro) {

		String insertSql = "insert into carro (idcarro, modelo, ano, valor) " + " values (?,?,?,?)";

		try {
			con.setAutoCommit(false);
			PreparedStatement psInsert = con.prepareStatement(insertSql);

			psInsert.setString(1, Integer.toString(carro.getIdCarro()));
			psInsert.setString(2, carro.getModelo());
			psInsert.setString(3, Integer.toString(carro.getAno()));
			psInsert.setString(4, Double.toString(carro.getAno()));

			System.out.println("Insert efetuado com sucesso!");
			
			psInsert.execute();

			con.commit();

		} catch (SQLException e) {
			try {
			con.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);

		} finally {
		}

	}

	public void updateCarro(Carro carro) {

			
		String updateSql = "update carro (modelo, ano, valor) " + " set (?,?,?) " + " where idCarro = ? ";

		try {
			PreparedStatement pUpdateCarro = con.prepareStatement(updateSql);

			con.setAutoCommit(false);
			pUpdateCarro.setString(1, carro.getModelo());
			pUpdateCarro.setInt(2, carro.getAno());
			pUpdateCarro.setString(1, carro.getModelo());
			
			System.out.println("Update efetuado com sucesso!");
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();

			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		} finally {
			closeConnection();
		}

	}

	public void deleteCarro(Carro carro) {

		String deleteSql = "delete carro where idCarro = ? ";

		Connection con = getConnection();

		try {
			PreparedStatement deleteCarro = con.prepareStatement(deleteSql);

			con.setAutoCommit(false);

			deleteCarro.executeUpdate();

			con.commit();
			
			System.out.println("Carro excluído com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();

			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		} finally {
			closeConnection();
		}

	}

	public Connection getConnection() {

		String url = "jdbc:mysql://localhost:3306/carro";
		String usuario = "root";
		String senha = "";

		try {
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão com o banco com sucesso!");
			return conexao;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void closeConnection() {
		
		if (con != null) {
			try {
				con.close();
				System.out.println("Conexão com o banco com fechada!");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
