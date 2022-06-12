package serv;

import DAO.DAOSupplierImpl;
import Entity.Supplier;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateSupplier")
public class UpdateSupplierServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOSupplierImpl dsi = new DAOSupplierImpl();
        String param = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String vatNumber = req.getParameter("vatnumber");
        Supplier supplier = Supplier.builder()
                .id(Integer.parseInt(param))
                .name(name)
                .address(address)
                .vatNumber(vatNumber)
                .build();
        Supplier supplier1 = dsi.update(supplier);
        resp.sendRedirect(req.getContextPath()+"/listAllSuppliers");
    }
}
