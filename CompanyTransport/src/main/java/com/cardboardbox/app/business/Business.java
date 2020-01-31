package com.cardboardbox.app.business;

import java.util.ArrayList;
import java.util.List;

import com.cardboardbox.app.model.Responsetrans;
import com.cardboardbox.app.model.Transportadora;
import com.cardboardbox.app.transaction.GetTransportadoras;
import com.cardboardbox.app.transaction.TransactionDB;

public class Business {

	public static int getTransportadora(String origem, String destino, int distancia, String tipoTransporte,
			String prioridade) {
		List<Transportadora> tList = new ArrayList<Transportadora>();
		List<Transportadora> resultList = new ArrayList<Transportadora>();
		for (Transportadora t : TransactionDB.get()) {
				tList.add(t);
		}
		for (Transportadora t : GetTransportadoras.get()) {
				tList.add(t);
		}
		if (tipoTransporte.equals("Aéreo")) {
			for (Transportadora t : tList) {
				Transportadora result = new Transportadora();
				result.setTempoAereo(getCalculoTempo(distancia, t.getTempoAereo()));
				result.setValorAereo(getCalculoValor(distancia, t.getValorAereo()));
				result.setId(t.getId());
				resultList.add(result);

			}
			if (prioridade.equals("Menor preco")) {
				System.out.println(checarMenorValorAereo(resultList).getId());
			} else if (prioridade.equals("Menor tempo")) {
				System.out.println(checarMenorTempoAereo(resultList).getId());
			}
		} else if (tipoTransporte.equals("Terrestre")) {
			for (Transportadora t : tList) {
				Transportadora result = new Transportadora();
				result.setTempoTerrestre(getCalculoTempo(distancia, t.getTempoTerrestre()));
				result.setValorTerrestre(getCalculoValor(distancia, t.getValorTerrestre()));
				result.setId(t.getId());
				resultList.add(result);
				
			}
			if (prioridade.equals("Menor preco")) {
				System.out.println(checarMenorValorTerrestre(resultList).getId());
			} else if (prioridade.equals("Menor tempo")) {
				System.out.println(checarMenorTempoTerrestre(resultList).getId());
			}
		} else {
			for (Transportadora t : tList) {
				Transportadora result = new Transportadora();
				result.setTempoAereo(getCalculoTempo(distancia, t.getTempoAereo()));
				result.setTempoTerrestre(getCalculoTempo(distancia, t.getTempoTerrestre()));
				result.setValorAereo(getCalculoValor(distancia, t.getValorAereo()));
				result.setValorTerrestre(getCalculoValor(distancia, t.getValorTerrestre()));
				result.setId(t.getId());
				resultList.add(result);
				

			}
			if (prioridade.equals("Menor preco")) {
				System.out.println(checarMenorValorTerrestre(resultList).getId());
				System.out.println(checarMenorValorAereo(resultList).getId());
			} else if (prioridade.equals("Menor tempo")) {
				System.out.println(checarMenorTempoTerrestre(resultList).getId());
				System.out.println(checarMenorTempoAereo(resultList).getId());
			}
		}

		return 0;
	}

	private static double getCalculoValor(int distancia, double valor) {
		return distancia * valor / 10;
	}

	private static int getCalculoTempo(int distancia, int tempo) {
		return distancia * tempo / 60;
	}

	private static Transportadora checarMenorValorAereo(List<Transportadora> tList) {
		Transportadora t = tList.get(0);
		if(t.getTempoAereo() == 0 ) {
			t.setTempoAereo(Integer.MAX_VALUE);
		}
		for (Transportadora rt : tList) {
			if (rt.getValorAereo() < t.getValorAereo() && t.getValorAereo() != 0 && rt.getValorAereo() != 0.0) {
				t = rt;
			}
			if (rt.getValorAereo() == t.getValorAereo() && t.getValorAereo() != 0 && rt.getValorAereo() != 0.0) {
				if (rt.getTempoAereo() < t.getTempoAereo() && t.getTempoAereo() == 0 && rt.getTempoAereo() != 0.0) {
					t = rt;
				}
			}
		}
		return t;
	}

	private static Transportadora checarMenorTempoAereo(List<Transportadora> tList) {
		Transportadora t = tList.get(0);
		if(t.getTempoAereo() == 0 ) {
			t.setTempoAereo(Integer.MAX_VALUE);
		}
		for (Transportadora rt : tList) {
			if (rt.getTempoAereo() < t.getTempoAereo() && t.getTempoAereo() != 0 && rt.getTempoAereo() != 0.0) {
				t = rt;
			}
			if (rt.getTempoAereo() == t.getTempoAereo() && t.getTempoAereo() != 0 && rt.getTempoAereo() != 0.0) {
				if (rt.getValorAereo() < t.getValorAereo() & t.getValorAereo() != 0 && rt.getValorAereo() != 0.0) {
					t = rt;
				}
			}
		}
		return t;
	}

	private static Transportadora checarMenorValorTerrestre(List<Transportadora> tList) {
		Transportadora t = tList.get(0);
		if(t.getTempoTerrestre() == 0 ) {
			t.setTempoAereo(Integer.MAX_VALUE);
		}
		for (Transportadora rt : tList) {
			if (rt.getValorTerrestre() < t.getValorTerrestre() && t.getValorTerrestre() != 0
					&& rt.getValorTerrestre() != 0.0) {
				t = rt;
			}
			if (rt.getValorTerrestre() == t.getValorTerrestre() && t.getValorTerrestre() != 0
					&& rt.getValorTerrestre() != 0.0) {
				if (rt.getTempoTerrestre() < t.getTempoTerrestre() && t.getTempoTerrestre() != 0 && rt.getTempoTerrestre() != 0.0) {
					t = rt;
				}
			}
		}
		return t;
	}

	private static Transportadora checarMenorTempoTerrestre(List<Transportadora> tList) {
		Transportadora t = tList.get(0);
		if(t.getTempoTerrestre() == 0 ) {
			t.setTempoAereo(Integer.MAX_VALUE);
		}
		for (Transportadora rt : tList) {
			if (rt.getTempoTerrestre() < t.getTempoTerrestre() && t.getTempoTerrestre() != 0 && rt.getTempoTerrestre() != 0.0) {
				t = rt;
			}
			if (rt.getTempoTerrestre() == t.getTempoTerrestre() && t.getTempoTerrestre() != 0 && rt.getTempoTerrestre() != 0.0) {
				if (rt.getValorTerrestre() < t.getValorTerrestre() && t.getValorTerrestre() != 0 && rt.getValorTerrestre() != 0.0) {
					t = rt;
				}
			}
		}
		return t;
	}
}
