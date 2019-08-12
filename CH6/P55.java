public class P55 {

    public static int getDepth(BinarySearchTree.Node node){
        return getDepth(node, 0);
    }

    private static int getDepth(BinarySearchTree.Node node, int d){
        if (node == null)   return d;
        return Math.max(getDepth(node.right, d + 1), getDepth(node.left, d + 1));
    }


    public static boolean isBalanced(BinarySearchTree.Node node){
        if (checkBalance(node) == -1)   return false;
        return true;
    }

    private static int checkBalance(BinarySearchTree.Node node){
        if (node == null)   return 0;
        int l = checkBalance(node.left), r = checkBalance(node.right);
        if (l == -1 || r == -1 || l - r > 1 || l - r < -1)  return -1;
        else                                    return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(10);
        bst.addNode(5);
        bst.addNode(7);
        bst.addNode(2);
        bst.addNode(15);
        bst.addNode(17);
        bst.addNode(12);

        bst.printTopToBottom();

        System.out.println(isBalanced(bst.root));

        System.out.println(getDepth(null));

        for (int i = 3; i >= 0; i -- )
            bst.addNode(i);

        bst.printTopToBottom();
        System.out.println(getDepth(bst.root));
        System.out.println(isBalanced(bst.root));

        bst = new BinarySearchTree();
        bst.addNode(1);
        bst.addNode(2);
        bst.addNode(3);
        System.out.println(isBalanced(bst.root));
    }

}
