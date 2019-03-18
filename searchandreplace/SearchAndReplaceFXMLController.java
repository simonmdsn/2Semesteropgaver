/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchandreplace;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author simon
 */
public class SearchAndReplaceFXMLController implements Initializable {

    private FileChooser fileChooser;
    private StringBuilder sb = new StringBuilder();
    
    @FXML
    private TextField erstatTextField;
    @FXML
    private TextField søgTextField;
    @FXML
    private TextArea tekstTextArea;
    @FXML
    private Button erstatAlleButton;
    @FXML
    private Button åbenFilButton;
    @FXML
    private Button gemSomButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
    }   

    @FXML
    private void erstatAlleOnAction(ActionEvent event) {
        tekstTextArea.setText(tekstTextArea.getText().replaceAll(søgTextField.getText(), erstatTextField.getText()));
    }

    @FXML
    private void åbenFilOnAction(ActionEvent event) {
        File file = fileChooser.showOpenDialog(tekstTextArea.getScene().getWindow());
        if (file.exists()) {
            try (Scanner sc = new Scanner(file)) {
                while(sc.hasNextLine()) {
                    sb.append(sc.nextLine()).append("\n");
                }
                tekstTextArea.setText(sb.toString());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SearchAndReplaceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void gemSomOnAction(ActionEvent event) {
        fileChooser.showSaveDialog(tekstTextArea.getScene().getWindow());
            
    }
    
}
