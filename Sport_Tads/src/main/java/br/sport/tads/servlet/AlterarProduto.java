
package br.sport.tads.servlet;

import br.sport.tads.dao.ProdutoDAO;
import br.sport.tads.utils.Utils;
import br.sport.tads.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Fernando
 */

public class AlterarProduto extends HttpServlet {
    
   @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codProd = Integer.parseInt(request.getParameter("codProduto"));
        Produto produto = ProdutoDAO.getProduto(codProd); 
        request.setAttribute("prod",produto);
         RequestDispatcher rd = getServletContext().getRequestDispatcher("/alterarProduto.jsp");
         rd.forward(request, response);
     } 
         
         
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codProd = Integer.parseInt(request.getParameter("codProduto"));
        int cod_Filial = Integer.parseInt(request.getParameter("filial"));  // Long cpf = Long.parseLong(request.getParameter("cpf"));
        String nome_produto = request.getParameter("nome");  // String nome = request.getParameter("nome");
        String marca_produto = request.getParameter("marca");
        String categoria_produto = request.getParameter("categoria");
        Double valor = Double.parseDouble(request.getParameter("valor"));
        int  qtdEstoque = Integer.parseInt(request.getParameter("qtd"));
       
        Produto produto = ProdutoDAO.getProduto(codProd); 
            produto.setCodFilial(cod_Filial);
            produto.setNomeProduto(nome_produto);
            produto.setMarcaProduto(marca_produto);
            produto.setCategoriaProduto(categoria_produto);
            produto.setValorProduto(valor);
            produto.setQuantidadeEmEstoque(qtdEstoque);
       
            try {
             ProdutoDAO.alterarProduto(produto); 
             response.sendRedirect("sucesso.jsp");
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(AlterarProduto.class.getName()).log(Level.SEVERE, null, ex);
             Utils.mostrarTelaErro(ex, request, response);
         } 
        
    } 
    
}


