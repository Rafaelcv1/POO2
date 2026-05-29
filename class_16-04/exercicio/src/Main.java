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

  public void avaliar(Animal paciente) {

  }
}
