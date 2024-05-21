/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig
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
        newProduto.setCategoria(Integer.parseInt(request.getParameter("categorias")));
        newProduto.setDescricao(request.getParameter("descricao"));
        newProduto.setPreco(Float.parseFloat(request.getParameter("preco")));
        newProduto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        Part filePart = request.getPart("imagem");
    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // Corrige problemas com o navegador IE
    if (fileName != null && !fileName.isEmpty()) {
        String basePath = getServletContext().getRealPath("/") + "assets"; // Caminho para a pasta assets
        File uploads = new File(basePath);
        if (!uploads.exists()) {
            uploads.mkdirs(); // Cria o diretório se não existir
        }
        File file = new File(uploads, fileName);

        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace(); // Trate as exceções de forma adequada
        }

        // Configurando apenas o caminho relativo da imagem no banco de dados
        newProduto.setImagem("assets/" + fileName);
    } else {
        newProduto.setImagem(null);
    }

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
