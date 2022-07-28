package serv;

import DAO.DAOSellerImpl;
import Entity.Seller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/AddSeller")
public class AddSellerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOSellerImpl dsi = new DAOSellerImpl();
        PrintWriter pw =resp.getWriter();
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String tel = req.getParameter("tel");
        Seller seller;
        seller = new Seller(name,address,tel);
        try {
            dsi.create(seller);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pw.println("You have successfully added a Manufacturer!");
        resp.setContentType("text/html");
        pw.println("<html><body>");
        pw.println("<a href=\"listAllSellers\">Go back</a>");
        pw.println("</body></html>");
    }
}
