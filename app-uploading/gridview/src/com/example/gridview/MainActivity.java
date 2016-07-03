package com.example.gridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class MainActivity extends ActionBarActivity {

	private GridView gridView;
	private List<Map<String, Object>>dataList;
	
	private SimpleAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gridView =(GridView) findViewById(R.id.gridView);
		//1.准备数据源
		List<Map<String, Object>>dataList = new ArrayList<Map<String,Object>>();
		adapter= new SimpleAdapter(this, getdata(), R.layout.item, new String[]{"img","text"}, new int[]{R.id.image,R.id.text});
	    gridView.setAdapter(adapter);
	}
	private List<Map<String, Object>> getdata() {
		private int[]icon = {R.drawable.address_book,R.drawable.calendar,R.drawable.camera,R.drawable.clock,R.drawable.games_control,R.drawable.messenger,R.drawable.ringtone,R.drawable.settings,R.drawable.speech_balloon,R.drawable.weather,R.drawable.world,R.drawable.youtube};
	        private String[] iconName = {"通信录","日历","照相机","时钟","游戏","短信","铃声","设置","语音","天气","浏览器","视频"};
		// TODO Auto-generated method stub
		for(int i = 0;i<icon.length;i++){
			Map<String, Object>map = new HashMap<String, Object>();
			map.put("img",icon[i] );
			map.put("text", iconName[i]);
			dataList.add(map);
		}
		
		return dataList;
	}

	
}
