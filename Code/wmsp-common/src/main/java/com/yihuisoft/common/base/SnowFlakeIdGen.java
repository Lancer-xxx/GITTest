package com.yihuisoft.common.base;

import com.yihuisoft.common.util.app.SnowFlakeIdWorker;
import tk.mybatis.mapper.genid.GenId;

/**
 * 通过雪花算法 生成id
 * @author dim
 * @date 2019/8/13
 */
public class SnowFlakeIdGen implements GenId<Long> {
    @Override
    public Long genId(String table, String column) {
        return SnowFlakeIdWorker.generateId();
    }
}
