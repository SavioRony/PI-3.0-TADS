package br.sport.tads.servlet;

import br.sport.tads.dao.VendaDAO;
import br.sport.tads.entidade.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendaListarCpf extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> listaCpf = VendaDAO.listaCpf();
        request.setAttribute("artilheiros", listaCpf);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/teste");
        requestDispatcher.forward(request, response);
    }
}
