package com.icecool.movilistdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.icecool.mymovielist.MoviesList;
import com.icecool.mymovielist.info;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private com.icecool.mymovielist.MoviesList vodList;
    String img="http://sd-pic.com/upload/vod/20220219-1/0bb48249fc944e4dd604e42e34fdb09b.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vodList = findViewById(R.id.vodList);
        vodList.setcolumns(4);

        vodList.setFtitle_visible(false);
        vodList.setFenshu_visible(false);
        vodList.setGengxing_visible(false);
        vodList.ImgSet(R.drawable.loadding,R.drawable.falseimg);


        vodList.setImg_aspect(3,3);

        //item被点击事件监听
        vodList.SetOnMyitemClickListener(new MoviesList.OnMyitemClickListener() {
            @Override
            public void OnMyItemClickListener(GridView parent, View view, int position, List<info> datas) {
                Toast.makeText(MainActivity.this, "你选了" + datas.get(position).getVod_name(), Toast.LENGTH_SHORT).show();
            }
        });

        //item长按事件监听
        vodList.SetOnMyitemLongClickListener(new MoviesList.OnMyitemLongClickListener() {
            @Override
            public void OnMyItemLongClickListener(GridView parent, View view, int position, List<info> datas) {
                Toast.makeText(MainActivity.this, "你长按了" + datas.get(position).getVod_name(), Toast.LENGTH_SHORT).show();
            }
        });

        //下拉到底部事件监听
        vodList.SetTobuttomListener(new MoviesList.TobuttomListener() {
            @Override
            public void tobuttomListener() {
                addVodData();
            }
        });

        vodList.SetOnFreshListener(new MoviesList.OnfreshListener() {
            @Override
            public void Onfresh() {
                vodList.AddData(img,"一江春水"+111,""+111,"11","HD","张学友" );
                vodList.StopRefresh();
            }
        });

    }

    public void addVodData(){
        for (int i=0;i<3;i++){
            vodList.AddData(img,"一江春水"+i,""+i,"9.0","HD","刘德华" );
        }
    }
}