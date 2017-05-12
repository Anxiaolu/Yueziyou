package cn.edu.sdut.softlab.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the book database table.
 *
 */
@ManagedBean(name = "Book")
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    private String barcode;

    private String flag;

    private String introduction;

    private String name;

    private String book_thum;

    private String press;

    private String writer;

    //bi-directional many-to-one association to Book
    @OneToMany(mappedBy = "book")
    private Set<Account> accounts;

    //bi-directional many-to-one association to Category
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    //bi-directional many-to-one association to Stuff
    @ManyToOne(fetch = FetchType.LAZY)
    private Stuff stuff;

    //bi-directional one-to-one association to BorrowReturnRecord
    @OneToOne(mappedBy = "book", fetch = FetchType.LAZY)
    private BorrowReturnRecord borrowReturnRecord;

    //bi-directional one-to-one association to StockIn
    @OneToOne(mappedBy = "book", fetch = FetchType.LAZY)
    private StockIn stockIn;

    public Book() {
    }

    public Book(String flag, String name, String writer) {
        this.flag = flag;
        this.name = name;
        this.writer = writer;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_thum() {
        return book_thum;
    }

    public void setBook_thum(String book_thum) {
        this.book_thum = book_thum;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPress() {
        return this.press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Set<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Stuff getStuff() {
        return this.stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public BorrowReturnRecord getBorrowReturnRecord() {
        return this.borrowReturnRecord;
    }

    public void setBorrowReturnRecord(BorrowReturnRecord borrowReturnRecord) {
        this.borrowReturnRecord = borrowReturnRecord;
    }

    public StockIn getStockIn() {
        return this.stockIn;
    }

    public void setStockIn(StockIn stockIn) {
        this.stockIn = stockIn;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", barcode=" + barcode + ", "
                + "flag=" + flag + ", introduction=" + introduction + ", "
                + "name=" + name + ", book_thum=" + book_thum + ", "
                + "press=" + press + ", writer=" + writer + ", "
                + "category=" + category + ", stuff=" + stuff + '}';
    }

}
