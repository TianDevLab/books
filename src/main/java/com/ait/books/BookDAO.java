package com.ait.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {

    public List<Book> findAll() {
        List<Book> books = new ArrayList<Book>();
        Connection c = null;
        String sql = "SELECT * FROM book ORDER BY title";
        try {
            c = ConnectionHelper.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                books.add(processRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return books;
    }

    public Book findById(int id) {
        String sql = "SELECT * FROM book WHERE id = ?";
        Book book = null;
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = processRow(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return book;
    }

    public Book findByName(String title) {
        Book book = null;
        Connection c = null;
        String sql = "SELECT * FROM book as e " +
                "WHERE UPPER(title) LIKE ? " +
                "ORDER BY title";
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, "%" + title.toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book = processRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return book;
    }

    protected Book processRow(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setFormat(rs.getString("format"));
        book.setPublicationDate(rs.getString("publication_date"));
        book.setPublisher(rs.getString("publisher"));
        book.setPublisherURL(rs.getString("publisher_url"));
        book.setImage(rs.getString("image"));
        book.setImageThumb(rs.getString("imagethumb"));
        book.setReview(rs.getString("review"));
        book.setId(rs.getInt("id"));
        return book;
    }

}
