package model;

import java.util.List;

import com.mysql.cj.jdbc.Blob;

public class Product {
	private int id;
	private String name;
	private String productdecs;
	private int brandID;
	private int categoryproductid;
	private int sexid;
	private int affilatepercent;
	private int userid; 
	private int status;
	private List<Blob> images;
	
	public Product() {
		
	}

	public Product(int id, String name, String productdecs, int brandID, int categoryproductid, int sexid,
			int affilatepercent, int userid, int status, List<Blob> images) {
		super();
		this.id = id;
		this.name = name;
		this.productdecs = productdecs;
		this.brandID = brandID;
		this.categoryproductid = categoryproductid;
		this.sexid = sexid;
		this.affilatepercent = affilatepercent;
		this.userid = userid;
		this.status = status;
		this.images = images;
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductdecs() {
		return productdecs;
	}

	public void setProductdecs(String productdecs) {
		this.productdecs = productdecs;
	}

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}

	public int getCategoryproductid() {
		return categoryproductid;
	}

	public void setCategoryproductid(int categoryproductid) {
		this.categoryproductid = categoryproductid;
	}

	public int getSexid() {
		return sexid;
	}

	public void setSexid(int sexid) {
		this.sexid = sexid;
	}

	public int getAffilatepercent() {
		return affilatepercent;
	}

	public void setAffilatepercent(int affilatepercent) {
		this.affilatepercent = affilatepercent;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Blob> getImages() {
		return images;
	}

	public void setImages(List<Blob> images) {
		this.images = images;
	}

	
}
