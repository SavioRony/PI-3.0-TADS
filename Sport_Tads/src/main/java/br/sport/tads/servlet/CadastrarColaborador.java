package br.sport.tads.servlet;

import br.sport.tads.dao.ColaboradorDAO;
import br.sport.tads.entidade.Colaborador;
import br.sport.tads.utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarColaborador extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Colaborador colaborador = new Colaborador();
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        int numero = Integer.parseInt(request.getParameter("numero"));
        int cep = Integer.parseInt(request.getParameter("cep"));
        String cidade = request.getParameter("cidade");
        String cargo = request.getParameter("cpf");
        int filial = Integer.parseInt(request.getParameter("filial"));
        String usuario = request.getParameter("usuario");
        String senha = colaborador.codificarSenha(request.getParameter("senha"));
        String perfil = request.getParameter("perfil");

        colaborador = new Colaborador(nome, cpf, endereco, numero, cep, cidade, cargo, filial, usuario, senha, perfil);
        try {
            ColaboradorDAO.addColadorador(colaborador);
            response.sendRedirect("ListarColaboradores");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarColaborador.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
