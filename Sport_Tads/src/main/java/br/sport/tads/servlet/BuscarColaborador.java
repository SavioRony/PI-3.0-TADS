package br.sport.tads.servlet;

import br.sport.tads.dao.ColaboradorDAO;
import br.sport.tads.entidade.Colaborador;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuscarColaborador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        String cpf = request.getParameter("cpf");
        List<Colaborador> listaColaboradores = null;
        Colaborador c = (Colaborador) sessao.getAttribute("colaborador");

        if (cpf.equals("")) {
            listaColaboradores = ColaboradorDAO.getColaboradores(c.getCodFilial());
        } else {
            listaColaboradores = ColaboradorDAO.getColaborador(cpf, c.getCodFilial());
        }
        request.setAttribute("listaColaboradores", listaColaboradores);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/TI/listaColaboradores.jsp");
        requestDispatcher.forward(request, response);
    }
}
