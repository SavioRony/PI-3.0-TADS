
package br.sport.tads.servlet;

import br.sport.tads.dao.ItemVendaDAO;
import br.sport.tads.entidade.ItemVenda;
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
public class VendaCarrinho extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codVendaStr = request.getParameter("codVenda");
        int codVenda = Integer.parseInt(codVendaStr);
        String codFilialStr = request.getParameter("codFilial");
        int codFilial = Integer.parseInt(codFilialStr);
 
        List<ItemVenda> listaItemVenda = ItemVendaDAO.getItemVenda(codVenda);
        
        request.setAttribute("listaItemVenda",listaItemVenda);
        request.setAttribute("codVenda",codVenda);
        request.setAttribute("codFilial",codFilial);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/vendaCarrinho.jsp");
        requestDispatcher.forward(request, response);
    }


}
