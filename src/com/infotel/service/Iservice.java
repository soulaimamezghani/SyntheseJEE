package com.infotel.service;

import java.util.List;


import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;

public interface Iservice {
public int ajouterStagiaire (Stagiaire s);
public int supprimerStagiaire (int idStagiaire);
public List<Stagiaire> findAllStagiaire();
public void AttribuerStagiairePromotion(Stagiaire s, Promo p);


public int ajouterPromo (Promo p);
public int supprimerPromo (int idPromo);
public List<Promo> findALLPromo();
public void AttribuerPromotionFormation(Promo p, Formation f);

public int ajouterFormation (Formation f);
public int supprimerFormation (int idFormation);
public List<Formation> findALLFormation();
	
}
