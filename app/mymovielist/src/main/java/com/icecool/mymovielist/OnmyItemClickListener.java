package com.icecool.mymovielist;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

public interface OnmyItemClickListener {
    void onmyItemClick(AdapterView<?> parent, View view, int position, List<info> datas);

}
