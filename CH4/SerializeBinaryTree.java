import java.io.*;

public class SerializeBinaryTree {

    public static void serialize(BinarySearchTree.Node node, OutputStream out) throws IOException {
        if (node == null){
            out.write('$');
            out.write(',');
        }else {
            String num = Integer.toString(node.value);
            for (char i : num.toCharArray())
                out.write(i);
            out.write(',');
            serialize(node.left, out);
            serialize(node.right, out);
        }
    }

    public static BinarySearchTree.Node deSerialize(InputStream in) throws IOException{
        if (in == null)     return null;

        StringBuilder builder = new StringBuilder();
        BinarySearchTree.Node node = deSerialize(in, builder);
        return node;

    }

    private static BinarySearchTree.Node deSerialize(InputStream in, StringBuilder builder) throws IOException{
        if (in == null)     return null;
        char temp;
        while ((temp =(char) in.read()) != ','){
            builder.append(temp);
        }
        if (builder.indexOf("$") == -1) {
            try {
                BinarySearchTree.Node node = new BinarySearchTree.Node(Integer.parseInt(builder.toString()), null, null);

                builder.delete(0, builder.length());
                node.left = deSerialize(in, builder);
                node.right = deSerialize(in, builder);
                return node;
            }catch (NumberFormatException e){
                System.err.println(e.getMessage());
                return null;
            }

        }else
            builder.delete(0, builder.length());
        return null;
    }

    public static void main(String[] args) throws IOException{
        OutputStream out = new FileOutputStream("tree.txt");
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(10);
        bst.addNode(5);
        bst.addNode(15);
        serialize(bst.root, out);
        out.flush();
        out.close();


        InputStream in = new FileInputStream("tree.txt");
        BinarySearchTree.Node node = deSerialize(in);
        in.close();
        BinarySearchTree.printTopToBottomV2(node);
    }



}
