import models.Node;

public class MaxGain {
    public static int max = 0; //taking no node incase of all -ve //result is also stored here

    int maxGain(Node node) {
        if (node == null)
            return 0;

        int maxGainFromLeft = maxGain(node.L);
        int maxGainFromRight = maxGain(node.R);

        max = Math.max(max, (maxGainFromLeft + maxGainFromRight + node.data)); //maintain the maximum sum during the execution

        return (Math.max(maxGainFromLeft, maxGainFromRight) + node.data);
    }
}
