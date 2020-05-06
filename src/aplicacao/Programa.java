package aplicacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Programa {

	public static void main(String[] args) {
		
		Connection conexao = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conexao = DB.getConnection();
			
			st = conexao.createStatement();
			
			rs = st.executeQuery("select * from departamento");
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Nome"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
