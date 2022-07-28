package serv;

import DAO.DAOSellerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/deleteSeller")
public class DeleteSellerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOSellerImpl dsi = new DAOSellerImpl();
        String param = req.getParameter("id");
        try {
            dsi.delete(Integer.parseInt(param));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //ServletContext context = getServletContext();
        resp.sendRedirect(req.getContextPath() + "/listAllSellers");
        //rd.forward(req,resp);
    }
}
