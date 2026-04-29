package nn.binary_tree;

public class BinaryTree<T> {

    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;
    
    public BinaryTree(T data) {
        this.data = data;
    }

    

    public void setLeft(T data) {
        this.left = new BinaryTree<>(data);
    }



    public void setRight(T data) {
        this.right = new BinaryTree<>(data);
    }



    public static <T> void inOrder(BinaryTree<T> t)
    {
        if(t != null)
        {
            inOrder(t.left);
            System.out.println(t.data);
            inOrder(t.right);
        }
    }

    private static <T> void inOrderToString(StringBuilder sb, BinaryTree<T> t)
    {
        if(t != null)
        {
            inOrderToString(sb, t.left);
            sb.append(t.data);
            inOrderToString(sb, t.right);
        }
        // return sb.toString();
    }

    static <T> String inOrderToString(BinaryTree<T> t)
    {
        StringBuilder sb = new StringBuilder();
        inOrderToString(sb, t);
        return sb.toString();
    } 

    private static <T> void preOrderToString(StringBuilder sb, BinaryTree<T> t)
    {
        if(t != null)
        {
            sb.append(t.data);
            preOrderToString(sb, t.left);
            preOrderToString(sb, t.right);
        }
        // return sb.toString();
    }

    public static <T> String preOrderToString(BinaryTree<T> t)
    {
        StringBuilder sb = new StringBuilder();
        preOrderToString(sb, t);
        return sb.toString();
    } 

    private static <T> void postOrderToString(StringBuilder sb, BinaryTree<T> t)
    {
        if(t != null)
        {
            postOrderToString(sb, t.left);
            postOrderToString(sb, t.right);
            sb.append(t.data);
        }
        // return sb.toString();
    }

    static <T> String postOrderToString(BinaryTree<T> t)
    {
        StringBuilder sb = new StringBuilder();
        postOrderToString(sb, t);
        return sb.toString();
    } 


    public static BinaryTree<Character> createTreeOne()
    {
        BinaryTree<Character> root = new BinaryTree<Character>('A');
        root.setLeft('B');
        root.left.setLeft('D');
        root.left.left.setRight('G');
        root.setRight('C');
        root.right.setLeft('E');
        root.right.setRight('F');
        root.right.left.setLeft('H');
        root.right.left.setRight('I');

        return root;
    }

    public static void main(String[] args) {
        BinaryTree<Character> treeOne = createTreeOne();
        System.out.println("Preorder :" + preOrderToString(treeOne));
        System.out.println("Inorder  :" + inOrderToString(treeOne));
        System.out.println("Postorder:" + postOrderToString(treeOne));
    }
    
}
