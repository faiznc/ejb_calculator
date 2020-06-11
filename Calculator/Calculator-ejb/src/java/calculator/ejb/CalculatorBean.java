/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.ejb;

import javax.ejb.Stateful;

/**
 *
 * @author WINDOWS 10
 */
@Stateful
public class CalculatorBean implements CalculatorBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private double total = 0;
    private int count = 0;
    private String aksi = "";
    private boolean kondisi;

    @Override
    public double tambah(double value) {
        total += value;
        count++;
        return total;
    }
    @Override
    public double kurang(double value) {
        total = total -  value;
        count++;
        return total;
    }
    @Override
    public double kali(double value) {
        total = total *  value;
        count++;
        return total;
    }
    @Override
    public double bagi(double value) {
        total = total /  value;
        count++;
        return total;
    }
    @Override
    public double reset() {
        total = 0;
        return total;
    }
    
    @Override
    public void setAksi(String aksinya) {
        aksi = aksinya;
    }
    @Override
    public void setTotal(double value) {
        total = value;
    }
    @Override
    public void setKondisi(boolean kondisinya) {
        kondisi = kondisinya;
    }

    @Override
    public String getAksi() {
        return aksi;
    }
    @Override
    public double getTotal() {
        return total;
    }
    @Override
    public boolean getKondisi() {
        return kondisi;
    }
    @Override
    public double average() {
        return total / count;
    }
    @Override
    public int getCount() {
        return count;
    }
}
