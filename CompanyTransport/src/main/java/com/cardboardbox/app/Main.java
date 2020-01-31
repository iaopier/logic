package com.cardboardbox.app;

import java.util.Scanner;



import com.cardboardbox.app.business.Business;
import com.cardboardbox.app.model.Responsetrans;
import com.cardboardbox.app.transaction.GetTransportadoras;
import com.cardboardbox.app.transaction.TransactionDB;
import com.cardboardbox.app.transaction.TransactionREST;

public class Main {

	public static void main(String[] args) {

		Business.getTransportadora("São Paulo - SP", "Manaus - MA", 3875,"Aéreo", "Menor preco");
		Business.getTransportadora("Florianópolis - SC", "Campinas - SP", 762,"Terrestre", "Menor preco");
		Business.getTransportadora("Salvador - BA", "Belém - PA", 2018,"-", "Menor tempo");
		Business.getTransportadora("São Paulo - SP", "Assunção - PAR", 1350,"-", "Menor tempo");
		Business.getTransportadora("Salvador - BA", "Brasília - DF", 1449,"Terrestre", "Menor tempo");

	}
}
