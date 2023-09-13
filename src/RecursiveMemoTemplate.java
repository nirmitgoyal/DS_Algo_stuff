public class RecursiveMemoTemplate {

  function helper(node, the parent is robbed or not?) {
    tackle basic case...

    if the parent is robbed:
    we can not rob this node.
      return helper(node.left, False) + helper(node.right, False)

    if the parent is not robbed:
    two choices: rob this node or not?
       calculate `rob` and `not_rob`...

    return max(rob, not_rob)
  }
}
