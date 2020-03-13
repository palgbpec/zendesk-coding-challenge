package com.zendesk.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class JsonUtil {
    public JsonArray readJson(String jsonFilename) {
        JsonArray jsonArray = null;
        try {
            InputStream inputStream = getClass().getResourceAsStream("/"+jsonFilename);
            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStream, writer, "UTF-8");
            jsonArray = new JsonParser().parse(writer.toString()).getAsJsonArray();
            return  jsonArray;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
