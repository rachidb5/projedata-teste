import domain.Funcionario;
import domain.FuncionarioLista;
import javafx.print.Collation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        FuncionarioLista lista = new FuncionarioLista();

        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.

        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador");
        Funcionario joao = new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38), "Operador");
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14), "Coordenador");
        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor");
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 01, 3), new BigDecimal(2234.68), "Recepcionista");
        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador");
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84), "Contador");
        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45), "Gerente");
        Funcionario heloisa = new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85), "Eletricista");
        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal(2799.93), "Gerente");

        lista.add(maria);
        lista.add(joao);
        lista.add(caio);
        lista.add(miguel);
        lista.add(alice);
        lista.add(heitor);
        lista.add(arthur);
        lista.add(laura);
        lista.add(heloisa);
        lista.add(helena);

        // 3.2 – Remover o funcionário “João” da lista.
        lista.remove(joao);
        /*
        * 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
                • informação de data deve ser exibido no formato dd/mm/aaaa;
•                informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
        * */
        lista.showFuncionarios();
        System.out.println("-------");


        // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        lista.raiseSalary(new BigDecimal(.10));

        // 3.5  – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Funcionario>> funcionarioPorFuncao = lista.groupByFuncao();

        //3.6  – Imprimir os funcionários, agrupados por função.
        funcionarioPorFuncao.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println("-------");

        // 3.7 – O item não está descrito, portanto, assumi que não existe e a lista pula do 3.6 para o 3.8.

        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        Stream.concat(lista.selectByMonth(10).stream(), lista.selectByMonth(12).stream())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("-------");

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println(lista.older());
        System.out.println("-------");

       //3.10 – Imprimir a lista de funcionários por ordem alfabética.
        lista.sortedList().forEach(System.out::println);
        System.out.println("-------");

        // 3.11 – Imprimir o total dos salários dos funcionários.
        System.out.println(lista.salarySum());
        System.out.println("-------");

        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        lista.salarios().forEach(System.out::println);
    }
}