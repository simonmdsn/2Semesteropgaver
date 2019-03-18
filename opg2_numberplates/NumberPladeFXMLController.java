/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opg2_numberplates;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import opg3_playingcards.DeckOfCards;

/**
 * FXML Controller class
 *
 * @author simon
 */
public class NumberPladeFXMLController implements Initializable {

    
    
    private NumberPlates np;
    private DeckOfCards doc;
    
    @FXML
    private TextField tekstField;
    @FXML
    private Button tjekButton;
    @FXML
    private Label outputLabel;
    @FXML
    private Label kortLabel;
    @FXML
    private Button blandKnap;
    @FXML
    private Slider swapSlider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        np = new NumberPlates();
        doc = new DeckOfCards();
        kortLabel.setText(doc.toString());
    }    

    @FXML
    private void tjekAction(ActionEvent event) {
        outputLabel.setText(np.validate(tekstField.getText())); 
    }
        
        
    @FXML
    private void blandAction(ActionEvent event) {
        int swapValue = (int)swapSlider.getValue();
        doc.shuffle(swapValue);
        kortLabel.setText(doc.toString());
        System.out.println("Du blandede " + swapValue +" kort");
    }
    
}
