package com.melo.spring.bean.strategy.support;

import com.melo.spring.bean.strategy.ConvertValueStrategy;

public class StringStrategy implements ConvertValueStrategy {

    @Override
    public String convertValue(String value) {
        return value;
    }
}
