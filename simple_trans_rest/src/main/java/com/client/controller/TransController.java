package com.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.client.model.Responsetrans;
import com.client.model.Transportadora;

@RestController
@RequestMapping("")
public class TransController {

	@RequestMapping(value = "/service/transportadora", method = RequestMethod.GET)
	public ResponseEntity<?> getTransportadora(@RequestParam(required = false) Integer tipoTransporte) {
		List<Responsetrans> rList = new ArrayList<Responsetrans>();
		if (tipoTransporte != null) {
			for (Transportadora t : data()) {
				if (t.getTipoTransporte() == tipoTransporte) {
					Responsetrans r = new Responsetrans();
					r.setTempoAereo(t.getTempoAereo());
					r.setTempoTerrestre(t.getTempoTerrestre());
					r.setValorAereo(t.getValorAereo());
					r.setValorTerrestre(t.getValorTerrestre());
					rList.add(r);
				}
			}
			return new ResponseEntity<>(rList, HttpStatus.OK);
		} else {
			for (Transportadora t : data()) {
				Responsetrans r = new Responsetrans();
				r.setTempoAereo(t.getTempoAereo());
				r.setTempoTerrestre(t.getTempoTerrestre());
				r.setValorAereo(t.getValorAereo());
				r.setValorTerrestre(t.getValorTerrestre());
				rList.add(r);
			}
			return new ResponseEntity<>(rList, HttpStatus.OK);
		}

	}

	private List<Transportadora> data() {
		Transportadora t2 = new Transportadora();
		t2.setId(2);
		t2.setTempoAereo(30);
		t2.setTempoTerrestre(59);
		t2.setTipoTransporte(2);
		t2.setValorAereo(200);
		t2.setValorTerrestre(75);

		Transportadora t3 = new Transportadora();
		t3.setId(3);
		t3.setTempoAereo(33);
		t3.setTempoTerrestre(65);
		t3.setTipoTransporte(2);
		t3.setValorAereo(180);
		t3.setValorTerrestre(55);

		Transportadora t4 = new Transportadora();
		t4.setId(4);
		t4.setTempoAereo(30);
		t4.setTipoTransporte(1);
		t4.setValorAereo(175);

		List<Transportadora> tList = new ArrayList<Transportadora>();
		tList.add(t2);
		tList.add(t3);
		tList.add(t4);
		return tList;
	}

}
