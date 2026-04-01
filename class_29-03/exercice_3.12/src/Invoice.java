public class Invoice {

  private String numero;
  private String descricao;
  private int qntComprada;
  private double preco;

  public Invoice(String numero, String descricao, int qntComprada, double preco) {
    setNumero(numero);
    setDescricao(descricao);
    setQntComprada(qntComprada);
    setPreco(preco);
  }

  public double getInvoiceAmout() {
    return preco * qntComprada;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public int getQntComprada() {
    return qntComprada;
  }

  public void setQntComprada(int qntComprada) {
    this.qntComprada = qntComprada > 0 ? qntComprada : 0;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco > 0 ? preco : 0.0;
  }

}
