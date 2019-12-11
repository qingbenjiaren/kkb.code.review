package com.melo.spring.reviewbean.strategy.support;

import com.melo.spring.reviewbean.strategy.ConvertValueStrategy;

public class IntegerStrategy implements ConvertValueStrategy {
    @Override
    public Object convertValue(String value) {
        return Integer.parseInt(value);
    }
}
