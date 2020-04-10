package t1908e;

import t1908e.entity.Article;
import t1908e.helper.ConnectionHelper;

import java.sql.*;
import java.util.ArrayList;

public class MainThread {

    public static void main(String[] args) {
        loadArticleById(81);
        loadArticleById(82);
        loadArticleById(83);
        loadArticleById(84);
        loadArticleById(85);
    }

    public static Article loadArticleById(int id) {
        System.out.println(String.format("Loading data by id: %d ...", id));
        try {
            String queryString = "select id, url, title, status from articles where id = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(queryString);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { // chuyển con trỏ xuống dòng tiếp theo.
                String url = resultSet.getString("url");
                String title = resultSet.getString("title");
                int status = resultSet.getInt("status");
                Article article = new Article(id, url, title, status);
                return article; // stop here.
            }
            System.out.println("Thao tác thành công!");
        } catch (SQLException e) {
            // e.printStackTrace();
            System.err.println("Lỗi khi thao tác với database. Message: " + e.getMessage());
        }
        return null;
    }

    public static ArrayList<Article> loadArticle() {
        System.out.println("Loading data...");
        ArrayList<Article> listArticle = new ArrayList<Article>();
        try {
            String queryString = "select id, url, title, status from articles order by id desc";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(queryString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { // chuyển con trỏ xuống dòng tiếp theo.
                int id = resultSet.getInt("id"); // kiểu dữ liệu gì, trường nào (hoặc index thứ mấy, index start từ 1)
                String url = resultSet.getString("url");
                String title = resultSet.getString("title");
                int status = resultSet.getInt("status");
                Article article = new Article(id, url, title, status);
                listArticle.add(article);
            }
            System.out.println("Thao tác thành công!");
        } catch (SQLException e) {
            // e.printStackTrace();
            System.err.println("Lỗi khi thao tác với database. Message: " + e.getMessage());
        }
        return listArticle;
    }

    public static void insertArticle(Article article) {
        try {
            String queryString = "INSERT INTO articles " +
                    "(id, url, title, description, content, `source`, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(queryString);
            preparedStatement.setInt(1, article.getId());
            preparedStatement.setString(2, article.getUrl());
            preparedStatement.setString(3, article.getTitle());
            preparedStatement.setString(4, article.getDescription());
            preparedStatement.setString(5, article.getContent());
            preparedStatement.setString(6, article.getSource());
            preparedStatement.setInt(7, article.getStatus());
            preparedStatement.execute();
            System.out.println("Thao tác thành công!");
        } catch (SQLException e) {
            // e.printStackTrace();
            System.err.println("Lỗi khi thao tác với database. Message: " + e.getMessage());
        }
    }
}
