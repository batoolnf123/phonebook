/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonebook;


public class BSTNode<T> {

    public String key;
    public T data;
    public BSTNode<T> left, right;

    public BSTNode(String k, T val) {//joury
        key = k;
        data = val;
        left = right = null;
    }

    public BSTNode(String k, T val, BSTNode<T> l, BSTNode<T> r) {//joury
        key = k;
        data = val;
        left = l;
        right = r;
    }

  
}
