package Tree;

public class BinaryTree<E> {

    private static class Node<E> {

        private E data;             // reference to data stored in Node
        private Node<E> parent;     // reference to parent Node
        private Node<E> left;       // reference to left child Node
        private Node<E> right;      // reference to right child Node

        public Node(E data, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
            this.data = data;
            this.parent = parent;
            this.left = leftChild;
            this.right = rightChild;
        }

        // accessor methods
        public E getData() {
            return data;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        // update methods
        public void setData(E data) {
            this.data = data;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

    }

    private Node<E> root = null;

    private int size = 0;

    public int height() {
        return (int)Math.floor(Math.log(size) / Math.log(2));
    }

    public void insert(E data) {
        if (root == null) {
            Node<E> newest = new Node<>(data, null, null, null);
            root = newest;
            size++;
        } else {
            insertInner(root, data);
        }
    }

    private void insertInner(Node<E> localroot, E data) {
        if (isExternal(localroot)) {
            Node<E> newest = new Node<>(data, localroot, null, null);
            localroot.setLeft(newest);
            size++;
        } else {
            if (localroot.getLeft() == null) {
                Node<E> newest = new Node<>(data, localroot, null, null);
                localroot.setLeft(newest);
                size++;
            } else if (localroot.getRight() == null) {
                Node<E> newest = new Node<>(data, localroot, null, null);
                localroot.setRight(newest);
                size++;
            } else {
                if (!hasTwoChilds(localroot.getLeft())) {
                    insertInner(localroot.getLeft(), data);
                } else {
                    insertInner(localroot.getRight(), data);
                }
            }
        }

    }

    public void remove(E data) {

    }

    public void preorderTraversal() {
        String displayingPreorder = preorderInner(root);
        System.out.println(displayingPreorder);
    }

    private String preorderInner(Node localroot) {
        if (localroot == null) {
            return "";
        }
        return localroot.getData().toString() + " " + preorderInner(localroot.getLeft()) + preorderInner(localroot.getRight());
    }

    public void postorderTraversal() {
        String displayingPostorder = postorderInner(root);
        System.out.println(displayingPostorder);
    }

    private String postorderInner(Node localroot) {
        if (localroot == null) {
            return "";
        }
        return postorderInner(localroot.getLeft()) + postorderInner(localroot.getRight()) + localroot.getData().toString() + " ";
    }

    public void inorderTraversal() {
        String displayingInorder = inorderInner(root);
        System.out.println(displayingInorder);
    }

    private String inorderInner(Node localroot) {
        if (localroot == null) {
            return "";
        }
        return inorderInner(localroot.getLeft()) + localroot.getData().toString() + " " + inorderInner(localroot.getRight());
    }

    private boolean isInternal(Node<E> node) {
        if (node.getLeft() != null || node.getRight() != null) {
            return true;
        }
        return false;
    }

    private boolean isExternal(Node<E> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return true;
        }
        return false;
    }

    private boolean hasTwoChilds(Node<E> node) {
        if (node.getLeft() != null && node.getRight() != null) {
            return true;
        }
        return false;
    }


}
