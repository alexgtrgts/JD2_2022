package serv;


import DAO.DAOProductImpl;
import Entity.Product;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/editProduct")
public class EditProductServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOProductImpl dpi = new DAOProductImpl();
        String param = req.getParameter("id");
        Product read = dpi.read(Integer.parseInt(param));
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/EditProduct.jsp");
        req.setAttribute("product",read);
        rd.forward(req,resp);

    }
}
