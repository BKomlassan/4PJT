/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supfile.utils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author BenyiJeanMarc
 */
@ManagedBean
public class Folder implements Serializable {

    String nom_dossier;

    public void createDirectory() {
        Path path = Paths.get("C:\\");
        try {
            Files.createDirectories(path);
        } catch (Exception e) {
        }

    }

//    public static void main(String[] args) throws IOException {
//        Folder f= new  Folder();
//        f.readDirectoriesFromDirectory();
//    }
    public void createDirectoryByLogin(String Login, String NameFolder) {

        Path path = Paths.get("C:\\" + Login + "\\" + NameFolder);
        try {
            Files.createDirectories(path);
        } catch (Exception e) {

        }
    }

    public List<String> readDirectoriesFromDirectory(String Login) {
        String dirPath = "C:\\" + Login;
        File dir = new File(dirPath);
        String[] files = dir.list();
        List<String> list = new ArrayList<>();
        if (files.length != 0) {
            for (String aFile : files) {
                list.add(aFile);
            }
           
        }
         return list;
          
    }

    public void openDirectory(String d) {
//    public void openDirectory() {
        //juste pour tester
        d = "cfv";
        String dirPath = "C:/bjm" + "/" + d;
        File dir = new File(dirPath);
        String[] files = dir.list();
        for (String aFile : files) {
            System.out.println(aFile);
        }
    }

    public String getNom_dossier() {
        return nom_dossier;
    }

    public void setNom_dossier(String nom_dossier) {
        this.nom_dossier = nom_dossier;
    }

}
