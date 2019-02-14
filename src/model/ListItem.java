package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="counts")
public class ListItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="QUANTITY")
	private int quantity;
	@Column(name="ITEM")
	private String item;
	@Column(name="PRICE")
	private double price;
	public ListItem(){
	super();
	}
	public ListItem(int quantity, String item, double price){
		super();
		this.quantity = quantity;
		this.item = item;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public String returnItemDetails( ) {
		return "Item:" + item + " Qty: " + quantity + " Price: " + price;
	}
}
