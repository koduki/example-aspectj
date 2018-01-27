package cn.orz.pascal.example.aspectj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Dummy Class.
 *
 * @author koduki
 */
public class Sub1 {

    private long count = 0;

    public void getProcess() {
        getPrivateProcess();
    }

    private void getPrivateProcess() {
        if (count % 3 == 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        count += 1;
    }
}
