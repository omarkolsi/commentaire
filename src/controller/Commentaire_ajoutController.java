/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import Entities.commentaire;
//import Service.commentaireService;
import java.util.ArrayList;
import java.util.List;
//import com.lynden.gmapsfx.GoogleMapView;
import java.io.FileNotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import gui.SessionController;
import Entities.commentaire;
import Service.commentaireService;

import javafx.event.EventHandler;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author rayen-sat
 */
public class Commentaire_ajoutController implements Initializable {
    private commentaireService tc=new commentaireService();
private commentaire t=new commentaire();

    @FXML
    private TableColumn<commentaire, String> ur;
    @FXML
    private TableColumn<commentaire, Integer> colomnPrenom;
    @FXML
    private TableColumn<commentaire, String> colomnCommentaite;
    @FXML
    private TextField textCommentaire;
    @FXML
    private Button btnCommenter;
    
    @FXML
    private Button btnSupprimer;
    @FXML
    private TableView<commentaire> table1;
    commentaireService ser=new commentaireService();
        List<commentaire>listcommontaire = ser.findAll();
         ObservableList<commentaire> data;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         List<commentaire> listForm = new ArrayList<>();
          data =
        FXCollections.observableArrayList();
        
        listForm = tc.findAll();
        System.out.println(listForm);
        System.out.println("***********");
        for(commentaire c:listForm){
            System.out.println("aaa"+c);
            data.add(c);
        }
        
        
               
                  
   /*colomnPrenom.setCellValueFactory( new PropertyValueFactory<>("id"));
    colomnCommentaite.setCellValueFactory( new PropertyValueFactory<>("Commentaire"));
    ur.setCellValueFactory(new PropertyValueFactory<>("Username"));*/
          colomnCommentaite.setCellFactory(TextFieldTableCell.forTableColumn());
          colomnCommentaite.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<commentaire, String>>() {
                    
                 @Override
                public void handle(TableColumn.CellEditEvent<commentaire, String> t) {
                    ((commentaire) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setCommentaire(t.getNewValue());
                    commentaire c = (commentaire) t.getTableView().getItems().get(t.getTablePosition().getRow());
                    c.setCommentaire(t.getNewValue());
                    
                   
                    commentaireService.getInstance().modifierCommentaire(c);
                }}
);
    
   
    
        //System.out.println("55555555555555555555555");
        //System.out.println(data);
//        ObservableList<commentaire> data = FXCollections.observableArrayList(listForm);
       // System.out.println(data);
        //table1.setItems(data);
        
                                 
    }
                             
public void resetTableData(List<commentaire> list){
    List<commentaire> myResult = tc.findAll();
    System.out.println("controller.Commentaire_ajoutController.resetTableData()");
    System.out.println(myResult);
       
        ObservableList<commentaire> data = FXCollections.observableArrayList(myResult);
         
 ur.setCellValueFactory(
        new PropertyValueFactory<>("username"));        
    colomnPrenom.setCellValueFactory(                
        new PropertyValueFactory<>("id"));
    colomnCommentaite.setCellValueFactory(
        new PropertyValueFactory<>("commentaire"));        


       
        table1.setItems(data);
}
    @FXML
    private void ajout_commentaire(ActionEvent event) throws FileNotFoundException {
         commentaireService ser=new commentaireService();
    
        t=table1.getSelectionModel().getSelectedItem();
        SessionController s = new SessionController();
        System.out.println(s.getNom12());
        
         commentaire commentaireee=new commentaire(0,s.getNom12(),textCommentaire.getText());
//        System.out.println(commentaireee);
//        System.out.println("-----------------------------------------------------------");
        ser.ajouterCommentaire(commentaireee);
        
        
         
              
    colomnPrenom.setCellValueFactory(                
        new PropertyValueFactory<commentaire,Integer>("id"));
    
    colomnCommentaite.setCellValueFactory(
        new PropertyValueFactory<commentaire,String>("commentaire"));
        ur.setCellValueFactory(
        new PropertyValueFactory<commentaire,String>("username"));    
        
        List<commentaire> listForm = new ArrayList<>();
        listForm = tc.findAll();
        System.out.println(listForm);
        System.out.println("*************");
        
        ObservableList<commentaire> data = FXCollections.observableArrayList(listForm);
        
        table1.setItems(data);
         
         
        
         
        List<commentaire> listcomentaire = ser.findAll();
        
        for(int i=0;i<listcomentaire.size();i++){
            System.out.println(listcomentaire.get(i));
            
        }
        
        
         
           
         
     
    }

    @FXML
    private void supprimer_commentaire(ActionEvent event) {
                t=table1.getSelectionModel().getSelectedItem();
       tc.supprimercommentaire(t);
        List<commentaire> listForm = new ArrayList<>();
        
        listForm = tc.findAll();
        
        resetTableData(listForm);
    }

    private void modifier_commentaire(ActionEvent event) {
              t=table1.getSelectionModel().getSelectedItem();
       tc.modifierCommentaire(t);
        List<commentaire> listForm = new ArrayList<>();
        
        listForm = tc.findAll();
        
        resetTableData(listForm);
    }

    private void ajouterCommentaire(commentaire t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @FXML
//    private void changeCommentaireCellEvent(TableColumn.CellEditEvent<S, T> event) {
//    }
    
}
