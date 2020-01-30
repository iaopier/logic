package com.cardboardbox.app.transaction;

import java.util.ArrayList;
import java.util.List;

import com.cardboardbox.app.model.Responsetrans;

public class GetTransportadoras {
	private static List<Responsetrans> rList = new ArrayList<Responsetrans>();
	public static List<Responsetrans> get() {
		for(Responsetrans r : TransactionREST.getDataFromRest()) {
			rList.add(r);
		}
		return rList;
	}
}
