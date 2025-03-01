package org.DJiLeaseMs.common.result;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PageResult {
    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数")
    private long total;

    /**
     * 当前页数据集合
     */
    @ApiModelProperty(value = "当前页数据集合")
    private List records;
}
