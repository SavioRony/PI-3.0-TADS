package br.sport.tads.servlet;

import br.sport.tads.entidade.ItemVenda;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VendaRemoveProdutoCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int linha = Integer.parseInt(request.getParameter("linha")) - 1;
        HttpSession sessaoVenda = request.getSession();

        List<ItemVenda> listaCarrinho = (List<ItemVenda>) sessaoVenda.getAttribute("listaCarrinho");
        double valorTotal = Double.parseDouble((String) sessaoVenda.getAttribute("valorTotal"));

        ItemVenda item = listaCarrinho.get(linha);
        valorTotal -= item.getSubTotal();
        listaCarrinho.remove(linha);
        sessaoVenda.setAttribute("listaCarrinho", listaCarrinho);
        sessaoVenda.setAttribute("valorTotal", valorTotal);

    }
}
