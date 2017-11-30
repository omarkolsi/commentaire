/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.commentaire;
import Technique.Connexion;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;


public class commentaireService {

    Statement ste;
    Connection connexion;

    public commentaireService() {

 try {
            connexion = Connexion.getIstanceConnexion();
            ste = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(commentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
private static commentaireService instance;
   
public static commentaireService getInstance(){
    if (instance==null) 
    {instance=new commentaireService();}
    return instance;
    }




    public void ajouterCommentaire(commentaire r) throws FileNotFoundException {
        try {
            PreparedStatement st = connexion.prepareStatement("INSERT INTO `commentaire` ( `username`,commentaire)  VALUES (?,?)");
          
               
           
            
            st.setString(1, r.getUsername());
            st.setString(2, r.getCommentaire());
            
            
              
            
            
            System.out.println("sql request" + st);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentaireService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("yesss" + ex);
        }


    }
    
    
    
      public void modifierCommentaire(commentaire r) {
        try {
            PreparedStatement st = connexion.prepareStatement("UPDATE `commentaire` SET `id`=?,`commentaire`=?  WHERE `id`=?");
               
          
            
       
            st.setInt(1, r.getId());
            st.setString(2, r.getCommentaire());
            st.setInt(3, r.getId());
            
            
           
           
        
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentaireService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("yesss" + ex);
        }
    }

    public void supprimercommentaire(commentaire r) {
        try {
            PreparedStatement st = connexion.prepareStatement("Delete from `commentaire` where `id`=?");
            st.setInt(1, r.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(commentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
     public List<commentaire> findAll() {
        List<commentaire> listCommentaire = new ArrayList<>();
        String requete = "select * from commentaire";
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
        
            while (resultat.next()) {
                commentaire p = new commentaire();

                p.setId(resultat.getInt(1));
                p.setCommentaire(resultat.getString(2));
                p.setUsername(resultat.getString(4));
                
                
              listCommentaire.add(p);
            }
            return listCommentaire;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
            return null;
        }
    }



}

