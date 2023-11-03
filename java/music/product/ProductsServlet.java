/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music.product;

import music.business.Product;
import music.data.ProductIO;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "ProductServlet", urlPatterns = {"/displayProducts"},
        initParams = {@WebInitParam(name = "relativeFile", value = "/WEB-INF/products.txt")})
public class ProductsServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/view.jsp";
        String file = this.getServletConfig().getInitParameter("relativeFile");
        String path = this.getServletContext().getRealPath(file);
        ArrayList<Product> listProduct = new ArrayList<Product>();
        listProduct = ProductIO.getProducts(path);
        request.setAttribute("listProduct", listProduct);
        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

