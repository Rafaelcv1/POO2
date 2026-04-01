public class estimarEuler {

  public static double estimarConstanteE(int numeroDeTermos) throws IllegalArgumentException {
    if (numeroDeTermos < 0)
      throw new IllegalArgumentException();

    double e = 0;
    double fat = 1.0;
    for (int i = 0; i <= numeroDeTermos; i++) {
      e += 1.0 / fat;
      fat *= i + 1.0;
    }
    return e;
  }
}
