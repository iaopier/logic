package com.cardboardbox.app;

import java.util.Scanner;



import com.cardboardbox.app.business.Business;
import com.cardboardbox.app.model.Responsetrans;
import com.cardboardbox.app.transaction.GetTransportadoras;
import com.cardboardbox.app.transaction.TransactionDB;
import com.cardboardbox.app.transaction.TransactionREST;

public class Main {

	public static void main(String[] args) {

		Business.getTransportadora("S�o Paulo - SP", "Manaus - MA", 3875,"A�reo", "Menor preco");
		Business.getTransportadora("Florian�polis - SC", "Campinas - SP", 762,"Terrestre", "Menor preco");
		Business.getTransportadora("Salvador - BA", "Bel�m - PA", 2018,"-", "Menor tempo");
		Business.getTransportadora("S�o Paulo - SP", "Assun��o - PAR", 1350,"-", "Menor tempo");
		Business.getTransportadora("Salvador - BA", "Bras�lia - DF", 1449,"Terrestre", "Menor tempo");

	}
}
