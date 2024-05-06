/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.ClientesDTO;
import model.dao.ClientesDAO;

/**
 *
 * @author Senai
 */
@WebServlet(name = "ClienteController", urlPatterns = {"/Cadastro", "/login", "/Cadastrar", "/logar"})
public class ClienteController extends HttpServlet {

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
            throws ServletException, IOException {
        String url = request.getServletPath();
        if(url.equals("/Cadastro")){
        String nextPage = "/WEB-INF/jsp/cadastro.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
       }else if(url.equals("/login")){
        String nextPage = "/WEB-INF/jsp/login.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
        }
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
        String url = request.getServletPath();
        if (url.equals("/Cadastrar")) {
            ClientesDTO cadast = new ClientesDTO();
            cadast.setNome(request.getParameter("nome").equals("") ? "" : request.getParameter("nome"));
            cadast.setSenha(request.getParameter("senha"));
            cadast.setEmail(request.getParameter("email"));
            cadast.setTelefone(request.getParameter("telefone"));
            cadast.setCpf(request.getParameter("cpf"));

            ClientesDAO caD = new ClientesDAO();
            caD.insert(cadast);

            response.sendRedirect("./login");
        } else if (url.equals("/logar")) {
            ClientesDTO cliente = new ClientesDTO();
            cliente.setNome(request.getParameter("nome"));
            cliente.setSenha(request.getParameter("senha"));

            ClientesDAO cliD = new ClientesDAO();
            cliente = cliD.buscarLogin(cliente);
            if (cliente.getIdCliente() > 0) {
                if (cliente.getStatus() == 2) {
                    // redirecionar para página de admin
                    response.sendRedirect("./Produtos");
                } else {
                    // redirecionar para página de usuario
                    response.sendRedirect("./index");
                }
            } else {
                request.setAttribute("erroMensagem", "Erro ao realizar Login");
                String nextPage = "/WEB-INF/jsp/erroLogin.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            }

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


