package connect;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Locale.Category;

import javax.servlet.http.HttpServletRequest;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.Product;

public class Dao {
	Connect cn = new Connect();
	Connection conn = cn.getConnection();
	
	
	public Vector geUser(String name, String pass) {
		Vector t = new Vector();
		String sqly = "SELECT * FROM users where UserName=? and Password=?";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setString(1, name);
			stmy.setString(2, pass);
			ResultSet rs = stmy.executeQuery();
			if (rs.next()) {
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getString(4));
				t.add(rs.getString(5));
				t.add(rs.getString(6));
				t.add(rs.getString(7));
				t.add(rs.getString(8));
				t.add(rs.getBlob(9));
				t.add(rs.getInt(10));
			}else {
				t = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return t;
	}
	public Vector geRoleOfUser(int id) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM roles where userId=?";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, id);
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getInt(3));
				t.add(rs.getInt(4));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(list);

		return list;
	}
	
	// admin
	
	// client
	
	public Vector getCategoryOfShop(HttpServletRequest request) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM categoryproduct WHERE userId=?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getInt(5));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public Vector getCategoryById(int id) {
		Vector cate = new Vector();
		String sqly = "SELECT * FROM categoryproduct WHERE categoryID=?";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, id);
			ResultSet rs = stmy.executeQuery();
			if (rs.next()) {
				cate.add(rs.getInt(1));
				cate.add(rs.getString(2));
				cate.add(rs.getString(3));
				cate.add(rs.getInt(5));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(cate);
		return cate;
	}
	
	public Vector getCategoryOfShopByName(HttpServletRequest request, String name) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM categoryproduct WHERE userId=? and categoryName like ?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			stmy.setString(2, "%"+name+"%");
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getInt(5));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(list);
		return list;
	}
	
	public void editstatusCategory(int sta, int id) {
		try {
			String sql = "UPDATE categoryproduct SET status =? WHERE categoryID =?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, sta);
			stm.setInt(2, id);
			stm.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public void editCategory(String name, String des, int status, int id) {
		try {
			String sql = "UPDATE categoryproduct SET categoryName=?, categoryDecs=?, status =? WHERE categoryID =?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, des);
			stm.setInt(3, status);
			stm.setInt(4, id);
			stm.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public void insertCategory(String name, String description,int userid, int status) {
		try {
			String sql = "INSERT INTO categoryproduct VALUES(null,?,?,?,?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, description);
			stm.setInt(3, userid);
			stm.setInt(4, status);
			stm.execute();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	
	public Vector getBrandOfShop(HttpServletRequest request) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM brand WHERE userId=?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getInt(5));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public void editstatusBrand(int sta, int id) {
		try {
			String sql = "UPDATE brand SET status =? WHERE brandID =?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, sta);
			stm.setInt(2, id);
			stm.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public void insertBrand(String name, String country,int userid, int status) {
		try {
			String sql = "INSERT INTO brand VALUES(null,?,?,?,?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, country);
			stm.setInt(3, userid);
			stm.setInt(4, status);
			stm.execute();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public Vector getBrandOfShopByName(HttpServletRequest request, String name) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM brand WHERE userId=? and brandName like ?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			stmy.setString(2, "%"+name+"%");
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getInt(5));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(list);
		return list;
	}
	
	public Vector getSex() {
		Vector list = new Vector();
		String sqly = "SELECT * FROM sex";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
	public void insertProduct(String name, String des, int idbrand, int idcate, int idsex, int aff, int userid, int status) {
	    String sql = "INSERT INTO products (name, productdecs, brandID, categoryproductid, sexid, affilatepercent, userid, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    try (PreparedStatement stm = conn.prepareStatement(sql)) {
	        stm.setString(1, name);
	        stm.setString(2, des);
	        stm.setInt(3, idbrand);
	        stm.setInt(4, idcate);
	        stm.setInt(5, idsex);
	        stm.setInt(6, aff);
	        stm.setInt(7, userid);
	        stm.setInt(8, status);
	        stm.executeUpdate(); // Use executeUpdate() for INSERT statements
	    } catch (SQLException e) {
	        e.printStackTrace(); // Handle exception properly
	    }
	}
	
	public void insertImgProduct(int id, InputStream inputStream) {
		try {
			String sql = "INSERT INTO productimages (productid, image) VALUES (?, ?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, id);
			stm.setBlob(2, inputStream);
			stm.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public int getIdNewProduct() {
		String sql = "SELECT MAX(productid) AS max_id FROM products";
	    
	    try (
	         PreparedStatement stm = conn.prepareStatement(sql);
	         ResultSet rs = stm.executeQuery()) {
	        
	        if (rs.next()) {
	            return rs.getInt("max_id"); // or use rs.getInt(1) if column index is used
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Log the exception
	    }
	    
	    return 0; // Default value if no product ID is found
	}
	
	public List<Product> getAllProduct() {
	    List<Product> list = new ArrayList<>();
	    String productSql = "SELECT * FROM products";
	    String imageSql = "SELECT image FROM productimages WHERE productid = ?";
	    PreparedStatement psProduct;
	    PreparedStatement psImage;

	    try {
	        // Fetch all products
	        psProduct = conn.prepareStatement(productSql);
	        ResultSet rsProduct = psProduct.executeQuery();
	      

	        while (rsProduct.next()) {
	            Product pro = new Product();
	            // Set product details
	            pro.setId(rsProduct.getInt("productid"));
	            pro.setName(rsProduct.getString("name"));
	            pro.setProductdecs(rsProduct.getString("productdecs"));
	            pro.setBrandID(rsProduct.getInt("brandid"));
	            pro.setCategoryproductid(rsProduct.getInt("categoryproductid"));
	            pro.setSexid(rsProduct.getInt("sexid"));
	            pro.setAffilatepercent(rsProduct.getInt("affilatepercent"));
	            pro.setUserid(rsProduct.getInt("userid"));
	            pro.setStatus(rsProduct.getInt("status"));

	            // Fetch images for this product
	            psImage = conn.prepareStatement(imageSql);
	            psImage.setInt(1, pro.getId());
	            ResultSet rsImage = psImage.executeQuery();

	            List<Blob> images = new ArrayList<>();
	            while (rsImage.next()) {
	                images.add((Blob) rsImage.getBlob("image"));
	            }
	            pro.setImages(images);

	            list.add(pro);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    System.out.println("Number of products fetched: " + list.size());
	    return list;
	}
	
	public List<Integer> getPrice() {
	    List<Integer> list = new ArrayList<>(); 
	    String sql = "SELECT p.productid, p.name, MIN(pq.price) AS min_price " +
	                 "FROM products p " +
	                 "JOIN productquantity pq ON p.productid = pq.productid " +
	                 "GROUP BY p.productid, p.name;";
	    PreparedStatement st;
	    ResultSet rs;
	    try {
	        st = conn.prepareStatement(sql);
	        rs = st.executeQuery();
	        while (rs.next()) {
	            list.add(rs.getInt("min_price"));  
	        }
	    } catch (Exception e) {
	        e.printStackTrace();  
	    }
	    return list;
	}

	 public List<InputStream> getProductImageById(int productId) {
	        List<InputStream> imageStreams = new ArrayList<>();
	        String sql = "SELECT image FROM product_images WHERE productid = ?";
	        
	        try (PreparedStatement stm = conn.prepareStatement(sql)) {
	            stm.setInt(1, productId);
	            ResultSet rs = stm.executeQuery();
	            
	            while (rs.next()) {
	                InputStream imageStream = rs.getBlob("image").getBinaryStream();
	                imageStreams.add(imageStream);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); 
	        }
	        
	        return imageStreams;
	    }
	 
	 public void insertQuantity(String size, String color, int quantity, int productid, int price) {
		    String sql = "INSERT INTO productquantity (size, color, quantity, productid, price) VALUES (?, ?, ?, ?, ?)";
		    
		    try {
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ps.setString(1, size);
		        ps.setString(2, color);
		        ps.setInt(3, quantity);
		        ps.setInt(4, productid);
		        ps.setInt(5, price);
		        
		      
		        int affectedRows = ps.executeUpdate();
		        
	
		        if (affectedRows > 0) {
		            System.out.println("Insert successful.");
		        } else {
		            System.out.println("Insert failed.");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();

		    }
		}
	
	public Vector getOrderOfShop(HttpServletRequest request) {
		Vector list = new Vector();
		String sqly = "SELECT o.* FROM orders o INNER JOIN orderdetails od ON o.orderCode=od.orderCode INNER JOIN products p on p.productid = od.productId WHERE p.userid=?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getString(1));
				t.add(rs.getString(2));
				t.add(rs.getInt(3));
				t.add(rs.getInt(4));
				t.add(rs.getDouble(5));
				t.add(rs.getInt(6));
				t.add(rs.getString(7));
				t.add(rs.getString(8));
				t.add(rs.getString(9));
				t.add(rs.getInt(10));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(list);
		return list;
	}
	
	public void editstatusOrder(int sta, int id) {
		try {
			String sql = "UPDATE orders SET orderStatusId =? WHERE orderCode =?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, sta);
			stm.setInt(2, id);
			stm.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public Vector getOrderByIdOrder(String id) {
		Vector t = new Vector();
		String sqly = "SELECT * FROM orders WHERE orderCode=?";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setString(1, id);
			ResultSet rs = stmy.executeQuery();
			if (rs.next()) {
				t.add(rs.getString(1));
				t.add(rs.getString(2));
				t.add(rs.getInt(3));
				t.add(rs.getInt(4));
				t.add(rs.getDouble(5));
				t.add(rs.getInt(6));
				t.add(rs.getString(7));
				t.add(rs.getString(8));
				t.add(rs.getString(9));
				t.add(rs.getInt(10));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
	
	public Vector getOrderDetailByIdOrder(String id) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM orderdetails WHERE orderCode=?";
		PreparedStatement stmy;
		Dao dao = new Dao();
		
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setString(1, id);
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getInt(3));
				t.add(rs.getString(4));
				t.add(rs.getString(5));
				t.add(rs.getString(6));
				t.add(rs.getInt(7));
				Vector pro = new Vector();
				pro = dao.getProductByIdProduct(rs.getInt(3));
				t.add(pro.get(1));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public Vector getProductByIdProduct(int id) {
		Vector t = new Vector();
		String sqly = "SELECT * FROM products WHERE productId=?";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, id);
			ResultSet rs = stmy.executeQuery();
			if (rs.next()) {
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getInt(4));
				t.add(rs.getInt(5));
				t.add(rs.getInt(6));
				t.add(rs.getInt(7));
				t.add(rs.getInt(8));
				t.add(rs.getInt(9));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
	
	public Vector getVoucherOfShop(HttpServletRequest request) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM `voucher` WHERE userId=?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getInt(2));
				t.add(rs.getDouble(3));
				t.add(rs.getString(4));
				t.add(rs.getString(5));
				t.add(rs.getDouble(6));
				t.add(rs.getInt(7));
				t.add(rs.getInt(8));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	// customer
	public static void main(String[] args) {
		Dao dao = new Dao();
		List<Product> list = new ArrayList<Product>();
		list = dao.getAllProduct();
		for (Product product : list) {
			System.out.println(product.getImages());
		}
		
	}
	public List<Blob> getImagesByProductId(int productId) {
	    List<Blob> images = new ArrayList<>();
	    String sql = "SELECT image FROM productimages WHERE productid = ?";
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, productId);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            images.add((Blob) rs.getBlob("image"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return images;
	}
}

