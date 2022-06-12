package serv;

import DAO.DAOSupplierImpl;
import Entity.Supplier;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/editSupplier")
public class EditSupplierServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOSupplierImpl dsi = new DAOSupplierImpl();
        String param = req.getParameter("id");
        Supplier sup = dsi.read(Integer.parseInt(param));
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/EditSupplier.jsp");
        req.setAttribute("supplier",sup);
        rd.forward(req,resp);
    }
}
