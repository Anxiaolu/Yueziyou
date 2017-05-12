///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.edu.sdut.softlab.util;
//
//import cn.edu.sdut.softlab.model.Category;
//import cn.edu.sdut.softlab.service.categoryFacade;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.transaction.UserTransaction;
//import org.junit.Test;
//
///**
// *
// * @author huanlu
// */
//public class categoryTest {
//
//    @Inject
//    EntityManager em;
//
//    @Inject
//    UserTransaction utx;
//
//    @Inject
//    categoryFacade categoryService;
//
//    @Inject
//    Utxfactory utxfactory;
//
//    @Test
//    public void test() throws Exception {
//        try {
//            utx = utxfactory.getUserTransaction();
//            utx.begin();
//            categoryService.create(new Category(1,"1231231", "2s"));
//        } finally {
//            utx.commit();
//        }
//    }
//}
