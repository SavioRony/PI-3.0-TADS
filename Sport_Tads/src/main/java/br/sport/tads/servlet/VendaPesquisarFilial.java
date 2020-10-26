
package br.sport.tads.servlet;

import br.sport.tads.dao.FilialDAO;
import br.sport.tads.entidade.Filial;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author savio
 */
public class VendaPesquisarFilial extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        String cpf = request.getParameter("cpf");
        String codFilialstr = request.getParameter("codFilial");
        int codFilial = Integer.parseInt(codFilialstr);
        
        List<Filial> listaFilial = FilialDAO.getFilial(codFilial);                
            request.setAttribute("listaFilial", listaFilial);
            request.setAttribute("cpf", cpf);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/vendaFilial.jsp");
            requestDispatcher.forward(request, response);
    }

       protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
            request.setAttribute("cpf", cpf);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/vendaFilial.jsp");
            requestDispatcher.forward(request, response);

    }


}
