import models.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateAllBSTsFrom1Ton {
    void GenerateAllBSTsFrom1Ton(int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        //fill from 1 to n;

        GenerateAllBSTsFrom1TonHelper(numbers);
    }

    private ArrayList<Node> GenerateAllBSTsFrom1TonHelper(ArrayList<Integer> numbers) {
        if (numbers.length == 0)
            return null;
        if (numbers.length == 1)
            return new ArrayList<>(Arrays.asList(new Node(numbers.get(0))));

        ArrayList<Node> bsts = new ArrayList<>();
        for (int n : numbers) {
            ArrayList<Integer> lefts = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                lefts.add(numbers.get(i));
            ArrayList<Integer> rights = new ArrayList<>();
            for (int i = n + 1; i < numbers.length; i++)
                rights.add(numbers.get(i));
            ArrayList<Node> leftNodes = GenerateAllBSTsFrom1TonHelper(lefts);
            ArrayList<Node> rightNodes = GenerateAllBSTsFrom1TonHelper(rights);

            //add in every possible way. Since they are sorted, no need to do a BST check
            for (Node leftNode : leftNodes) {
                for (Node rightNode : rightNodes) {
                    bsts.add(new Node(n, leftNode, rightNode));
                }
            }
        }

        return bsts;
    }
}
