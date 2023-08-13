package com.example.educacao.model;

public class Aluno {
    private Integer matricula;
    private String nome;
    /**
     * Nota da disciplina 1
     */
    private double nota1; 
    /**
     * Nota da disciplina 2
     */
    private double nota2; 
    /**
     * Nota da disciplina 3
     */
    private double nota3;

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        if(nota1 < 0 || nota1 > 10)
            throw new IllegalArgumentException("A nota não pode ser negativa.");
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        if(nota2 < 0 || nota2 > 10)
            throw new IllegalArgumentException("A nota não pode ser negativa.");
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        if(nota3 < 0 || nota3 > 10)
            throw new IllegalArgumentException("A nota não pode ser negativa.");
        this.nota3 = nota3;
    }

    public double CalculaMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }
}
