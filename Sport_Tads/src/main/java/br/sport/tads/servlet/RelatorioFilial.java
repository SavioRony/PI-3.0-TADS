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
 * @author Hugo Souza Araujo
 */
public class RelatorioFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Relatorio> listaFiliais = RelatorioDAO.relatorioFiliais();
        request.setAttribute("listaFiliais", listaFiliais);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/relatorioFiliais.jsp");
        requestDispatcher.forward(request, response);
    }

}
