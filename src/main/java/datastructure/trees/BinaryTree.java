package datastructure.trees;

public class BinaryTree {
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
            System.out.println(focusNode);
            inorderTreeWalk(focusNode.right);
        }
    }

    public Node search(int key) {
        while ((root != null) && (key != root.key)) {
            if (key < root.key) root = root.lift;
            else root = root.right;
        }
        return root;
    }
    public Node searchI(Node root, int key) {
        if ((root == null) || (key == root.key)) return root;
        else if (key < root.key) return searchI(root.lift, key);
        else return searchI(root.right, key);
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


    public void remove(Node node) {
        Node y;
        Node x;
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
            node.key = y.key;
        }


    }

    public Node treeSuccessor(Node node) {
        node = node.right;
        while (node.lift != null)
            node = node.lift;
        return node;

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

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node n = new Node("www", 23);
        binaryTree.insert(new Node("Max", 11));
        binaryTree.insert(new Node("Ali", 66));
        binaryTree.insert(n);
        binaryTree.insert(new Node("Lara", 13));
        binaryTree.insert(new Node("Jan", 22));
        binaryTree.insert(new Node("Moh", 33));
        System.out.println(binaryTree.getRoot());
        System.out.println(binaryTree.treeRight(binaryTree.getRoot()));
        System.out.println();
        System.out.println(binaryTree.searchI(n, n.key));
        System.out.println(binaryTree.searchI(n, 13));
        System.out.println();

        binaryTree.inorderTreeWalk(binaryTree.root);

        binaryTree.remove(n);
        System.out.println("_______");
        binaryTree.inorderTreeWalk(binaryTree.root);
        System.out.println("___");
        System.out.println();
        System.out.println(binaryTree.search( 13));
        System.out.println(binaryTree.searchI(binaryTree.root, 22));
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
