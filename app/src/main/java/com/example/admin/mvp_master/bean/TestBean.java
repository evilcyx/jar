package com.example.admin.mvp_master.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18.
 */

public class TestBean {


    /**
     * status : 0
     * message : null
     * data : [{"aid":1,"aname":"肖庭","password":"xtxt","state":1,"jurisdictionId":null,"uptime":"","newuptime":null},{"aid":2,"aname":"逆创公司","password":"nichuang","state":1,"jurisdictionId":null,"uptime":null,"newuptime":null},{"aid":3,"aname":"立刻马上那个","password":null,"state":1,"jurisdictionId":null,"uptime":null,"newuptime":null},{"aid":4,"aname":"达到","password":null,"state":1,"jurisdictionId":null,"uptime":null,"newuptime":null}]
     */

    private int status;
    private Object message;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * aid : 1
         * aname : 肖庭
         * password : xtxt
         * state : 1
         * jurisdictionId : null
         * uptime :
         * newuptime : null
         */

        private int aid;
        private String aname;
        private String password;
        private int state;
        private Object jurisdictionId;
        private String uptime;
        private Object newuptime;

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public String getAname() {
            return aname;
        }

        public void setAname(String aname) {
            this.aname = aname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public Object getJurisdictionId() {
            return jurisdictionId;
        }

        public void setJurisdictionId(Object jurisdictionId) {
            this.jurisdictionId = jurisdictionId;
        }

        public String getUptime() {
            return uptime;
        }

        public void setUptime(String uptime) {
            this.uptime = uptime;
        }

        public Object getNewuptime() {
            return newuptime;
        }

        public void setNewuptime(Object newuptime) {
            this.newuptime = newuptime;
        }
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "status=" + status +
                ", message=" + message +
                ", data=" + data +
                '}';
    }
}
