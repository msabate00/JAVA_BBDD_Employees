/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author AitramKG
 */
public class BaseDeDades {

    private Connection connection = null;
    private Statement statement = null;
    private int columnasTotales = 0;
    private int filasTotales = 0;
    private int lastrow = 0;
    private int mostrarFilas = 50;

    private void connect() throws SQLException {
        String url = "jdbc:mysql://172.16.0.100:3306/employees";
        String user = "admin";
        String passwd = "1234";
        if (connection == null) {
            connection = DriverManager.getConnection(url, user, passwd);
        }
        if (statement == null) {
            statement = connection.createStatement();
        }
    }

    private void disconnect() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                ;
            } finally {
                statement = null;
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                ;
            } finally {
                connection = null;
            }
        }
    }

    public List<String> getColumns() throws SQLException {

        connect();

        List<String> columnas = new ArrayList<String>();

        try (ResultSet rs = statement.executeQuery("SHOW COLUMNS FROM employees")) {
            while (rs.next()) {
                columnas.add(rs.getString(1));
            }

        }
        columnasTotales = columnas.size();

        disconnect();

        return columnas;
    }

    public String[][] getContent(int start) throws SQLException {

        connect();
        try (ResultSet rs = statement.executeQuery("SELECT * FROM employees LIMIT " + start + "," + getMostrarFilas())) {
            rs.first();
            String[][] a = new String[mostrarFilas][columnasTotales];

            for (int i = 0; i < getMostrarFilas(); i++) {

                for (int j = 1; j < columnasTotales + 1; j++) {
                    a[i][j - 1] = rs.getString(j);
                }
                rs.next();
            }
            rs.last();
            if (rs.getRow() > 0) {
                lastrow = start + getMostrarFilas();
            } else {
                lastrow = start;
            }

            disconnect();
            return a;

        }
    }

    public String[][] findByName(String name) throws SQLException {
        connect();
//SELECT *, ...FROM table_name WHERE columnN LIKE pattern;
        if (name.length() >= 3) {
            try (ResultSet rs = statement.executeQuery("SELECT * FROM employees WHERE first_name LIKE '%" + name + "%' ORDER BY emp_no DESC")) {
                rs.last();
                String[][] result = new String[rs.getRow()][columnasTotales];
                rs.first();

                for (int i = 0; i < result.length; i++) {

                    for (int j = 1; j < columnasTotales + 1; j++) {
                        result[i][j - 1] = rs.getString(j);
                    }
                    rs.next();
                }
                rs.last();
                disconnect();

                return result;
            }
        }else{
            return null;
        }
    }

    public Boolean insert(String[] datos) throws SQLException {
        connect();

        if (datos.length == 5) {

            PreparedStatement st = connection.prepareStatement("INSERT INTO employees(emp_no, first_name, last_name, gender, birth_date, hire_date) VALUES (?, ?, ?, ?, ?, ?)");
            ResultSet rs = statement.executeQuery("SELECT max(emp_no) FROM employees");
            rs.first();

            st.setInt(1, rs.getInt(1) + 1);
            st.setString(2, datos[0]);
            st.setString(3, datos[1]);
            st.setString(4, datos[2]);
            st.setString(5, datos[3]);
            st.setString(6, datos[4]);

            int files = st.executeUpdate();
            if (files == 1) {
                disconnect();
                return true;
            }
        }
        disconnect();
        return false;

    }

    /**
     * @return the lastrow
     */
    public int getLastrow() {
        return lastrow;
    }

    /**
     * @return the mostrarFilas
     */
    public int getMostrarFilas() {
        return mostrarFilas;
    }

}
