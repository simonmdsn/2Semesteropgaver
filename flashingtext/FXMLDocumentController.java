/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashingtext;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
 *
 * @author erso
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label funLabel;
    private String text;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private Slider sleepSlider;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        thread.setDaemon(true);
        
    }



    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    if (funLabel.getText().trim().length() == 0) {
                        text = "Programming is fun";
                    } else {
                        text = "";
                    }
                    System.out.println("Flash: " + text);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            funLabel.setText(text);
                        }
                    });

                    Thread.sleep((long)sleepSlider.getValue());
                }
            } catch (InterruptedException ex) {
            }

        }

    });

    @FXML
    private void startButton(ActionEvent event) {
        thread.start();
    }

    @FXML
    private void stopOnAction(ActionEvent event) {
        if(thread.isAlive()){
            thread.interrupt();
        }
    }
}
