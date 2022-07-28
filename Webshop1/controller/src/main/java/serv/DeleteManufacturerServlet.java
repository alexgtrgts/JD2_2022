package serv;

import DAO.DAOManufacturerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/deleteManufacturer")
public class DeleteManufacturerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOManufacturerImpl dmi = new DAOManufacturerImpl();
        String param = req.getParameter("id");
        try {
            dmi.delete(Integer.parseInt(param));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //ServletContext context = getServletContext();
        resp.sendRedirect(req.getContextPath() + "/listAllManufacturers");
        //resp.forward(req,resp);
    }
}
