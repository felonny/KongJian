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
		//�½�һ��������
		String[]arr_data = {"tangyuchen","tangyuchen","tangyuchen"};
		arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_data);
		
		dataList = new ArrayList<Map<String,Object>>() ;
		//from:������Դmap�е�ID
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
			map.put("text", "Ľ����"+i);
			dataList.add(map);
		}
		return dataList;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		String text = listview.getItemAtPosition(position)+"";
		//toast���һ������ָ����toast��ʱ��
		Toast.makeText(this,"position:"+position+"text:"+text, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		switch(scrollState){
		case SCROLL_STATE_FLING:
			Log.i("Main", "��ָ���뿪��Ļ֮ǰ�����Ļ�����һ�£���ͼ���ڹ������ڼ�������");
			Map<String, Object>map = new HashMap<String, Object>();
			map.put("img", R.drawable.ic_launcher);
			map.put("text", "������");
			dataList.add(map);
			simp_adapter.notifyDataSetChanged();
			break;
		case SCROLL_STATE_IDLE:
			Log.i("Main", "��ͼֹͣ����");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			Log.i("Main", "��ָû���뿪��Ļ����ͼ��������");
			break;
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		
	}
}