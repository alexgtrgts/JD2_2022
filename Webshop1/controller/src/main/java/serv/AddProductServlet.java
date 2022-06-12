package serv;

import DAO.DAOProductImpl;
import Entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/AddProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOProductImpl dpi = new DAOProductImpl();
        PrintWriter pw =resp.getWriter();
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        Product product;
        product = new Product(name,Double.parseDouble(price),type,description);
        try {
            dpi.create(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pw.println("You have successfully added a product!");
        resp.setContentType("text/html");
        pw.println("<html><body>");
        pw.println("<a href=\"listAll\">Go back</a>");
        pw.println("</body></html>");
    }
}
