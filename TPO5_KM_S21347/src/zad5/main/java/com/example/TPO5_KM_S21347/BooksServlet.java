package com.example.TPO5_KM_S21347;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class BooksServlet extends HttpServlet {

    public BooksServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DataBase dataBase = new DataBase();
        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks = dataBase.getBooksTable();
        request.setAttribute("books",listOfBooks);
        request.getRequestDispatcher("books.jsp").forward(request, response);
    }

    public void destroy() {}
}