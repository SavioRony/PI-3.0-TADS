package br.sport.tads.servlet;

import br.sport.tads.dao.ClienteDAO;
import br.sport.tads.entidade.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class buscarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        List<Cliente> listaClientes = ClienteDAO.getClientes(cpf);
        request.setAttribute("listaClientes", listaClientes);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/Vendas/listaClientes.jsp");
        requestDispatcher.forward(request, response);
    }
}
