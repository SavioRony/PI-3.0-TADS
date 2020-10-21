package br.senac.sp.servlet;

import br.senac.sp.dao.ColaboradorDAO;
import br.senac.sp.entidade.Colaborador;
import java.io.IOException;
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
public class ListarColaboradores extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Colaborador> listaColaboradores = ColaboradorDAO.getColaboradores();
        System.out.println("QUANTIDADE DE ELEMENTOS LISTA:" + listaColaboradores.size());
        request.setAttribute("listaColaboradores", listaColaboradores);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(
                "/listaColaboradores.jsp");
        requestDispatcher.forward(request, response);
    }

}
