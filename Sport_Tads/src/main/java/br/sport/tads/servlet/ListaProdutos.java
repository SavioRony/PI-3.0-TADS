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

public class ListaProdutos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produto> listaProdutos = ProdutoDAO.getListaProdutos();
        request.setAttribute("listaProd", listaProdutos);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/listaProdutos.jsp");
        requestDispatcher.forward(request, response);
    }
}
