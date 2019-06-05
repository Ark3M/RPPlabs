package com.dimedrol.lab2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    public static final String url = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/";
    private Retrofit mRetrofit;

    public NetworkService() {
        mRetrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null)
            mInstance = new NetworkService();
        return mInstance;
    }

    public IRequester get_req() {
        mRetrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        return mRetrofit.create(IRequester.class);
    }
}
