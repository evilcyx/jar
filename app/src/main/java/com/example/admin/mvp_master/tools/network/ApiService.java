package com.example.admin.mvp_master.tools.network;

import com.example.admin.mvp_master.bean.BookBean;
import com.example.admin.mvp_master.bean.MoiveBean;
import com.example.admin.mvp_master.bean.MoiveBeanList;
import com.example.admin.mvp_master.bean.TestBean;
import com.example.admin.mvp_master.bean.UserBean;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
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
//
    @GET("movie/{moivetype}")
    Observable<MoiveBeanList> getMoiveList(@Path("moivetype") String MoiveType);//电影列表

    @GET("movie/subject/{moiveId}")
    Observable<MoiveBean> getMoive(@Path("moiveId") int moiveId);


    @GET("book/1220562")
    Observable<BookBean> doubanList();






    public static final String XiaotingUrl="http://10.1.107.190:8080/idea02/CircleAdminController/";

    @GET("listCircleAdmin")
    Observable<TestBean> getList();





}
