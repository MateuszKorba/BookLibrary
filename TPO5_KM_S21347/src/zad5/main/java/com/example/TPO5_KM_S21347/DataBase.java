package com.example.TPO5_KM_S21347;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private String username = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/booksdb";
    static String nameDriver = "com.mysql.cj.jdbc.Driver";

    public List<Book> getBooksTable(){
        Connection connection = null;
        List<Book> listofBooks = new ArrayList<>();
        try{
            connection = createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM booksdb.books");
            while(resultSet.next()){
                listofBooks.add(new Book(resultSet.getInt("id"),resultSet.getString("title"),resultSet.getString("author"),resultSet.getString("genre"),resultSet.getFloat("price")));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listofBooks;
    }

    private Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(nameDriver);
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

}
