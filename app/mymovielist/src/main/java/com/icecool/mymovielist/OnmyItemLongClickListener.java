package com.icecool.mymovielist;

import android.view.View;
import android.widget.AdapterView;

import java.util.List;

public interface OnmyItemLongClickListener {
    void onmyItemLongClick(AdapterView<?> parent, View view, int position, List<info> datas);
}
