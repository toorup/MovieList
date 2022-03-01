package com.icecool.mymovielist;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.List;
import java.util.Vector;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class MoviesList extends LinearLayout {

    public Context context;
    private List<info> userList = new Vector<>(); //多线程操作LIST用Vector
    private adapter2 adapter;
    private GridView grid;
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean Title_visible=true;         //标题是否可见
    private boolean Fenshu_visible=true;        //分数是否可见
    private boolean Ftitle_visible=true;         //副标题是否可见
    private boolean Gengxing_visible=true;      //更新是否可见
    private int aspect_Hight;                   //宽高比-高
    private int aspect_Width;                   //宽高比-宽
    private int columns=3;                      //列数


    public MoviesList(Context context) {
        this(context, null);
        this.context=context;
    }

    public MoviesList(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.mylistview, this);
        String img="http://sd-pic.com/upload/vod/20220219-1/0bb48249fc944e4dd604e42e34fdb09b.jpg";
        for(int i=0;i<2;i++){
            userList.add(new info(img,"test"+i,"test" + i,"10","HD","刘德华" ));
        }
        this.grid = findViewById(R.id.grid);
        this.adapter = new adapter2(userList, context);
        this.grid.setAdapter(adapter);
        AutoLoadListener autoLoadListener;
        autoLoadListener = new AutoLoadListener(callBack);
        this.grid.setOnScrollListener(autoLoadListener);

        this.grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                OnmyItemClickListener.OnMyItemClickListener ((GridView) adapterView, view,i, userList);
            }
        });

        this.grid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                OnmyItemLongClickListener.OnMyItemLongClickListener ((GridView) adapterView, view,i, userList);
                return true;
            }
        });

        swipeRefreshLayout=findViewById(R.id.swipeLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onfreshListener.Onfresh();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });

    }

    public void ImgSet(int LoadImg,int FalseImg){
        adapter.ImgSet(LoadImg,FalseImg);
    }


    public void ClearList(){
        userList.clear();
        adapter.notifyDataSetChanged();
    }

    public void AddData(String Vod_img,String Vod_name,String Vod_id,String Vod_score,String Vod_update,String Vod_actor){
        userList.add(new info(Vod_img,Vod_name,Vod_id,Vod_score,Vod_update,Vod_actor));
        adapter.notifyDataSetChanged();
    }

    AutoLoadListener.AutoLoadCallBack callBack = new AutoLoadListener.AutoLoadCallBack() {

        public void execute(String url) {
            tobuttomListener.tobuttomListener();
        }
    };

    public void StopRefresh(){
        swipeRefreshLayout.setRefreshing(false);
    }


    /***************自定义点击回调*********自定义回调的三步**********/
    OnMyitemClickListener OnmyItemClickListener;  //定义实例
    public void SetOnMyitemClickListener(OnMyitemClickListener Listener){
        this.OnmyItemClickListener=Listener;
    }
    public interface OnMyitemClickListener{     //定义接口
        public void OnMyItemClickListener(GridView parent, View view, int position, List<info> datas);
    }

    /***************自定义长按回调*********自定义回调的三步**********/
    OnMyitemLongClickListener OnmyItemLongClickListener;  //定义实例
    public void SetOnMyitemLongClickListener(OnMyitemLongClickListener Listener){
        this.OnmyItemLongClickListener=Listener;
    }
    public interface OnMyitemLongClickListener{     //定义接口
        public void OnMyItemLongClickListener(GridView parent, View view, int position, List<info> datas);
    }

    /***************下拉到底部监听*********自定义回调的三步**********/
    TobuttomListener tobuttomListener;
    public void SetTobuttomListener(TobuttomListener Listener){
        this.tobuttomListener=Listener;
    }
    public interface TobuttomListener{
        public void tobuttomListener();
    }

    /**********************************************************/
    OnfreshListener onfreshListener;
    public void SetOnFreshListener(OnfreshListener Listener){
        this.onfreshListener=Listener;
    }
    public interface OnfreshListener{
        public void Onfresh();
    }

    public void setImg_aspect(int Width,int Height){
        adapter.setImg_aspect(Width,Height);
    }

    public void setcolumns(int columns){
        this.columns=columns;
        this.grid.setNumColumns(this.columns);
        adapter.setColumns(columns);
    }

    public void setTitle_visible(boolean visible){
        adapter.setTitle_visible(visible);
    }

    public void setFtitle_visible(boolean visible){
        adapter.setFtitle_visible(visible);
    }

    public void setGengxing_visible(boolean visible){
        adapter.setGengxing_visible(visible);
    }

    public void setFenshu_visible(boolean visible){
        adapter.setFenshu_visible(visible);
    }

}
