package com.example.spiner;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener{
    private TextView textview;
    private Spinner spinner;
    private List<String> list ;
    private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textview = (TextView) findViewById(R.id.textView);
		textview.setText("你选择的是北京");
		spinner= (Spinner) findViewById(R.id.spinner);
		list = new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("广州");
		list.add("深圳");
		//数组设配器
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item ,list);
		//adpter设计一个下拉列表的样式
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//spinner加载适配器
		spinner.setAdapter(adapter);
		//设置监听器
		spinner.setOnItemSelectedListener(this);
		
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		String cityName = adapter.getItem(position);
		textview.setText("你选择的是"+cityName);
	}
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

	
}
