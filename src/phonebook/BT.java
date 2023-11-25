

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
      
       public boolean findkey(String tkey) {//anoud
        BSTNode<T> p = root;

        while (p != null) {
            current = p;
            if (tkey.compareToIgnoreCase(p.key) == 0) {
                return true;

            } else if (tkey.compareToIgnoreCase(p.key) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        return false;
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
    
    
    
   
    
     public void inOrder() {
        if (root == null) {
            System.out.println("Empty tree");
        } else {
            inOrder((BSTNode<Contact>) root);
        }

    }

    private void inOrder(BSTNode<Contact> p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        System.out.println("key=" + p.key);
        System.out.println(p.data.toString());
        inOrder(p.right);
    }

    public void preOrder() {
        if (root == null) {
            System.out.println("Empty tree");
        } else {
            preOrder((BSTNode<Contact>) root);
        }
    }

    private void preOrder() {
      
        if (p == null) {
            return;
        }
        System.out.println("key=" + p.key);
        System.out.println(p.data.toString());
        preOrder(p.left);
        preOrder(p.right);
    }
    

    public boolean checkPhoneExist(String phone) {
        if (root == null) {
            return false;
        } else {
            return CheckPhoneInorder((BSTNode<Contact>) root, phone);
        }
    }

    private boolean CheckPhoneInorder(BSTNode<Contact> p, String phone) {
        if (p == null) {
            return false;
        }
        boolean ExistInLeft = CheckPhoneInorder(p.left, phone)
        :
      if (ExistInLeft) {
            return true;
        }
        if (p.data.getPhoneNumber().equals(phone)) {
            return true;
        }
        return CheckPhoneInorder(p.right, phone);
    }

    public linkedlist<Contact> SearchByFirstName(String n) {
        linkedlist<Contact> res = new linkedlist<Contact>();
        
      if (root == null) {
            return res;
        }
        RecSearchByFirstName(root, res, n);
        return res;
    }

    private void RecSearchByFirstName(BSTNode<T> p, linkedlist<Contact> res, String n) {
        if (p == null) {
            return;
        }
        RecSearchByFirstName(p.left, res, n);
        //String 
    }

}
