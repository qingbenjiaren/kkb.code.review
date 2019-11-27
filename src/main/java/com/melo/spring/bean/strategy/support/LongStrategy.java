package com.melo.spring.bean.strategy.support;

import com.melo.spring.bean.strategy.ConvertValueStrategy;

public class LongStrategy implements ConvertValueStrategy {
    @Override
    public Object convertValue(String value) {
        return Long.parseLong(value);
    }
}
