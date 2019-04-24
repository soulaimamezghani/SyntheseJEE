package com.infotel.service;

import java.util.List;

import com.infotel.dao.DaoImpl;
import com.infotel.dao.Idao;
import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;

public class ServiceImpl implements Iservice {
	 private Idao dao = new DaoImpl();


	@Override
	public int ajouterStagiaire(Stagiaire s) {
		// TODO Auto-generated method stub
		return dao.ajouterStagiaire(s);
	}

	@Override
	public int supprimerStagiaire(int idStagiaire) {
		// TODO Auto-generated method stub
		return dao.supprimerStagiaire(idStagiaire);
	}

	@Override
	public List<Stagiaire> findAllStagiaire() {
		// TODO Auto-generated method stub
		return dao.findAllStagiaire();
	}

	@Override
	public int ajouterPromo(Promo p) {
		// TODO Auto-generated method stub
		return dao.ajouterPromo(p);
	}

	@Override
	public int supprimerPromo(int idPromo) {
		// TODO Auto-generated method stub
		return dao.supprimerPromo(idPromo);
	}

	@Override
	public List<Promo> findALLPromo() {
		// TODO Auto-generated method stub
		return dao.findALLPromo();
	}

	@Override
	public int ajouterFormation(Formation f) {
		// TODO Auto-generated method stub
		return dao.ajouterFormation(f);
	}

	@Override
	public int supprimerFormation(int idFormation) {
		// TODO Auto-generated method stub
		return dao.supprimerFormation(idFormation);
	}

	@Override
	public List<Formation> findALLFormation() {
		// TODO Auto-generated method stub
		return dao.findALLFormation();
	}

	@Override
	public void AttribuerStagiairePromotion(Stagiaire s, Promo p) {
		dao.AttribuerStagiairePromotion(s, p);
		
	}

	@Override
	public void AttribuerPromotionFormation(Promo p, Formation f) {
		dao.AttribuerPromotionFormation(p, f);
		
	}

}
