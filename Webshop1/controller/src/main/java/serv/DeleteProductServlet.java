package serv;

import DAO.DAOProductImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOProductImpl dpi = new DAOProductImpl();
        String param = req.getParameter("id");
        try {
            dpi.delete(Integer.parseInt(param));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //ServletContext context = getServletContext();
        resp.sendRedirect(req.getContextPath() + "/listAllProducts");
        //rd.forward(req,resp);
    }
}
