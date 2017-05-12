/*
 * Copyright 2017 huanlu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.edu.sdut.softlab.controller;

import cn.edu.sdut.softlab.model.Category;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cn.edu.sdut.softlab.service.categoryFacade;
import cn.edu.sdut.softlab.util.Utxfactory;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.UserTransaction;

/**
 *
 * @author huanlu
 */
@Named("categoryManager")
@RequestScoped
public class CategoryController {

    @Inject
    private transient Logger logger;

    @Inject
    private categoryFacade categoryService;

    @Inject
    private EntityManager em;

    @Inject
    Utxfactory utxfactory;

    @Inject
    private UserTransaction utx;

    private Category newCategory = new Category();

    public Category getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(Category newCategory) {
        this.newCategory = newCategory;
    }

    public String addCategory() throws Exception {
        //m.getTransaction();
        //utx = utxfactory.getUserTransaction();
        if (newCategory == null) {
            System.out.println("!!!!!!");
        } else {
            try {
                utx.begin();
                categoryService.create(newCategory);
                logger.log(Level.INFO, "Added {0}", newCategory);
                //em.persist(newCategory);
                //System.out.println(newCategory.toString());
            } finally {
                utx.commit();
            }
        }
        return "index.xhtml?faces-redirect=true";
    }

    public List<Category> getAllCategory() throws Exception {
        utx.begin();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Category.class));
        utx.commit();
        List<Category> categorys = em.createQuery(cq).getResultList();
        for (Category c : categorys) {
            System.out.println(c.toString());
        }

        return categorys;
    }
}
