/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication29;

/**
 *
 * @author KhanhNguyen9872
 */
public class BSTCourse {
    private static class BSTNode{
        Course data ; 
        BSTNode left , right ; 
        BSTNode(Course data){
            this.data = data ;
        }
    }    
    private BSTNode root ; 
    public void insert(Course c){
        root = insertRec(root, c); 
    }
    private BSTNode insertRec(BSTNode root , Course c){
        if(root == null){
            return new BSTNode(c); 
        }
        if(c.compareTo(root.data) < 0){
            root.left = insertRec(root.left , c) ; 
        }
        else if (c.compareTo(root.data) > 0){
            root.right = insertRec(root.right, c) ; 
        }
        return root ; 
    }
    public Course search(String ma){
        return searchRec(root , ma);
    }
    private Course searchRec(BSTNode root , String ma){
        if(root == null){
            return null ; 
        }
        int cmp = ma.compareTo(root.data.getMaKhoaHoc());
        if(cmp == 0 ){
            return root.data ; 
        }
        if(cmp < 0){
            return searchRec(root.left , ma); 
        }
        return searchRec(root.right , ma);
    }
    public void inorder(){
        inorderRec(root); 
    }
    private void inorderRec(BSTNode root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }
    public void rebuildFromList(LinkedListCourse list) {
        root = null;
        Node temp = list.head;   
        while (temp != null) {
            insert(temp.data);
            temp = temp.next;
        }
    }
}
