package serv;

import DAO.DAOManufacturerImpl;
import Entity.Manufacturer;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateManufacturer")
public class UpdateManufacturerServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOManufacturerImpl dmi = new DAOManufacturerImpl();
        String param = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String brand = req.getParameter("brand");
        Manufacturer manufacturer = Manufacturer.builder()
                .id(Integer.parseInt(param))
                .name(name)
                .address(address)
                .brand(brand)
                .build();
        Manufacturer read = dmi.update(manufacturer);
        resp.sendRedirect(req.getContextPath() + "/listAllManufacturers");

    }
}
