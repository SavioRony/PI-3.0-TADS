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
        HttpSession sessaoVenda = request.getSession();
        String cpf = request.getParameter("cpf");
        
        if(ClienteDAO.getCliente(cpf)!= null){
            Cliente cliente = ClienteDAO.getCliente(cpf);
            sessaoVenda.setAttribute("cpf", cpf);
            sessaoVenda.setAttribute("cliente", cliente);
            sessaoVenda.setAttribute("semCliente", 0);
        }else{
            sessaoVenda.setAttribute("semCliente", 1);
        }
    }
}
