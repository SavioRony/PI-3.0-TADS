package br.sport.tads.servlet;

import br.sport.tads.dao.ProdutoDAO;
import br.sport.tads.entidade.ItemVenda;
import br.sport.tads.entidade.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        //Verifica se tem a quantidade suficiente para adcionar no carrinho
        if (quantidade > produto.getQuantidadeEmEstoque()) {
            sessaoVenda.setAttribute("semEstoque", 1); //Estoque infuficiente
        } 
        else{
            
            double valorTotal = 0;
            double subValor = quantidade * produto.getValorProduto();
            List<ItemVenda> listaCarrinho;
            DecimalFormat df = new DecimalFormat("###.00");
            String subV = df.format(subValor).replace(",", ".");
            subValor = Double.parseDouble(subV);
            ItemVenda item = new ItemVenda(produto.getCodProduto(), produto.getNomeProduto(), produto.getMarcaProduto(), produto.getValorProduto(), quantidade, subValor);
            quantidade = produto.getQuantidadeEmEstoque() - quantidade;
            try {
                ProdutoDAO.alterarQuantProduto(quantidade, produto.getCodProduto());
            } catch (SQLException ex ) {
                System.out.println("Erro na alteração da quantidade em estoque!");
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro na alteração da quantidade em estoque!");
            }
            
            if (sessaoVenda.getAttribute("valorTotal") == null) {
                valorTotal = subValor;
            } else {
                valorTotal = (double) sessaoVenda.getAttribute("valorTotal");
                valorTotal += subValor;
            }

            if (sessaoVenda.getAttribute("listaCarrinho") == null) {
                listaCarrinho = new ArrayList<>();
            } else {
                listaCarrinho = (List<ItemVenda>) sessaoVenda.getAttribute("listaCarrinho");
            }
            if (!listaCarrinho.contains(item)) {
                listaCarrinho.add(item);
            }
            sessaoVenda.setAttribute("quantEstoque", quantidade);
            sessaoVenda.setAttribute("listaCarrinho", listaCarrinho);
            sessaoVenda.setAttribute("valorTotal", valorTotal);
        }
    }
}
