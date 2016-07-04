package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemClickListener,OnScrollListener {
    private ListView listview;
    private ArrayAdapter<String>arr_adapter;
    private SimpleAdapter simp_adapter;
    private List<Map<String, Object>>dataList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listview = (ListView) findViewById(R.id.listView);
		//新建一个适配器
		String[]arr_data = {"tangyuchen","tangyuchen","tangyuchen"};
		arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_data);
		
		dataList = new ArrayList<Map<String,Object>>() ;
		//from:从数据源map中的ID
		simp_adapter = new SimpleAdapter(this, getdata(), R.layout.item, new String[]{"img","text"}, new int[]{R.id.imageView,R.id.textview});
		//listview.setAdapter(arr_adapter);
		listview.setAdapter(arr_adapter);
		listview.setOnItemClickListener(this);
		listview.setOnScrollListener(this);
	}

	private List<Map<String, Object>> getdata(){
		for(int i = 0;i<20;i++){
			Map<String, Object>map = new HashMap<String, Object>();
			map.put("img", R.drawable.ic_launcher);
			map.put("text", "慕课网"+i);
			dataList.add(map);
		}
		return dataList;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		String text = listview.getItemAtPosition(position)+"";
		//toast最后一个参数指的是toast的时间
		Toast.makeText(this,"position:"+position+"text:"+text, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		switch(scrollState){
		case SCROLL_STATE_FLING:
			Log.i("Main", "手指在离开屏幕之前用力的滑动了一下，视图由于惯性仍在继续滑动");
			Map<String, Object>map = new HashMap<String, Object>();
			map.put("img", R.drawable.ic_launcher);
			map.put("text", "增加项");
			dataList.add(map);
			simp_adapter.notifyDataSetChanged();
			break;
		case SCROLL_STATE_IDLE:
			Log.i("Main", "视图停止滑动");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			Log.i("Main", "手指没有离开屏幕，视图继续滑动");
			break;
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		
	}
}