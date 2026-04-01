import java.util.List;
import java.util.ArrayList;

public class QueenValidMovement {

  static public List<IntegerPair> movimentosPossiveisRainha(int x, int y) {
    List<IntegerPair> movimentosValidos = new ArrayList<IntegerPair>();
    for (int j = x + 1; j < 8; j++) {
      movimentosValidos.add(new IntegerPair(j, y));
    }
    for (int j = x - 1; j > -1; j--) {
      movimentosValidos.add(new IntegerPair(j, y));
    }
    for (int i = y + 1; i < 8; i++) {
      movimentosValidos.add(new IntegerPair(x, i));
    }
    for (int i = y - 1; i > -1; i--) {
      movimentosValidos.add(new IntegerPair(x, i));
    }
    for (int i = y + 1, j = x + 1; j < 8 && i < 8; i++, j++) {
      movimentosValidos.add(new IntegerPair(j, i));
    }
    for (int i = y - 1, j = x + 1; j < 8 && i > -1; i--, j++) {
      movimentosValidos.add(new IntegerPair(j, i));
    }
    for (int i = y + 1, j = x - 1; j > -1 && i < 8; i++, j--) {
      movimentosValidos.add(new IntegerPair(j, i));
    }
    for (int i = y - 1, j = x - 1; j > -1 && i > -1; i--, j--) {
      movimentosValidos.add(new IntegerPair(j, i));
    }
    return movimentosValidos;
  }
}
