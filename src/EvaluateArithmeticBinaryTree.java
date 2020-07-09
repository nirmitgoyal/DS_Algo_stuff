import com.company.Node;

public class EvaluateArithmeticBinaryTree {
    int EvaluateArithmeticBinaryTree(Node node){
        if (node.data=='*')
            return EvaluateArithmeticBinaryTree(node.left)*EvaluateArithmeticBinaryTree(node.right);
        else
            return node.data;
    }
}
