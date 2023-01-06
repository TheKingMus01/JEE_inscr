/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

/**
 *
 * @author MOY
 */
public class Etudiant {
    private int CNE ,code_de_formation;
    private String nom,prenom,date_de_naissance,type_de_Bac,Titre_de_formation,nombre_heures;

    public Etudiant(int CNE, String nom, String prenom, String date_de_naissance, String type_de_Bac , int code_de_formation, String Titre_de_formation, String nombre_heures) {
        this.CNE = CNE;
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.type_de_Bac = type_de_Bac;
        this.Titre_de_formation = Titre_de_formation;
        this.nombre_heures = nombre_heures;
        this.code_de_formation = code_de_formation;
    }

    public Etudiant() {
    }

    public int getCNE() {
        return CNE;
    }

    public void setCNE(int CNE) {
        this.CNE = CNE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getType_de_Bac() {
        return type_de_Bac;
    }

    public void setType_de_Bac(String type_de_Bac) {
        this.type_de_Bac = type_de_Bac;
    }

    public String getTitre_de_formation() {
        return Titre_de_formation;
    }

    public void setTitre_de_formation(String Titre_de_formation) {
        this.Titre_de_formation = Titre_de_formation;
    }

    public String getNombre_heures() {
        return nombre_heures;
    }

    public void setNombre_heures(String nombre_heures) {
        this.nombre_heures = nombre_heures;
    }

    public int getCode_de_formation() {
        return code_de_formation;
    }

    public void setCode_de_formation(int code_de_formation) {
        this.code_de_formation = code_de_formation;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "CNE=" + CNE + ", nom=" + nom + ", prenom=" + prenom + ", date_de_naissance=" + date_de_naissance + ", type_de_Bac=" + type_de_Bac + ", Titre_de_formation=" + Titre_de_formation + ", nombre_heures=" + nombre_heures + ", code_de_formation=" + code_de_formation + '}';
    }
    
}
