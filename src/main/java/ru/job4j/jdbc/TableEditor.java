package ru.job4j.jdbc;

import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException {
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws SQLException {
        String sql = String.format(
                "create table if not exists %s(%s, %s);",
                tableName,
                "id serial primary key",
                "name varchar(255)"
        );
        execute(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = String.format(
                "DROP TABLE IF EXISTS %s;",
                tableName
        );
        execute(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql = String.format(
                "ALTER TABLE IF EXISTS %s ADD COLUMN IF NOT EXISTS %s %s;",
                tableName,
                columnName,
                type
        );
        execute(sql);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = String.format(
                "ALTER TABLE IF EXISTS %s DROP COLUMN IF EXISTS %s",
                tableName,
                columnName
        );
        execute(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String sql = String.format(
                "ALTER TABLE IF EXISTS %s RENAME %s TO %s",
                tableName,
                columnName,
                newColumnName
        );
        execute(sql);
    }

    private void execute(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    public static void main(String[] args) throws SQLException {
        TableEditor tableEditor = new TableEditor(LoadProperties.getProperties());
        String nameTable = "test_jdbc";
        String nameColumn = "newColumn";
        String reNameColumn = "newColumn_rename";

        tableEditor.createTable(nameTable);

        tableEditor.addColumn(nameTable, nameColumn, "varchar(32)");
        System.out.println(tableEditor.getScheme(nameTable));

        tableEditor.renameColumn(nameTable, nameColumn, reNameColumn);
        System.out.println(tableEditor.getScheme(nameTable));

        tableEditor.dropColumn(nameTable, reNameColumn);
        System.out.println(tableEditor.getScheme(nameTable));

        tableEditor.dropTable(nameTable);
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
