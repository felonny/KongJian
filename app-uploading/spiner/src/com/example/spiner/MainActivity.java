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
		textview.setText("��ѡ����Ǳ���");
		spinner= (Spinner) findViewById(R.id.spinner);
		list = new ArrayList<String>();
		list.add("����");
		list.add("�Ϻ�");
		list.add("����");
		list.add("����");
		//����������
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item ,list);
		//adpter���һ�������б����ʽ
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//spinner����������
		spinner.setAdapter(adapter);
		//���ü�����
		spinner.setOnItemSelectedListener(this);
		
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		String cityName = adapter.getItem(position);
		textview.setText("��ѡ�����"+cityName);
	}
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

	
}
