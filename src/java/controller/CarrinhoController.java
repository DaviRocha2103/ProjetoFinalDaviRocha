/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.CarrinhoDTO;
import model.bean.ClientesDTO;
import model.dao.CarrinhoDAO;
import model.dao.EstoqueDAO;

/**
 *
 * @author Senai
 */
public class CarrinhoController extends HttpServlet {

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
        ClientesDTO user = new ClientesDTO();

        if (user.getIdCliente() == 0) {
            String nextPage = "/WEB-INF/jsp/login.jsp";
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
            System.out.println("aqui1");
        }

        CarrinhoDAO cDao = new CarrinhoDAO();

        if (url.equals("/Adicionar")) {
            CarrinhoDTO cart = new CarrinhoDTO();
            cart.setIdProduto(Integer.parseInt(request.getParameter("produto")));

            String nome = request.getParameter("produto");         

            EstoqueDAO eDao = new EstoqueDAO();
            int quantidade_disponivel = eDao.Quantidade(nome);

            cart = cDao.validacao(cart);
System.out.println("aqui2");
            if (cart.getIdProduto() > 0 & cart.getQuantidade() < quantidade_disponivel) {
                int idProduto = cart.getIdProduto();
                int quantidade = cart.getQuantidade();
                float preco = cart.getPreco();
                float total = cart.getTotal();
                quantidade = quantidade + 1;
                total = preco * quantidade;

                cDao.att(quantidade, idProduto, total);
System.out.println("aqui3");
                List<CarrinhoDTO> produto = cDao.ler(ClientesDTO.getIdCliente());
                float total_carrinho = cDao.Total(ClientesDTO.getIdCliente());

                request.setAttribute("total", total_carrinho);
                request.setAttribute("produtos", produto);
                String nextPage = "/WEB-INF/jsp/carrinho.jsp";

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            } else if (cart.getIdProduto() > 0 & cart.getQuantidade() >= quantidade_disponivel) {  
                System.out.println("aqui4");
            } else {
                cart.setImagem(request.getParameter("imagem"));
                cart.setIdProduto(Integer.parseInt(request.getParameter("idProduto")));
                cart.setPreco(Float.parseFloat(request.getParameter("preco")));
                cart.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                cart.setTotal(cart.getPreco() * cart.getQuantidade());
                cart.setIdClientes(ClientesDTO.getIdCliente());
System.out.println("aqui5");
                cDao.add(cart);
            }
        } else if (url.equals("/Adicionar")) {
            int idCarrinho = Integer.parseInt(request.getParameter("id"));
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            float preco = Float.parseFloat(request.getParameter("preco"));
            float total = Float.parseFloat(request.getParameter("total"));
            quantidade = quantidade + 1;
            total = preco * quantidade;
System.out.println("aqui6");
            String nome = request.getParameter("produto");

            EstoqueDAO eDao = new EstoqueDAO();
            int quantidade_disponivel = eDao.Quantidade(nome);

            if (quantidade <= quantidade_disponivel) {
                cDao.att(quantidade, idCarrinho, total);

                List<CarrinhoDTO> produto = cDao.ler(ClientesDTO.getIdCliente());
                float total_carrinho = cDao.Total(ClientesDTO.getIdCliente());
System.out.println("aqui7");
                request.setAttribute("total", total_carrinho);
                request.setAttribute("produtos", produto);
            }

        }
        if (url.equals("/Diminuir")) {
            int idCarrinho = Integer.parseInt(request.getParameter("id"));
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            float preco = Float.parseFloat(request.getParameter("preco"));
            float total = Float.parseFloat(request.getParameter("total"));
System.out.println("aqui8");
            quantidade = quantidade - 1;
            total = preco * quantidade;

            if (quantidade <= 0) {
                cDao.delete(idCarrinho);
            } else {
                cDao.att(quantidade, idCarrinho, total);
            }
System.out.println("aqui9");
            List<CarrinhoDTO> produto = cDao.ler(ClientesDTO.getIdCliente());
            float total_carrinho = cDao.Total(ClientesDTO.getIdCliente());

            request.setAttribute("total", total_carrinho);
            request.setAttribute("produtos", produto);
            String nextPage = "/WEB-INF/jsp/carrinho.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
System.out.println("aqui10");
        } else {
            List<CarrinhoDTO> produto = cDao.ler(ClientesDTO.getIdCliente());
            request.setAttribute("produtos", produto);
            System.out.println(url);
            float totalCarrinho = cDao.Total(ClientesDTO.getIdCliente());
            request.setAttribute("total", totalCarrinho);
System.out.println("aqui11");
            String nextPage = "/WEB-INF/jsp/carrinho.jsp";

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
        processRequest(request, response);
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
