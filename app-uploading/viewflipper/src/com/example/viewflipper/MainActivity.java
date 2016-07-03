package com.example.viewflipper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends ActionBarActivity {

	private ViewFlipper flipper;
	private int[] resId={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};
	private float startX;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		flipper = (ViewFlipper) findViewById(R.id.flipper);
		//动态导入为viewflipper加入子view
		    for(int i = 0;i<resId.length;i++){
		    	flipper.addView(getImageView(resId[i]));
		    }
		    //为viewflipper添加动画效果，
		  /*  flipper.setInAnimation(this,R.anim.left_in);
		    flipper.setOutAnimation(this, R.anim.left_out);
		    //为viewflipper视图切换时间间隔
		    flipper.setFlipInterval(3000);
		    flipper.startFlipping();*/
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		//手指落下
		case MotionEvent.ACTION_DOWN:
		{
			startX = event.getX();
			break;
		}
        case MotionEvent.ACTION_MOVE:
			if(event.getX() - startX >100){
				flipper.setInAnimation(this, R.anim.left_in);
				flipper.setOutAnimation(this, R.anim.left_out);
				//显示前一页
				flipper.showPrevious();
			}
			if(startX-event.getX() >100){
				flipper.setInAnimation(this, R.anim.right_in);
				flipper.setOutAnimation(this, R.anim.right_out);
				//显示前一页
				flipper.showNext();
			}
			break;
        case MotionEvent.ACTION_UP:
			
			break;
		default:
			break;
		}
		return super.onTouchEvent(event);
	}
	private ImageView getImageView(int resId){
		ImageView image = new ImageView(this);
		//image.setImageResource(resId);
		image.setBackgroundResource(resId);
		return image;
	}

	
}
