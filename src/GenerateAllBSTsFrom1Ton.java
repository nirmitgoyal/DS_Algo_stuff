import models.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateAllBSTsFrom1Ton {

    List<Node> generateAllBSTsFrom1ToN(int n) {
        return generateAllBSTsFrom1ToNHelper(IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList()));//fill from 1 to n
    }

    private List<Node> generateAllBSTsFrom1ToNHelper(List<Integer> numbers) {
        if (numbers.size() == 0)
            return new ArrayList<>();
        if (numbers.size() == 1)
            return new ArrayList<>(Arrays.asList(new Node(numbers.get(0))));

        List<Node> bsts = new ArrayList<>();

        for (int n : numbers) {
            List<Integer> lefts = new ArrayList<>();
            List<Integer> rights = new ArrayList<>();

            for (int i = 0; i <= n; i++)
                lefts.add(numbers.get(i));
            for (int i = n + 1; i < numbers.size(); i++)
                rights.add(numbers.get(i));

            List<Node> leftNodes = generateAllBSTsFrom1ToNHelper(lefts);
            List<Node> rightNodes = generateAllBSTsFrom1ToNHelper(rights);

            //Add in every possible way. Since they are sorted, no need to do a BST check
            for (Node leftNode : leftNodes)
                for (Node rightNode : rightNodes)
                    bsts.add(new Node(n, leftNode, rightNode));
        }

        return bsts;
    }
}
