package serv;

import DAO.DAOSellerImpl;
import Entity.Seller;

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

@WebServlet(value = "/listAllSellers")
public class ListAllSellersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOSellerImpl dsi = new DAOSellerImpl();
        try {
            List<Seller> seller = dsi.listAll();
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/ListAllSellers.jsp");
            req.setAttribute("seller", seller);
            rd.forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
