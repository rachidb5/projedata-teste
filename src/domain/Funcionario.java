package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Funcionario extends Pessoa  implements Comparable<Funcionario> {
    // 2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate data_nascimento, BigDecimal salario, String funcao) {
        super(nome, data_nascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void raiseSalary(BigDecimal raise) {
        this.salario = this.salario.add(this.salario.multiply(raise));
    }

    public String qtdSalarios(){
        BigDecimal salario = new BigDecimal(1212.00);
        BigDecimal qtd = getSalario().divide(salario, 2, RoundingMode.HALF_UP);
        return getNome()+" recebe "+String.valueOf(qtd)+" salarios";
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###,###,###,###,###.00");
        return
                "{ nome = " + getNome()  +
                ", data de nascimento = " + getData_nascimento().getDayOfMonth() + "/" + getData_nascimento().getMonthValue() + "/" + getData_nascimento().getYear()  +
                ", salario = " + df.format(getSalario().setScale(2, BigDecimal.ROUND_HALF_EVEN)) +
                ", Função = " + getFuncao()+" }";
    }

    @Override
    public int compareTo(Funcionario f) {
        return this.getNome().compareTo(f.getNome());
    }
}
