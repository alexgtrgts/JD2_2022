package serv;

import DAO.DAOProductImpl;
import Entity.Product;

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

@WebServlet(value = "/listAllProducts")
public class ListAllProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOProductImpl dpi = new DAOProductImpl();
        try {
            List<Product> product = dpi.listAll();
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/ListAllProducts.jsp");
            req.setAttribute("product", product);
            rd.forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
