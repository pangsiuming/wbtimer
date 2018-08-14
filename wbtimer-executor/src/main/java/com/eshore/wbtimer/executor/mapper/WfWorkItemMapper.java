package com.eshore.wbtimer.executor.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.eshore.wbtimer.executor.mapper.bean.WfWorkItem;

public interface WfWorkItemMapper extends BaseMapper<WfWorkItem> {

    WfWorkItem selectWfWorkItemBySblsh(String sblsh);
}