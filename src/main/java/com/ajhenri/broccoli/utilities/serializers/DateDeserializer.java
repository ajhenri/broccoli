package com.ajhenri.broccoli.utilities.serializers;

import static com.ajhenri.broccoli.utilities.Constants.GLOBAL_DATE_FORMAT;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser p, DeserializationContext context)
            throws IOException {
        String date = p.getText();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(GLOBAL_DATE_FORMAT);
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }

}
