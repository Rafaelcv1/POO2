import java.util.Arrays;

/*
 * Não mexa nestas interfaces.
 * Elas estão aqui apenas como auxiliares para o seu código.
 * Você não precisa alterá-las nem reimplementá-las.
 */
interface FuncaoReal {
  double avaliar(double x);
}

/*
 * Não mexa nesta interface.
 * Ela representa uma função real de duas variáveis.
 */
interface FuncaoDuasVariaveis {
  double avaliar(double x, double y);
}

/*
 * Você não precisa mexer em nada abaixo desta linha até a classe principal.
 * Estas são classes concretas que implementam as interfaces acima e representam
 * funções matemáticas que podem ser usadas para testar os métodos numéricos.
 * Se você quiser experimentar outras funções, basta alterar a expressão
 * matemática
 * dentro do método avaliar da classe correspondente.
 */

class FuncaoCuboMenosXMenosDois implements FuncaoReal {
  @Override
  public double avaliar(double x) {
    return x * x * x - x - 2.0;
  }
}

class FuncaoQuadraticaMaisDoisXMaisUm implements FuncaoReal {
  @Override
  public double avaliar(double x) {
    return x * x + 2.0 * x + 1.0;
  }
}

class FuncaoUmSobreUmMaisXQuadrado implements FuncaoReal {
  @Override
  public double avaliar(double x) {
    return 1.0 / (1.0 + x * x);
  }
}

class FuncaoSenoMenosMeio implements FuncaoReal {
  @Override
  public double avaliar(double x) {
    return Math.sin(x) - 0.5;
  }
}

class DerivadaXMaisY implements FuncaoDuasVariaveis {
  @Override
  public double avaliar(double x, double y) {
    return x + y;
  }
}

class DerivadaYMenosXQuadrado implements FuncaoDuasVariaveis {
  @Override
  public double avaliar(double x, double y) {
    return y - x * x;
  }
}

/*
 * Programa principal.
 * Ele apenas instancia algumas funções concretas e invoca os quatro métodos
 * implementados pelo estudante, mostrando os resultados na saída padrão.
 */
public class Main {
  public static void main(String[] args) {
    FuncaoReal funcaoRaiz1 = new FuncaoCuboMenosXMenosDois();
    FuncaoReal funcaoRaiz2 = new FuncaoSenoMenosMeio();
    FuncaoReal funcaoIntegral1 = new FuncaoQuadraticaMaisDoisXMaisUm();
    FuncaoReal funcaoIntegral2 = new FuncaoUmSobreUmMaisXQuadrado();
    FuncaoDuasVariaveis funcaoEuler1 = new DerivadaXMaisY();
    FuncaoDuasVariaveis funcaoEuler2 = new DerivadaYMenosXQuadrado();
    try {
      double raiz1 = AlgoritmosNumericos.bissecao(funcaoRaiz1, 1.0, 2.0, 1.0e-8, 100);
      double raiz2 = AlgoritmosNumericos.bissecao(funcaoRaiz2, 0.0, 2.0, 1.0e-8, 100);

      System.out.println("Bisseção em f(x) = x^3 - x - 2, intervalo [1,2]: " + raiz1);
      System.out.println("Bisseção em f(x) = sen(x) - 0.5, intervalo [0,2]: " + raiz2);
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
     double[][] A = {
     { 10.0, -1.0, 2.0, 0.0 },
     { -1.0, 11.0, -1.0, 3.0 },
     { 2.0, -1.0, 10.0, -1.0 },
     { 0.0, 3.0, -1.0, 8.0 }
     };
     double[] b = { 6.0, 25.0, -11.0, 15.0 };
    
     double[] solucao = AlgoritmosNumericos.jacobiComReorganizacaoDiagonal(A, b,
     1.0e-8, 200);
     System.out.println("Solução aproximada do sistema linear por Jacobi: " +
     Arrays.toString(solucao));
    
     double integral1 = AlgoritmosNumericos.trapezios(funcaoIntegral1, 0.0, 2.0,
     1000);
     double integral2 = AlgoritmosNumericos.trapezios(funcaoIntegral2, 0.0, 1.0,
     1000);
    
     System.out.println("Integral por trapézios de x^2 + 2x + 1 em [0,2]: " +
     integral1);
     System.out.println("Integral por trapézios de 1/(1+x^2) em [0,1]: " +
     integral2);
    
     double euler1 = AlgoritmosNumericos.euler(funcaoEuler1, 0.0, 1.0, 0.1, 10);
     double euler2 = AlgoritmosNumericos.euler(funcaoEuler2, 0.0, 1.0, 0.05, 20);
    
     System.out.println("Euler para y' = x + y, com x0=0, y0=1, h=0.1, 10 passos:
     " + euler1);
     System.out.println("Euler para y' = y - x^2, com x0=0, y0=1, h=0.05, 20
     passos: " + euler2);
  }
}
