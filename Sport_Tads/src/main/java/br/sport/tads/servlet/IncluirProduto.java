
package br.sport.tads.servlet;


import br.sport.tads.dao.ProdutoDAO;
import br.sport.tads.entidade.Produto;
import br.sport.tads.utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando
 */
public class IncluirProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        String cod_FilialStr = request.getParameter("filial");
        String nome_produto = request.getParameter("nome");
        String marca_produto = request.getParameter("marca");
        String categoria_produto = request.getParameter("categoria");
        String valorStr_produto = request.getParameter("valor");
        String qtdEstoqueStr_produto = request.getParameter("qtd");
        
        int codFilial = Integer.parseInt(cod_FilialStr);
        Double valor = Double.parseDouble(valorStr_produto);
        int qtd_Estoque = Integer.parseInt(qtdEstoqueStr_produto);
                            
        
        Produto produto = new Produto (codFilial,nome_produto,marca_produto,categoria_produto,valor,qtd_Estoque);
        
        try {
            ProdutoDAO.incluirProduto(produto);
            
            response.sendRedirect("listaProdutos");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }

    

}
