import models.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllBSTsFrom1Ton {

    List<Node> GenerateAllBSTsFrom1Ton(int n) {
        List<Integer> numbers = new ArrayList<>();

        //fill from 1 to n
        int value = 1;
        for (int i = 0; i < n; i++)
            numbers.add(value++);

        return GenerateAllBSTsFrom1TonHelper(numbers);
    }

    private List<Node> GenerateAllBSTsFrom1TonHelper(List<Integer> numbers) {
        if (numbers.size() == 0)
            return new ArrayList<>();
        if (numbers.size() == 1)
            return new ArrayList<>(Arrays.asList(new Node(numbers.get(0))));

        List<Node> bsts = new ArrayList<>();
        for (int n : numbers) {
            List<Integer> lefts = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                lefts.add(numbers.get(i));

            List<Integer> rights = new ArrayList<>();
            for (int i = n + 1; i < numbers.length; i++)
                rights.add(numbers.get(i));

            List<Node> leftNodes = GenerateAllBSTsFrom1TonHelper(lefts);
            List<Node> rightNodes = GenerateAllBSTsFrom1TonHelper(rights);

            //Add in every possible way. Since they are sorted, no need to do a BST check
            for (Node leftNode : leftNodes)
                for (Node rightNode : rightNodes)
                    bsts.add(new Node(n, leftNode, rightNode));
        }

        return bsts;
    }
}
