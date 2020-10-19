package br.senac.sp.servlet;

import br.senac.sp.dao.ProdutoDAO;
import br.sport.tads.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletBD extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletBD</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            List<Produto> listaProdutos = ProdutoDAO.getListaProdutos();
            for(Produto produto: listaProdutos) {
                
                
                out.println(produto);
                out.println("<br/>");
            }
                   
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
