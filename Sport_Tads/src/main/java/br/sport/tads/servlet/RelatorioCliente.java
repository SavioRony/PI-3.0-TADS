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

public class RelatorioCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        List<Relatorio> listRelatorio = RelatorioDAO.getRelatorioCliente(cpf);
        request.setAttribute("listaClientes", listRelatorio);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/relatorioClientes.jsp");
        requestDispatcher.forward(request, response);
    }
}
