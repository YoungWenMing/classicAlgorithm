import java.util.Stack;

public class P54 {

    static int rep = 0;

    public static BinarySearchTree.Node findNthNode(BinarySearchTree.Node node, int k){
        if (node == null)   return null;
        if (k <=0)          return null;
        rep = k;
        return findNthNode(node);
    }

    private static BinarySearchTree.Node findNthNode(BinarySearchTree.Node node){
        if (node == null)   return null;
        BinarySearchTree.Node n = findNthNode(node.left);
        if (rep == 1)   {
            rep = 0;
            return node;
        }else if (rep == 0){
            return n;
        }else {
            rep --;
            return findNthNode(node.right);
        }
    }

    public static BinarySearchTree.Node findNthNodeV(BinarySearchTree.Node node, int k){
        if (node == null || k <=0)  return null;
        Stack<BinarySearchTree.Node> stack = new Stack<>();
        BinarySearchTree.Node n = node;
        do{
            while (n != null){
                stack.push(n);
                n = n.left;
            }
            n = stack.pop();
            k --;
            if (k == 0) return n;
            n = n.right;
        }while (!stack.empty());
        return null;
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

        System.out.println(findNthNode(bst.root, 3).value);
        System.out.println(findNthNode(bst.root, 8));
        System.out.println("iterative method: " + findNthNodeV(bst.root, 8));



        bst = new BinarySearchTree();
        bst.addNode(20);
        bst.addNode(15);
        bst.addNode(10);
        bst.addNode(5);

        bst.printTopToBottom();
        System.out.println(findNthNode(bst.root, 3).value);
        System.out.println(findNthNodeV(bst.root, 3).value);
    }
}

