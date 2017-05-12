/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.util;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.transaction.UserTransaction;

/**
 *
 * @author huanlu
 */
public class Utxfactory {
    public Utxfactory(){
    }
    
    public UserTransaction getUserTransaction() throws  Exception{
        UserTransaction ut;
        try {
            InitialContext ic = new InitialContext();
            ut = (UserTransaction) ic.lookup("java:/jboss/yueziyouDS");
        } catch (Exception e) {
            throw new ServletException(e);
        }
        return ut;
    }
}
