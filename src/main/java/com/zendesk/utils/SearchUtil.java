package com.zendesk.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class SearchUtil {

    public static List<JsonObject> search(JsonArray jsonArray, String searchTerm, String searchValue) {
        int len = jsonArray.size();
        List<JsonObject> jsonObjectList = new ArrayList<>();
        for(int i=0; i<len; i++) {
            JsonElement jsonElement = jsonArray.get(i);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            for (final Map.Entry<String, JsonElement> entry: jsonObject.entrySet()) {
                final String key = entry.getKey();
                final JsonElement value = entry.getValue();
                if(key.equalsIgnoreCase(searchTerm)) {
                    if(value.isJsonArray()) {
                        final JsonArray keyJsonArray = value.getAsJsonArray();
                        int size = keyJsonArray.size();
                        for(int j=0;j< size;j++) {
                            if(searchValue.equalsIgnoreCase(keyJsonArray.get(j).getAsString())) {
                                jsonObjectList.add(jsonObject);
                            }
                        }
                    }else {
                        if(value.getAsString().equalsIgnoreCase(searchValue)) {
                            jsonObjectList.add(jsonObject);
                        }
                    }
                }
            }
        }
        return jsonObjectList;
    }

    public static LinkedHashSet<String> getTerms(JsonArray jsonArray) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        int len = jsonArray.size();
        for(int i=0; i<len; i++) {
            JsonElement jsonElement = jsonArray.get(i);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            for (final Map.Entry<String, JsonElement> entry: jsonObject.entrySet()) {
                final String key = entry.getKey();
                set.add(key);
            }
        }
        return set;
    }
}
