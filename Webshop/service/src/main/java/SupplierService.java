import DAO.DAOSupplierImpl;
import Entity.Supplier;

import java.sql.SQLException;

public class SupplierService {

    DAOSupplierImpl dsupplieri = new DAOSupplierImpl();

    public void addSupplier(Supplier supplier) {
        try {
            dsupplieri.create(supplier);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
