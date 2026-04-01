public class HeartRates {

  private String nome;
  private String sobrenome;
  private int diaDoNascimento;
  private int mesDoNascimento;
  private int anoDoNascimento;

  public HeartRates(String nome, String sobrenome, int diaDoNascimento, int mesDoNascimento, int anoDoNascimento) {
    setNome(nome);
    setSobrenome(sobrenome);
    setDiaDoNascimento(diaDoNascimento);
    setMesDoNascimento(mesDoNascimento);
    setAnoDoNascimento(anoDoNascimento);
  }

  public int idade() {
    return 2026 - anoDoNascimento;
  }

  public int maxHeartFreq() {
    return 220 - idade();
  }

  public double intendedHeartFreq() {
    return maxHeartFreq() * 0.5;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public int getDiaDoNascimento() {
    return diaDoNascimento;
  }

  public void setDiaDoNascimento(int diaDoNascimento) {
    this.diaDoNascimento = diaDoNascimento;
  }

  public int getMesDoNascimento() {
    return mesDoNascimento;
  }

  public void setMesDoNascimento(int mesDoNascimento) {
    this.mesDoNascimento = mesDoNascimento;
  }

  public int getAnoDoNascimento() {
    return anoDoNascimento;
  }

  public void setAnoDoNascimento(int anoDoNascimento) {
    this.anoDoNascimento = anoDoNascimento;
  }

}
