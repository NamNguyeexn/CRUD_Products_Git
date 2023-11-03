/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music.product;

import music.business.Product;
import music.data.ProductIO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nam
 */
@WebServlet(name = "ChangeProducts", urlPatterns = {"/addProduct", "updateProduct/*"},
        initParams = {@WebInitParam(name = "relativeFile", value = "/WEB-INF/products.txt")})
public class ChangeProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/add.jsp";
        String file = this.getServletConfig().getInitParameter("relativeFile");
        String path = this.getServletContext().getRealPath(file);
        Product product = new Product();
        String pathInfo = request.getPathInfo();
        String actionAtr = "add";
        if (pathInfo != null) {
            String[] parts = pathInfo.split("/");
            String code = parts[1];
            Product oldProduct = ProductIO.getProduct(code, path);
            request.setAttribute("product", oldProduct);
            actionAtr = "update";
        }
        request.setAttribute("action", actionAtr);
        String action = request.getParameter("action");
        if (action != null) {
            String code = request.getParameter("code").trim();
            String description = request.getParameter("description").trim();
            String priceString = request.getParameter("price").trim();
            double price = Double.parseDouble(priceString);
            if (!code.isEmpty() && !description.isEmpty() && price != 0) {
                product = new Product(code, description, price);
                if(action.equals("add")){
                    ProductIO.insert(product, path);
                }else{
                    ProductIO.update(product, path);
                }
            }
            request.setAttribute("listProduct", ProductIO.getProducts(path));
            response.sendRedirect(request.getContextPath() + "/displayProducts");
            return;
        }
        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
