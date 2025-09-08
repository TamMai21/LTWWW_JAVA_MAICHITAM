package com.example.tuan03.controller;

import com.example.tuan03.model.CartBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "cartController", urlPatterns = {"/bai4/cart"})
public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // CartController.java - các hàm xử lý trong CartController.java
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strAction = request.getParameter("action");

        if (strAction != null && !strAction.equals("")) {
            if (strAction.equals("add")) {
                addToCart(request);
            } else if (strAction.equals("Update")) {
                updateCart(request);
            } else if (strAction.equals("Delete")) {
                deleteCart(request);
            }
        }
        response.sendRedirect("/ShoppingCartJSPSession/ShoppingCart.jsp");
    }

    protected void deleteCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strItemIndex = request.getParameter("itemindex");
        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
        }
        cartBean.deleteCartItem(strItemIndex);
    }

    protected void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strQuantity = request.getParameter("quantity");
        String strItemIndex = request.getParameter("itemindex");

        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
        }
        cartBean.updateCartItem(strItemIndex, strQuantity);
    }

    protected void addToCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strModelNo = request.getParameter("modelNo");
        String strDescription = request.getParameter("description");
        String strPrice = request.getParameter("price");
        String strQuantity = request.getParameter("quantity");

        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");

        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
            session.setAttribute("cart", cartBean);
        }

        cartBean.addCartItem(strModelNo, strDescription, strPrice, strQuantity);
    }
}