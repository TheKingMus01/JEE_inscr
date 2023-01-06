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
import ma.projet.beans.formation;
import ma.projet.connexion.DaoFactory;
import ma.projet.dao.IDao;

/**
 *
 * @author MOY
 */
public class FormationService  implements IDao<formation>{

    @Override
    public boolean Add(formation o) {
try{
        Statement stm=DaoFactory.getConnection().createStatement();
        String q = "insert into formation values(" + o.getCode() + ",'" +o.getTitre_de_formation() + "','" +o.getNombre_heures() + "')";
            int update = stm.executeUpdate(q);
          return true;  
        }
        catch(Exception ex){ex.printStackTrace();
        return false;
        }       }

    @Override
    public boolean delete(formation o) {
try{
              Statement stm=DaoFactory.getConnection().createStatement();
                      String q = "delete from formation where code=" + o.getCode() ;
                  stm.executeUpdate(q); 
                   return true;}
        catch(Exception ex){ex.printStackTrace();
        return false;}      }

    @Override
    public boolean update(formation o) {
try{
            Statement stmt =DaoFactory.getConnection().createStatement();
        String q = "update formation  set Titre_de_formation='" +o.getTitre_de_formation() + "', nombre_heures='" +o.getNombre_heures()+ "' where code=" + o.getCode();
            int update = stmt.executeUpdate(q);
            return true;
             }
        catch(Exception ex){ex.printStackTrace();
        return false;
        }    
    }

    @Override
    public List<formation> findById(int id) {
List<formation> listformation=new ArrayList<formation>();
        try{
        Statement stm=DaoFactory.getConnection().createStatement();
         String q = "select * from formation where code="+id+"";
            ResultSet rs = stm.executeQuery(q);
         
             while(rs.next())
            {
            int code=rs.getInt(1);
            String Titre_de_formation=rs.getString(2);
            String nombre_heures=rs.getString(3);

           listformation.add(new formation(code,Titre_de_formation,nombre_heures));
            }
                }
        catch(Exception ex){ex.printStackTrace();}
             return listformation;
    }       

    @Override
    public List<formation> findAll() {
List<formation> listformations=new ArrayList<formation>();
        try{
        Statement stm=DaoFactory.getConnection().createStatement();
         String q = "select * from formation";
            ResultSet rs = stm.executeQuery(q);
         
             while(rs.next())
            {
            int code=rs.getInt(1);
            String Titre_de_formation=rs.getString(2);
            String nombre_heures=rs.getString(3);

           listformations.add(new formation(code,Titre_de_formation,nombre_heures));
            }
                }
        catch(Exception ex){ex.printStackTrace();}
             return listformations;    }

    @Override
    public List<formation> findByFormation(int code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
