/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.ejb;

import javax.ejb.Local;

/**
 *
 * @author WINDOWS 10
 */
@Local
public interface CalculatorBeanLocal {
    public double tambah(double value);
    public double kurang(double value);
    public double kali(double value);
    public double reset();
    public double bagi(double value);
    public void setAksi(String aksinya);
    public void setTotal(double value);
    public void setKondisi(boolean kondisinya);
    public String getAksi();
    public double getTotal();
    public boolean getKondisi();
    public double average();
    public int getCount();

}
