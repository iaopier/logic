package com.cardboardbox.app.business;

import java.util.ArrayList;
import java.util.List;

import com.cardboardbox.app.model.Responsetrans;
import com.cardboardbox.app.transaction.GetTransportadoras;
import com.cardboardbox.app.transaction.TransactionDB;

public class Business {

	public static int getTransportadora(String origem, String destino, int distancia,String tipoTransporte, String prioridade) {
		List<Responsetrans> rList = new ArrayList<Responsetrans>();
		for (Responsetrans r : TransactionDB.get()) {
			rList.add(r);
		}
		for (Responsetrans r : GetTransportadoras.get()) {
			rList.add(r);
		}
		if(tipoTransporte == null) {
			for(Responsetrans r : rList) {
				System.out.println("Calculo aereo "+ getCalculoValor(distancia,r.getValorAereo()));
				
				System.out.println("Calculo aereo tempo "+ getCalculoTempo(distancia,r.getTempoAereo()));
				
				System.out.println("Calculo terrestre "+ getCalculoValor(distancia,r.getValorTerrestre()));
				
				System.out.println("Calculo terrestre tempo "+ getCalculoTempo(distancia,r.getTempoTerrestre()));
			}
		}else if(tipoTransporte == "Aéreo") {
			for(Responsetrans r : rList) {
				System.out.println("Calculo aereo "+ getCalculoValor(distancia,r.getValorAereo()));
				
				System.out.println("Calculo aereo tempo "+ getCalculoTempo(distancia,r.getTempoAereo()));
			}
		}else if(tipoTransporte == "Terrestre") {
			for(Responsetrans r : rList) {
	
				System.out.println("Calculo terrestre "+ getCalculoValor(distancia,r.getValorTerrestre()));
				
				System.out.println("Calculo terrestre tempo "+ getCalculoTempo(distancia,r.getTempoTerrestre()));
			}
		}
		
		return 0;
	}

	private static double getCalculoValor(int distancia, double valor) {
		return distancia * valor / 10;
	}
	
	private static double getCalculoTempo(int distancia, int tempo) {
		return distancia * tempo / 60;
	}
}
