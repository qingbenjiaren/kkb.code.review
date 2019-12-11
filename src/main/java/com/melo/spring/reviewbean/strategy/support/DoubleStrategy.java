package com.melo.spring.reviewbean.strategy.support;

import com.melo.spring.reviewbean.strategy.ConvertValueStrategy;

public class DoubleStrategy implements ConvertValueStrategy {

    @Override
    public Object convertValue(String value) {
        return Double.parseDouble(value);
    }
}
