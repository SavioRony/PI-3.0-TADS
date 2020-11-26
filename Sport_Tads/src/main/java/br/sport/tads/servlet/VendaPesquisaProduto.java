package br.sport.tads.servlet;

import br.sport.tads.dao.ProdutoDAO;
import br.sport.tads.entidade.Colaborador;
import br.sport.tads.entidade.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VendaPesquisaProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        HttpSession sessaoVenda = request.getSession();
        Colaborador c = (Colaborador) sessaoVenda.getAttribute("colaborador");
        Produto produto = ProdutoDAO.getProduto(idProduto, c.getCodFilial());
        sessaoVenda.setAttribute("produto", produto);

    }

}
