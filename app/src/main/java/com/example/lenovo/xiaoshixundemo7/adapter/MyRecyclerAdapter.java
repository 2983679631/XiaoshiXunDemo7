package com.example.lenovo.xiaoshixundemo7.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.xiaoshixundemo7.R;
import com.example.lenovo.xiaoshixundemo7.newsbenas.Data;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

/**
 * Created by Lenovo on 2018/3/6.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private List<Data.StudentsBean.StudentBean> studentBeanList;
    private Context context;

    public MyRecyclerAdapter(List<Data.StudentsBean.StudentBean> studentBeanList, Context context) {
        this.studentBeanList = studentBeanList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.height = new Random().nextInt(100)+100;
        holder.itemView.setLayoutParams(layoutParams);

        Picasso.with(context).load(studentBeanList.get(position).getImg()).into(holder.img_name);
        holder.tv_name.setText(studentBeanList.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return studentBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img_name;
        private final TextView tv_name;

        public ViewHolder(View itemView) {
            super(itemView);

            img_name = itemView.findViewById(R.id.img_name);
            tv_name = itemView.findViewById(R.id.tv_name);


        }
    }
}
