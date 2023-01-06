/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.projet.beans.Etudiant;
import ma.projet.beans.formation;
import ma.projet.dao.IDao;
import ma.projet.service.EtudiantService;
import ma.projet.service.FormationService;

/**
 *
 * @author MOY
 */
public class Controleur extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {doPost(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

String do_this = request.getParameter("do_this");
    IDao Es= new EtudiantService();
    IDao Fs= new FormationService();
Etudiant e=new Etudiant();
formation f = new formation();
if (do_this == null) {
    
        
request.setAttribute("listformations", Fs.findAll());
                    request.getRequestDispatcher("addEtudiant.jsp").forward(request, response);
} else if (do_this.equals("delete")) {
                    int cne = Integer.parseInt(request.getParameter("cne").toString().trim());
                    String nom = (String)request.getParameter("nom");
                     String prenom = (String)request.getParameter("prenom");
                     String date_de_naissance = (String)request.getParameter("date_de_naissance");
                     String type_de_Bac = (String)request.getParameter("type_de_Bac");
                     int code_de_formation =  Integer.parseInt(request.getParameter("code_de_formation"));
                     String Titre_de_formation = (String)request.getParameter("Titre_de_formation");
                     String nombre_heures = (String)request.getParameter("nombre_heures");


Es.delete(new Etudiant(cne,nom,prenom,date_de_naissance,type_de_Bac,code_de_formation,Titre_de_formation,nombre_heures));
                     request.setAttribute("listformations", Fs.findAll());
request.setAttribute("listEtudiants", Es.findAll());
                    request.getRequestDispatcher("/Show.jsp").forward(request, response);
} 
else if(do_this.equals("create")){    
                     int cne =  Integer.parseInt(request.getParameter("cne"));
                     String nom = (String)request.getParameter("nom");
                     String prenom = (String)request.getParameter("prenom");
                     String date_de_naissance = (String)request.getParameter("date_de_naissance");
                     String type_de_Bac = (String)request.getParameter("type_de_Bac");
                     int code_de_formation =  Integer.parseInt(request.getParameter("code_de_formation"));
                     String Titre_de_formation = (String)request.getParameter("Titre_de_formation");
                     String nombre_heures = (String)request.getParameter("nombre_heures");
            
                 Es.Add(new Etudiant(cne,nom,prenom,date_de_naissance,type_de_Bac,code_de_formation,Titre_de_formation,nombre_heures));
                                      request.setAttribute("listformations", Fs.findAll());
    
                 request.setAttribute("listEtudiants", Es.findAll());
                    request.getRequestDispatcher("/Show.jsp").forward(request, response);
            
        
} 
else if (do_this.equals("update")) {

                     int cne =  Integer.parseInt(request.getParameter("cne").toString().trim());
                     String nom = (String)request.getParameter("nom");
                     String prenom = (String)request.getParameter("prenom");
                     String date_de_naissance = (String)request.getParameter("date_de_naissance");
                     String type_de_Bac = (String)request.getParameter("type_de_Bac");
                     int code_de_formation =  Integer.parseInt(request.getParameter("code_de_formation").toString().trim());
                     String Titre_de_formation = (String)request.getParameter("titre_de_formation");
                     String nombre_heures = (String)request.getParameter("nombre_heures");
                     Es.update(new Etudiant(cne,nom,prenom,date_de_naissance,type_de_Bac,code_de_formation,Titre_de_formation,nombre_heures));

                     request.setAttribute("listformations", Fs.findAll());
                           request.setAttribute("listEtudiants", Es.findAll());
                    request.getRequestDispatcher("/Show.jsp").forward(request, response);
            
            }
        
 

 else if (do_this.equals("search")) {

                     int cne =  Integer.parseInt(request.getParameter("cne").toString().trim());
request.setAttribute("listEtudiant",Es.findById(cne));
 request.getRequestDispatcher("/update.jsp").forward(request, response);
    

 }    
     else if (do_this.equals("selectFormation")) {
                              int id =  Integer.parseInt(request.getParameter("code_de_formation"));
                                        request.setAttribute("listFormation",Fs.findById(id));

                                      request.getRequestDispatcher("/NextStep.jsp").forward(request, response);

    

 } else if (do_this.equals("Show")) {
                     request.setAttribute("listformations", Fs.findAll());
                           request.setAttribute("listEtudiants", Es.findAll());
                    request.getRequestDispatcher("/Show.jsp").forward(request, response);

    

 }else if (do_this.equals("FormationModify")) {
                              int id =  Integer.parseInt(request.getParameter("code_de_formation"));
                                        request.setAttribute("listFormation",Fs.findById(id));

                                      request.getRequestDispatcher("/modify.jsp").forward(request, response);

    

 }else if (do_this.equals("ShowF1")) {
                              int code =  Integer.parseInt(request.getParameter("code"));
                                        request.setAttribute("listEF",Es.findByFormation(code));

                                      request.getRequestDispatcher("/ShowEF.jsp").forward(request, response);

    

 }else if (do_this.equals("addtoF")) {
                                   int code =  Integer.parseInt(request.getParameter("code"));
                             request.setAttribute("listEtudiants", Es.findAll());
                    request.getRequestDispatcher("/add.jsp").forward(request, response);


 }else if (do_this.equals("insertinF")) {
                                   int code_de_formation =  Integer.parseInt(request.getParameter("code_de_formation"));
                                   int cne =  Integer.parseInt(request.getParameter("CNE").toString().trim());
                                        
                                   request.setAttribute("listFormation",Fs.findById(code_de_formation));
                                request.setAttribute("letudiant",Es.findById(cne));
                    request.getRequestDispatcher("/addplus.jsp").forward(request, response);


 }
    
    
    
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
