/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author huanlu
 */
@ManagedBean(name = "index_bigpic")
@Entity
@Table(name = "index_bigpic")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Index_bigpic.findAll", query = "SELECT i FROM index_bigpic i")
})
public class index_bigpic implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    Integer id;

    @NotNull
    @Size(max = 30)
    @Column(name = "name")
    String name;

    @NotNull
    @Size(max = 50)
    @Column(name = "thumb")
    String thumb;
    
    @NotNull
    @Size(max = 13)
    @Column(name = "operator")
    String operator;

    public index_bigpic(String name, String thumb, String operator) {
        this.name = name;
        this.thumb = thumb;
        this.operator = operator;
    }

    public index_bigpic() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "index_bigpic{" + "id=" + id + ", name=" + name + ", thumb=" + thumb + ", operator=" + operator + '}';
    }

}
