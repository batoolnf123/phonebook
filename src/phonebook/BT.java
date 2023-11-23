
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

    public boolean findkey(String key) {//joury
        BSTNode<T> p = root;
        if (root == null) {
            return false;
        }
        while (p != null) {
            current = p;
            if (key.compareTo(p.key) == 0) {
                return true;
            } else if (key.compareTo(p.key) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return false;
    }

    public boolean insert(String k, T val) {//joury
        if (root == null) {
            current = root = new BSTNode<T>(k, val);
            return true;
        }

        BSTNode<T> p = current;
        if (findkey(k)) {
            current = p;
            return false;
        }

        BSTNode<T> newv = new BSTNode<T>(k, val);
        if (k.compareTo(current.key) < 0) {
            current.left = newv;

        } else {
            current.right = newv;

        }
        current = newv;
        return true;
    }



