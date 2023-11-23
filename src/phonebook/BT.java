
public class BST<T> {

    BSTNode<T> root, current;

    /**
     * Creates a new instance of BST
     */
    public BST() {//joury
        root = current = null;
    }

    public boolean empty() {//joury
        return root == null;
    }

    public boolean full() {//joury
        return false;
    }

    public T retrieve() {//joury
        return current.data;
    }

    public void clear() {//joury
        current = root = null;
    }

     public boolean findkey(String tkey) {//anoud
        BSTNode<T> p = root, q = root;
        if (empty()) {
            return false;
        }

        while (p != null) {
            q = p;
            if (tkey.compareToIgnoreCase(p.key) == 0) {
                current = p;
                return true;
            } else if (tkey.compareToIgnoreCase(p.key) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        current = q;
        return false;
    }
    
      public boolean insert(String k, T val) {//anoud
        BSTNode<T> p = current;
        BSTNode<T> newNode = new BSTNode<T>(k, val);

        if (empty()) {
            current = root = newNode;
        }

        if (findkey(k)) {
            current = p; // find key modified current so return it
            return false; // key already in the BST cant insert
        }

        if (k.compareToIgnoreCase(current.key) < 0) {
            current.left = newNode;

        } else {
            current.right = newNode;
        }
        current = newNode;
        return true;

    }

    public boolean remove(String key) {//joury
        BSTNode<T> pointer = root;
        BSTNode<T> q = null;
        String SearchKey = key;
        //case 1 if the tree is empty
        if (pointer == null) {
            return false;
        }
        //case 2 if the key is the root
        if (SearchKey.compareTo(pointer.key) < 0) {
            q = pointer;
            pointer = pointer.left;

        } else if (SearchKey.compareTo(pointer.key) > 0) {
            q = pointer;
            pointer = pointer.right;
        } else {
            if (pointer.right != null && pointer.left != null) {
                BSTNode<T> j = pointer.right;
                q = pointer;
                while (j.left != null) {
                    q = j;
                    j = j.left;
                }
                pointer.key = j.key;
                pointer.data = j.data;
                SearchKey = j.key;
                pointer = j;
            }
            if (pointer.left != null) {
                pointer = pointer.left;

            } else {
                pointer = pointer.right;
            }
            if (q == null) {
                root = pointer;
            } else {
                if (SearchKey.compareTo(q.key) < 0) {
                    q.left = pointer;
                } else {
                    q.right = pointer;
                }
            }
            current = root;
            return true;
        }

        return false;
    }

  
   


