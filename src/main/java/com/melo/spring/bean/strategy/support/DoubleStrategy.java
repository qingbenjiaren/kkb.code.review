package com.melo.spring.bean.strategy.support;

import com.melo.spring.bean.strategy.ConvertValueStrategy;

public class DoubleStrategy implements ConvertValueStrategy {

    @Override
    public Object convertValue(String value) {
        return Double.parseDouble(value);
    }
}
