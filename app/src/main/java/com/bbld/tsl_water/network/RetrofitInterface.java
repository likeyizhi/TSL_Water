package com.bbld.tsl_water.network;

import com.bbld.tsl_water.bean.VersionAndroid;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by likey on 2017/08/22.
 */

public interface RetrofitInterface {
    /**
     * 自动更新
     */
    @GET("api/User/GetVersionAndroid")
    Call<VersionAndroid> getVersionAndroid();

}

