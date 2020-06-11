/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.web;

import calculator.ejb.CalculatorBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WINDOWS 10
 */
@WebServlet(name = "Calculator", urlPatterns = {"/Calculator"})

public class Calculator extends HttpServlet {

    CalculatorBeanLocal calculatorBean = lookupCalculatorBeanLocal();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            double total = 0;
            double average = 0;
            int count = 0;
            boolean kondisi = calculatorBean.getKondisi();
            String requestnya = calculatorBean.getAksi();
            String display = "";

            if (request.getParameter("Add") != null) {

                if (kondisi) {
                    if (requestnya == "Tambah") {
                        total = calculatorBean.tambah(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Kurang") {
                        total = calculatorBean.kurang(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Kali") {
                        total = calculatorBean.kali(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Bagi") {
                        total = calculatorBean.bagi(Double.parseDouble(request.getParameter("value")));
                    }
                } else {
                    calculatorBean.setTotal(Double.parseDouble(request.getParameter("value")));
                }
                calculatorBean.setAksi("Tambah");
                total = 0;
                calculatorBean.setKondisi(true);
                display = "";
//                total = calculatorBean.tambah(Double.parseDouble(request.getParameter("value")));
            }
            if (request.getParameter("Reset") != null) {
                total = calculatorBean.reset();
                calculatorBean.setKondisi(false);
                display = "";
            }
            if (request.getParameter("Sub") != null) {
                if (kondisi) {
                    if (requestnya == "Tambah") {
                        total = calculatorBean.tambah(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Kurang") {
                        total = calculatorBean.kurang(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Kali") {
                        total = calculatorBean.kali(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Bagi") {
                        total = calculatorBean.bagi(Double.parseDouble(request.getParameter("value")));
                    }
                } else {
                    calculatorBean.setTotal(Double.parseDouble(request.getParameter("value")));
                    //total = calculatorBean.kurang(Double.parseDouble(request.getParameter("value")));
                }
                calculatorBean.setAksi("Kurang");
                total = 0;
                calculatorBean.setKondisi(true);
                display = "";
            }
            if (request.getParameter("Mul") != null) {
                if (kondisi) {
                    if (requestnya == "Tambah") {
                        total = calculatorBean.tambah(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Kurang") {
                        total = calculatorBean.kurang(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Kali") {
                        total = calculatorBean.kali(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Bagi") {
                        total = calculatorBean.bagi(Double.parseDouble(request.getParameter("value")));
                    }
                } else {
                    calculatorBean.setTotal(Double.parseDouble(request.getParameter("value")));
                    // total = calculatorBean.kali(Double.parseDouble(request.getParameter("value")));
                }
                calculatorBean.setAksi("Kali");
                total = 0;
                calculatorBean.setKondisi(true);
                display = "";
            }
            if (request.getParameter("Div") != null) {
                if (kondisi) {
                    if (requestnya == "Tambah") {
                        total = calculatorBean.tambah(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Kurang") {
                        total = calculatorBean.kurang(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Kali") {
                        total = calculatorBean.kali(Double.parseDouble(request.getParameter("value")));
                    } else if (requestnya == "Bagi") {
                        total = calculatorBean.bagi(Double.parseDouble(request.getParameter("value")));
                    }
                } else {
                    calculatorBean.setTotal(Double.parseDouble(request.getParameter("value")));
                    // total = calculatorBean.bagi(Double.parseDouble(request.getParameter("value")));
                }
                calculatorBean.setAksi("Bagi");
                total = 0;
                calculatorBean.setKondisi(true);
                display = "";
            }

            total = calculatorBean.getTotal();

//            requestnya = calculatorBean.getAksi();
            if (request.getParameter("Hasil") != null) {
                calculatorBean.setKondisi(false);
                if ("Tambah".equals(requestnya)) {
                    total = calculatorBean.tambah(Double.parseDouble(request.getParameter("value")));
                }
                if ("Kurang".equals(requestnya)) {
                    total = calculatorBean.kurang(Double.parseDouble(request.getParameter("value")));
                }
                if ("Kali".equals(requestnya)) {
                    total = calculatorBean.kali(Double.parseDouble(request.getParameter("value")));
                }
                if ("Bagi".equals(requestnya)) {
                    total = calculatorBean.bagi(Double.parseDouble(request.getParameter("value")));
                }
                display = String.valueOf(total);
            }

            PrintWriter out = response.getWriter();
            //Debugging mode
//            out.println("Operasi: " + requestnya + "<br />");
//            out.println("Total: " + total + "<br />");
//            out.println("kondisi: " + kondisi + "<br />");
//            out.println("display: " + display + "<br />");

            // Kirim variabel ke halaman
            out.println("<script>");
            out.println("teksnya = " + total + ";");
            out.println("requestnya = " + requestnya + ";");
            out.println("display = " + display + ";"); //delete
            out.println("kondisi = " + kondisi + ";");
            out.println("</script>");

// out.println("");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");

            rd.include(request, response);
        } catch (IOException | NumberFormatException | ServletException ex) {
            PrintWriter out = response.getWriter();

//            out.println("Error: " + ex.getMessage() + "<br />Silahkan isi field dengan angka");
            double total = calculatorBean.getTotal();
            out.println("Total: " + total + "<br />");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");

            if (request.getParameter("Add") != null) {
                calculatorBean.setAksi("Tambah");
            }
            if (request.getParameter("Sub") != null) {
                calculatorBean.setAksi("Kurang");
            }
            if (request.getParameter("Div") != null) {
                calculatorBean.setAksi("Bagi");
            }
            if (request.getParameter("Mul") != null) {
                calculatorBean.setAksi("Kali");
            }
            rd.include(request, response);
        } finally {
            PrintWriter out = response.getWriter();
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private CalculatorBeanLocal lookupCalculatorBeanLocal() {
        try {
            Context c = new InitialContext();
            return (CalculatorBeanLocal) c.lookup("java:global/Calculator/Calculator-ejb/CalculatorBean!calculator.ejb.CalculatorBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
