package br.sport.tads.servlet;

import br.sport.tads.dao.RelatorioDAO;
import br.sport.tads.entidade.Relatorio;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RelatorioConsolidadoVendasPorFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dataInicio = request.getParameter("dataInicio");
        String dataFinal = request.getParameter("dataFinal");
        double totalFaturado = 0;
        List<Relatorio> listaFiliais = RelatorioDAO.novoRelatorioConsolidadoVendasPorFilial(dataInicio, dataFinal);
        for (Relatorio r : listaFiliais) {
            totalFaturado += r.getSubTotal();
        }
        DecimalFormat df = new DecimalFormat("#,###.00");
        request.setAttribute("listaFiliais", listaFiliais);
        request.setAttribute("totalFaturado", df.format(totalFaturado));
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/Global/relatorioConsolidadoVendasPorFilial.jsp");
        requestDispatcher.forward(request, response);
    }
}
