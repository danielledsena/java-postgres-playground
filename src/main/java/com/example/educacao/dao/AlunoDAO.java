package com.example.educacao.dao;
import com.example.dao.DAO;
import com.example.educacao.model.Aluno;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class AlunoDAO extends DAO {
    public AlunoDAO(Connection conn) {
        super(conn);
    }

    public void inserir(Aluno aluno) {
        try {
            var sql = "insert into aluno (nome) values (?)";
            var statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, aluno.getNome());
            statement.executeUpdate();
            var result = statement.getGeneratedKeys();
            if (result.next()) {
                aluno.setMatricula(result.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível inserir o aluno no BD.", e);
        }
    }

    public void inserirNota(int idDisciplina, double nota, int matricula){
        if (idDisciplina <= 0 || idDisciplina > 3)
            throw new IllegalArgumentException("O id da disciplina deve estar entre 1 e 3");

        try {
            var sql = "update aluno set nota" + idDisciplina + " = ? where matricula = ?";
            var statement = conn.prepareStatement(sql);
            statement.setDouble(1, nota);
            statement.setInt(2, matricula);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível inserir a nota no BD.", e);
        }
    }
}