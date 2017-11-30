/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;





public class login {

    private static int id;
    private static String prenom;
    //private String Commentaire;
     private static String Nom;
     //private int id_user;
   
   
    public login() {
    }

    public login(int id,String Nom, String prenom ) {
        this.id = id;
        this.Nom = Nom;
       // this.Commentaire = Commentaire;
        this.prenom = prenom;
       // this.numberetoil = numberetoil;
      //this.numberchambre = numberchambre;
        //this.visibilite = visibilite;
          //this.aime = aime;
    }

//    public commentaire(String Nom, String prenom) {
//        this.Nom = Nom;
//        this.description = description;
//    }
    
    
//....................

//    public commentaire(String description) {
//        this.description = description;
//    }
    
//.......................
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
//    public String getCommentaire() {
//        return Commentaire;
//    }
//
//    public void setCommentaire(String Commentaire) {
//        this.Commentaire = Commentaire;
//    }

    /*public int getNumberetoil() {
        return numberetoil;
    }

    public void setNumberetoil(int numberetoil) {
        this.numberetoil = numberetoil;
    }

    public int getNumberchambre() {
        return numberchambre;
    }

    public void setNumberchambre(int numberchambre) {
        this.numberchambre = numberchambre;
    }

    public int getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(int visibilite) {
        this.visibilite = visibilite;
    }

    public int getAime() {
        return aime;
    }

    public void setAime(int aime) {
        this.aime = aime;
    }*/

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", nom=" + Nom + ", prenom=" + prenom  + '}';
    }
    
    

   
}