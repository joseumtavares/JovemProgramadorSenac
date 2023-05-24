package aulasjavasenac;

/*
Versão dos exercícios da Professora Marta - Por Jose Tavares Equipe Tristando, 23 de maio de 2023
https://github.com/joseumtavares
*/
import javax.swing.*;

public class CalculadoraIdadeMedia {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Idade Média");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Digite a idade de 25 alunos:");

        panel.add(label);
        frame.getContentPane().add(panel);

        int contador = 1;
        int somaIdades = 0;

        while (contador <= 5) {
            String input = javax.swing.JOptionPane.showInputDialog("Idade do aluno " + contador);
            int idade = Integer.parseInt(input);
            somaIdades += idade;

            double idadeMedia = (double) somaIdades / contador;
            javax.swing.JOptionPane.showMessageDialog(null, "Média das idades até agora: " + idadeMedia);

            contador++;
        }

        double idadeMediaFinal = (double) somaIdades / 25;
        javax.swing.JOptionPane.showMessageDialog(null, "A idade média dos 25 alunos é: " + idadeMediaFinal);

        frame.pack();
        frame.setVisible(true);
    }
}
