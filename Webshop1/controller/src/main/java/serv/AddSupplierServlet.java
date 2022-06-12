package serv;

import DAO.DAOSupplierImpl;
import Entity.Supplier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(value = "/AddSupplier")
public class AddSupplierServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOSupplierImpl dsi = new DAOSupplierImpl();
        PrintWriter pw = resp.getWriter();
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String vatNumber = req.getParameter("vatnumber");
        Supplier sup = new Supplier(name,address,vatNumber);
        try {
            dsi.create(sup);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pw.println("You have successfully added a supplier!");
        resp.setContentType("text/html");
        pw.println("<html><body>");
        pw.println("<br>");
        pw.println("<a href=\"index.jsp\">Go back</a>");
        pw.println("<br>");
        pw.println("</body></html>");
    }
}
