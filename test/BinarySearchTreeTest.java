import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    BinarySearchTree bst, bst2, bst3;

    @Before
    public void initialize(){
        bst = new BinarySearchTree();
        bst.addNode(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(15);
        bst.addNode(14);
        bst.addNode(17);
        bst.addNode(16);
        bst.addNode(30);
        bst.addNode(28);

        bst2 = new BinarySearchTree();
        bst2.addNode(10);
        bst2.addNode(15);
        bst2.addNode(17);
        bst2.addNode(19);

        bst3 = new BinarySearchTree();
        bst3.addNode(10);
        bst3.addNode(9);
        bst3.addNode(7);
    }

    @Test
    public void postOrderSeqIsTree() {
        int[] seq = new int[]{1, 3, 2, 6, 8, 7, 4};
        assertTrue(BinarySearchTree.postOrderSeqIsTree(seq));


    }


    @Test
    public void testPrintMidIterative(){
        BinarySearchTree.printMidIterative(bst.root);
        BinarySearchTree.printMidIterative(bst2.root);
        BinarySearchTree.printMidIterative(bst3.root);
    }

    @Test
    public void testPrintFrontIterative(){
        BinarySearchTree.printFrontIterative(bst.root);
        System.out.println();
        BinarySearchTree.printFrontIterative(bst2.root);
        System.out.println();
        BinarySearchTree.printFrontIterative(bst3.root);
    }

    @Test
    public void testPrintBackIterative(){
        BinarySearchTree.printBackIterative(bst.root);
        System.out.println();
        BinarySearchTree.printBackIterative(bst2.root);
        System.out.println();
        BinarySearchTree.printBackIterative(bst3.root);
    }
}