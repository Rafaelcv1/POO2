public class InvoiceTest {
  public static void main(String[] args) {
    Invoice teste = new Invoice("123", "descricao de teste", 3, 1.99);
    System.out.println("teste do getNumero: " + teste.getNumero());
    System.out.println("teste do getDescricao: " + teste.getDescricao());
    System.out.println("teste do getQntComprada: " + teste.getQntComprada());
    System.out.println("teste do getPreco: " + teste.getPreco());
    System.out.println("teste do getInvoiceAmout: " + teste.getInvoiceAmout());

    teste.setDescricao("segunda descricao");
    teste.setNumero("69");
    teste.setQntComprada(-1);
    teste.setPreco(-6.9);

    System.out.println("teste do getNumero: " + teste.getNumero());
    System.out.println("teste do getDescricao: " + teste.getDescricao());
    System.out.println("teste do getQntComprada: " + teste.getQntComprada());
    System.out.println("teste do getPreco: " + teste.getPreco());
    System.out.println("teste do getInvoiceAmout: " + teste.getInvoiceAmout());

  }
}
