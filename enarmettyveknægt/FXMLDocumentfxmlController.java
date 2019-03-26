/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enarmettyveknægt;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author simon
 */
public class FXMLDocumentfxmlController implements Initializable {
    
    Image[] imageArr;
    Thread thread;
    
    ExecutorService executor = Executors.newFixedThreadPool(3);
            
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private Button stop1;
    @FXML
    private Button stop2;
    @FXML
    private Button stop3;
    @FXML
    private Label textLabel;
    @FXML
    private Button startButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        imageArr = new Image[10];

        for (int i = 0; i < imageArr.length; i++) {
            imageArr[i] = new Image(new File("src/enarmettyveknægt/fruits" + i + ".png").toURI().toString());

            executeThreads();

        }

    }

    @FXML
    public void enableButton(ActionEvent e) {
        stop1.setDisable(false);
        stop2.setDisable(false);
        stop3.setDisable(false);
        startButton.setDisable(true);

        executeThreads();

    }

    public void executeThreads() {
        executor.execute(() -> {
            BanditRunnable(image1, 100, stop1);
        });
        executor.execute(() -> {
            BanditRunnable(image2, 120, stop2);
        });
        executor.execute(() -> {
            BanditRunnable(image3, 140, stop3);
        });
    }

    @FXML
    public void disableButton(ActionEvent e) {
                
        if (e.getSource().equals(stop1)) {
            stop1.setDisable(true);
        } else if (e.getSource().equals(stop2)) {
            stop2.setDisable(true);
        } else if (e.getSource().equals(stop3)) {
            stop3.setDisable(true);
        }
        
        
        
        if (stop1.isDisabled() && stop2.isDisabled() && stop3.isDisabled()) {
            startButton.setDisable(false);
            if (image1.getImage() == image2.getImage() && image2.getImage() == image3.getImage()) {
                textLabel.setText("3 ens. Jackpot");
            } else if (image1.getImage() == image2.getImage() || image1.getImage() == image3.getImage() || image2.getImage() == image3.getImage()) {
                textLabel.setText("2 ens. Godt klaret");
            } else {
                textLabel.setText("Ingen ens. Prøv igen.");
            }

        }

    }

    public void BanditRunnable(ImageView im, long sleepTime, Button b) {
        while (!b.isDisabled()) {
            im.setImage(imageArr[(int) (Math.random() * 10)]);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentfxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
