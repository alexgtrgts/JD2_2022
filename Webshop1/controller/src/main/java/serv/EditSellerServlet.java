package serv;


import DAO.DAOSellerImpl;
import Entity.Seller;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/editSeller")
public class EditSellerServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOSellerImpl dsi = new DAOSellerImpl();
        String param = req.getParameter("id");
        Seller seller = dsi.read(Integer.parseInt(param));
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/EditSeller.jsp");
        req.setAttribute("seller", seller);
        rd.forward(req, resp);

    }
}
