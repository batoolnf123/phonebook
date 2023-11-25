/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonebook;


public class BSTNode {
    //joury

     public int key;
public T data;
public BSTNode<T> left, right;
/** Creates a new instance of BSTNode */
public BSTNode(int k, T val) {
key = k;
data = val;
left = right = null;
}
public BSTNode(int k, T val, BSTNode<T> l, BSTNode<T> r) {
key = k;
data = val;
left = l;
right = r;
}
public void inOrder(){
    if(root==null)
        System.out.println("Empty tree");
    else
        inOrder((BSTNode<Contact>)root);
             
}
  private void inOrder(BSTNode<Contact>p) {
      if(p==null)
          return;
      inOrder(p.left);
      System.out.println("key="+p.key);
      System.out.println(p.data.toString());
      inOrder(p.right);
  }
  public void preOrder(){
      if(root==null)
          System.out.println("Empty tree");
      else
          preOrder((BSTNode<Contact>)root);
  }
  private void preOrder(){
      if (p==null)
          return;
      System.out.println("key="+p.key);
      System.out.println(p.data.toString());
      preOrder(p.left);
      preOrder(p.right);
  }
  public boolean checkPhoneExist(String phone){
      if(root==null)
          return false;
      else
          return CheckPhoneInorder((BSTNode<Contact>)root,phone);
  }
  private boolean CheckPhoneInorder(BSTNode<Contact>p,String phone){
      if(p==null)
          return false;
      boolean ExistInLeft=CheckPhoneInorder(p.left,phone):
      if(ExistInLeft)
          return true;
      if(p.data.getPhone_num().equals(phone))
          return true;
      return CheckPhoneInorder(p.right,phone);
  }
  public LinkedList<Contact> SearchByFirstName(String n){
      LinkedList<Contact> res=new LinkedList<Contact>():
      if(root==null)
          return res;
      RecSearchByFirstName(root,res,n);
      return res;
  }
  private void RecSearchByFirstName(BSTNode<T>p,LinkedList<Contact>res,String n)
  {
      if(p==null)
          return;
      RecSearchByFirstName(p.left,res,n);
      String 
  }
}
