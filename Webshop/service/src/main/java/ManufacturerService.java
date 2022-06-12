import DAO.DAOManufacturerImpl;
import Entity.Manufacturer;
import Entity.Product;

import java.sql.SQLException;

public class ManufacturerService {

    DAOManufacturerImpl dmi = new DAOManufacturerImpl();

    public void addManufacturer(Manufacturer manufacturer) {
        try {
            dmi.create(manufacturer);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addProductId(Product product) {

    }
}
