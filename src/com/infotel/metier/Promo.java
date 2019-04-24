package com.infotel.metier;

public class Promo {
	private int idPromo;
	private String nomsession;
	private int effectif;

	public int getIdPromo() {
		return idPromo;
	}

	public void setIdPromo(int idPromo) {
		this.idPromo = idPromo;
	}

	public String getNomsession() {
		return nomsession;
	}

	public void setNomsession(String nomsession) {
		this.nomsession = nomsession;
	}

	public int getEffectif() {
		return effectif;
	}

	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}

	@Override
	public String toString() {
		return "Promo [idPromo=" + idPromo + ", nomsession=" + nomsession + ", effectif=" + effectif + "]";
	}

	
}

