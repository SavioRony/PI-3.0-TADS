
package br.sport.tads.servlet;


import br.sport.tads.dao.ProdutoDAO;
import br.sport.tads.entidade.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author savio
 */
public class VendaProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        int codFilial = Integer.parseInt(request.getParameter("codFilial"));
        int codVenda = Integer.parseInt(request.getParameter("codVenda"));
        int codProduto = Integer.parseInt(request.getParameter("codProduto"));

        
        List<Produto> listaProdutos = ProdutoDAO.getListaProdutos(codFilial,codProduto);
        request.setAttribute("listaProd",listaProdutos);
        request.setAttribute("codFilial", codFilial);
        request.setAttribute("codVenda", codVenda);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/vendaProduto.jsp");
        requestDispatcher.forward(request, response);
    }

}
