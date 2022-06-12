//Реализовать промежуточный проект(каждому дал индивидуально).
//        В нем два maven подмодуля, один -repository,  второй - service. Подключить checkstyle,
//        jacoco.В maven подмодуле repository реализовать маппинг на JPA entity(Hibernate),
//        создать DAO используя параметризацию класса через Generic. Базу создавать через liquibase.
//        Покрыть тестами используя H2(базу накатывать через Hibernate).
//        В maven подмодуле service реализовать подключение maven подмодуля repository.
//        Реализовать класс содердащий main.
//        В main методе наполнить базу тестовыми данными через DAO.


import Entity.Manufacturer;
import Entity.Product;
import Entity.Seller;
import Entity.Supplier;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ApplicationRunner {
    public static void main(String[] args) {

        ManufacturerService ms = new ManufacturerService();
        ProductService ps = new ProductService();
        SellerService ss = new SellerService();
        SupplierService supServ = new SupplierService();

        Product product = Product.builder()
                .name("лопата")
                .description("малая саперная")
                .price(5.0)
                .type("шанцевый инструмент")
                .build();
        Product product1 = Product.builder()
                .name("телефон")
                .type("мобильный")
                .description("без чехла")
                .price(500.0)
                .build();
        Seller seller = Seller.builder()
                .name("BME")
                .address("220001, Minks,Skryganova,2")
                .tel("+375295000000")
                .build();
        Manufacturer manufacturer = Manufacturer.builder()
                .name("Agat")
                .address("220078, Minks,Golodeda,25")
                .brand("AG")
                .build();
        Manufacturer manufacturer2 = Manufacturer.builder()
                .name("MMZ")
                .address("220000, Minsk,Nezavisimosti,1")
                .brand("MMZ")
                .build();
        Seller seller1 = Seller.builder()
                .name("Kanimis")
                .address("221213, Minsk,Cetkin,18")
                .tel("+375290010002")
                .build();
        Supplier supplier = Supplier.builder()
                .name("DANA")
                .address("220003, Minks,Mayak,1")
                .vatNumber("009569812")
                .build();
        Supplier supplier2 = Supplier.builder()
                .name("SevernyiVeter")
                .address("229999, Minsk,Rokossovskogo,15")
                .vatNumber("015678539")
                .build();


        ms.addManufacturer(manufacturer);
        ms.addManufacturer(manufacturer2);
        ps.addProduct(product);
        ps.addProduct(product1);
        supServ.addSupplier(supplier);
        supServ.addSupplier(supplier2);
        ss.addSeller(seller);
        ss.addSeller(seller1);

        Set<Supplier> supplierSet = new HashSet<>();
        Set<Supplier> supplierSet2 = new HashSet<>();
        supplierSet.add(supplier);
        supplierSet2.add(supplier2);

        Set<Seller> sellerSet = new HashSet<>();
        Set<Seller> sellerSet2 = new HashSet<>();
        sellerSet.add(seller);
        sellerSet2.add(seller1);


        product.setSellerSet(sellerSet);
        product1.setSellerSet(sellerSet2);
        product.setSupplierSet(supplierSet);
        product1.setSupplierSet(supplierSet2);
        manufacturer.setProduct(product);
        manufacturer2.setProduct(product1);
        product.setManufacturer(manufacturer);
        product1.setManufacturer(manufacturer2);


        try {
            supServ.dsupplieri.update(supplier);
            supServ.dsupplieri.update(supplier2);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
