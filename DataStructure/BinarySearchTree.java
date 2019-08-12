import java.io.*;
import java.util.*;

public class BinarySearchTree {

    public Node root;

    static class Node{
        int value;
        Node left, right;

        public Node(int value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    public BinarySearchTree(){}

    /**
     * add an new node to the original tree
     * @param value
     */
    public void addNode(int value){
        root = addNode(root, value);
    }

    private Node addNode(Node node, int value){
        if (node == null)
            return new Node(value, null, null);
        else if (node.value == value)
            return node;
        else if (node.value > value)
            node.left = addNode(node.left, value);
        else
            node.right = addNode(node.right, value);
        return node;
    }


    public Node getRoot(){
        return root;
    }


    public Node FindNthNode(int n){

        return FindNthNode(root, new int[]{n});
    }

    private Node FindNthNode(Node node, int[] n){
        if (node == null || n[0] == 0) return node;
        Node target = FindNthNode(node.left, n);
        if (target == null){
            n[0] --;
            if (n[0] == 0)     return node;
            else            return FindNthNode(node.right, n);
        }
        return target;
    }

    public int getMaxDepth(){
        int maxD[] = new int[]{0};
        getMaxDepth(maxD, 0, root);
        return maxD[0];
    }

    private void getMaxDepth(int[] maxD, int d, Node n){
        if (n == null)  return;
        d ++;
        if (d > maxD[0])    maxD[0] = d;
        getMaxDepth(maxD, d, n.right);
        getMaxDepth(maxD, d, n.left);

    }

    public int getMaxDepthV2(Node node){
        if (node == null)       return 0;
        int left = getMaxDepthV2(node.left),
                right = getMaxDepthV2(node.right);
        return left > right? left + 1: right + 1;

    }

    public boolean isBalancedTree(){
        if (isBalancedTree(root) != -1)
            return true;
        return false;
    }

    private int isBalancedTree(Node n){
        if (n == null)  return 0;
        int l = isBalancedTree(n.left),
                m = isBalancedTree(n.right);
        if (l == -1 || m == -1 || l - m > 1 || m - l > 1)
            return -1;
        return m > l? m + 1: l + 1;
    }



    public static void printMid(Node n){
        if (n == null)
            return;
        printMid(n.left);
        System.out.print(" " + n.value + " ");
        printMid(n.right);
    }

    public static void printFront(Node n){
        if (n == null)
            return;
        System.out.print(n.value + "  ");
        printFront(n.left);
        printFront(n.right);
    }

    public static void printFrontIterative(Node n){
        if (n == null)  return;
        Stack<Node> stack = new Stack<>();
        stack.push(n);
        Node p;

        while (!stack.empty()){
            p = stack.pop();
            System.out.println(p.value + " ");
            if (p.right != null)    stack.push(p.right);
            if (p.left != null)     stack.push(p.left);
        }
    }

    public static void printMidIterative(Node n){
        if (n == null)  return;
        Stack<Node> stack = new Stack<>();
        Node p = n;

        do{
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            if (!stack.empty()){
                p = stack.pop();
                System.out.print(p.value + " ");
                p = p.right;
            }
        }while (! stack.empty() || p != null);
    }


    public static void printBackIterative(Node n){
        if (n == null)  return;
        Node t = n, p = null;
        Stack<Node> stack = new Stack<>();
        do {
            while (t != null && t != p){
                stack.push(t);
                t = t.left;
            }
            if (!stack.empty()){
                t = stack.peek();
                if (t.right != null && t.right != p)
                    t = t.right;
                else
                    System.out.print((p = stack.pop()).value + " ");
            }
        }while (! stack.empty());

    }



    public static void printBackIterativeV2(Node node){
        if (node == null) return;
        Stack<Node> stack = new Stack<>();
        //stack.push(node);
        Node t = node, lastPop = null;
        while (!stack.empty() || t !=null){
            while (t !=null){
                stack.push(t);
                t = t.left;
            }
            t = stack.peek();
            if (t.right == null || lastPop == t.right){
                System.out.print(stack.pop().value + " ");
                lastPop = t;
                t = null;
            }else {
                t = t.right;
            }
        }
    }










    /**
     * take the front go-through sequence and the middle of a binary search tree
     * rebuild the binary search tree and return the root node
     * @param front
     * @param middle
     * @return
     */
    public static Node rebuild(int[] front, int[] middle){
        if (front.length != middle.length)
            return null;
        return rebuild(front, middle, 0, front.length -1, 0, front.length - 1);
    }

    private static Node rebuild(int[] front, int[] middle, int lf, int rf, int lm, int rm){

        if (lf == rf || lm == rm)
            return new Node(front[lf], null, null);
        else if (lf > rf || lm > rm)
            return null;

        Node currentRoot = new Node(front[lf], null, null);
        int rootPos = findRootInMiddle(front[lf], lm, rm, middle);

        int leftQ = rootPos - lm, rightQ = rm - rootPos;
        currentRoot.left = rebuild(front, middle, lf + 1, lf + leftQ, lm, rootPos - 1);
        currentRoot.right = rebuild(front, middle, rf - rightQ + 1, rf, rootPos + 1, rm);

        return currentRoot;
    }

    private static int findRootInMiddle(int root, int lm, int rm, int[] middle){
        for (int i = lm; i <= rm; i ++){
            if (root == middle[i])
                return i;
        }
        return -1;
    }


    /**
     * find the most close neighbor with bigger value of a node
     * no matter whether it is in the tree or not
     * @param bst
     * @param base
     * @return
     */
    public static Node findMostCloseBigger(BinarySearchTree bst, int base){
        Node node = bst.getRoot();
        if (node == null)   return null;
        return findMostCloseBigger(node, base);
    }

    private static Node findMostCloseBigger(Node node, int base){
        int d = node.value - base;
        if (d <= 0 && node.right != null)
            return findMostCloseBigger(node.right, base);
        //when base is smaller, the goal is in the left side
        else if (d > 0){
            //when left does not exist or left node's value is smaller or identical to the base
            //this node itself is the goal
            if (node.left == null || node.left.value <= base)
                return node;
            else
                return findMostCloseBigger(node.left, base);
        }
        return null;

    }

    /**
     * to check whether a binary search tree is a sub-tree of
     * this binary search tree
     * @param bst
     * @return
     */
    public boolean isContained(BinarySearchTree bst){
        if (bst == null)    return false;
        Node start = findSameValue(root, bst.getRoot());
        return isContained(start, bst.getRoot());
    }

    private boolean isContained(Node n1, Node n2){
        if (n1 == null && n2 == null)   return true;
        if (n1 == null || n2 == null)   return false;
        if (n1.value == n2.value)
            return isContained(n1.left, n2.left) && isContained(n1.right, n2.right);
        return false;
    }

    private Node findSameValue(Node base, Node sub){
        if (base != null && sub !=null){
            if (base.value == sub.value)
                return base;
            else if (base.value < sub.value)
                return findSameValue(base.right, sub);
            else
                return findSameValue(base.left, sub);
        }
        return null;

    }

    public BinarySearchTree getMirror(){
        Node otherNode = getMirror(root);
        BinarySearchTree b = new BinarySearchTree();
        b.root = otherNode;
        return b;
    }

    public Node getMirror(Node origin){
        if (origin == null)     return null;
        Node mirror  = new Node(origin.value, null, null);
        mirror.left = getMirror(origin.right);
        mirror.right = getMirror(origin.left);
        return mirror;
    }


    static public boolean isSymmetric(Node n){
        if (n == null)      return true;
        return isSymmetric(n.right, n.left);
    }

    static private boolean isSymmetric(Node n, Node m){
        if (n == null && m == null)     return true;
        if (n == null || m == null)     return false;
        if (n.value != m.value)         return false;
        return isSymmetric(n.right, m.left)
                    && isSymmetric(n.left, m.right);

    }


    public void printTopToBottom(){
        Node n = root;
        if (n == null)  return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(n);
        int currentLayer = 1, nextLayer = 0;
        boolean direction = true;
        while (!queue.isEmpty()){
            n = queue.poll();
            if (n.left != null) {
                queue.offer(n.left);
                nextLayer++;
            }
            if (n.right != null) {
                queue.offer(n.right);
                nextLayer++;
            }



            System.out.print(n.value + " ");
            currentLayer --;
            if (currentLayer == 0){
                System.out.print("\n");
                currentLayer = nextLayer;
                nextLayer = 0;
            }
        }
    }

    public static void printTopToBottomV2(Node node){
        if (node == null)   return;
        Queue<Node> queue = new LinkedList<>();
        int current = 1, next = 0;
        queue.add(node);
        Node n;
        while (queue.peek() != null){
            while (current > 0){
                n = queue.remove();
                current --;
                System.out.print(n.value + " ");
                if (n.left != null) {
                    queue.add(n.left);
                    next ++;
                }
                if (n.right != null) {
                    queue.add(n.right);
                    next ++;
                }
            }
            System.out.println();
            current = next; next = 0;
        }
    }

    public void printTopToBottomRotate(){
        Node n = root;
        if (n == null)  return;
        Stack<Node> oddStack = new Stack<>(),
                evenStack = new Stack<>();
        oddStack.push(n);
        boolean direction = true;
        // if not both stack are empty, the loop go on
        while ( (!oddStack.empty()) || (!evenStack.empty())){
            if (direction){
                while (!oddStack.empty()){
                    Node temp = oddStack.pop();
                    System.out.print(temp.value + " ");
                    if (temp.right != null)     evenStack.push(temp.right);
                    if (temp.left != null)      evenStack.push(temp.left);
                }
                System.out.print("\n");
            }else {
                while (!evenStack.empty()){
                    Node temp = evenStack.pop();
                    System.out.print(temp.value + " ");
                    if (temp.left != null)      oddStack.push(temp.left);
                    if (temp.right != null)     oddStack.push(temp.right);
                }
                System.out.print("\n");
            }
            direction = !direction;
        }
    }

    /**
     * to check whether a sequence, which is viewed as
     * post order of a binary search tree, is really belong
     * to a tree
     * consider that in a binary search tree,
     * its root is the last node of post-order sequence
     * if we go through the sequence, once we meet the first node
     * which is bigger than root, we find the first node of right
     * sub-tree. There can not be any node which is smaller than
     * root in this right sub-tree, if so, return false.
     * @param seq
     * @return
     */
    public static boolean postOrderSeqIsTree(int[] seq){
        return postOrderSeqIsTree(seq, 0, seq.length - 1);
    }

    private static boolean postOrderSeqIsTree(int[] seq, int start, int end){
        if (end <= start)   return true;
        int root = seq[end], middle = -1;
        for (int i = start; i < end; i ++){
            if (middle == -1) {
                if (seq[i] > root) middle = i;
            }
            else
                if (seq[i] < root)  return false;
        }
        return postOrderSeqIsTree(seq, start, middle -1 ) &&
                postOrderSeqIsTree(seq, middle, end - 1);
    }

    /**
     * print all paths along which all value sum up to expectedSum
     * @param expectedSum
     */
    public void pathSumEquals(int expectedSum){
        Stack<Integer> path = new Stack<>();
        printPath(expectedSum, path, root);
    }

    private void printPath(int expectedSum, Stack<Integer> path, Node n){
        if (n == null)      return;
        path.push(n.value);
        int cmp = expectedSum - n.value;
        if (cmp == 0 && n.right == null && n.left == null){
            for (int i: path)
                System.out.print(i + " ");
            System.out.print("\n");
        }else if (cmp > 0){
            if (cmp > n.value)
                printPath(cmp, path, n.right);
            printPath(cmp, path, n.left);
        }
        path.pop();

    }


    public static Node TreeToLinkedList(Node root){
        root = TreeToLinkedList(root, false);
        return root;
    }

    private static Node TreeToLinkedList(Node n, boolean direction){
        if (n == null)      return null;
        Node left = TreeToLinkedList(n.left, true);
        Node right = TreeToLinkedList(n.right, false);

        // because of this transformation, directly right and left
        // are apt to change
        n.right = right;
        n.left  = left;

        // link left and right to this node
        if (left != null)       left.right = n;
        if (right != null)      right.left = n;
        // direction is used to indicate which node we should return
        // the head or the tail?
        if (direction)
            while (n.right != null)
                n = n.right;
        else
            while (n.left != null)
                n = n.left;
        return  n;
    }

    public String Serialize(){
        if (root == null)   return "$";
        StringBuilder builder = new StringBuilder();
        Serialize(root, builder);
        return builder.toString();
    }

    private void Serialize(Node n, StringBuilder builder){
        if (n == null){
            builder.append("$,");
            return;
        }
        else {
            builder.append(n.value + ",");
            Serialize(n.left, builder);
            Serialize(n.right, builder);
        }
    }

    static public Node DeSerialize(InputStream is){

        int i = 0;
        String number = "";
        try{
            while (i != 44 || i == -1){
                i = is.read();
                if (i != 44 && i != 36)    number += (char) i;
            }
            if (number != "") {
                Node r = new Node(Integer.parseInt(number), null, null);
                r.left = DeSerialize(is);
                r.right = DeSerialize(is);
                return r;
            }
        }catch (IOException e){

        }
        return null;
    }


    public static void  main(String[] args){
        /*
        int[] front = {1,2,4,7,3,5,6,8};
        int[] middle = {4,7,2,1, 5,3,8,6};
        Node r = rebuild(front, middle);
        printMid(r);
        System.out.print("\n");
        printFront(r);
        System.out.print("\n");
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < 10; i ++)
            bst.addNode(9 - i);
        printFront(bst.root);
        printMid(bst.root );
        front =new int[]{9,8,7,6,5,4,3,2,1,0};
        middle = new int[]{0,1,2,3,4,5,6,7,8,9};
        Node s = rebuild(front, middle);
        printMid(s);
        printFront(s);

        front = new int[]{1};
        middle = new int[]{1};
        Node t = rebuild(front, middle);
        printFront(t);
        printMid(t);

        Random random = new Random();
        BinarySearchTree bst = new BinarySearchTree();
        int[] array = new int[]{43,  19,  18,  6,  3,  44,  51,  46,  88,  70 };
        for (int i = 0; i < 10; i ++)
            bst.addNode(array[i]);
        printMid(bst.getRoot());
        System.out.println();
        printFront(bst.getRoot());

        BinarySearchTree bst2 = new BinarySearchTree();
        int[] array2 = new int[]{51, 46, 88, 70};
        for (int i = 0; i < array2.length; i ++)
            bst2.addNode(array2[i]);
        System.out.println( bst.isContained(bst2));

        bst2 = new BinarySearchTree();
        bst2.addNode(5);
        bst2.addNode(3);
        bst2.addNode(6);
        bst2.addNode(1);
        bst2.addNode(4);
        bst2.addNode(8);

        BinarySearchTree t = new BinarySearchTree();
        t.addNode(6);
        t.addNode(7);
        System.out.println( bst2.isContained(new BinarySearchTree()));

        t = new BinarySearchTree();
        t.addNode(2);
        t.addNode(1);
        t.addNode(0);
        printMid(t.root);

        t = t.getMirror();
        printMid(t.root);
        t = new BinarySearchTree();
        t.addNode(2);
        t = t.getMirror();
        printMid(t.root);
        //System.out.printf("find most bigger neighbor of %d : %d",a, BinarySearchTree.findMostCloseBigger(bst, a).value);

        t = new BinarySearchTree();
        Node n = new Node(0, null, null);
        Node n1 = new Node(1, null, null);
        Node n2 = new Node(1, null, null);

        Node n0 = new Node(2, n1, null);
        System.out.println(isSymmetric(n0));
        System.out.println(isSymmetric(n));*/

        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(20);
        //bst.addNode(10);
        bst.addNode(30);
        //bst.addNode(15);
        //bst.addNode(7);
        //bst.addNode(25);
        bst.addNode(34);
        //bst.pathSumEquals(78);
        //bst.printTopToBottom();

        BinarySearchTree.printBackIterativeV2(bst.root);
        System.out.println();
        BinarySearchTree.printBackIterative(bst.root);
        System.out.println();

        BinarySearchTree.printMid(bst.root);
        System.out.println();
        BinarySearchTree.printMidIterative(bst.root);
        System.out.println();
        BinarySearchTree.printTopToBottomV2(bst.root);
        System.out.println();
        HashSet<Integer> hashSet = new HashSet();


        //BinarySearchTree.printFront(bst.root);
        /*System.out.println(bst.FindNthNode(5).value);
        System.out.println(bst.FindNthNode(10));
        System.out.println(bst.getMaxDepth());

        bst = new BinarySearchTree();

        System.out.println(bst.getMaxDepth());
        System.out.println(bst.isBalancedTree());
        bst.addNode(2);
        bst.addNode(1);
        bst.addNode(3);
        System.out.println(bst.getMaxDepth());
        System.out.println(bst.isBalancedTree());*/
        //System.out.println();

        /*
        Node x = BinarySearchTree.TreeToLinkedList(bst.root);
        x = BinarySearchTree.TreeToLinkedList(null);
        while (x != null) {
            System.out.print(x.value + " ");
            x = x.right;
        }*/
        /*
        String s = bst.Serialize();
        try {
            PrintWriter fo = new PrintWriter(new FileWriter("/home/wenming/cslab/interviewProblems/output/foo2.txt"));
            fo.write(s);
            fo.close();
            FileInputStream fi = new FileInputStream("/home/wenming/cslab/interviewProblems/output/foo2.txt");
            Node n = BinarySearchTree.DeSerialize(fi);
            fi.close();
            BinarySearchTree.printFront(n);
        }catch (IOException e){

        }*/
        //File f = new File("foo.txt");



        /*
        BinarySearchTree.printMid(bst.root);
        BinarySearchTree.printFront(bst.root);
        System.out.print("\n");
        bst.printTopToBottom();
        bst.printTopToBottomRotate();

        bst = new BinarySearchTree();
        bst.addNode(4);
        bst.printTopToBottom();

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (int i :stack){
            System.out.print(i);
        }
        for (int i :stack){
            System.out.print(i);
        }*/
    }
}
