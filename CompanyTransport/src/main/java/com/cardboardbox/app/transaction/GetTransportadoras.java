package com.cardboardbox.app.transaction;

import java.util.ArrayList;
import java.util.List;

import com.cardboardbox.app.model.Responsetrans;
import com.cardboardbox.app.model.Transportadora;

public class GetTransportadoras {
	private static List<Transportadora> tList = new ArrayList<Transportadora>();
	public static List<Transportadora> get() {
		for(Transportadora t : TransactionREST.getDataFromRest()) {
			tList.add(t);
		}
		return tList;
	}
}
