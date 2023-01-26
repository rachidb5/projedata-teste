package domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class FuncionarioLista {
    private List<Funcionario> lista = new ArrayList<Funcionario>();

    public void add(Funcionario f){
        this.lista.add(f);
    }

    public void remove(Funcionario f){
        this.lista.remove(f);
    }

    public void showFuncionarios(){
        this.lista.forEach(System.out::println);
    }

    public void raiseSalary(BigDecimal raise){
        for (int i = 0; i < lista.size(); i++){
            lista.get(i).raiseSalary(raise);
        }
    }

    public List<Funcionario> selectByMonth(int month){
        List<Funcionario> selected = new ArrayList<Funcionario>();
        for (int i = 0; i < lista.size(); i++){
            if(lista.get(i).getData_nascimento().getMonthValue() == month){
                selected.add(lista.get(i));
            }
        }
        return selected;
    }
    public  List<Funcionario> sortedList(){
        List<Funcionario> sorted = this.lista;
        Collections.sort(sorted);
        return sorted;
    }
    public String older(){
        int olderAge = 0;
        String nome = "";
        for (int i = 0; i < this.lista.size(); i++){
            if(Period.between(this.lista.get(i).getData_nascimento(), LocalDate.now()).getYears() > olderAge) {
                olderAge = Period.between(this.lista.get(i).getData_nascimento(), LocalDate.now()).getYears();
                nome = this.lista.get(i).getNome();
            }
        }
        return "Maior idade: "+nome+", " + String.valueOf(olderAge)+" Anos";
    }

    public String salarySum(){
        BigDecimal sum = new BigDecimal(0.00);
        DecimalFormat df = new DecimalFormat("###,###,###,###,###.00");
        for (int i = 0; i < this.lista.size(); i++){
            sum = sum.add(this.lista.get(i).getSalario());
        }
        return "Soma dos salarios: R$ "+df.format(sum.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }
    public List<String> salarios(){
        List<String> salariosList = new ArrayList<>();
        for (int i = 0; i < this.lista.size(); i++){
            salariosList.add(this.lista.get(i).qtdSalarios());
        }
        return salariosList;
    }

    public Map<String, List<Funcionario>> groupByFuncao(){
        final Map<String, List<Funcionario>> funcionarioPorFuncao = lista.stream().collect(groupingBy(Funcionario::getFuncao));
        return funcionarioPorFuncao;
    }
}
