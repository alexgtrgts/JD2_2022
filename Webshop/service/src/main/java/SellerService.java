import DAO.DAOSellerImpl;
import Entity.Seller;

import java.sql.SQLException;

public class SellerService {

    DAOSellerImpl dselleri = new DAOSellerImpl();

    public void addSeller(Seller seller) {
        try {
            dselleri.create(seller);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
