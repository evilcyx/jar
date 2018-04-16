package com.example.admin.mvp_master.tools.network;

import com.example.admin.mvp_master.bean.BookBean;
import com.example.admin.mvp_master.bean.UserBean;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;


/**
 * Created by admin on 2018/3/30.
 *请求接口公共接口
 */

public interface ApiService {

    //测试端口
    public static final String BASE_URL = "http://116.62.168.251:8080/";

    @GET("NewWeb/GetBeijinPicList")
    Observable<List<UserBean>> login();

    public static final String BASEDoubanUrl="https://api.douban.com/v2/";


    @GET("book/1220562")
    Observable<BookBean> doubanList();

//    https://api.douban.com/v2/user/:name



    public static final String XiaotingUrl="http://10.1.107.190:8080/NcCircle/";

    @GET("aa/listall")
    Observable<RequestBody> getList();

}
