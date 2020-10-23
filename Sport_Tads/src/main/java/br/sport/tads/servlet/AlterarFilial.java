package br.sport.tads.servlet;

import br.sport.tads.dao.FilialDAO;
import br.sport.tads.entidade.Filial;
import br.sport.tads.utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarFilial extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codFilial = Integer.parseInt(request.getParameter("codFilial"));
        Filial filial = FilialDAO.getFilial(codFilial);
        request.setAttribute("filial", filial);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/alterarFilial.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codFilial = Integer.parseInt(request.getParameter("codFilial"));
        String nomeFilial = request.getParameter("nomeFilial");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        int status = Integer.parseInt(request.getParameter("status"));
        Filial filial = FilialDAO.getFilial(codFilial);
        filial.setNomeFilial(nomeFilial);
        filial.setEstado(estado);
        filial.setCidade(cidade);
        filial.setStatus(status);
        
        try {
            FilialDAO.alterarFilial(filial);
            response.sendRedirect("CadastroFilial");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }

}
