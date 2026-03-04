/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication29;

import java.util.*;

/**
 *
 * @author KhanhNguyen9872
 */
public class CourseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListCourse list = new LinkedListCourse();
        BSTCourse bst = new BSTCourse();
        Stack<String> historyStack = new Stack<>();
        Queue<Course> pendingQueue = new LinkedList<>();

        System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ KHÓA HỌC ");

        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: 
                    System.out.print("Mã KH: ");
                    String ma = sc.nextLine();
                    System.out.print("Loại (online/offline): ");
                    String loai = sc.nextLine();
                    System.out.print("Giá: ");
                    double gia = sc.nextDouble();
                    sc.nextLine();

                    Course c = new Course(ma, loai, gia);
                    list.add(c);
                    bst.insert(c);
                    pendingQueue.add(c);
                    historyStack.push("ADD: " + ma);
                    System.out.println("Đã thêm!");
                    break;

                case 2:  
                    System.out.print("Mã KH xóa: ");
                    String maX = sc.nextLine();
                    if (list.delete(maX)) {
                        bst.rebuildFromList(list);
                        historyStack.push("Xóa: " + maX);
                        System.out.println("Đã xóa!");
                    } else System.out.println("Không tìm thấy!");
                    break;

                case 3: 
                    System.out.print("Mã KH sửa: ");
                    String maS = sc.nextLine();
                    Course f = list.searchLinear(maS);
                    if (f != null) {
                        System.out.print("Loại mới: ");
                        f.setLoai(sc.nextLine());
                        System.out.print("Giá mới: ");
                        f.setGia(sc.nextDouble());
                        sc.nextLine();
                        bst.rebuildFromList(list);
                        historyStack.push("Cập nhật: " + maS);
                        System.out.println("Đã sửa!");
                    } else System.out.println("Không tìm thấy!");
                    break;

                case 4:
                    System.out.print("Mã KH tìm tuyến tính: ");
                    System.out.println(list.searchLinear(sc.nextLine()));
                    break;
                case 5:
                    System.out.print("Mã KH tìm nhị phân: ");
                    String maBS = sc.nextLine();
                    Course kq = list.binarySearchByMa(maBS);
                    if (kq != null) {
                        System.out.println(kq);
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;
                case 6:
                    System.out.print("Mã KH tìm BST: ");
                    Course res = bst.search(sc.nextLine());
                    System.out.println(res != null ? res : "Không tìm thấy");
                    break;
                case 7: 
                    list.bubbleSortByPrice(); 
                    bst.rebuildFromList(list);
                    System.out.println("Sắp xếp nổi bọt xong!");
                    break ; 
                case 8: 
                    list.selectionSortByPrice();
                    bst.rebuildFromList(list); 
                    System.out.println("Sắp xếp lựa chọn xong!");
                    break ; 
                case 9:
                    list.insertionSortByPrice(); 
                    bst.rebuildFromList(list);
                    System.out.println("Sắp xếp chèn xong!");
                    break ;
                case 10:
                    list.printAll(); 
                    break ;
                case 11:
                    bst.inorder(); 
                    break ;
                case 12: 
                    System.out.println("Mã KH thêm queue: ");
                    Course qc = list.searchLinear(sc.nextLine()); 
                    if(qc != null){
                        pendingQueue.add(qc); 
                        System.out.println("Đã thêm queue!");
                    }else{
                        System.out.println("Không tìm thấy!");
                    }
                    break ; 
                case 13:
                    if(!pendingQueue.isEmpty()){
                        System.out.println("Xử lý: " + pendingQueue.poll());
                    }else{
                        System.out.println("Queue trống!");
                    }
                    break ; 
                case 14: 
                    if(!historyStack.isEmpty()){
                        System.out.println("Last: "+ historyStack.pop());
                    }else{
                        System.out.println("Không có lịch sử!");
                    }
                    break ; 
                case 0: 
                    System.out.println("Cảm ơn bạn!");
                    sc.close();
                    return; 
                default:
                    System.out.println("Lựa chọn sai!");
            }
        }
    }
    private static void showMenu() {
        System.out.println("\n---------------------------");
        System.out.println("1. Thêm khóa học");
        System.out.println("2. Xóa khóa học");
        System.out.println("3. Sửa khóa học");
        System.out.println("4. Tìm kiếm tuyến tính");
        System.out.println("5. Tìm kiếm nhị phân theo mã");
        System.out.println("6. Tìm kiếm BST");
        System.out.println("7. Sắp xếp nổi bọt theo giá");
        System.out.println("8. Sắp xếp lựa chọn theo giá");
        System.out.println("9. Sắp xếp chèn theo giá");
        System.out.println("10. Hiển thị danh sách LinkedList");
        System.out.println("11. Hiển thị BST");
        System.out.println("12. Thêm vào Queue chờ");
        System.out.println("13. Xử lý Queue");
        System.out.println("14. Xem lịch sử");
        System.out.println("0. Thoát");
        System.out.print("Nhập lựa chọn: ");
    }
}
