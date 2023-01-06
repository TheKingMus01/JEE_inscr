/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.connexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MOY
 */
public class DaoFactory {
    private static String driver="com.mysql.jdbc.Driver";
private static String url="jdbc:mysql://localhost:3306/inscription";
private static String user="root";
private static String password="";
public static Connection connection;

    
   public static Connection getConnection()throws Exception{
            Class.forName(driver);
           return connection = DriverManager.getConnection(url, user,password);
   }
   
   public static void Sedeconnecter() throws Exception{
   connection.close();
   
   }
}
