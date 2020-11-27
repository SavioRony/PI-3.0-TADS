package br.sport.tads.servlet;

import br.sport.tads.entidade.ItemVenda;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VendaRemoverProdutoCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String linha = request.getParameter("linha");
        int L = Integer.parseInt(linha) - 1;
        HttpSession sessaoVenda = request.getSession();
        List<ItemVenda> listaCarrinho = (List<ItemVenda>) sessaoVenda.getAttribute("listaCarrinho");
        Double valorTotal = (Double) sessaoVenda.getAttribute("valorTotal");
        ItemVenda item = listaCarrinho.get(L);
        valorTotal -= item.getSubTotal();
        listaCarrinho.remove(L);
        sessaoVenda.setAttribute("listaCarrinho", listaCarrinho);
        sessaoVenda.setAttribute("valorTotal", valorTotal);
    }
}
