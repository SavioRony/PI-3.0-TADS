
package br.senac.sp.servlet;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.utils.Utils;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpfStr = request.getParameter("cpf");
        String celularStr = request.getParameter("celular");
        Long cpf = Long.parseLong(cpfStr);
        int celular = Integer.parseInt(celularStr);
        
        Cliente cliente = new Cliente(nome, cpf, email, celular);
        try {
            ClienteDAO.addCliente(cliente);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }

    
}
