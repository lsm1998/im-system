package com.lsm1998.im.webcommon.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseListRequest extends BaseRequest
{
    /**
     * 页码
     */
    private Integer page;

    /**
     * 分页大小
     */
    private Integer size;

    public BaseListRequest()
    {
        this.page = 1;
        this.size = 10;
    }

    public <T> Page<T> pageInfo()
    {
        return new Page<>(page, size);
    }
}
