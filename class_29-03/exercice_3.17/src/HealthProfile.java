public class HealthProfile {
  private String nome;
  private String sobrenome;
  private Character sexo;
  private int diaDeNascimento;
  private int mesDeNascimento;
  private int anoDeNascimento;
  private double altura;
  private double peso;

  public HealthProfile(String nome, String sobrenome, Character sexo, int diaDeNascimento, int mesDeNascimento,
      int anoDeNascimento, double altura, double peso) {
    setNome(nome);
    setSobrenome(sobrenome);
    setSexo(sexo);
    setDiaDeNascimento(diaDeNascimento);
    setMesDeNascimento(mesDeNascimento);
    setAnoDeNascimento(anoDeNascimento);
    setAltura(altura);
    setPeso(peso);
  }

  public int idade() {
    return 2026 - anoDeNascimento;
  }

  public double maxFreq() {
    return 220 - idade();
  }

  public double freqAlvo() {
    return maxFreq() * 0.5;
  }

  public double IMC() {
    return peso / Math.pow(altura, 2);
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

  public Character getSexo() {
    return sexo;
  }

  public void setSexo(Character sexo) {
    this.sexo = sexo;
  }

  public int getDiaDeNascimento() {
    return diaDeNascimento;
  }

  public void setDiaDeNascimento(int diaDeNascimento) {
    this.diaDeNascimento = diaDeNascimento;
  }

  public int getMesDeNascimento() {
    return mesDeNascimento;
  }

  public void setMesDeNascimento(int mesDeNascimento) {
    this.mesDeNascimento = mesDeNascimento;
  }

  public int getAnoDeNascimento() {
    return anoDeNascimento;
  }

  public void setAnoDeNascimento(int anoDeNascimento) {
    this.anoDeNascimento = anoDeNascimento;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }
}
