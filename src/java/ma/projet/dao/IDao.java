/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.dao;

import java.util.List;
import ma.projet.beans.Etudiant;

/**
 *
 * @author MOY
 */
public interface IDao<T> {
  //ADD
    public  boolean Add(T o);
  //DELETE 
    public boolean delete(T o); 
   //UPDATE
    public boolean update(T o); 
    //FINDBYID
    public List<T> findById (int id);
    public List<T> findByFormation (int code);
    //LISTER
    public List<T> findAll();
    


}
