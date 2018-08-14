package com.eshore.wbtimer.executor.service.impl;

import com.eshore.wbtimer.core.log.WbtimerJobLogger;
import com.eshore.wbtimer.executor.mapper.MyusersMapper;
import com.eshore.wbtimer.executor.mapper.bean.Myusers;
import com.eshore.wbtimer.executor.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyifan on 2018/4/8.
 * 业务描述:xxxx
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private MyusersMapper myusersMapper;

    @Override
    public void start() throws Exception {
        Myusers myusers = new Myusers();
        myusers.setUsername("test");
        myusers.setPassword("test");
        try {
            myusersMapper.insert(myusers);
        }catch(Exception e){
            WbtimerJobLogger.log(e);//日志输出到调度中心
           WbtimerJobLogger.log(e);
        }
    }
}
