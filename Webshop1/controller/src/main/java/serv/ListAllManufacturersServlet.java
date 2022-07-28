package serv;

import DAO.DAOManufacturerImpl;
import Entity.Manufacturer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/listAllManufacturers")
public class ListAllManufacturersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOManufacturerImpl dmi = new DAOManufacturerImpl();
        try {
            List<Manufacturer> manufacturer = dmi.listAll();
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/ListAllManufacturers.jsp");
            req.setAttribute("manufacturer", manufacturer);
            rd.forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
