import java.util.ArrayList;

/**
 * Binary Search Tree Implementation, it creates an array list tree which has
 * a leftchild, a right child, a parent, prints it in preorder, postorder, inorder,
 * it also has methods to insert, delete and search the tree
 */

public class binaryStreeImplicit {

    ArrayList<mydata> tree = new ArrayList<mydata>(); // holds all the nodes of the binary search tree

    int treeSize; // number of nodes in the binary search tree
    int lastIndexUsed; // the tree may not be complete, so specifies the array bound

    /**
     * @return root returns the index of the root of the tree or negative 1 if tree is empty
     */
    private int root() {
        if (treeSize == 0) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * @param i index of the current node
     * @return leftchild return the index of the left child of a node at index i
     */
    private int leftchild(int i) {
        return (2 * i) + 1;
    }

    /**
     * @param i index of the current node
     * @return leftchild return the index of the right child of a node at index i
     */
    private int rightchild(int i){
        return (2 * i) + 2;
    }

    /**
     * @param i index of the current node
     * @return leftchild return the index of the parent of a node at index i
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * prints data of nodes in inorder one line at a time; prints only the nodes where actual data exists
     * @param i to begin traversal
     */
    public void inorderTraversal(int i){

        if (i < treeSize) {
            inorderTraversal(leftchild(i));
            System.out.print(tree.get(i).stuName + " ");
            inorderTraversal(rightchild(i));
        }

    }

    /**
     * prints data of nodes in a preorder one line at a time; prints only the nodes where actual data exists
     * @param i to begin traversal
     */
    public void preorderTraversal(int i){
        if (i < treeSize) {
            System.out.print(tree.get(i).stuName + " ");
            inorderTraversal(leftchild(i));
            inorderTraversal(rightchild(i));
        }
    }


    /**
     * prints data of nodes in a postordder one line at a time; prints only the nodes where actual data exists
     * @param i to begin traversal
     */
    public void postorderTraversal(int i){
        if (i < treeSize) {
            inorderTraversal(leftchild(i));
            inorderTraversal(rightchild(i));
            System.out.print(tree.get(i).stuName + " ");
        }
    }

    /**
     * inserts x into the tree; returns the index of the array where inserted, or negative 1 if unsuccessful
     * @param x of type mydata
     * @return int return the integer that represents node index in the tree
     */
    public int insert (mydata x) {
        mydata node;
        int i;
        int j;

        i = root(); // start at the root node

        // handle the case where the tree is empty
        if (i == -1) {
            tree.add(0, x);
            treeSize++;
            return i;
        }

        node = tree.get(i);
        while (i < treeSize && node != null) {
            if (x.stuName.compareTo(node.stuName) < 0) {
                i = leftchild(i);
            } else if (x.stuName.compareTo(node.stuName) > 0) {
                i = rightchild(i);
            } else {
                return -1;
            }

            if (i >= treeSize) break;

            node = tree.get(i);
        }

        // add in null nodes to fill the tree
        if (i >= treeSize) {
            for (j = treeSize; j < i; j++) {
                tree.add(j, null);
                treeSize++;
            }
            tree.add(i, x);
            treeSize++;
        } else {
            tree.set(i, x);
        }

        return i;
    }


    /**
     * deletes x from the tree note this
     * may create a hole in the array storing the tree nodes but BST is maintained
     * returns negative 1 if x does not exist, otherwise the index where x was
     * @param x of type mydata
     * @return int return the integer that represents node index in the tree
     */
    public int delete (mydata x) {
        int i;
        int replacement;

        i = search(x);

        if (i == -1) {
            return -1;
        }

        replacement = leftchild(i);
        if (replacement >= treeSize) {
            // there is no left child
            replacement = rightchild(replacement);
            if (replacement >= treeSize) {
                // there is no right child
                tree.set(i, null);
                return i;
            } else {
                // replace i with node at replacement and shift all children up
            }

            return replacement;
        }

        return -1;
    }


    /**
     * returns the index where x exists, otherwise negative 1
     * @param x of type mydata
     * @return int return the integer that represents node index in the tree
     */
    public int search (mydata x) {

        int i;
        mydata node;

        i = root();
        node = tree.get(i);

        while (!x.stuName.equals(node.stuName) && i <= treeSize) {
            if (x.stuName.compareTo(node.stuName) < 0) {
                i = leftchild(i);
            } else if (x.stuName.compareTo(node.stuName) > 0) {
                i = rightchild(i);
            } else {
                return -1;
            }
            node = tree.get(i);
        }

        return i;
    }

}
