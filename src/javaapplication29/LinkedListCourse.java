/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication29;

import java.util.Arrays;

/**
 *
 * @author KhanhNguyen9872
 */
    
class Node {
    Course data;
    Node next;
    Node(Course data) { 
        this.data = data; 
        this.next = null; 
    }
}
class LinkedListCourse {
    Node head;

    public void add(Course c) {
        Node newNode = new Node(c);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    public boolean delete(String ma) {
        if (head == null) return false;
        if (head.data.getMaKhoaHoc().equals(ma)) {
            head = head.next;
            return true;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.getMaKhoaHoc().equals(ma)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Course searchLinear(String ma) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.getMaKhoaHoc().equals(ma)) return temp.data;
            temp = temp.next;
        }
        return null;
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Danh sách trống!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void bubbleSortByPrice() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data.getGia() > current.next.data.getGia()) {
                    Course temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
    
    public void selectionSortByPrice() {
        if (head == null) return;
        Node current = head;
        while (current != null) {
            Node minNode = current;
            Node r = current.next;
            while (r != null) {
                if (r.data.getGia() < minNode.data.getGia()) {
                    minNode = r;
                }
                r = r.next;
            }
            if (minNode != current) {
                Course temp = current.data;
                current.data = minNode.data;
                minNode.data = temp;
            }
            current = current.next;
        }
    }
    public void insertionSortByPrice() {
        if (head == null || head.next == null) return;

        Node sorted = null;      
        Node current = head;

        while (current != null) {
            Node next = current.next;

            if (sorted == null || sorted.data.getGia() >= current.data.getGia()) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.data.getGia() < current.data.getGia()) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        head = sorted;   
    }
    public Course[] toArray() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        Course[] arr = new Course[count];
        temp = head;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.data;
            temp = temp.next;
        }
        return arr;
    }

    public Course binarySearchByMa(String ma) {
        Course[] arr = toArray();

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = ma.compareTo(arr[mid].getMaKhoaHoc());
            
            if (cmp == 0) {
                return arr[mid];
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }
}
