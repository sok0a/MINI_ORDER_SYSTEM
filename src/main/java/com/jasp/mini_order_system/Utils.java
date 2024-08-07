package com.jasp.mini_order_system;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Utils {

    public static <T> void print(List<T> list) {
        final Gson gson = new GsonBuilder().setPrettyPrinting()
                                           .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                                           .create();
        System.out.println(gson.toJson(list));
    }

    private static class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

        private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");


        @Override
        public void write(JsonWriter out, LocalDateTime value) throws IOException {
            out.value(value.format(formatter));
        }

        @Override
        public LocalDateTime read(JsonReader in) throws IOException {
            return LocalDateTime.parse(in.nextString(), formatter);
        }
    }

}