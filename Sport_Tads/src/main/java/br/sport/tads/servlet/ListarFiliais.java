
package br.sport.tads.servlet;

import br.sport.tads.dao.FilialDAO;
import br.sport.tads.entidade.Filial;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarFiliais extends HttpServlet{
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Filial> listaFiliais = FilialDAO.listarFiliais();
        request.setAttribute("listaFiliais", listaFiliais);
        
         RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/listaFiliais.jsp");
         requestDispatcher.forward(request, response);
    }
    
}
