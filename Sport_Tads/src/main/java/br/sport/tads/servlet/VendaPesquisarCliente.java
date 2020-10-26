
package br.sport.tads.servlet;

import br.sport.tads.dao.ClienteDAO;
import br.sport.tads.dao.FilialDAO;
import br.sport.tads.entidade.Cliente;
import br.sport.tads.entidade.Filial;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando
 */
public class VendaPesquisarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        
            List<Cliente> listaClientes = ClienteDAO.getClientes(cpf);                
            request.setAttribute("listaCliente", listaClientes);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/vendaCliente.jsp");
            requestDispatcher.forward(request, response);
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
            request.setAttribute("cpf", cpf);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/vendaFilial.jsp");
            requestDispatcher.forward(request, response);

    }
}
