import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class WordSearch {

  //  static Map<String, Boolean> visited = new HashMap<>(); //no need 
  static int rows, cols;

  public static List<Index> find(char[][] m, String word) {
    rows = m.length;
    cols = m[0].length;
    List<Index> ans = new ArrayList<>();

    int startIndex = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if ((m[r][c] == word.charAt(startIndex))) {
          search(m, word, startIndex, new Index(r, c), ans);
        }
      }
    }

    return ans;
  }

  private static void search(char[][] m, String word, int index, Index mIndex, List<Index> ans) {
    int r = mIndex.getRow();
    int c = mIndex.getCol();

    ans.add(new Index(r, c));

    if (ans.size() == word.length()) {
      return;
    }

    for (Index neighbour : getNeighbours(m, word, index + 1, mIndex)) {
      search(m, word, index + 1, neighbour, ans);
    }

    if (ans.size() != word.length()) {
      ans.remove(ans.size() - 1);
    }
  }

  private static List<Index> getNeighbours(char[][] m, String word, int index, Index mIndex) {
    int r = mIndex.getRow();
    int c = mIndex.getCol();

    List<Index> neighbours = new ArrayList<>();

    int newC = c + 1;
    int newR = r + 1;
    if (isSafe(newC, cols) && isSafe(index, word.length())//right
        && m[r][newC] == word.charAt(index)) {
      neighbours.add(new Index(r, newC));
    }
    if (isSafe(newR, rows) && isSafe(index, word.length())//down
        && m[newR][c] == word.charAt(index)) {
      neighbours.add(new Index(newR, c));
    }

    return neighbours;
  }

  public static boolean isSafe(int index, int n) {
    return index >= 0 && index < n;
  }

  public static void main(String[] args) {
    char[][] grid1 = {
//        0    1    2    3    4    5
        {'c', 'c', 'x', 't', 'i', 'b'},//0
        {'c', 'c', 'a', 't', 'n', 'i'},//1
        {'a', 'c', 'n', 'n', 't', 't'},//2
        {'t', 'c', 's', 'i', 'p', 't'},//3
        {'a', 'o', 'o', 'o', 'a', 'a'},//4
        {'o', 'a', 'a', 'a', 'o', 'o'},//5
        {'k', 'a', 'i', 'c', 'k', 'i'} //6
    };
    String word1 = "catnip";
    String word2 = "cccc";
    String word3 = "s";
    String word4 = "bit";
    String word5 = "aoi";
    String word6 = "ki";
    String word7 = "aaa";
    String word8 = "ooo";

    char[][] grid2 = {{'a'}};
    String word9 = "a";

    System.out.println(find(grid1, word1));
    System.out.println();

    System.out.println(find(grid1, word2));
    System.out.println();

    System.out.println(find(grid1, word3));
    System.out.println();

    System.out.println(find(grid1, word4));
    System.out.println();

    System.out.println(find(grid1, word5));
    System.out.println();

    System.out.println(find(grid1, word6));
    System.out.println();

    System.out.println(find(grid1, word7));
    System.out.println();

    System.out.println(find(grid1, word8));
    System.out.println();

    System.out.println(find(grid2, word9));
    System.out.println();
  }
//  Correct:
//find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
//find_word_location(grid1, word2) =>
//       [(0, 1), (1, 1), (2, 1), (3, 1)]
//    OR [(0, 0), (1, 0), (1, 1), (2, 1)]
//    OR [(0, 0), (0, 1), (1, 1), (2, 1)]
//    OR [(1, 0), (1, 1), (2, 1), (3, 1)]
//find_word_location(grid1, word3) => [(3, 2)]
//find_word_location(grid1, word4) => [(0, 5), (1, 5), (2, 5)]
//find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
//find_word_location(grid1, word6) => [(6, 4), (6, 5)]
//find_word_location(grid1, word7) => [(5, 1), (5, 2), (5, 3)]
//find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
//find_word_location(grid2, word9) => [(0, 0)]
/*
      [Index(row=1, col=1), Index(row=1, col=2), Index(row=1, col=3), Index(row=2, col=3), Index(row=3, col=3), Index(row=3, col=4)]

      [Index(row=0, col=0), Index(row=0, col=1), Index(row=1, col=1), Index(row=2, col=1)]

      [Index(row=3, col=2)]

      [Index(row=0, col=5), Index(row=1, col=5), Index(row=2, col=5)]

      [Index(row=4, col=5), Index(row=5, col=5), Index(row=6, col=5)]

      [Index(row=6, col=4), Index(row=6, col=5)]

      [Index(row=5, col=1), Index(row=5, col=2), Index(row=5, col=3)]

      [Index(row=4, col=1), Index(row=4, col=2), Index(row=4, col=3)]

      [Index(row=0, col=0)]
      */

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  static class Index {

    int row, col;
  }

}

