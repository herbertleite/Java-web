package br.senac.pi3.brawan.controller;

import br.senac.pi3.brawan.DAO.VendasDAO;
import br.senac.pi3.brawan.model.ItemVenda;
import br.senac.pi3.brawan.model.Produto;
import br.senac.pi3.brawan.model.Venda;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "VendaServlet", urlPatterns = {"/venda01", "/VendaExcluir", "/venda02", "/verifica"})
public class VendaServlet extends HttpServlet {

    private ArrayList<ItemVenda> lista;
    private ArrayList<Produto> pro;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String pagina = request.getRequestURI();

        try {
            if (pagina.endsWith("VendaExcluir")) {
                excluirItem(request, response);
            } else if (pagina.endsWith("venda02")) {
                venda02(request, response);
            }
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String pagina = request.getRequestURI();

        try {
            if (pagina.endsWith("venda01")) {
                carrinho(request, response);
            }

        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    protected void carrinho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        HttpSession sessao = request.getSession(true);
        
        // Verifica se as listas estao nulas
        if (pro == null && lista == null) {
            pro = new ArrayList();
            lista = new ArrayList();

        }

        VendasDAO venda = new VendasDAO();

        //Pega o cpf do cliente da pagina JSP
        String cpf = request.getParameter("cpfCliente");

        //Validador se cliente consta no banco
        boolean cpfEhValido = venda.buscarCliente(cpf);

        if (cpfEhValido == false) {
            pro.clear();
            request.setAttribute("msgErroCliente", "Cliente não cadastrado no sistema!");
            request.getRequestDispatcher("./jsp/vendas/carrinho.jsp")
                    .forward(request, response);
        }

        //Pega o cod do produto da pagina JSP
        String cod = request.getParameter("CodProduto");

        //Validador se produto existe no banco
        boolean produtoEhValido = venda.buscarProduto(cod.replace(" ", ""));

        if (produtoEhValido == false) {
            pro.clear();
            request.setAttribute("msgErroProduto", "Produto não cadastrado no sistema!");
            request.getRequestDispatcher("./jsp/vendas/carrinho.jsp")
                    .forward(request, response);

        }

        //Pega a qtd que o cliente deseja compra do produto
        int quantidade = Integer.parseInt(request.getParameter("Quantidade"));

        pro = venda.listarCod(cod);

        //Verifica o estoque do produto
        for (int i = 0; i < pro.size(); i++) {
            int qtdProd = pro.get(i).getQuantidade();
            if (qtdProd < quantidade) {
                pro.clear();
                request.setAttribute("msgErroEstoque", "Estoque de " + qtdProd + " produtos, menor que o solicitado.");
                request.getRequestDispatcher("./jsp/vendas/carrinho.jsp")
                        .forward(request, response);
            }
            break;
        }

        //Verifica se tem produto repetido no carrinho e alerta o vendedor
        int idProduto = 0;

        for (int i = 0; i < pro.size(); i++) {
            idProduto = pro.get(i).getId();

        }

        for (ItemVenda listItem : lista) {

            if (listItem.getId() == idProduto) {
                pro.clear();
                request.setAttribute("msgErroRepetido", "Produto já adicionado ao carrinho!");
                request.getRequestDispatcher("./jsp/vendas/carrinho.jsp")
                        .forward(request, response);
            }

        }

        /* Se lista produto estiver vazia, significa que aconteceu algum erro,
            Entao operacao nao é realizada
         */
        if (!pro.isEmpty()) {

            ItemVenda item = new ItemVenda();

            float valor = 0;

            // Seta os valores da lista produto na lista ItemVenda
            for (Produto list : pro) {

                valor = Float.parseFloat(list.getValorUnitario());
                item.setQuantidadeEstoque(list.getQuantidade());
                item.setId(list.getId());
                item.setNome(list.getNome());
                item.setCodigoProd(list.getCodigo());
                item.setValorUnitario(list.getValorUnitario());

            }

            //Variavel que pega o valor total do item
            float valorTotalItem = quantidade * valor;

            item.setQuantidade(quantidade);
            item.setValorTotalItem(valorTotalItem);
            lista.add(item);

            //A lista produto pode ser limpa, pois vou utilizar somente na prox chamada ao metodo
            pro.clear();

        }

        

        if (cpfEhValido == true) {

            
            sessao.setAttribute("lista", lista);

        }
        sessao.setAttribute("cpf", cpf);
        RequestDispatcher rd = request.getRequestDispatcher("./jsp/vendas/carrinho.jsp");
        rd.forward(request, response);

    }

    protected void excluirItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        int id = Integer.parseInt(request.getParameter("id"));

        //Percorre a lista e verifica se o ID é igual e exclui referente ao index
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                break;

            }

        }

        HttpSession sessao = request.getSession(true);
        RequestDispatcher rd = request.getRequestDispatcher("./jsp/vendas/carrinho.jsp");
        sessao.setAttribute("lista", lista);

        rd.forward(request, response);

    }

    protected void venda02(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        HttpSession sessao = request.getSession();

        VendasDAO dao = new VendasDAO();

    

            Venda venda = new Venda();
            int quantidadeTotal = 0;
            float valorTotal = 0;

            for (ItemVenda item : lista) {
                dao.inserirItemVenda(item.getId(), item.getValorTotalItem());
                quantidadeTotal = quantidadeTotal + item.getQuantidade();
                float valor = item.getQuantidade() * Float.parseFloat(item.getValorUnitario());
                valorTotal = valorTotal + valor;
            }

            //Atualiza estoque de produto    
            for (int i = 0; i < lista.size(); i++) {
                int estoqueAtual = lista.get(i).getQuantidadeEstoque() - lista.get(i).getQuantidade();
                dao.atualizarEstoque(estoqueAtual, lista.get(i).getId());
            }

            // Se carrinho estiver vazio retorna com alerta 
            if (valorTotal == 0) {
                lista.clear();
                sessao.removeAttribute("lista");
                request.setAttribute("MsgVazio", "O carrinho está vazio!");
                request.getRequestDispatcher("./jsp/vendas/carrinho.jsp")
                        .forward(request, response);

            }

            Object idCaixa = request.getSession().getAttribute("usuario");
            Object cpfCliente = request.getSession().getAttribute("cpf");

            venda.setQuantidade(quantidadeTotal);
            venda.setValorTotal(valorTotal);
            dao.finalizarVenda(venda, idCaixa, cpfCliente);

            lista.clear();

            sessao.removeAttribute("cpf");
            sessao.removeAttribute("lista");

            request.setAttribute("MsgSucesso", "Venda realizada com sucesso!");

            RequestDispatcher rd = request.getRequestDispatcher("./jsp/vendas/carrinho.jsp");
            rd.forward(request, response);
        }
    }


