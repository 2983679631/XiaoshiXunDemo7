package com.example.lenovo.xiaoshixundemo7.p;

import android.content.Context;

import com.example.lenovo.xiaoshixundemo7.m.Medoal;
import com.example.lenovo.xiaoshixundemo7.newsbenas.Data;
import com.google.gson.Gson;

/**
 * Created by Lenovo on 2018/3/6.
 */

public class PresenterDemo implements control.Presenter{

    private control.View view;
    private Context context;
    Medoal medoal = Medoal.getMedoal();


    public PresenterDemo(control.View view, Context context) {
        this.view = view;
        this.context = context;

    }

    @Override
    public void OnRequestString(String url ) {

        medoal.JsonString(url, new Medoal.JsonData() {
            @Override
            public void OnData(String result) {


                        Gson gson = new Gson();
                        Data data = gson.fromJson(result, Data.class);
                        view.OnReponseString(data);
            }
        });

    }

}
