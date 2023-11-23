
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
        BSTNode<T> p = root;
        BSTNode<T> q = null;
        String SearchKey = key;
        //case 1 if the tree is empty
        if (p == null) {
            return false;
        }
        //case 2 if the key is the root
        if (SearchKey.compareTo(p.key) < 0) {
            q = p;
            p = p.left;

        } else if (SearchKey.compareTo(p.key) > 0) {
            q = p;
            p = p.right;
        } else {
            if (p.right != null && p.left != null) {
                BSTNode<T> j = p.right;
                q = p;
                while (j.left != null) {
                    q = j;
                    j = j.left;
                }
                p.key = j.key;
                p.data = j.data;
                SearchKey = j.key;
                p = j;
            }
            if (p.left != null) {
                p = p.left;

            } else {
                p = p.right;
            }
            if (q == null) {
                root = p;
            } else {
                if (SearchKey.compareTo(q.key) < 0) {
                    q.left = p;
                } else {
                    q.right = p;
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



