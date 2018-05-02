/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfile.utils;


import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author BenyiJeanMarc
 */
@ManagedBean(name = "fileUploadView")
public class fileUploadView implements Serializable {

    private UploadedFile file;
    private String destination = "C:\\";
    private String extValidate;

    public void upload() {

        if (file != null) {
            Path path = Paths.get("C:\\" + "Path");
        try {
            Files.createDirectories(path);
        } catch (Exception e) {

        }
        }
         else
        {
           Path path = Paths.get("C:\\" + "Bnn");
        try {
            Files.createDirectories(path);
        } catch (Exception e) {

        }
        }
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getExtValidate() {
        return extValidate;
    }

    public void setExtValidate(String extValidate) {
        this.extValidate = extValidate;
    }


}
