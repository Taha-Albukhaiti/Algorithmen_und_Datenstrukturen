package datastructure.trees;

public class BinaryTreeI {
    Node root = null;

    public Node getRoot() {
        return root;
    }

    public Node treeLeft(Node node) {
        if (node != null) return node.lift;
        else return null;
    }

    public Node treeRight(Node rightNode) {
        if (rightNode != null) return rightNode.right;
        else return null;
    }

    public void inorderTreeWalk(Node focusNode) {
        if (focusNode != null) {
            inorderTreeWalk(focusNode.lift);
            System.out.println(focusNode.toString());
            inorderTreeWalk(focusNode.right);
        }
    }

    public Node search(Node root, int key) {
        if ((root == null) || (key == root.key)) return root;
        else if (key < root.key) return search(root.lift, key);
        else return search(root.right, key);
    }

    public void insert(Node n) {
        Node y = null;
        Node focusNode = root;
        while (focusNode != null) {
            y = focusNode;
            if (n.key < focusNode.key) {
                focusNode = focusNode.lift;
            } else {
                focusNode = focusNode.right;
            }
        }
        n.p = y;
        if (y == null) {
            root = n;
        } else {
            if (n.key < y.key) {
                y.lift = n;
            } else {
                y.right = n;
            }
        }
    }

    private Node treeMinimum(Node b) {
        while (b.lift != null)
            b = b.lift;
        return b;
    }

    private Node treeMaximum(Node b) {
        while (b.right != null)
            b = b.right;
        return b;
    }

    public void treeDeleteBuch(Node node) {
        Node y = null;
        if (node.lift == null) transplant(node, node.right);
        else if (node.right == null) transplant(node, node.lift);
        else {
            y = treeMinimum(node.right);
            if (y.p != node) {
                transplant(y, y.right);
                y.right = node.right;
                y.right.p = y;
            }
            transplant(node, y);
            y.lift = node.lift;
            y.lift.p = y;
        }

    }

    private void transplant(Node u, Node v) {
        if (u.p == null) root = v;
        else if (u == u.p.lift) u.p.lift = v;
        else u.p.right = v;
        if (v != null) v.p = u.p;
    }

    public static void main(String[] args) {
        BinaryTreeI binaryTree = new BinaryTreeI();
        Node n = new Node("www", 23);
        binaryTree.insert(new Node("Ali", 66));
        binaryTree.insert(new Node("Max", 11));
        binaryTree.insert(n);
        binaryTree.insert(new Node("Lara", 13));
        binaryTree.insert(new Node("Jan", 22));
        binaryTree.insert(new Node("Moh", 33));
        binaryTree.inorderTreeWalk(binaryTree.root);

        binaryTree.treeDeleteBuch(n);
        System.out.println("_______");
        binaryTree.inorderTreeWalk(binaryTree.root);
        System.out.println("___");
        System.out.println(binaryTree.search(binaryTree.root, 22));

    }
}
/*
 Node y = root;
        Node x = root;
        if (node.lift == null || node.right == null) {
            y = node;
        } else {
            y = treeSuccessor(node);
        }
        if (y.lift != null) {
            x = y.lift;
        } else {
            x = y.right;
        }
        if (x != null) {
            x.p = y.p;
        }
        if (y.p == null) {
            root = x;
        } else if (y == y.p.lift) {
            y.p.lift = x;
        } else {
            y.p.right = x;
        }
        if (y != node) {
            node = y;
        }



        Node focusNode = root;
        Node parent = root;
        boolean isItAleftChild = true;
        while (focusNode.key != key) {
            parent = focusNode;
            if (key < focusNode.key) {
                isItAleftChild = true;
                focusNode = focusNode.lift;
            } else {
                isItAleftChild = false;
                focusNode = focusNode.right;
            }
            if (focusNode == null) return false;
        }
        if (focusNode.lift == null && focusNode.right == null) {
            if (focusNode == root) {
                root = null;
            } else if (isItAleftChild) {
                parent.lift = null;
            } else {
                parent.right = null;
            }
        } else if (focusNode.right == null) {
            if (focusNode == root)
                root = focusNode.lift;
            else if (isItAleftChild)
                parent.lift = focusNode.lift;
            else
                parent.right = focusNode.lift;

        } else if (focusNode.lift == null) {
            if (focusNode == root)
                root = focusNode.right;
            else if (isItAleftChild)
                parent.lift = focusNode.right;
            else
                parent.right = focusNode.right;

        } else {
            Node replacement = getReplacementNode(focusNode);
            if (focusNode == root)
                root = replacement;

            else if(isItAleftChild)
                parent.lift = replacement;

            else
                parent.right= replacement;
            replacement.lift = focusNode.lift;
        }
        return true;
 */
