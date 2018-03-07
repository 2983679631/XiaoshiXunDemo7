package com.example.lenovo.xiaoshixundemo7.m;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Lenovo on 2018/3/6.
 */

// M层：
public class Medoal {

    private  OkHttpClient okHttpClient;
    private static volatile Medoal medoal;
    private Handler  handler;

    private Medoal() {

        okHttpClient = new OkHttpClient();
        handler = new Handler(Looper.getMainLooper());

    }


    public static Medoal getMedoal(){

        Medoal mm = null;

        if(medoal == null){

            synchronized (Medoal.class){

                if(mm == null){

                    mm = new Medoal();

                    medoal = mm;
                }
            }
        }

        return medoal ;
    }



    public void JsonStringMethod(final String jsonString , final JsonData data){

        handler.post(new Runnable() {
            @Override
            public void run() {

                if(data != null){

                    data.OnData(jsonString);
                }
            }
        });


    }

    public void JsonString(String url, final JsonData data){

        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if(response != null && response.isSuccessful()) {
                    JsonStringMethod(response.body().toString(), data);
                }

            }
        });
    }


    public interface JsonData{

        void OnData(String result);
    }


}
