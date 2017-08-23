package com.bbld.tsl_water.network;

import com.bbld.tsl_water.base.Constants;
import com.bbld.tsl_water.bean.VersionAndroid;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by likey on 2017/08/22.
 */

public class RetrofitService {
    private static RetrofitService retrofitService = new RetrofitService();
    private static RetrofitInterface retrofitInterface;

    private RetrofitService() {
        initRetrofit();
    }

    public static RetrofitService getInstance() {
        if (retrofitService == null) {
            retrofitService = new RetrofitService();
        }
        return retrofitService;
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    /**
     * 自动更新
     */
    public Call<VersionAndroid> getVersionAndroid() {
        return retrofitInterface.getVersionAndroid();
    }
}
