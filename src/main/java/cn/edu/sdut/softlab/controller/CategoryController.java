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
    private UserTransaction utx;

    private Category newCategory = new Category();

    public Category getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(Category newCategory) {
        this.newCategory = newCategory;
    }

    public String addCategory() throws Exception {
        try {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            utx.begin();
            categoryService.create(newCategory);
            //logger.log(Level.INFO, "Added {0}", newCategory);
            return "";
        } finally {
            utx.commit();
        }
    }

    public List<Category> getAllCategory() throws Exception {
        try {
            utx.begin();
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Category.class));
            return em.createQuery(cq).getResultList();
        } finally {
            utx.commit();
        }
    }
}
