package cn.orz.pascal.example.aspectj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author koduki
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("run");
        Sub1 sub = new Sub1();
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            sub.getProcess();
        }
    }
}
