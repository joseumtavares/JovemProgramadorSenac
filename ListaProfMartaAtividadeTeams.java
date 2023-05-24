package aulasjavasenac;

/*
 *  Exercícios da Aula do dia 22_05_2023 da Professora Marta,
 *  Por Jose Tavares Equipe Tristando, Prazo entrega 24 de maio de 2023
 *  https://github.com/joseumtavares
*/

/*  Questão 1: Desenvolva um programa que, a partir do salário de Mariana,
 *  possa determinar em quantos meses o dinheiro de Pedro será igual ou 
 *  maior que o dela. Sabe-se que Pedro ganha um terço do salário de 
 *  Mariana atualmente. Mariana investe todo o seu salário em um fundo 
 *  que rende 2% ao mês, enquanto Pedro investe todo o seu salário em um 
 *  fundo que rende 5% ao mês. Seu programa deve mostrar a quantidade 
 *  de meses necessários para que o dinheiro de Pedro seja igual ou 
 *  ultrapasse o valor de Mariana.
 */

/*  Questão 2: Desenvolva um programa para a empresa XXX que leia o código,
 *  o sexo (M/F) e o número de horas trabalhadas dos funcionários. Sabe-se
 *  que o valor da hora trabalhada é R$30,00. O programa deve apresentar 
 *  uma lista com o código, o salário bruto e o salário líquido de todos 
 *  os funcionários, considerando que homens têm um desconto de 10% e
 *  mulheres têm um desconto de 5% em seus respectivos salários. Além 
 *  disso, o programa deve mostrar a média dos salários líquidos dos 
 *  funcionários separadamente por sexo. (Atenção: O código para parar 
 *  a leitura dos funcionários é 9999)*/


import java.util.Scanner;

public class ListaProfMartaAtividadeTeams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("-------------------------------------------");
            System.out.println("|         Empresa Turistando SC           |");
            System.out.println("================== MENU ===================");
            System.out.println("|    Selecione a opção desejada:          |");
            System.out.println("| 1. Comparação de Rendimentos:           |");
            System.out.println("| 2. Cálculo de Salário dos Funcionários  |");
            System.out.println("| 3. Sair                                 |");
            System.out.println("-------------------------------------------");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    compararRendimentos(scanner);
                    break;
                case 2:
                    calcularSalariosFuncionarios(scanner);
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
        } while (opcao != 3);

        scanner.close();
    }

    public static void compararRendimentos(Scanner scanner) {
        System.out.println("==== Empresa Turistando SC ====");
        System.out.println("-------------------------------");
        System.out.println("| Bem-vindo(a) ao programa que |");
        System.out.println("|  calcula os rendimentos de   |");
        System.out.println("|  aplicações financeiras de   |");
        System.out.println("|      dois funcionários.      |");
        System.out.println("-------------------------------");

        System.out.print("Informe o salário de Mariana: R$ ");
        double salarioMariana = scanner.nextDouble();
        System.out.println("-------------------------------");

        double salarioPedro = salarioMariana / 3;
        double rendimentoMariana = 0.02;
        double rendimentoPedro = 0.05;

        int meses = 0;

        while (salarioPedro < salarioMariana) {
            salarioMariana += salarioMariana * rendimentoMariana;
            salarioPedro += salarioPedro * rendimentoPedro;
            meses++;
        }

        System.out.println("Pedro precisará de " + meses + " meses para ter um valor igual ou maior que Mariana.");
    }


    public static void calcularSalariosFuncionarios(Scanner scanner) {
        int codigo;
        String nome;
        char sexo;
        int horasTrabalhadas;
        double valorHora = 30.0;
        double salarioBruto;
        double salarioLiquido;
        double totalSalarioHomens = 0.0;
        double totalSalarioMulheres = 0.0;
        int numHomens = 0;
        int numMulheres = 0;

        System.out.println("======= Empresa Turistando SC =======");
        System.out.println("-------------------------------------");
        System.out.println("|   Bem-vindo(a) ao programa que     |");
        System.out.println("|   calcula o salário líquido dos    |");
        System.out.println("|   funcionários e exibe a média     |");
        System.out.println("|  dos salários separada por sexo  . |");
        System.out.println("-------------------------------------");

        System.out.println("Informe os dados dos funcionários:");
        System.out.println("Informe o codigo do primeiro funcionario:");

        System.out.println("-------------------------------------");

        while (true) {
            System.out.println("Os Códigos começam do 1 e vão até 9998,");
            System.out.println("se quiser sair do programa digite 9999:");

            codigo = scanner.nextInt();

            if (codigo == 9999) {
                break;
            }

            System.out.print("Nome: ");
            scanner.nextLine(); // Limpar o buffer do teclado
            nome = scanner.nextLine();
            System.out.println("-------------------------------------");

            System.out.print("Sexo (M/F): ");
            sexo = scanner.next().charAt(0);
            System.out.println("-------------------------------------");

            System.out.print("Horas trabalhadas: ");
            horasTrabalhadas = scanner.nextInt();
            System.out.println("-------------------------------------");

            salarioBruto = horasTrabalhadas * valorHora;

            switch (sexo) {
                case 'M':
                    salarioLiquido = salarioBruto - (salarioBruto * 0.10);
                    totalSalarioHomens += salarioLiquido;
                    numHomens++;
                    break;
                case 'F':
                    salarioLiquido = salarioBruto - (salarioBruto * 0.05);
                    totalSalarioMulheres += salarioLiquido;
                    numMulheres++;
                    break;
                default:
                    System.out.println("Sexo inválido. O funcionário será desconsiderado.");
                    continue; // Pula para a próxima iteração do loop
            }

            System.out.println("=== Dados do Funcionário ===");
            System.out.println("|Código: " + codigo + "|");
            System.out.println("|Salário Bruto: R$" + salarioBruto + "|");
            System.out.println("|Salário Líquido: R$" + salarioLiquido + "|");
            System.out.println("============================");
        }

        System.out.println("=== Média dos Salários Líquidos ===");
        System.out.println("-------------------------------------");

        if (numHomens > 0) {
            double mediaSalarioHomens = totalSalarioHomens / numHomens;
            System.out.println("Média dos salários dos homens: R$" + mediaSalarioHomens);
            System.out.println("-------------------------------------");

        } else {
            System.out.println("Não há funcionários do sexo masculino.");
            System.out.println("-------------------------------------");

        }

        if (numMulheres > 0) {
            double mediaSalarioMulheres = totalSalarioMulheres / numMulheres;
            System.out.println("Média dos salários das mulheres: R$" + mediaSalarioMulheres);
            System.out.println("-------------------------------------");

        } else {
            System.out.println("Não há funcionárias do sexo feminino.");
        }
    }
}
