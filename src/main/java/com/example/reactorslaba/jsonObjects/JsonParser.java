package com.example.reactorslaba.jsonObjects;

import com.example.reactorslaba.Reactor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class JsonParser {

  //  File jsonFile = new File("/Users/dazorina/Documents/private/асус не умирай/files_for_laba4/ReactorType.json");

    private final ArrayList<Reactor> reactorArrayList = new ArrayList<>();

    public ArrayList<Reactor> getReactorArrayList() {
        return reactorArrayList;
    }

    public JsonParser(File file) {
        parse(file);
    }

    public void parse(File file) {

        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file)) {

            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);

            JSONArray reactorJsonArray = (JSONArray) rootJsonObject.get("ReactorType");

            for (Object reactorObject : reactorJsonArray) {
                JSONObject reactorJsonObject = (JSONObject) reactorObject;

                String name = (String) reactorJsonObject.get("name");
                double burnup = Double.parseDouble((String) reactorJsonObject.get("burnup"));
                double kpd = Double.parseDouble((String) reactorJsonObject.get("kpd"));
                double enrichment = Double.parseDouble((String) reactorJsonObject.get("enrichment"));
                double thermalCapacity = Double.parseDouble((String) reactorJsonObject.get("termal_capacity"));
                double electricalCapacity = Double.parseDouble((String) reactorJsonObject.get("electrical_capacity"));
                double lifeTime = Double.parseDouble((String) reactorJsonObject.get("life_time"));
                double firstLoad = Double.parseDouble((String) reactorJsonObject.get("first_load"));

                Reactor reactor = new Reactor(name, burnup, kpd, enrichment, thermalCapacity, electricalCapacity, lifeTime, firstLoad);

                reactorArrayList.add(reactor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
