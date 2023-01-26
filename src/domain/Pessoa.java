package domain;

import java.time.LocalDate;

public class Pessoa {
    // 1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
    private String nome;
    private LocalDate data_nascimento;

    public Pessoa(String nome, LocalDate data_nascimento) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
