package com.cardboardbox.app.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.cardboardbox.app.model.Responsetrans;

public class TransactionDB {
	public static List<Responsetrans> get() {
		Connection conn = null;
		List<Responsetrans> rList = new ArrayList<Responsetrans>();
		try {
			String dbURL3 = "jdbc:postgresql://localhost:5432/cardboardbox";
			Properties parameters = new Properties();
			parameters.put("user", "postgres");
			parameters.put("password", "sazx1ecs");

			conn = DriverManager.getConnection(dbURL3, parameters);

			if (conn != null) {
				//System.out.println("Connected to database");
			}

			Statement stmt = null;

			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(
					"SELECT \"idTipoTransporte\", valor, tempo\r\n" + "	FROM public.\"dadosTransportadoraView\";");
			
			Responsetrans r = new Responsetrans();
			
			while (rs.next()) {

				int idTipoTransporte = rs.getInt("idTipoTransporte");

				double valor = rs.getDouble("valor");

				int tempo = rs.getInt("tempo");

				r.setTempoTerrestre(tempo);
				r.setValorTerrestre(valor);
				rList.add(r);
			}

			rs.close();

			stmt.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
		}
		return rList;
	}
}
