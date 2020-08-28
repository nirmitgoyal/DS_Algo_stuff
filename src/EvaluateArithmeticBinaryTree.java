import models.Node;

public class EvaluateArithmeticBinaryTree {
    int EvaluateArithmeticBinaryTree(Node node) {
        if (node.data == '*')
            return EvaluateArithmeticBinaryTree(node.L) * EvaluateArithmeticBinaryTree(node.R);
        else
            return node.data;
    }
}
