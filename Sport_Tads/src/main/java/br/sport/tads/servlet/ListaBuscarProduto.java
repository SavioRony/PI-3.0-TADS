package br.sport.tads.servlet;

import br.sport.tads.dao.ProdutoDAO;
import br.sport.tads.entidade.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaBuscarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProduto = 0;
        if(!request.getParameter("idProduto").equals("")){
            idProduto = Integer.parseInt(request.getParameter("idProduto"));
        } 
        String categoria = request.getParameter("categoria");
        System.out.println(categoria);
        List<Produto> listaProduto = ProdutoDAO.getProduto(idProduto,categoria);
        request.setAttribute("listaProd", listaProduto);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protegido/Backoffice/listaProdutos.jsp");
        requestDispatcher.forward(request, response);
        
    }

}
