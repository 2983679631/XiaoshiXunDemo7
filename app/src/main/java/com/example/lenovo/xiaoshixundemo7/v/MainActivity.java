package com.example.lenovo.xiaoshixundemo7.v;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lenovo.xiaoshixundemo7.R;
import com.example.lenovo.xiaoshixundemo7.adapter.MyRecyclerAdapter;
import com.example.lenovo.xiaoshixundemo7.newsbenas.Data;
import com.example.lenovo.xiaoshixundemo7.p.PresenterDemo;
import com.example.lenovo.xiaoshixundemo7.p.control;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements control.View{

    private RecyclerView rv_name;
    private List<Data.StudentsBean.StudentBean> studentBeanList;
    private Banner ban_name;
    private int arr[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private Button tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        initData();


    }

    private void initData() {

        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            integerList.add(arr[i]);

        }

        ban_name.isAutoPlay(true);
        ban_name.setDelayTime(2000);
        ban_name.setIndicatorGravity(Banner.CENTER);
        ban_name.setBannerStyle(Banner.CIRCLE_INDICATOR_TITLE);
        ban_name.setImages(integerList);

    }


    private void initView() {
        rv_name = (RecyclerView) findViewById(R.id.rv_name);
        ban_name = (Banner) findViewById(R.id.ban_name);


    }


    @Override
    public void OnReponseString(final Data data) {

        new PresenterDemo(this, this).OnRequestString("http://172.16.54.15:8080/json/data.json");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {


                studentBeanList = data.getStudents().getStudent();

                MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(studentBeanList, MainActivity.this);
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                rv_name.setLayoutManager(staggeredGridLayoutManager);
                rv_name.setAdapter(myRecyclerAdapter);

            }
        });


    }

}
