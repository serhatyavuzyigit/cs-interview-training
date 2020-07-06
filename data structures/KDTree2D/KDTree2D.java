package KDTree2D;

/*
  A regular Binary Search Tree can only insert the points searching using either the x or y coordinate,
  but not both. The idea in a kd-tree is that, at each level, the tree compares against one dimension
  (called cutting dimension). The cutting dimension cycles through dimensions as you walk down
  the tree. For example, a 2D kd-tree first compares on the x coordinate to decide whether to go
  to the left or right of a node, then at the next level compares on the y coordinate. Then it’s back
  to x again.
*/

import java.util.ArrayList;

public class KDTree2D
{
    // nested static class for a KDTree2D node
    protected static class Node
    {
        private Point2D element;    // an element of current node
        private Node parent;        // a reference to parent node
        private Node left;          // a reference to left child
        private Node right;         // a reference to right child

        public Node(Point2D p ,Node above ,Node leftChild, Node rightChild) {
            element = p;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        // accessor methods
        public Point2D getElement() { return element; }
        public Node getParent() { return parent; }
        public Node getLeft() { return left; }
        public Node getRight() { return right; }

        // update methods
        public void setElement(Point2D e) { element = e; }
        public void setParent(Node parentNode) { parent = parentNode; }
        public void setLeft(Node leftChild) { left = leftChild; }
        public void setRight(Node rightChild) { right = rightChild; }
    }

    protected Node createNode(Point2D e, Node parent, Node left, Node right) {
        return new Node(e, parent, left, right);
    }

    public KDTree2D (ArrayList<Point2D> points) {  // constructcs new KDTree2D for given Point2D of ArrayList
        for(int i=0;i<points.size();i++)
            insert(points.get(i));
    }

    public KDTree2D() { } // default constructor
    protected Node root = null;

    private int size = 0;

    public int size() { return size; }

    public Node root() { return root; }

    public Node parent(Node node) {
        if(node.getParent() != null)
            return node.getParent();
        return null;
    }

    public Node left(Node node) {
        return node.getLeft();
    }

    public Node right(Node node) {
        return node.getRight();
    }

    public Node addRoot(Point2D p) {
        if(size != 0)
            System.out.println("Tree is not empty");
        else {
            root = createNode(p,null,null,null);
            size = 1;
            return root;
        }
        return null;

    }

    public Node addLeft(Node parent ,Point2D p) {
        if(parent.getLeft() != null)
            System.out.println("Error while addLeft");
        else {
            Node child = createNode(p,parent,null,null);
            parent.setLeft(child);
            size++;
            return child;
        }
        return null;
    }

    public Node addRight(Node parent ,Point2D p) {
        if(parent.getRight() != null)
            System.out.println("Error while addRight");
        else {
            Node child = createNode(p,parent,null,null);
            parent.setRight(child);
            size++;
            return child;
        }
        return null;
    }
    /*
      inserts the given point to tree
    */
    public void insert(Point2D p)
    {
        if(size == 0)   // add to root
            addRoot(p);
        else {
            int flag = 0;
            insertInner(root(),p,flag);
        }
    }
    private void insertInner(Node localroot, Point2D p, int f) {
        if(hasNoChild(localroot)) {
            if(f%2 == 0) {
                if(localroot.getElement().getX() > p.getX())
                    addLeft(localroot,p);
                else
                    addRight(localroot,p);
            }
            else {
                if(localroot.getElement().getY() > p.getY())
                    addLeft(localroot,p);
                else
                    addRight(localroot,p);
            }
        }
        else {
            if(f%2 == 0) {
                if(localroot.getElement().getX() > p.getX()) {
                    if(hasOnlyRightChild(localroot))
                        addLeft(localroot,p);
                    else
                        insertInner(left(localroot),p,f+1);
                }
                else {
                    if(hasOnlyLeftChild(localroot))
                        addRight(localroot,p);
                    else
                        insertInner(right(localroot),p,f+1);
                }
            }
            else {
                if(localroot.getElement().getY() > p.getY()) {
                    if(hasOnlyRightChild(localroot))
                        addLeft(localroot,p);
                    else
                        insertInner(left(localroot),p,f+1);
                }
                else {
                    if(hasOnlyLeftChild(localroot))
                        addRight(localroot,p);
                    else
                        insertInner(right(localroot),p,f+1);
                }
            }
        }
    }
    public boolean hasTwoChild(Node node) {
        if(left(node) != null && right(node) != null)
            return true;
        return false;
    }
    public boolean hasOnlyLeftChild(Node node) {
        if(left(node) != null && right(node) == null)
            return true;
        return false;
    }

    public boolean hasOnlyRightChild(Node node) {
        if(left(node) == null && right(node) != null)
            return true;
        return false;
    }

    public boolean hasNoChild(Node node) {
        if(node == null)
            return true;
        if(left(node) == null && right(node) == null)
            return true;
        return false;
    }

    public boolean hasLeftChild(Node node) {
        if(left(node) != null)
            return true;
        return false;
    }

    public boolean hasRightChild(Node node) {
        if(right(node) != null)
            return true;
        return false;
    }

    public String toString() {
        String s = "";
        s = displayPreorderInner(root());
        int b = s.lastIndexOf('\n');
        s = s.substring(0,b);
        return s;
    }
    private String displayPreorderInner(Node localroot) {
        if(localroot == null)
            return "";
        if(hasNoChild(localroot))
            return printSpace(localroot) + localroot.getElement().toString() +"\n";
        return printSpace(localroot) + localroot .getElement().toString() + "\n"+ displayPreorderInner(left(localroot)) + displayPreorderInner(right(localroot));
    }

    public int depth(Node node)
    {
        if(node == root())
            return 0;
        return 1 + depth(parent(node));
    }

    public String printSpace(Node node)
    {
        String s = "";
        for(int i=0;i<depth(node);i++)
            s += " ";
        return s;
    }

    public Point2D search(Point2D point) {
        int flag = 0;
        return diffSearchInner(root(),point,flag);
    }
    private Point2D diffSearchInner(Node localroot, Point2D point, int flag) {
        if(localroot == null)
            return null;
        if(flag%2 == 0) {// search for x coordinate
            if(localroot.getElement().getX() > point.getX()) {
                return diffSearchInner(left(localroot),point,flag+1);
            }
            else if (localroot.getElement().getX() < point.getX()) {
                return diffSearchInner(right(localroot),point,flag+1);
            }
            else {// x coordinates are equal
                if(localroot.getElement().getY() == point.getY()) // point found;
                    return localroot.getElement();
                else // point not found
                    return null;
            }

        } else { // search for y coordinate
            if(localroot.getElement().getY() > point.getY()) {
                return diffSearchInner(left(localroot),point,flag+1);
            }
            else if(localroot.getElement().getY() < point.getY()) {
                return diffSearchInner(right(localroot),point,flag+1);
            }
            else { // y coordinates are equal
                if(localroot.getElement().getX() == point.getX())
                    return localroot.getElement();
                else
                    return null;
            }
        }

    }

    /*
      finds minumum point in tree
    */
    public Point2D findMin(int d) {
        Point2D min = root.getElement();
        if(d == 0) {    // finds for x coordinate
            return findMinForX(root(),min);
        } else if(d == 1) { // finds for y coordinate
            return findMinForY(root(),min);
        } else {
            return null;
        }
    }
    /*
      finds maximum point in tree
    */
    public Point2D findMax(int d) {
        Point2D max = root.getElement();
        if(d == 0) {    // finds for x coordinate
            return findMaxForX(root(),max);
        } else if(d == 1) { // finds for y coordinate
            return findMaxForY(root(),max);
        } else {
            return null;
        }
    }

    public Point2D findMinForX(Node localroot,Point2D min)  //finding minumum point for x coordinate
    {
        if(localroot == null) {
            return new Point2D(Integer.MAX_VALUE,Integer.MAX_VALUE);
        }
        if(hasNoChild(localroot))
            return localroot.getElement();
        Point2D left = findMinForX(left(localroot),min);
        Point2D right = findMinForX(right(localroot),min);
        if(left.getX() < right.getX())
            min = left;
        else
            min = right;
        if(localroot.getElement().getX() < min.getX())
            min = localroot.getElement();
        return min;

    }

    public Point2D findMinForY(Node localroot,Point2D min) //finding minumum point for y coordinate
    {
        if(localroot == null)
            return new Point2D(Integer.MAX_VALUE,Integer.MAX_VALUE);
        if(hasNoChild(localroot))
            return localroot.getElement();
        Point2D left = findMinForY(left(localroot),min);
        Point2D right = findMinForY(right(localroot),min);
        if(left.getY() < right.getY()) {
            min = left;
        }
        else {
            min = right;
        }
        if(localroot.getElement().getY() < min.getY())
            min = localroot.getElement();
        return min;

    }

    public Point2D findMaxForX(Node localroot,Point2D max)  //finding minumum point for x coordinate
    {
        if(localroot == null) {
            return new Point2D(Integer.MIN_VALUE,Integer.MIN_VALUE);
        }
        if(hasNoChild(localroot))
            return localroot.getElement();
        Point2D left = findMaxForX(left(localroot),max);
        Point2D right = findMaxForX(right(localroot),max);
        if(left.getX() > right.getX())
            max = left;
        else
            max = right;
        if(localroot.getElement().getX() > max.getX())
            max = localroot.getElement();
        return max;

    }

    public Point2D findMaxForY(Node localroot,Point2D max) //finding minumum point for y coordinate
    {
        if(localroot == null)
            return new Point2D(Integer.MIN_VALUE,Integer.MIN_VALUE);
        if(hasNoChild(localroot))
            return localroot.getElement();
        Point2D left = findMaxForY(left(localroot),max);
        Point2D right = findMaxForY(right(localroot),max);
        if(left.getY() > right.getY()) {
            max = left;
        }
        else {
            max = right;
        }
        if(localroot.getElement().getY() > max.getY())
            max = localroot.getElement();
        return max;

    }

}