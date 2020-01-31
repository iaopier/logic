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
import com.cardboardbox.app.model.Transportadora;

public class TransactionDB {
	public static List<Transportadora> get() {
		Connection conn = null;
		List<Transportadora> tList = new ArrayList<Transportadora>();
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
			
			Transportadora t = new Transportadora();
			t.setId(1);
			while (rs.next()) {

				int idTipoTransporte = rs.getInt("idTipoTransporte");

				double valor = rs.getDouble("valor");

				int tempo = rs.getInt("tempo");

				t.setTempoTerrestre(tempo);
				t.setValorTerrestre(valor);
				tList.add(t);
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
		return tList;
	}
}
