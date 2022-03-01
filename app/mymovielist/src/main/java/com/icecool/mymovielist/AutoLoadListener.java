package com.icecool.mymovielist;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/**
 * �������б�ײ�����ȡ��һҳ����
 */
public class AutoLoadListener implements OnScrollListener{
 
	public interface AutoLoadCallBack {
		void execute(String url);
	}
 
	//private int getLastVisiblePosition = 0,lastVisiblePositionY=0;
	private AutoLoadCallBack  mCallback;
	public AutoLoadListener(AutoLoadCallBack callback)
	{
		this.mCallback = callback;
	}
	
	public void onScrollStateChanged(AbsListView view, int scrollState) {
 
		if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
			//�������ײ�
			if (view.getLastVisiblePosition() == (view.getCount() - 1)) {
				View v=(View) view.getChildAt(view.getChildCount()-1);
				int[] location = new  int[2] ;
				v.getLocationOnScreen(location);//��ȡ��������Ļ�ڵľ�������
		      //  int y=location [1];
 
		        Log.e("x"+location[0],"y"+location[1]);
				/*if (view.getLastVisiblePosition()!=getLastVisiblePosition
						&& lastVisiblePositionY!=y)//��һ�������ײ�
				{
					Toast.makeText(view.getContext(), "�ٴ������ײ������ɷ�ҳ",500).show();
					getLastVisiblePosition=view.getLastVisiblePosition();
					lastVisiblePositionY=y;
					return;
				}
				else if (view.getLastVisiblePosition()==getLastVisiblePosition
						&& lastVisiblePositionY==y)//�ڶ��������ײ�
				{*/
					mCallback.execute("？？？");
				//}
			}
			
			//δ�������ײ����ڶ��������ײ�����ʼ��
		//	getLastVisiblePosition=0;	
		//	lastVisiblePositionY=0;
		}
	}
 
	public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
		
	}
}