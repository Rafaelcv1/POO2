public class Main {
  public static void main(String[] args) {
    Mamifero felix = new Gato();
    Animal pateta = new Cachorro();
    Cobra python = new Cobra();

    felix.mamar();
    ((Mamifero) pateta).mamar();
    ((Reptil) pateta).emitirSom();
    ;

    Animal animal;
    animal = felix;
    animal.emitirSom();
    animal = pateta;
    animal.emitirSom();
    animal = python;
    animal.emitirSom();
    animal = new GatoManco();
    animal.emitirSom();
  }
}

abstract class Animal {
  private String nome;

  abstract public void emitirSom();

  public final void reino() {
    System.out.println("reino animal");
  }

  void apresentar() {

  }
}

abstract class Mamifero extends Animal {
  public void mamar() {
    System.out.println("não, não me chupa, o bixo que chupa é muito chato ~DavyJones");
  }

  @Override
  public void reino() {
    System.out.println("sou um vegetal fofinho");
  }
}

abstract class Reptil extends Animal {
  public void trocaEscamas() {
  }

}

class Gato extends Mamifero {
  public void emitirSom() {
    System.out.println("MIAU");
  }
}

class GatoManco extends Gato {
  @Override
  public void emitirSom() {
    super.emitirSom();
    System.out.println("toc");
  }
}

class Cachorro extends Mamifero {
  public void emitirSom() {
    System.out.println("AUAU");
  }
}

class Cobra extends Reptil {
  public void emitirSom() {
    System.out.println("sss");
  }
}

class Veterinario {
  Animal paciente;

  private void avaliarGato(Gato paciente) {
    System.out.println("gato avaliado");
  }

  private void avaliarCachorro(Cachorro paciente) {
    System.out.println("Cachorro avaliado");
  }

  private void avaliarCobra(Cobra paciente) {
    System.out.println("Cobra avaliada");
  }

  public void avaliar(Animal paciente) {
    if (paciente instanceof Gato)
      avaliarGato((Gato) paciente);
    else if (paciente instanceof Cachorro)
      avaliarCachorro((Cachorro) paciente);
    else if (paciente instanceof Cobra)
      avaliarCobra((Cobra) paciente);
    else
      System.out.println("nao conheco esse animal");
  }
}
