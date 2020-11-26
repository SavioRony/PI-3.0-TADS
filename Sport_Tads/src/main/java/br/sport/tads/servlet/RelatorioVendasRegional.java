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

public class RelatorioVendasRegional extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dataInicio = request.getParameter("dataInicio");
        String dataFinal = request.getParameter("dataFinal");
        int codFilial = Integer.parseInt(request.getParameter("codFilial"));
        double valorTotal = 0;

        List<Relatorio> listaVendasRegional = RelatorioDAO.novoRelatorioVendasFilial(codFilial, dataInicio, dataFinal);
        for (Relatorio r : listaVendasRegional) {
            valorTotal += r.getValorTotal();
        }
        request.setAttribute("vendas", listaVendasRegional);
        request.setAttribute("valorTotal", valorTotal);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/Regional/relatorioVendasRegional.jsp");
        requestDispatcher.forward(request, response);
    }

}
