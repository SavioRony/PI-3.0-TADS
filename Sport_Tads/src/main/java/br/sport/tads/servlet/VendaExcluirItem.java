package br.sport.tads.servlet;

import br.sport.tads.dao.ItemVendaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendaExcluirItem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idItemSrt = request.getParameter("idItem");
        int idItem = Integer.parseInt(idItemSrt);
        String codProdutoStr = request.getParameter("codProduto");
        int codProduto = Integer.parseInt(codProdutoStr);
        String quantidadeStr = request.getParameter("quantidade");
        int quantidade = Integer.parseInt(quantidadeStr);
        try {
            ItemVendaDAO.excluirItemVenda(idItem, codProduto, quantidade);
            response.getWriter().print(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ExcluirProduto.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().print(false);
        }
    }
}
