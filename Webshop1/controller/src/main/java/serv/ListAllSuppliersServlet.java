package serv;

import DAO.DAOSupplierImpl;
import Entity.Supplier;

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

@WebServlet(value = "/listAllSuppliers")
public class ListAllSuppliersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOSupplierImpl dsi = new DAOSupplierImpl();
        try {
            List<Supplier> supplierList = dsi.listAll();
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/ListAllSuppliers.jsp");
            req.setAttribute("supplier",supplierList);
            rd.forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
