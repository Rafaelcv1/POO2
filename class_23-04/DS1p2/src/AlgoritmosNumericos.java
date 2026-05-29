class AlgoritmosNumericos {
  public static double bissecao(FuncaoReal f, double a, double b, double tolerancia, int maxIteracoes)
      throws IllegalArgumentException {
    if (f == null)
      throw new IllegalArgumentException();
    if (a == b)
      throw new IllegalArgumentException();
    if (tolerancia < 0)
      throw new IllegalArgumentException();
    if (maxIteracoes < 0)
      throw new IllegalArgumentException();

    double fa = f.avaliar(a);
    double fb = f.avaliar(b);

    if ((fa > 0 && fb > 0) || (fa < 0 && fb < 0))
      throw new IllegalArgumentException();

    if (fa == fb)
      throw new IllegalArgumentException();

    for (int i = 1; i <= maxIteracoes; i++) {
      double meio = (a + b) / 2;
      double fm = f.avaliar(meio);
      if (Math.abs(fm) < tolerancia)
        return meio;
      if (fa * fm < 0) {
        b = meio;
        fb = fm;
      } else {
        a = meio;
        fa = fm;
      }
    }
    return (a + b) / 2;
  }

  public static double[] jacobiComReorganizacaoDiagonal(double[][] A, double[] b, double tolerancia, int maxIteracoes)
      throws IllegalArgumentException {
    if (A == null)
      throw new IllegalArgumentException();
    if (b == null)
      throw new IllegalArgumentException();

    int n = A.length;
    for (int i = 0; i < n; i++) {
      if (A[i].length != n)
        throw new IllegalArgumentException();
      if (n != b.length || A[i].length != b.length)
        throw new IllegalArgumentException();
    }

    if (tolerancia < 0)
      throw new IllegalArgumentException();
    if (maxIteracoes < 0)
      throw new IllegalArgumentException();

    for (int i = 0; i < n; i++) {
      int maxLinha = i;
      for (int k = i + 1; k < n; k++) {
        if (Math.abs(A[k][i]) > Math.abs(A[maxLinha][i])) {
          maxLinha = k;
        }
      }
      double[] tmpRow = A[i];
      A[i] = A[maxLinha];
      A[maxLinha] = tmpRow;
      double tmpB = b[i];
      b[i] = b[maxLinha];
      b[maxLinha] = tmpB;
    }

    for (int i = 0; i < n; i++) {
      if (A[i][i] == 0)
        throw new IllegalArgumentException();
    }

    double[] xAtual = new double[n];
    double[] xNovo = new double[n];

    for (int iter = 1; iter <= maxIteracoes; iter++) {
      for (int i = 0; i < n; i++) {
        double soma = 0;
        for (int j = 0; j < n; j++) {
          if (j != i) {
            soma += A[i][j] * xAtual[j];
          }
        }
        xNovo[i] = (b[i] - soma) / A[i][i];
      }

      double erro = 0;
      for (int i = 0; i < n; i++) {
        erro = Math.max(erro, Math.abs(xNovo[i] - xAtual[i]));
        xAtual[i] = xNovo[i];
      }

      if (erro < tolerancia)
        return xAtual;
    }

    return xAtual;
  }

  public static double trapezios(FuncaoReal g, double limiteInferior, double limiteSuperior,
      int numeroDeSubintervalos) {
    if (g == null)
      throw new IllegalArgumentException();
    if (limiteInferior >= limiteSuperior)
      throw new IllegalArgumentException();
    if (numeroDeSubintervalos <= 0)
      throw new IllegalArgumentException();

    double h = (limiteSuperior - limiteInferior) / numeroDeSubintervalos;
    double soma = g.avaliar(limiteInferior) + g.avaliar(limiteSuperior);

    for (int i = 1; i < numeroDeSubintervalos; i++) {
      double x = limiteInferior + i * h;
      soma += 2 * g.avaliar(x);
    }

    return (h / 2) * soma;
  }

  public static double euler(FuncaoDuasVariaveis f, double xInicial, double yInicial, double passo,
    if (f == null)
      throw new IllegalArgumentException();
    if (passo <= 0)
      throw new IllegalArgumentException();
    if (numeroDePassos < 0)
      throw new IllegalArgumentException();

    double x = xInicial;
    double y = yInicial;

    for (int k = 1; k <= numeroDePassos; k++) {
      double derivada = f.avaliar(x, y);
      y = y + passo * derivada;
      x = x + passo;
    }

    return y;
  }
}
