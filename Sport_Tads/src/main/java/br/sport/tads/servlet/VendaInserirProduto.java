package br.sport.tads.servlet;

import br.sport.tads.dao.ItemVendaDAO;
import br.sport.tads.entidade.ItemVenda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendaInserirProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codVenda = Integer.parseInt(request.getParameter("codVenda"));
        int codProduto = Integer.parseInt(request.getParameter("codProduto"));
        int codFilial = Integer.parseInt(request.getParameter("codFilial"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double subTotal = Double.parseDouble(request.getParameter("subTotal"));

        try {
            ItemVenda item = new ItemVenda(codVenda, codProduto, quantidade, subTotal);
            ItemVendaDAO.inserirItemVenda(item);
            request.setAttribute("codFilial", codFilial);
            request.setAttribute("codVenda", codVenda);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/vendaProduto.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VendaProduto.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("/erro.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
