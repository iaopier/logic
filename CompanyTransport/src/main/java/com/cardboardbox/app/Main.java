package com.cardboardbox.app;

import java.util.Scanner;

import com.cardboardbox.app.business.Business;
import com.cardboardbox.app.model.Responsetrans;
import com.cardboardbox.app.transaction.GetTransportadoras;
import com.cardboardbox.app.transaction.TransactionDB;
import com.cardboardbox.app.transaction.TransactionREST;

public class Main {

	public static void main(String[] args) {
		Business.getTransportadora("São Paulo - SP ", "Manaus - MA  ", 3875, "Menor Preço");
		/*
		 * for(Responsetrans r : TransactionDB.get()) {
		 * System.out.println(r.getTempoAereo());
		 * System.out.println(r.getTempoTerrestre());
		 * System.out.println(r.getValorAereo());
		 * System.out.println(r.getValorTerrestre());
		 * 
		 * } for(Responsetrans r : GetTransportadoras.get()) {
		 * System.out.println(r.getTempoAereo());
		 * System.out.println(r.getTempoTerrestre());
		 * System.out.println(r.getValorAereo());
		 * System.out.println(r.getValorTerrestre()); System.out.println(); }
		 */
	}

}
