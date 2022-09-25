package ru.netology.db;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

    private static final String url = System.getProperty("dbUrl");
    private static final String user = "app";
    private static final String password = "pass";

     @SneakyThrows
    private static Connection getConnection() {
        return DriverManager.getConnection(url, user, password);
    }

    @SneakyThrows
    private static String getValue(String query) {
        var runner = new QueryRunner();
        var value = "";
        try (var conn = DataBase.getConnection()) {
            value = runner.query(conn, query, new ScalarHandler<>());
        }
        return value;
    }

    @SneakyThrows
    public static String getDebitCardTransactionStatus() {
         return getValue("SELECT status FROM payment_entity;");
    }

    @SneakyThrows
    public static String getCreditCardTransactionStatus() {
        return getValue("SELECT status FROM credit_request_entity;");
    }

    @SneakyThrows
    public static void cleanDB() {
        var connection = DataBase.getConnection();
        connection.createStatement().executeUpdate("TRUNCATE credit_request_entity;");
        connection.createStatement().executeUpdate("TRUNCATE payment_entity;");
        connection.createStatement().executeUpdate("TRUNCATE order_entity;");
    }
}
