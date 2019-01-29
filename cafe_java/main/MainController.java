/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe_java.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Kaung Myat Soe
 */
public class MainController implements Initializable {

    @FXML
    private Label cafeJava;
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeAnimation();
       
        
    } 
    public void makeAnimation(){
         ScaleTransition scaleT=new ScaleTransition(Duration.seconds(3), cafeJava);
         scaleT.setFromX(0.0);
         scaleT.setFromY(0.0);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();
        
        scaleT.setOnFinished(e->{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/cafe_java/food/food.fxml"));
             try {
                 Parent root=loader.load();
                 Scene scene=new Scene(root);
                 Stage stage=new Stage();
                 stage.setScene(scene);
                 stage.show();
                 Stage curStage=(Stage) cafeJava.getScene().getWindow();
                 curStage.close();
             } catch (IOException ex) {
                 Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
      
    }
    
}
