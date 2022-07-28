package serv;


import DAO.DAOManufacturerImpl;
import Entity.Manufacturer;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/editManufacturer")
public class EditManufacturerServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOManufacturerImpl dmi = new DAOManufacturerImpl();
        String param = req.getParameter("id");
        Manufacturer manufacturer = dmi.read(Integer.parseInt(param));
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/EditManufacturer.jsp");
        req.setAttribute("manufacturer",manufacturer);
        rd.forward(req,resp);
    }
}
