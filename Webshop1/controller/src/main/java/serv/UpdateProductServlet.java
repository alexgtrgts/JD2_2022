package serv;

import DAO.DAOProductImpl;
import Entity.Product;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateProduct")
public class UpdateProductServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOProductImpl dpi = new DAOProductImpl();
        String param = req.getParameter("id");
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String desc = req.getParameter("description");
        String price = req.getParameter("price");
        Product product = Product.builder()
                .id(Integer.parseInt(param))
                .name(name)
                .type(type)
                .description(desc)
                .price(Double.parseDouble(price))
                .build();
        Product read = dpi.update(product);
        resp.sendRedirect(req.getContextPath()+"/listAll");

    }
}
