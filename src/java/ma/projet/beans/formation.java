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
public class formation {
    private int code ;
    private String Titre_de_formation,nombre_heures;

    public formation(int code, String Titre_de_formation, String nombre_heures) {
        this.code = code;
        this.Titre_de_formation = Titre_de_formation;
        this.nombre_heures = nombre_heures;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "formation{" + "code=" + code + ", Titre_de_formation=" + Titre_de_formation + ", nombre_heures=" + nombre_heures + '}';
    }

    public formation() {
    }
    
}
