package com.yxl.trains.trains.facade;

/**
 * 公共接口
 *
 * @param <T> 请求对象
 * @param <K> 返回对象
 */
public interface YCommonService<T, K> {

    String AUTHOR_NAME = "Allan Bruce Charlie Dark";

    String ADDRESS = "China";

    void prepare(T request);

    K execute(T request);

    default boolean checkSuccess(K response) {
        return false;
    }

    default void afterAll(T request, K response) {

    }


}
