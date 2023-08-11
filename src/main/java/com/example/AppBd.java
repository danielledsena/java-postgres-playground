package com.example;
import java.sql.SQLException;

import com.example.dao.ConnectionManager;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.dao.DAO;
import com.example.model.Marca;
import com.example.model.Produto;


public class AppBd {
    public static void main(String[] args){
        new AppBd();
    }

    public AppBd() {
        try (var conn = ConnectionManager.getConnection()) {
            var estadoDAO = new EstadoDAO(conn);
            estadoDAO.listar();
            estadoDAO.localizar("CE");

            var marca = new Marca();
            marca.setId(2L);

            var produto = new Produto();
            produto.setId(206L);
            produto.setMarca(marca);
            produto.setValor(321);
            produto.setNome("Produto atualizado 2");

            var produtoDAO = new ProdutoDAO(conn);
            //produtoDAO.inserir(conn, produto);
            produtoDAO.atualizar(produto);
            produtoDAO.excluir(202L);

            var dao = new DAO(conn);
            dao.listar("produto");
        } catch(SQLException e) {
            System.err.println("Não foi possível se conectar ao banco de dados: " + e.getMessage()); 
        } 
    }
}