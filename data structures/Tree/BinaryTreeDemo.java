package Tree;

public class BinaryTreeDemo {

    public static void main(String [] args) {

        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        bt.insert(6);
        bt.insert(7);

        System.out.print("Preorder Traversal: ");
        bt.preorderTraversal();

        System.out.print("Postorder Traversal: ");
        bt.postorderTraversal();

        System.out.print("Inorder Traversal: ");
        bt.inorderTraversal();

        System.out.println(bt.height());

        a = 10;

        if(a < 20)
            System.out.println("zazzz");
        else if(a <30)
            System.out.println("111");
    }
}
