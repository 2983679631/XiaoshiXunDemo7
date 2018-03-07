package com.example.lenovo.xiaoshixundemo7.p;

import com.example.lenovo.xiaoshixundemo7.newsbenas.Data;

import okhttp3.Callback;

/**
 * Created by Lenovo on 2018/3/6.
 */

public interface control {

    interface View{

        void OnReponseString(Data data);
    }

    interface Presenter{


         void OnRequestString(String url );

    }

    interface Imodel {
         void initData(Callback callback);
    }
}
