package com.eshore.wbtimer.executor.common.code.dataplatform.bean;

import java.util.List;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018/2/1 9:20
 */
//多行列表组装
public class MutiRow {

    private String name;
    private List<Row> rows;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<" + name+" >");
        if(rows!=null){
            for (Row r : rows) {
                sb.append(r.toString());
            }
        }
        sb.append("</" + name + ">");
        return sb.toString();
    }

}

