package com.melo.spring.reviewbean.strategy.support;

import com.melo.spring.reviewbean.strategy.ConvertValueStrategy;

public class LongStrategy implements ConvertValueStrategy {
    @Override
    public Object convertValue(String value) {
        return Long.parseLong(value);
    }
}
