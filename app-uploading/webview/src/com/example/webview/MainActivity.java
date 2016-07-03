package com.example.webview;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends ActionBarActivity {
    private WebView webView;
    private String url="http://www.hao123.com";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web);
		//Uri uri = Uri.parse(url);
		//Intent intent = new Intent(Intent.ACTION_VIEW,uri);
		//startActivity(intent);
		init(); 
	}
	private void init() {
		// TODO Auto-generated method stub
		webView = (WebView) findViewById(R.id.webView);
		//���ر�����Դ
		//webView.loadUrl("file:///android_asset/css15.html");
		//����web��Դ
		webView.loadUrl(url);
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				//����ֵΪtrueʱ��webview�д򿪣�false����ϵͳ�������
				view.loadUrl(url);
				return true;
			}
		});
		//����֧��javascript
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		
		
	}
	//������������������ڱ׶ˣ��ڵ�����ؼ���ʱ��᷵�ص��������˵���
			//��д���������ص��߼�
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
	    // TODO Auto-generated method stub
    	if(keyCode == KeyEvent.KEYCODE_BACK){
    		if(webView.canGoBack()){
    			webView.goBack();
    			return true;
    		}
    		else{
    			System.exit(0);//�˳�����
    		}
    	}
	    return super.onKeyDown(keyCode, event);
    }


	
}
