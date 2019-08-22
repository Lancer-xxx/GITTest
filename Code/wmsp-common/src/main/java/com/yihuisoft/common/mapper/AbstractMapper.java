package com.yihuisoft.common.mapper;

import com.yihuisoft.common.vo.PagerVO;

import java.util.List;

public interface AbstractMapper<D> {

    List<D> list(PagerVO pagerVO);

    <D> D getById(Object id);

    int save(D d);

    int updateById(D d);

    int deleteById(D d);

    <D> D get(D d);

    <D> D update(D d);

    List<D> listAll(D d);
}
