package br.sport.tads.servlet;

import br.sport.tads.dao.ClienteDAO;
import br.sport.tads.entidade.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VendaPesquisarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cpf = request.getParameter("cpf");
        Cliente cliente = ClienteDAO.getCliente(cpf);
        HttpSession sessaoVenda = request.getSession();
        sessaoVenda.setAttribute("cpf", cpf);
        sessaoVenda.setAttribute("cliente", cliente);

    }

}
