package cn.edu.sdut.softlab.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the category database table.
 *
 */
@ManagedBean(name = "Category")
@Entity
@XmlRootElement
@Table(name = "category")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Size(max = 13)
    @Column(name = "barcode")
    private String barcode;

    @Size(max = 3)
    @Column(name = "name")
    private String name;

    //bi-directional many-to-one association to Book
    @OneToMany(mappedBy = "category")
    private Set<Book> books;
//
//    //bi-directional one-to-one association to StockIn
//    @OneToOne(mappedBy = "categoryBean", fetch = FetchType.LAZY)
//    private StockIn stockIn;

    public Category() {
    }

    public Category(String barcode, String name) {
        this.barcode = barcode;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    public Book addBook(Book book) {
        getBooks().add(book);
        book.setCategory(this);

        return book;
    }
//
//    public Book removeBook(Book book) {
//        getBooks().remove(book);
//        book.setCategory(null);
//
//        return book;
//    }
//    public StockIn getStockIn() {
//        return this.stockIn;
//    }
//
//    public void setStockIn(StockIn stockIn) {
//        this.stockIn = stockIn;
//    }
    @Override
    public String toString() {
        return "Category{" + "barcode=" + barcode + ", name=" + name + '}';
    }

}
