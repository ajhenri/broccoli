package com.ajhenri.broccoli.utilities.serializers;

import static com.ajhenri.broccoli.utilities.Constants.GLOBAL_DATE_FORMAT;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator generator, SerializerProvider provider) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(GLOBAL_DATE_FORMAT);
        String dateString = dateFormat.format(date);
        generator.writeString(dateString);
    }
}
