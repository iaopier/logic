package com.client.model;

public class Transportadora {
	private int id;
	private double valorAereo;
	private double valorTerrestre;
	private int tipoTransporte;
	private int tempoAereo;
	private int tempoTerrestre;
	public Transportadora() {
		super();
	}
	public double getValorAereo() {
		return valorAereo;
	}
	public void setValorAereo(double valorAereo) {
		this.valorAereo = valorAereo;
	}
	public double getValorTerrestre() {
		return valorTerrestre;
	}
	public void setValorTerrestre(double valorTerrestre) {
		this.valorTerrestre = valorTerrestre;
	}
	public int getTipoTransporte() {
		return tipoTransporte;
	}
	public void setTipoTransporte(int tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}
	public int getTempoAereo() {
		return tempoAereo;
	}
	public void setTempoAereo(int tempoAereo) {
		this.tempoAereo = tempoAereo;
	}
	public int getTempoTerrestre() {
		return tempoTerrestre;
	}
	public void setTempoTerrestre(int tempoTerrestre) {
		this.tempoTerrestre = tempoTerrestre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
