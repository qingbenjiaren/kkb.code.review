package com.melo.spring.reviewbean.strategy.support;

import com.melo.spring.reviewbean.strategy.ConvertValueStrategy;

public class BooleanStrategy implements ConvertValueStrategy {
    @Override
    public Object convertValue(String value) {
        return Boolean.valueOf(value);
    }
}
