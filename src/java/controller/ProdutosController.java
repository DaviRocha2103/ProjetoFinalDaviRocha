/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.bean.CategoriaDTO;
import model.bean.ProdutosDTO;
import model.dao.CategoriasDAO;
import model.dao.ProdutosDAO;

/**
 *
 * @author Senai
 */
public class ProdutosController extends HttpServlet {

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
        ProdutosDAO produtosDAO = new ProdutosDAO();
        CategoriasDAO CategoriasDAO = new CategoriasDAO();
        List<CategoriaDTO> categorias = CategoriasDAO.listarCategorias();
        request.setAttribute("categorias", categorias);
        String url = request.getServletPath();
        System.out.println(url);
        if(url.equals("/cadastroP")) {
            String nextPage = "/WEB-INF/jsp/cadastroProdutos.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if(url.equals("/index")){
            List<ProdutosDTO> produtos = produtosDAO.read();
            for (int i = 0; i < produtos.size(); i++) {
                    
                    if (produtos.get(i).getImagem() != null) {
                        String imagemBase64 = Base64.getEncoder().encodeToString(produtos.get(i).getImagem());
                        System.out.println("aqui");
                        System.out.println(imagemBase64);
                        produtos.get(i).setImagemBase64(imagemBase64);

                    }
                }
            request.setAttribute("produtos", produtos);
            String nextPage = "/WEB-INF/jsp/index.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/buscarProdutos")) {
            String busca = request.getParameter("busca") != null ? request.getParameter("busca") : "";
            if(busca.equals("")) {
                String categoria = request.getParameter("cat");
                List<ProdutosDTO> produtos = produtosDAO.buscaCategoria(Integer.parseInt(categoria));
                request.setAttribute("produtos", produtos);
            } else {
                busca = "%"+busca+"%";
                List<ProdutosDTO> produtos = produtosDAO.buscaProdutos(busca);
                request.setAttribute("produtos", produtos);
            }
            String nextPage = "/WEB-INF/jsp/produtos.jsp";
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
        ProdutosDTO newProduto = new ProdutosDTO();
        newProduto.setNome(request.getParameter("nome"));
        newProduto.setCategoria(Integer.parseInt(request.getParameter("categoria")));
        newProduto.setDescricao(request.getParameter("descricao"));
        newProduto.setPreco(Float.parseFloat(request.getParameter("valor")));
        Part filePart = request.getPart("imagem");
        InputStream istream = filePart.getInputStream();
        ByteArrayOutputStream byteA = new ByteArrayOutputStream();
        byte[] img = new byte[4096];
        int byteRead = -1;
        while((byteRead = istream.read(img)) != -1 ) {
            byteA.write(img, 0, byteRead);
        }
        byte[] imgBytes = byteA.toByteArray();
        newProduto.setImagem(imgBytes);
        ProdutosDAO produtosD = new ProdutosDAO();
        produtosD.insert(newProduto);
        response.sendRedirect("./index");
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
