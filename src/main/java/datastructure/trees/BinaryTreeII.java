package datastructure.trees;

public class BinaryTreeII {
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

    public boolean deleteNode(int key) {
        // Start at the top of the tree

        Node focusNode = root;
        Node parent = root;

        // When searching for a Node this will
        // tell us whether to search to the
        // right or left

        boolean isItALeftChild = true;

        // While we haven't found the Node
        // keep looking

        while (focusNode.key != key) {
            parent = focusNode;
            // If we should search to the left
            if (key < focusNode.key) {
                isItALeftChild = true;
                // Shift the focus Node to the left child
                focusNode = focusNode.lift;
            } else {
                // Greater than focus node so go to the right
                isItALeftChild = false;
                // Shift the focus Node to the right child
                focusNode = focusNode.right;
            }
            // The node wasn't found
            if (focusNode == null)
                return false;
        }
        // If Node doesn't have children delete it
        if (focusNode.lift == null && focusNode.right == null) {
            // If root delete it
            if (focusNode == root)
                root = null;
                // If it was marked as a left child
                // of the parent delete it in its parent
            else if (isItALeftChild)
                parent.lift = null;
                // Vice versa for the right child
            else
                parent.right = null;
        }
        // If no right child
        else if (focusNode.right == null) {
            if (focusNode == root)
                root = focusNode.lift;
                // If focus Node was on the left of parent
                // move the focus Nodes left child up to the
                // parent node
            else if (isItALeftChild)
                parent.lift = focusNode.lift;
                // Vice versa for the right child
            else
                parent.right = focusNode.lift;
        }
        // If no left child
        else if (focusNode.right == null) {
            if (focusNode == root)
                root = focusNode.right;
                // If focus Node was on the left of parent
                // move the focus Nodes right child up to the
                // parent node
            else if (isItALeftChild)
                parent.lift = focusNode.right;
                // Vice versa for the left child
            else
                parent.right = focusNode.right;
        }
        // Two children so I need to find the deleted nodes
        // replacement
        else {
            Node replacement = getReplacementNode(focusNode);
            // If the focusNode is root replace root
            // with the replacement
            if (focusNode == root)
                root = replacement;
                // If the deleted node was a left child
                // make the replacement the left child
            else if (isItALeftChild)
                parent.lift = replacement;
                // Vice versa if it was a right child
            else
                parent.right = replacement;
            replacement.lift = focusNode.lift;
        }
        return true;


    }


    private Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.right;

        // While there are no more left children

        while (focusNode != null) {

            replacementParent = replacement;

            replacement = focusNode;

            focusNode = focusNode.lift;

        }

        // If the replacement isn't the right child
        // move the replacement into the parents
        // leftChild slot and move the replaced nodes
        // right child into the replacements rightChild

        if (replacement != replacedNode.right) {

            replacementParent.lift = replacement.right;
            replacement.right = replacedNode.right;

        }

        return replacement;
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
        BinaryTreeII binaryTree = new BinaryTreeII();
        Node n = new Node("www", 23);
        binaryTree.insert(new Node("Ali", 66));
        binaryTree.insert(new Node("Max", 11));
        binaryTree.insert(n);
        binaryTree.insert(new Node("Lara", 13));
        binaryTree.insert(new Node("Jan", 22));
        binaryTree.insert(new Node("Moh", 33));
        binaryTree.inorderTreeWalk(binaryTree.root);

        binaryTree.deleteNode(n.key);
        System.out.println("_______");
        binaryTree.inorderTreeWalk(binaryTree.root);
        System.out.println("___");
        System.out.println(binaryTree.search(binaryTree.root, 22));

    }
}
