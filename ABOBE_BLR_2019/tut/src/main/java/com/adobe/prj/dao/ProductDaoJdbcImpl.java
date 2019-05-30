package com.adobe.prj.dao;



        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.util.List;

        import com.adobe.prj.entity.Product;

public class ProductDaoJdbcImpl implements ProductDao {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/trg_2019";
    private static String USER = "root";
    private static String PWD = "Welcome123";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addProduct(Product p) throws PersistenceException {
        String SQL = "insert into products (id, name, price, category) values (0,?,?,?)";
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL,USER, PWD);
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getCategory());
            ps.executeUpdate();
        } catch (SQLException e) {
//			e.printStackTrace();
            throw new PersistenceException("unable to add product", e);
        } finally {
            if( con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Product> getProducts() throws FetchException{
        String SQL = "select id, name, price, category from products";
        List<Product> products = new ArrayList<>();
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL,USER, PWD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()) {
                products.add(new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("category")));

            }
        } catch (SQLException e) {
//			e.printStackTrace();
            throw new FetchException("unable to get products", e);
        } finally {
            if( con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return products;
    }

}
