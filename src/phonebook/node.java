/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonebook;

/**
 *
 * @author batoolalfouzan
 */

public class node<T> 
{

   public T data;
    public node<T> next;

    public node(T d) 
    {
        this.data = d;
        next = null;

    }

    public T getData() 
    {
        return data;
    }

}

