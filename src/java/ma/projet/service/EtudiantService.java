/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ma.projet.beans.Etudiant;
import ma.projet.connexion.DaoFactory;
import ma.projet.dao.IDao;

/**
 *
 * @author MOY
 */
public class EtudiantService implements IDao<Etudiant>{

    public boolean Add(Etudiant e) {
  try{
        Statement stm=DaoFactory.getConnection().createStatement();
        String q = "insert into etudiant values(" + e.getCNE() + ",'" +e.getNom() + "','" +e.getPrenom() + "','" +e.getDate_de_naissance()+ "','" +e.getType_de_Bac()+ "'," +e.getCode_de_formation()+",'" +e.getTitre_de_formation()+ "','" +e.getNombre_heures()+ "')";
            int update = stm.executeUpdate(q);
          return true;  
        }
        catch(Exception ex){ex.printStackTrace();
        return false;
        }   
  
 }

    @Override
    public List<Etudiant> findById(int id) {
List<Etudiant> listEtudiant=new ArrayList<Etudiant>();
        try{
        Statement stm=DaoFactory.getConnection().createStatement();
         String q = "select * from Etudiant where cne="+id+"";
            ResultSet rs = stm.executeQuery(q);
         
             while(rs.next())
            {
            int CNE=rs.getInt(1);
            String nom=rs.getString(2);
            String prenom=rs.getString(3);
            String date_de_naissance=rs.getString(4);
            String type_de_Bac=rs.getString(5);
            int code_de_formation=rs.getInt(6);
            String Titre_de_formation=rs.getString(7);
            String nombre_heures=rs.getString(8);

           listEtudiant.add(new Etudiant(CNE,nom,prenom,date_de_naissance,type_de_Bac,code_de_formation,Titre_de_formation,nombre_heures));
            }
                }
        catch(Exception ex){ex.printStackTrace();}
             return listEtudiant;
    }   

    @Override
    public List<Etudiant> findAll() {
List<Etudiant> listEtudiants=new ArrayList<Etudiant>();
        try{
        Statement stm=DaoFactory.getConnection().createStatement();
         String q = "select * from etudiant";
            ResultSet rs = stm.executeQuery(q);
         
             while(rs.next())
            {
            int CNE=rs.getInt(1);
            String nom=rs.getString(2);
            String prenom=rs.getString(3);
            String date_de_naissance=rs.getString(4);
            String type_de_Bac=rs.getString(5);
            int code_de_formation=rs.getInt(6);
            String Titre_de_formation=rs.getString(7);
            String nombre_heures=rs.getString(8);

           listEtudiants.add(new Etudiant(CNE,nom,prenom,date_de_naissance,type_de_Bac,code_de_formation,Titre_de_formation,nombre_heures));
            }
                }
        catch(Exception ex){ex.printStackTrace();}
             return listEtudiants;    }

    @Override
    public boolean delete(Etudiant o) {
try{
              Statement stm=DaoFactory.getConnection().createStatement();
                      String q = "delete from etudiant where CNE=" + o.getCNE();
                  stm.executeUpdate(q); 
                   return true;}
        catch(Exception ex){ex.printStackTrace();
        return false;}    
    }

    @Override
    public boolean update(Etudiant o) {
try{
            Statement stmt =DaoFactory.getConnection().createStatement();
        String q = "update etudiant  set nom='" +o.getNom() + "', prenom='" +o.getPrenom()+ "',date_de_naissance='" +o.getDate_de_naissance()+"',type_de_Bac='" +o.getType_de_Bac()+"',code_de_formation=" +o.getCode_de_formation()+",Titre_de_formation='" +o.getTitre_de_formation()+"',nombre_heures='" +o.getNombre_heures()+ "' where CNE=" + o.getCNE();
            int update = stmt.executeUpdate(q);
            return true;
             }
        catch(Exception ex){ex.printStackTrace();
        return false;
        }    }
    public List<Etudiant> findByFormation(int code) {
List<Etudiant> listEtudiant=new ArrayList<Etudiant>();
        try{
        Statement stm=DaoFactory.getConnection().createStatement();
         String q = "select * from Etudiant where code_de_formation ="+code+"";
            ResultSet rs = stm.executeQuery(q);
         
             while(rs.next())
            {
            int CNE=rs.getInt(1);
            String nom=rs.getString(2);
            String prenom=rs.getString(3);
            String date_de_naissance=rs.getString(4);
            String type_de_Bac=rs.getString(5);
            int code_de_formation=rs.getInt(6);
            String Titre_de_formation=rs.getString(7);
            String nombre_heures=rs.getString(8);

           listEtudiant.add(new Etudiant(CNE,nom,prenom,date_de_naissance,type_de_Bac,code_de_formation,Titre_de_formation,nombre_heures));
            }
                }
        catch(Exception ex){ex.printStackTrace();}
             return listEtudiant;
    }   
}
