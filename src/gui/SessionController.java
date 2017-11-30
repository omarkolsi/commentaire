/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.commentaire;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Entities.commentaire;
import Service.commentaireService;
import controller.Commentaire_ajoutController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author rayen-sat
 */
public class SessionController implements Initializable {

    @FXML
    private TextField textNom;
    @FXML
    private TextField textPrenom;
    @FXML
    private Button btnLogin;
    public static String nom12;

    public static String getNom12() {
        return nom12;
    }

    public static void setNom12(String nom12) {
        SessionController.nom12 = nom12;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException {

        commentaireService ser = new commentaireService();

        commentaire commentaires = new commentaire(textNom.getText());
        nom12=textNom.getText();
          System.out.println(nom12);
          System.out.println("4545454545554545454545454554545454");
        //ser.ajouterCommentaire(commentaires);
       
        //nom1 = textNom.getText();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("commentaire_ajout.fxml"));
        Parent root = loader.load();

        Commentaire_ajoutController affichageController = loader.getController();

//       List<commentaire> listcom = ser.findAll();
//        
//        for(int i=0;i<listcom.size();i++){
//            System.out.println(listcom.get(i));
//        }
        textNom.getScene().setRoot(root);
    }

    void changescene(String gui, ActionEvent event) throws IOException {
        FXMLLoader fxmlloder = new FXMLLoader(getClass().getResource(gui));

    }

}
