package com.yxl.trains.trains.config;

public interface Converter<Input,Output> {
    Output convert(Input input);
}
