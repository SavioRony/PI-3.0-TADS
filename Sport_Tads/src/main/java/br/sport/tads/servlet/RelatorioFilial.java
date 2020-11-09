package br.sport.tads.servlet;

import br.sport.tads.dao.RelatorioDAO;
import br.sport.tads.entidade.Relatorio;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RelatorioFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Relatorio> listaFiliais = RelatorioDAO.relatorioFiliais();
        request.setAttribute("listaFiliais", listaFiliais);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/Regional/relatorioFiliais.jsp");
        requestDispatcher.forward(request, response);
    }
}
