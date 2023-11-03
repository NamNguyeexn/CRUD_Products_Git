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
@WebServlet(name = "DeleteProduct", urlPatterns = {"/deleteProduct"},
        initParams = {@WebInitParam(name = "relativeFile", value = "/WEB-INF/products.txt")})
public class DeleteProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/delete.jsp";
        String file = this.getServletConfig().getInitParameter("relativeFile");
        String path = this.getServletContext().getRealPath(file);
        String productCode = request.getParameter("productCode");
        if(productCode != null){
            Product oldProduct = ProductIO.getProduct(productCode, path);
            request.setAttribute("product", oldProduct);
            String action = request.getParameter("action");
            if(action != null && action.equals("delete")){
                ProductIO.delete(oldProduct, path);
                response.sendRedirect(request.getContextPath() + "/displayProducts");
                return;
            }
        }
        
        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

