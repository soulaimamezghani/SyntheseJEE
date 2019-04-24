package com.infotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;

public class DaoImpl implements Idao {
	private Connection conn; 
	private PreparedStatement st;
	private ResultSet rs;

	@Override
	public int ajouterStagiaire(Stagiaire s) {
		try {
			
			// 1-Se connecter à la base des données
			 conn = GestionConnexion.getInstance();
			 
			// 2- préparer et effectuer la requéte
			st = conn.prepareStatement("INSERT INTO Stagiaire (nom,prenom,age) Values(?,?,?)");
			st.setString(1, s.getNom());
			st.setString(2, s.getPrenom());
			st.setInt(3, s.getAge());

			st.executeUpdate();
			// 3-récupérer le résultat en cas de besoin (
		     } catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erreur");
		}
		return s.getIdStagiaire();
	}

	@Override
	public int supprimerStagiaire(int idStagiaire) {
		try {
			// 1-Se connecter à la base des données
			conn = GestionConnexion.getInstance();
			
			// 2- préparer et effectuer la requéte
			st = conn.prepareStatement("DELETE from Stagiaire where idStagiaire=?");
			st.setInt(1, idStagiaire);

			st.executeUpdate();

		} catch (Exception e) {
			
			System.out.println("Erreur");
		}
		return idStagiaire;
	}

	@Override
	public List<Stagiaire> findAllStagiaire() {
		List<Stagiaire> list = new ArrayList<Stagiaire>();
		try {
			// 1-Se connecter à la base des données
			conn = GestionConnexion.getInstance();
			
			// 2- préparer et effectuer la requéte
			st = conn.prepareStatement("SELECT * FROM Stagiaire ");
			rs = st.executeQuery();

			// 3-récupérer le résultat en cas de besoin 
			
			while (rs.next()) {
				Stagiaire s = new Stagiaire();
				s.setIdStagiaire(rs.getInt("idstagiaire"));
				s.setNom(rs.getString("nom"));
				s.setPrenom(rs.getString("prenom"));
				s.setAge(rs.getInt("age"));
				list.add(s);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public int ajouterPromo(Promo p) {
		try {
			// 1-Se connecter à la base des données
			 conn = GestionConnexion.getInstance();
			 
			// 2- préparer et effectuer la requéte
			st = conn.prepareStatement("INSERT INTO Promo(nomsession,effectif) Values(?,?)");
			st.setString(1, p.getNomsession());
			st.setInt(2, p.getEffectif());

			st.executeUpdate();
			// 3-récupérer le résultat en cas de besoin 
		     } catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erreur");
		}
		return p.getIdPromo();
	}

	@Override
	public int supprimerPromo(int idPromo) {
		try {
			// 1-Se connecter à la base des données
			conn = GestionConnexion.getInstance();
			// 2- préparer et effectuer la requéte
			st = conn.prepareStatement("DELETE from Promo where idPromo=?");
			st.setInt(1, idPromo);

			st.executeUpdate();

		} catch (Exception e) {
			
			System.out.println("Erreur");
		}
		return idPromo;
	}

	@Override
	public List<Promo> findALLPromo() {
		List<Promo> list = new ArrayList<Promo>();
		try {
			// 1-Se connecter à la base des données
			conn = GestionConnexion.getInstance();
			
			// 2- préparer et effectuer la requéte
			st = conn.prepareStatement("SELECT * FROM Promo ");
			rs = st.executeQuery();

			// 3-récupérer le résultat en cas de besoin 
			
			while (rs.next()) {
				Promo p = new Promo();
				p.setIdPromo(rs.getInt("idPromo"));
				p.setNomsession(rs.getString("nomSession"));
				p.setEffectif(rs.getInt("effectif"));
				
				list.add(p);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	@Override
	public int ajouterFormation(Formation f) {
		try {
			// 1-Se connecter à la base des données
			 conn = GestionConnexion.getInstance();
			// 2- préparer et effectuer la requéte
			st = conn.prepareStatement("INSERT INTO Formation (nomFormation) Values(?)");
			st.setString(1, f.getNomformation());
			st.executeUpdate();
			// 3-récupérer le résultat en cas de besoin (
		     } catch (Exception e) {
			
			System.out.println("Erreur");
		}
		return f.getIdformation();
	}

	@Override
	public int supprimerFormation(int idFormation) {
		try {
			// 1-Se connecter à la base des données
			conn = GestionConnexion.getInstance();
			// 2- préparer et effectuer la requéte
			st = conn.prepareStatement("DELETE from Formation where idFormation=?");
			st.setInt(1, idFormation);

			st.executeUpdate();

		} catch (Exception e) {
			
			System.out.println("Erreur");
		}
		return idFormation;
	}
	
	@Override
	public List<Formation> findALLFormation() {
		List<Formation> list = new ArrayList<Formation>();
		try {
			// 1-Se connecter à la base des données
			conn = GestionConnexion.getInstance();
			// 2- préparer et effectuer la requéte
			st = conn.prepareStatement("SELECT * FROM Formation ");
			rs = st.executeQuery();

			// 3-récupérer le résultat en cas de besoin 
			
			while (rs.next()) {
				Formation f = new Formation();
				f.setIdformation(rs.getInt("idformation"));
				f.setNomformation(rs.getString("nomformation"));
				
				list.add(f);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void AttribuerStagiairePromotion(Stagiaire s, Promo p) {
		try {
			//1- se connecter à la base de données
			conn = GestionConnexion.getInstance();
			
			//2- préparer effectuer la requête
			st = conn.prepareStatement("UPDATE Stagiaire set fpromo=? where idstagiaire=?");
			st.setInt(1, p.getIdPromo());
			st.setInt(2, s.getIdStagiaire());
			
			st.executeUpdate();
			//3- récupérer le résultat en cas de besoin			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void AttribuerPromotionFormation(Promo p, Formation f) {
		try {
			//1- se connecter à la base de données
			conn = GestionConnexion.getInstance();
			
			//2- préparer effectuer la requête
			st = conn.prepareStatement("UPDATE promo set fFormation=? where idpromo=?");
			st.setInt(1, f.getIdformation());
			st.setInt(2, p.getIdPromo());
			
			st.executeUpdate();
			//3- récupérer le résultat en cas de besoin			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}}
	