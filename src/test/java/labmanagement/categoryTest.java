///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import cn.edu.sdut.softlab.model.Category;
//import cn.edu.sdut.softlab.service.categoryFacade;
//import cn.edu.sdut.softlab.util.Utxfactory;
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
//            categoryService.create(new Category("12312312123", "2232322"));
//        } finally {
//            utx.commit();
//        }
//    }
//}
