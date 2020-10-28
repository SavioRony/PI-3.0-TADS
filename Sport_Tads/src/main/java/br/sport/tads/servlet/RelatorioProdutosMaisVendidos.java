
package br.sport.tads.servlet;

import br.sport.tads.dao.RelatorioDAO;
import br.sport.tads.entidade.Relatorio;
import java.io.IOException;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando
 */
public class RelatorioProdutosMaisVendidos extends HttpServlet {


     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
               
        List<Relatorio> listaProdutos = RelatorioDAO.relatorioDezMaisVendidos(); 
        request.setAttribute("listaProd", listaProdutos);
        
        
        
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/relatorioProdutos.jsp");
        requestDispatcher.forward(request, response);
    }

}


