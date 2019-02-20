package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//package and import statements
@Entity
@Table(name="shop")
public class Shop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SHOP_ID")
	private int id;
	@Column(name="SHOP_NAME")
	private String shopName;
	public Shop() {
		super();
		//TODO Auto-generated constructor stub
	}
	public Shop(int id, String shopName) {
		super();
		this.id = id;
		this.shopName = shopName;
	}
	public Shop(String shopName) {
		super();
		this.shopName = shopName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopperName(String shopName) {
		this.shopName = shopName;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", shopName=" + shopName + "]";
	}
}
