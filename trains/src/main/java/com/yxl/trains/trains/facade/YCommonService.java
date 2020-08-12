package com.yxl.trains.trains.facade;

public interface YCommonService<T> {

    String AUTHOR_NAME = "Allan Bruce Charlie Dark";

    String ADDRESS = "China";

    void prepare(T object);

    Object execute(T object);


    default void afterAll(T object) {

    }


}
