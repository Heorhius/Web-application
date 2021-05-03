package com.kaptsiug.db;

import com.kaptsiug.model.Bus;
import com.kaptsiug.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusProvider {
    private static final String MSG_USER_NOT_FOUND = "No entity with id: %d";
    private static final String QUERY_SELECT_ALL_BUSES = "SELECT * FROM bus;";
    public static final String QUERY_INSERT_BUSES = "INSERT INTO bus (departureStation,arrivalStation) VALUES (?,?);";
    public static final String QUERY_DELETE_BUS_BY_ID = "DELETE FROM bus WHERE bus.id = ?";
    private static BusProvider provider;

    private BusProvider() {
    }

    public static BusProvider getProvider() {
        if (provider == null) {
            provider = new BusProvider();
        }
        return provider;
    }

    public List<Bus> getAllBusses() {
        List<Bus> busPark = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery(QUERY_SELECT_ALL_BUSES);) {
            while (rs.next()) {
                Bus bus = new Bus(rs.getInt("id"),
                        rs.getString("departureStation"),
                        rs.getString("arrivalStation"));
                busPark.add(bus);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return busPark;
    }

    public void addBus(Bus bus) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(QUERY_INSERT_BUSES);) {
            pStatement.setString(1, bus.getDepartureStation());
            pStatement.setString(2, bus.getArrivalStation());
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteBusByID(int id) throws SQLException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(QUERY_DELETE_BUS_BY_ID);) {
            pStatement.setInt(1, id);
            pStatement.executeUpdate();
        }
    }

}
