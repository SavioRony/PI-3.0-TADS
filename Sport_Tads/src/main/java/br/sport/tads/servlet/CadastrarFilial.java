
package br.sport.tads.servlet;

import br.sport.tads.dao.FilialDAO;
import br.sport.tads.entidade.Filial;
import br.sport.tads.utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CadastrarFilial extends HttpServlet{
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String nomeFilial = request.getParameter("nomeFilial");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String statusStr = request.getParameter("status");
        
        int status = Integer.parseInt(statusStr);
        
        Filial filial = new Filial(nomeFilial, estado, cidade, status);
        try {
            FilialDAO.cadastrarFilial(filial);
            response.sendRedirect("ListarFiliais");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarFilial.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }
    
}
