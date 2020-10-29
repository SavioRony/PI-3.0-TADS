package br.sport.tads.servlet;

import br.sport.tads.dao.VendaDAO;
import br.sport.tads.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendaBuscarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codProdStr = request.getParameter("codProduto");
        int codProd = Integer.parseInt(codProdStr);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/vendas.jsp");
        requestDispatcher.forward(request, response);
    }
}
