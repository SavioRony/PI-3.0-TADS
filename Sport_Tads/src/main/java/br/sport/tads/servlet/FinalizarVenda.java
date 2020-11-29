package br.sport.tads.servlet;

import br.sport.tads.dao.ItemVendaDAO;
import br.sport.tads.dao.VendaDAO;
import br.sport.tads.entidade.Cliente;
import br.sport.tads.entidade.Colaborador;
import br.sport.tads.entidade.ItemVenda;
import br.sport.tads.entidade.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FinalizarVenda extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessaoVenda = request.getSession();

        Cliente cliente = (Cliente) sessaoVenda.getAttribute("cliente");
        Colaborador colaborador = (Colaborador) sessaoVenda.getAttribute("colaborador");
        double valorTotal = (double) sessaoVenda.getAttribute("valorTotal");
        Date dataAtual = new Date();

        Venda venda = new Venda(cliente.getCpf(), colaborador.getCodFilial(), colaborador.getCodigoColaborador(), dataAtual, valorTotal);
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("CodFilial: " + colaborador.getCodFilial());
        System.out.println("CodVendedor: " + colaborador.getCodigoColaborador());
        System.out.println("ValorTotal: " + valorTotal);
        try {
            venda = VendaDAO.GerarPedidoVenda(venda);
            System.out.println("CodVenda: " + venda.getCodVenda());

        } catch (SQLException ex) {
            Logger.getLogger(FinalizarVenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinalizarVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<ItemVenda> listaCarrinho = (List<ItemVenda>) sessaoVenda.getAttribute("listaCarrinho");

        try {

            for (ItemVenda item : listaCarrinho) {
                ItemVendaDAO.inserirItemVenda(item, venda.getCodVenda());
            }

            response.sendRedirect(request.getContextPath() + "/sucesso.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(FinalizarVenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinalizarVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sessaoVenda.removeAttribute("cliente");
            sessaoVenda.removeAttribute("valorTotal");
            sessaoVenda.removeAttribute("listaCarrinho");
            sessaoVenda.removeAttribute("produto");
        }

    }

}
