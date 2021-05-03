package com.kaptsiug.service;

import com.google.gson.Gson;
import com.kaptsiug.db.BusProvider;
import com.kaptsiug.exception.IllegalIDException;
import com.kaptsiug.model.Bus;

import java.sql.SQLException;
import java.util.List;

public class BusService {
    private final BusProvider busProvider;
    private final Gson gson;

    public BusService() {
        busProvider = BusProvider.getProvider();
        gson = new Gson();
    }

    public String getAllBusesForResponse() {
        List<Bus> busPark = busProvider.getAllBusses();
        return gson.toJson(busPark);
    }

    public void addBus(String jSonString) {
        Bus bus = gson.fromJson(jSonString, Bus.class);
        busProvider.addBus(bus);
    }

    public void deleteBus(String id) throws IllegalIDException, SQLException {
        char[] chars = id.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch)) {
                throw new IllegalIDException();
            }
        }
        int userID = Integer.parseInt(id);
        busProvider.deleteBusByID(userID);

    }
}
