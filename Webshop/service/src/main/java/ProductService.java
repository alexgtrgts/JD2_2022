import DAO.*;
import Entity.Product;

import java.sql.SQLException;

public class ProductService {

    DAOProductImpl daoProductImpl = new DAOProductImpl();

    public void addProduct(Product product) {
        try {
            daoProductImpl.create(product);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
