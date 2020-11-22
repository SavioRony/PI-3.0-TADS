package br.sport.tads.servlet;

import br.sport.tads.dao.ProdutoDAO;
import br.sport.tads.entidade.Colaborador;
import br.sport.tads.entidade.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListaProdutos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Colaborador c =(Colaborador) sessao.getAttribute("colaborador");
        List<Produto> listaProdutos = ProdutoDAO.getListaProdutos(c.getCodFilial());
        request.setAttribute("listaProd", listaProdutos);
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/protegido/Backoffice/listaProdutos.jsp");
        requestDispatcher.forward(request, response);
    }
}
