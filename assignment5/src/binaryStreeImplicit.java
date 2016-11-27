import java.util.ArrayList;

/**
 * Created by mkravtsova on 11/26/16.
 */

public class binaryStreeImplicit {

    ArrayList<mydata> tree = new ArrayList<mydata>(); // holds all the nodes of the binary search tree

    int treeSize; // number of nodes in the binary search tree
    int lastIndexUsed; // the tree may not be complete, so specifies the array bound

    //returns the index of the root of the tree or -1 if tree is empty
    int root() {
        if (treeSize == 0) {
            return -1;
        } else {
            return 0;
        }
    }

    // return the index of the left child of a node at index i
    int leftchild(int i) {
        return (2 * i) + 1;
    }

    // return the index of the right child of a node at index i
    int rightchild(int i){
        return (2 * i) + 2;
    }

    // return the index of the parent of a node at index i
    int parent(int i) {
        return (i - 1) / 2;
    }

    // prints data of nodes one line at a time; prints only the nodes where actual data exists (i.e., no holes)
    void inorderTraversal(){

    }

    // prints data of nodes one line at a time; prints only the nodes where actual data exists (i.e., no holes)
    void preorderTraversal(){

    }

    // prints data of nodes one line at a time; prints only the nodes where actual data exists (i.e., no holes)
    void postorderTraversal(){

    }

    // inserts x into the tree; returns the index of the array where inserted, or -1 if unsuccessful
    int insert (mydata x) {
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
            // go left?
            if (x.stuName.compareTo(node.stuName) < 0) {
                i = leftchild(i);
            } else if (x.stuName.compareTo(node.stuName) > 0) { // go right
                i = rightchild(i);
            } else { // value already exists
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

    // deletes x from the tree – note this
    // may create “hole” in the array storing the tree nodes but BST is
    // maintained; returns -1 if x doesn’t exist, otherwise the index where x was
    int delete (mydata x) {

        return -1;
    }

    // returns the index where x exists, otherwise -1
    // add any other private / public methods that may help manipulation of BST
    int search (mydata x) {
        return -1;
    }

}
