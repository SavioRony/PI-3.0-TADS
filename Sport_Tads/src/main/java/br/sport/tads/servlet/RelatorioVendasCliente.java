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

public class RelatorioVendasCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dataInicio = request.getParameter("dataInicio");
        String dataFinal = request.getParameter("dataFinal");
        String cpf = request.getParameter("cpf");
        int codFilial = Integer.parseInt(request.getParameter("codFilial"));

        List<Relatorio> listRelatorio = RelatorioDAO.novoRelatorioVendasPorCliente(cpf, dataInicio, dataFinal, codFilial);
        request.setAttribute("listaClientes", listRelatorio);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/Regional/relatorioVendasCliente.jsp");
        requestDispatcher.forward(request, response);
    }
}
