package br.sport.tads.servlet;

import br.sport.tads.dao.ColaboradorDAO;
import br.sport.tads.entidade.Colaborador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Colaborador colaborador = ColaboradorDAO.getColaboradores(login);

        if (colaborador == null || !colaborador.validarSenha(senha)) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?erro=UserNotFound");
        } else {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("colaborador", colaborador);
            response.sendRedirect(request.getContextPath() + "/protegido/index.jsp");
        }
    }

}
