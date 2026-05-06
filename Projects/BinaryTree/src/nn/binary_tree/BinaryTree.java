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

    public String inOrderToString()
    {
        StringBuilder sb = new StringBuilder();
        inOrderToString(sb, this);
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

    public String preOrderToString()
    {
        StringBuilder sb = new StringBuilder();
        preOrderToString(sb, this);
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

    public String postOrderToString()
    {
        StringBuilder sb = new StringBuilder();
        postOrderToString(sb, this);
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

    public static BinaryTree<Character> reconstuctionPreIn(String pre, String in)
    {
        if(pre.length() == 0)
            return null;
        BinaryTree<Character> root = new BinaryTree<>(pre.charAt(0));

        int index =in.indexOf(pre.charAt(0));

        root.left = reconstuctionPreIn(pre.substring(1, 1+index), in.substring(0, index));
        root.right = reconstuctionPreIn(pre.substring(index+1), in.substring(index+1));

        return root;
    }

    // public static BinaryTree<Character> reconstuctionPostIn(String post, String in)
    // {
    //     if(post.length() == )
    //     BinaryTree<Character> root = new BinaryTree<>(post.charAt(post.length()));

    // }

    @Override
    public String toString() {
        return inOrderToString();
    }

    public static <T> BinaryTree<T> reconstuctionPreIn(T pre[], int preLb, int preUb, T in[], int inLb, int inUb)
    {
        if(preLb > preUb || preLb >= pre.length || preUb < 0)
            return null;

        BinaryTree<T> root = new BinaryTree<T>(pre[0]);
        int index = 0;
        for(int i = inLb ; i <= inUb ; i++)
        {
            if(in[i].equals(pre[0]))
            {
                index = i;
                break;
            }
        }

        root.left = reconstuctionPreIn(pre, preLb+1, index+1, in, inLb, index-1);
        root.right = reconstuctionPreIn(pre, index+2, preUb, in, index+1, inUb);

        return root;
    }


    public static <T> BinaryTree<T> reconstuctionPostIn(T post[], int postLb, int postUb, T in[], int inLb, int inUb)
    {
        BinaryTree<T> root = new BinaryTree<T>(post[post.length-1]);
        int index = 0;
        for(int i = inLb ; i <= inUb ; i++)
        {
            if(in[i].equals(post[post.length-1]))
            {
                index = i;
                break;
            }
        }

        root.left = reconstuctionPostIn(post, postLb, index-1, in, inLb, index-1);
        // root.right = reconstuctionPostIn(post, postLb, postUb, in, inLb, inUb);

        return root;
    }

    

    public static void main(String[] args) {
        BinaryTree<Character> treeOne = createTreeOne();
        // System.out.println("Preorder :" + preOrderToString(treeOne));
        // System.out.println("Inorder  :" + inOrderToString(treeOne));
        // System.out.println("Postorder:" + postOrderToString(treeOne));

    //     String inorder = treeOne.inOrderToString();
    //     String preOrder = treeOne.preOrderToString();
    //     System.out.println(preOrder);
    //     System.out.println(inorder);
    //     BinaryTree<Character> tree = reconstuctionPreIn(preOrder, inorder);
    //     System.out.println(tree.postOrderToString());
    //     System.out.println(tree);

        Integer preOrder[] = {14, 4, 3, 9, 7, 5, 15, 18, 16, 17, 20};
        Integer inOrder[]  = {3, 4, 5, 7, 9, 14, 15, 16, 17, 18, 20};
        Integer postOrder[] ={3, 5, 7, 9, 4, 17, 16, 20, 18, 15, 14};
        // Integer preOrder[] = {20, 10, 30};
        // Integer inOrder[]  = {10, 20, 30};

        BinaryTree<Integer> root = reconstuctionPreIn(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
        System.out.println(root);
        // System.out.println(root.postOrderToString());
    }
    
}
