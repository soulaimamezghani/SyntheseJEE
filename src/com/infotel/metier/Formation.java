package com.infotel.metier;

public class Formation {

private int idformation;
private String nomformation;

public int getIdformation() {
	return idformation;
}
public void setIdformation(int idformation) {
	this.idformation = idformation;
}
public String getNomformation() {
	return nomformation;
}
public void setNomformation(String nomformation) {
	this.nomformation = nomformation;
}
@Override
public String toString() {
	return "Formation [idformation=" + idformation + ", nomformation=" + nomformation + "]";
}

}
