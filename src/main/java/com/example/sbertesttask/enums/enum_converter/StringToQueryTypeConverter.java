package com.example.sbertesttask.enums.enum_converter;

import com.example.sbertesttask.enums.Filter;
import org.springframework.core.convert.converter.Converter;

public class StringToQueryTypeConverter implements Converter<String, Filter> {
    @Override
    public Filter convert(String source) {
        return Filter.valueOf(source.toUpperCase());
    }
}
