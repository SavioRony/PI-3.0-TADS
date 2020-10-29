package br.sport.tads.servlet;

import br.sport.tads.dao.VendaDAO;
import br.sport.tads.entidade.Venda;
import br.sport.tads.utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendaGerarPedido extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        String filialStr = request.getParameter("filial");
        Date dataAtual = new Date();
        int codFilial = Integer.parseInt(filialStr);
        Venda venda = new Venda(cpf, codFilial, dataAtual);

        try {
            venda = VendaDAO.GerarPedidoVenda(venda);
            int codVenda = venda.getCodVenda();
            request.setAttribute("codFilial", codFilial);
            request.setAttribute("codVenda", codVenda);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/vendaProduto.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(VendaGerarPedido.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }
}
