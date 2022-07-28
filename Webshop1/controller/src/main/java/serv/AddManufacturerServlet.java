package serv;

import DAO.DAOManufacturerImpl;
import Entity.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/AddManufacturer")
public class AddManufacturerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOManufacturerImpl dmi = new DAOManufacturerImpl();
        PrintWriter pw =resp.getWriter();
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String brand = req.getParameter("brand");
        Manufacturer manufacturer;
        manufacturer = new Manufacturer(name,address,brand);
        try {
            dmi.create(manufacturer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pw.println("You have successfully added a Manufacturer!");
        resp.setContentType("text/html");
        pw.println("<html><body>");
        pw.println("<a href=\"listAllManufacturers\">Go back</a>");
        pw.println("</body></html>");
    }
}
