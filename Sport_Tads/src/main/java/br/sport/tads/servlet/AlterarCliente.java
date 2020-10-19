
package br.sport.tads.servlet;

import br.sport.tads.dao.ClienteDAO;
import br.sport.tads.entidade.Cliente;
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

public class AlterarCliente extends HttpServlet {

  
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        Cliente cliente = ClienteDAO.getCliente(cpf);
        request.setAttribute("cliente", cliente);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/alterarCliente.jsp");
        rd.forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         String nome = request.getParameter("nome");
         String email = request.getParameter("email");
         String cpf = request.getParameter("cpf");
         int celular = Integer.parseInt(request.getParameter("celular"));
         Cliente cliente = ClienteDAO.getCliente(cpf);
         cliente.setNome(nome);
         cliente.setEmail(email);
         cliente.setCelular(celular);
         
         try {
             ClienteDAO.updateCliente(cliente);
             response.sendRedirect("ListarClientes");
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
             Utils.mostrarTelaErro(ex, request, response);
         } 
        
    }

    

}
