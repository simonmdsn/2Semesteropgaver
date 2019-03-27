/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Callback;

import Callback.CallBackInterface;
import Callback.FacadeWithCallback;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author erso
 */
public class FXMLDocumentController implements Initializable, CallBackInterface {
   
    
    @FXML
    private TextArea textArea;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private ImageView die1view;
    @FXML
    private ImageView die2view;

    private FacadeWithCallback facade;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        startButton.setDisable(false);
        stopButton.setDisable(true);
    }

    @FXML
    private void buttonAction(ActionEvent event) {
        if (event.getSource() == startButton) {
            facade = new FacadeWithCallback(this);
            facade.start();
            stopButton.setDisable(false);
            startButton.setDisable(true);
// Initialize the facade and start it.
// handle access to the buttons
        } else {
            facade.interrupt();
            stopButton.setDisable(true);
            startButton.setDisable(false);
// Stop the facade
        }
    }




    @Override
    public void updateMessage(String message) {
        textArea.appendText(message+"\n");
        // This is the implementation of the CallBack. Remember it is called fro a Thread!
        // append the message to the textArea
    }

    @Override
    public void updateImages(File i1, File i2) {
        die1view.setImage(new Image(i1.toURI().toString()));
        die2view.setImage(new Image(i2.toURI().toString()));
    }
         
}



