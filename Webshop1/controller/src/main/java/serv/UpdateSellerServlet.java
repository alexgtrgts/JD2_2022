package serv;

import DAO.DAOSellerImpl;
import Entity.Seller;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateSeller")
public class UpdateSellerServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOSellerImpl dsi = new DAOSellerImpl();
        String param = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String tel = req.getParameter("tel");
        Seller seller = Seller.builder()
                .id(Integer.parseInt(param))
                .name(name)
                .address(address)
                .tel(tel)
                .build();
        Seller read = dsi.update(seller);
        resp.sendRedirect(req.getContextPath() + "/listAllSellers");
    }
}
