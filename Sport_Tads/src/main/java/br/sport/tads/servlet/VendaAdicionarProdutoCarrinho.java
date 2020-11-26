
package br.sport.tads.servlet;

import br.sport.tads.entidade.ItemVenda;
import br.sport.tads.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class VendaAdicionarProdutoCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessaoVenda = request.getSession();
        
        Produto produto = (Produto) sessaoVenda.getAttribute("produto");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        double subValor = quantidade * produto.getValorProduto();
        ItemVenda item = new ItemVenda(produto.getCodProduto(), produto.getNomeProduto(), produto.getMarcaProduto(), produto.getValorProduto(), quantidade, subValor);
        double valorTotal = 0;
        
        if(sessaoVenda.getAttribute("valorTotal") == null){
             valorTotal = subValor;
             System.out.println("Vazio: "+valorTotal);
        }else{
             valorTotal = (double) sessaoVenda.getAttribute("valorTotal");
             System.out.println("Resgate da Sessão: "+valorTotal);
             valorTotal += subValor;
             System.out.println("Somando com subTotal "+valorTotal);
        }
        
        
        List<ItemVenda> listaCarrinho;
        
        if (sessaoVenda.getAttribute("listaCarrinho") == null) {
            listaCarrinho = new ArrayList<>();
        } else {
            listaCarrinho = (List<ItemVenda>) sessaoVenda.getAttribute("listaCarrinho");
        }
        if (!listaCarrinho.contains(item)) {
            listaCarrinho.add(item);
        }
        sessaoVenda.setAttribute("listaCarrinho", listaCarrinho);
        sessaoVenda.setAttribute("valorTotal", valorTotal);
    }
}
