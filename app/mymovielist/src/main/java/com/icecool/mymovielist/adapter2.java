package com.icecool.mymovielist;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class adapter2 extends BaseAdapter {
    private List<info> dataList;
    private Context context;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private ImageView image;

    private boolean Title_visible=true;
    private boolean Fenshu_visible=true;
    private boolean Ftitle_visible=true;
    private boolean Gengxing_visible=true;
    private int aspect_Hight=9;
    private int aspect_Width=6;
    private int columns=3;
    private int LoadImg=R.drawable.load;
    private int FalseImg=R.drawable.weizd;


    public adapter2(List<info> dataList, Context context) {
        super();
        this.dataList = dataList;
        this.context = context;
    }

    public void setImg_aspect(int Width,int Height){
        this.aspect_Hight=Height;
        this.aspect_Width=Width;
    }

    public void setTitle_visible(boolean visible){
        this.Title_visible=visible;
    }

    public void setFtitle_visible(boolean visible){
        this.Ftitle_visible=visible;
    }

    public void setGengxing_visible(boolean visible){
        this.Gengxing_visible=visible;
    }

    public void setFenshu_visible(boolean visible){
        this.Fenshu_visible=visible;
    }
    public void setColumns(int columns){
        this.columns=columns;
    }


    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    public void ImgSet(int LoadImg,int FasleImg){
        this.LoadImg=LoadImg;
        this.FalseImg=FasleImg;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        if (convertView == null||convertView.getTag()==null) {

            LayoutInflater flater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = flater.inflate(R.layout.item_test, parent, false);


            DisplayMetrics dm = new DisplayMetrics();
            ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
            float density = dm.density;
            int width=((int)parent.getWidth()-(int)((columns+1)*density*20-1f))/columns ;
            int height=(int)(width*(aspect_Hight)/aspect_Width +20*density);
            convertView.setLayoutParams(new AbsListView.LayoutParams(width,height));// 动态设置item的高度

        }

        textView1 = (TextView) convertView.findViewById(R.id.title);
        textView1.setVisibility(Title_visible?View.VISIBLE:View.GONE);

        textView2 = (TextView) convertView.findViewById(R.id.Ftitle);
        textView2.setVisibility(Ftitle_visible?View.VISIBLE:View.GONE);

        image =(ImageView) convertView.findViewById(R.id.img_id);
        textView1 = (TextView) convertView.findViewById(R.id.title);
        textView1.setVisibility(Title_visible?View.VISIBLE:View.GONE);

        textView2 = (TextView) convertView.findViewById(R.id.Ftitle);
        textView2.setVisibility(Ftitle_visible?View.VISIBLE:View.GONE);

        textView3 = (TextView) convertView.findViewById(R.id.fenshu);
        textView3.setVisibility(Fenshu_visible?View.VISIBLE:View.GONE);

        textView4 = (TextView) convertView.findViewById(R.id.genxing);
        textView4.setVisibility(Gengxing_visible?View.VISIBLE:View.GONE);




        Picasso
        //androidX下，application下要加上android:usesCleartextTraffic="true"，不然http图片取不到
         .with(context)
         .load(dataList.get(position).getVod_img())
         .placeholder(LoadImg)
         .resize(450,300)
         .error(FalseImg)
         .into(this.image);



        textView1.setText(dataList.get(position).getVod_name());
        textView2.setText(dataList.get(position).getVod_actor());
        textView3.setText(dataList.get(position).getVod_score());
        textView4.setText(dataList.get(position).getVod_update());

        return convertView;
    }

}
