package br.sport.tads.servlet;

import br.sport.tads.dao.ClienteDAO;
import br.sport.tads.entidade.Cliente;
import br.sport.tads.utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String celularStr = request.getParameter("celular");
        long celular = Long.parseLong(celularStr);

        Cliente cliente = new Cliente(nome, cpf, email, celular);
        try {
            ClienteDAO.addCliente(cliente);
            response.sendRedirect("ListarClientes");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }
}
