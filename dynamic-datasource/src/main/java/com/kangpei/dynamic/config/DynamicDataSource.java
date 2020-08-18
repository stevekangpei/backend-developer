package com.kangpei.dynamic.config;

import com.kangpei.dynamic.context.DataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * description: DynamicDataSource <br>
 * date: 2020/8/18 10:57 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getKey();
    }
}
