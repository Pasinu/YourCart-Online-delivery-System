package org.yourcart.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.yourcart.beans.User;
import org.yourcart.model.CartModel;

@WebServlet(name = "increaseQuantity", urlPatterns = {"/increaseQuantity"})
public class increaseQuantity extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartModel cartModel = new CartModel();
        int id = Integer.parseInt(request.getParameter("id"));

        boolean addCart = cartModel.increaseQuantity(id);
        //get login user id
        User user = (User) request.getSession().getAttribute("LoginUser");
        response.getWriter().print(cartModel.getNubmberOfCartsForUser(user.getUserId()));

    }
}
