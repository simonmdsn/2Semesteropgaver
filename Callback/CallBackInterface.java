/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Callback;

import java.io.File;

/**
 *
 * @author erso
 */
public interface CallBackInterface {
    
    void updateMessage(String message);
    void updateImages(File i1, File i2);
    
}
