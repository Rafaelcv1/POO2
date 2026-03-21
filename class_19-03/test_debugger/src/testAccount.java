import java.util.Scanner;

public class testAccount {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    try {
      Account conta = new Account(sc.nextLine());
      System.out.println(conta.getName());
    } catch (Exception e) {
      System.out.println("deu pau");
    }
    sc.close();
  }
}
