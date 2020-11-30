package br.sport.tads.servlet;

import br.sport.tads.dao.ProdutoDAO;
import br.sport.tads.entidade.ItemVenda;
import br.sport.tads.entidade.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VendaRemoverProdutoCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessaoVenda = request.getSession();
        String linha = request.getParameter("linha");
        int L = Integer.parseInt(linha) - 1;

        List<ItemVenda> listaCarrinho = (List<ItemVenda>) sessaoVenda.getAttribute("listaCarrinho");
        Double valorTotal = (Double) sessaoVenda.getAttribute("valorTotal");
        ItemVenda item = listaCarrinho.get(L);
        valorTotal -= item.getSubTotal();
        
        Produto produto = ProdutoDAO.getProduto(item.getCodProduto());
        int quantidade = produto.getQuantidadeEmEstoque();
        quantidade = item.getQuantidade() + quantidade;
        listaCarrinho.remove(L);

        try{
            ProdutoDAO.alterarQuantProduto(quantidade, produto.getCodProduto());
        } catch (SQLException ex) {
            System.out.println("Erro na alteração da quantidade em estoque!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro na alteração da quantidade em estoque!");
        }
        sessaoVenda.setAttribute("listaCarrinho", listaCarrinho);
        sessaoVenda.setAttribute("valorTotal", valorTotal);
        sessaoVenda.setAttribute("quantEstoque", quantidade);
    }
}
