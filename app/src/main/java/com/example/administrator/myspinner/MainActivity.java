package com.example.administrator.myspinner;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Spinner spinner;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics dm = new DisplayMetrics();
        //获取屏幕信息
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int screenWidth = dm.widthPixels;

//        int screenHeigh = dm.heightPixels;
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setLayoutParams(new RelativeLayout.LayoutParams(screenWidth/2,70));
        for (int i = 0; i < 10; i++) {
            list.add("我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第我是第" + i + "个菜单");
        }
        spinner.setAdapter(new MyAdapter());

    }


    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(MainActivity.this, R.layout.item_spinner, null);
                holder.tv_item = (TextView) convertView.findViewById(R.id.tv_item);
//                holder.image = (ImageView) convertView.findViewById(R.id.img);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_item.setText(list.get(position));
//            holder.image.setImageResource(R.drawable.ic_launcher);
            return convertView;
        }
    }

    private class ViewHolder {
        public TextView tv_item;
        public ImageView image;
    }
}
