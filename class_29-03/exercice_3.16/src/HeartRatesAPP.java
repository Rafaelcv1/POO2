import java.util.Scanner;

public class HeartRatesAPP {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Digite seu nome: ");
    String nome = sc.nextLine();
    System.out.println("Digite seu sobrenome: ");
    String sobrenome = sc.nextLine();
    System.out.println("Digite sua data de Nascimento no fomato DD MM AAAA");
    int diaDoNascimento = sc.nextInt();
    int mesDoNascimento = sc.nextInt();
    int anoDoNascimento = sc.nextInt();
    HeartRates HR = new HeartRates(nome, sobrenome, diaDoNascimento, mesDoNascimento, anoDoNascimento);

    System.out.println("Sua idade (caso ja tenha feito aniversario) e: " + HR.idade());
    System.out.println("A Frequencia Maxima saudavel e: " + HR.maxHeartFreq());
    System.out.println("A Frequencia recomendada e: " + HR.intendedHeartFreq());

    sc.close();
  }
}
