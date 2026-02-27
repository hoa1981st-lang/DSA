/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication29;

/**
 *
 * @author KhanhNguyen9872
 */
public class Course {
    private String maKhoaHoc ; 
    private String loai ; 
    private double gia ; 
    
    public Course(String ma , String loai , double gia){
        this.maKhoaHoc = ma ; 
        this.loai = loai ;
        this.gia = gia ;
    }
    
    public String getMaKhoaHoc(){
        return maKhoaHoc ; 
    }
    public String getLoai(){
        return loai ;
    }
    public double getGia(){
        return gia ;
    }
    public void setLoai(String loai){
        this.loai = loai ; 
    }
    public void setGia(double gia){
        this.gia = gia ;
    }
    public int compareTo(Course other){
        return this.maKhoaHoc.compareTo(other.maKhoaHoc); 
    }
    @Override 
    public String toString(){
        return String.format("Mã: %s | Loại: %s | Gía: %.0f", maKhoaHoc , loai , gia); 
    }
}
