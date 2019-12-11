package com.melo.spring.reviewbean.strategy.support;

import com.melo.spring.reviewbean.strategy.ConvertValueStrategy;

public class StringStrategy implements ConvertValueStrategy {

    @Override
    public String convertValue(String value) {
        return value;
    }
}
