package br.sport.tads.servlet;

import br.sport.tads.dao.ColaboradorDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirColaborador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        try {
            ColaboradorDAO.deleteColadorador(cpf);
            response.getWriter().print(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ExcluirColaborador.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().print(false);
        }
    }
}
