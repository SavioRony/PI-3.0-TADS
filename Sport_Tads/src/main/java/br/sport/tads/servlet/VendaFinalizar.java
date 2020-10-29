package br.sport.tads.servlet;

import br.sport.tads.dao.VendaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendaFinalizar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codVendaStr = request.getParameter("codVenda");
        int codVenda = Integer.parseInt(codVendaStr);
        String valorTotalStr = request.getParameter("valorTotal");
        double valorTotal = Double.parseDouble(valorTotalStr);
        VendaDAO.finalizarVenda(valorTotal, codVenda);
        response.sendRedirect("sucesso.jsp");
    }
}
