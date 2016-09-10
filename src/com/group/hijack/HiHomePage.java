package com.group.hijack;

import java.util.ArrayList;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.group.utils.TopBar;

public class HiHomePage extends FragmentActivity {
	
	private TopBar mTopbar;
	
	// 下面的控件显示栏
	private TextView text_persons;
	private TextView text_msg;
	private TextView text_group;
	private TextView texts[];
	
	private FragmentManager mFmanger;
	private ArrayList<Fragment> mLists;
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_chat);
		
		
		initialViews();// 初始化控件。
	}


	private void initialViews() {
		mTopbar = (TopBar) findViewById(R.id.activity_topbar);
		texts = new TextView[3];
		texts[0] = (TextView) findViewById(R.id.text_chat_persons);
		texts[1] = (TextView) findViewById(R.id.text_chat_msg);
		texts[2] = (TextView) findViewById(R.id.text_chat_group);
		
		mFmanger = getSupportFragmentManager();
	}
	
	/**
	 * 跳转到哪个界面
	 */
	private void goTowhich(int index){
		setTextColor(index, getResources().getColor(R.color.background_blue), getResources().getColor(R.color.background_gray));
		
		setFragment(index);
	}

	private void setFragment(int index) {
		FragmentTransaction ft = mFmanger.beginTransaction();
		for(int i=0;i < 3;i++){
			ft.hide(mLists.get(i));
		}
		
		
		ft.commit();
	}


	private void setTextColor(int index,int color,int defortcolor){
		
	}
}
