package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="INV_DATE")
	private LocalDate invDate;
	@ManyToOne
	@JoinColumn(name="SHOP_ID")
	private Shop shop;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	 (name="ITEMS_ON_LIST",
	 joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
	 inverseJoinColumns={ @JoinColumn(name="ITEM_ID", referencedColumnName="ID", unique=true) }
	 )
	private List<ListItem> listOfItems;
	public int getId() {
		return id;
	}
	public ListDetails() {	
	}
	public ListDetails(int id, String listName, LocalDate invDate, Shop shop, List<ListItem> listOfItems) {
		this.id = id;
		this.listName = listName;
		this.invDate = invDate;
		this.shop = shop;
		this.listOfItems = listOfItems;
	}
	public ListDetails(String listName, LocalDate invDate, Shop shop, List<ListItem> listOfItems) {
		this.listName = listName;
		this.invDate = invDate;
		this.shop = shop;
		this.listOfItems = listOfItems;
	}
	public ListDetails(String listName, LocalDate invDate, Shop shop) {
		this.listName = listName;
		this.invDate = invDate;
		this.shop = shop;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getInvDate() {
		return invDate;
	}
	public void setInvDate(LocalDate invDate) {
		this.invDate = invDate;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public List<ListItem> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<ListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", invDate=" + invDate + ", shop=" + shop
				+ ", listOfItems=" + listOfItems + "]";
	}

}
