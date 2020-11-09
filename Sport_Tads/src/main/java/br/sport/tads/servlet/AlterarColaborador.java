package br.sport.tads.servlet;

import br.sport.tads.dao.ColaboradorDAO;
import br.sport.tads.entidade.Colaborador;
import br.sport.tads.utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarColaborador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        Colaborador colaborador = ColaboradorDAO.getColaborador(cpf);
        request.setAttribute("colaborador", colaborador);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/TI/alterarColaborador.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        int numero = Integer.parseInt(request.getParameter("numero"));
        int cep = Integer.parseInt(request.getParameter("cep"));
        String cidade = request.getParameter("cidade");
        String cargo = request.getParameter("cargo");
        int filial = Integer.parseInt(request.getParameter("filial"));
        String usuario = request.getParameter("email");
        String senha = request.getParameter("senha");

        Colaborador colaborador = ColaboradorDAO.getColaborador(cpf);
        colaborador.setNome(nome);
        colaborador.setEndereco(endereco);
        colaborador.setNumero(numero);
        colaborador.setCep(cep);
        colaborador.setCidade(cidade);
        colaborador.setCargo(cargo);
        colaborador.setCodFilial(filial);
        colaborador.setUsuario(usuario);
        colaborador.setSenha(senha);
        colaborador.setCpf(cpf);
        try {
            ColaboradorDAO.updateColaborador(colaborador);
            response.sendRedirect("ListarColaboradores");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarColaborador.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
