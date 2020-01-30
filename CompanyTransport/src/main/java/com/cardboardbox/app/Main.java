package com.cardboardbox.app;

import com.cardboardbox.app.model.Responsetrans;
import com.cardboardbox.app.transaction.GetTransportadoras;
import com.cardboardbox.app.transaction.TransactionDB;
import com.cardboardbox.app.transaction.TransactionREST;

public class Main {

	public static void main(String[] args) {
		for(Responsetrans r : GetTransportadoras.get()) {
			System.out.println(r.getTempoAereo());
			System.out.println(r.getTempoTerrestre());
			System.out.println(r.getValorAereo());
			System.out.println(r.getValorTerrestre());
			System.out.println();
		}
		for(Responsetrans r : TransactionDB.get()) {
			System.out.println(r.getTempoAereo());
			System.out.println(r.getTempoTerrestre());
			System.out.println(r.getValorAereo());
			System.out.println(r.getValorTerrestre());
			
		}
	}

}
