package cn.edu.gyc.hiphoto;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static cn.edu.gyc.hiphoto.GirlPhotoActivity.EXTRA_GIRL_PHOTO;

public class BrowseActivity extends Activity {
    String tag="BrowseActivity";

    ViewFlipper flipper;
    private final static int MIN_MOVE = 200;   //最小距离
    private MyGestureListener mgListener;
    private GestureDetector mDetector;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_browse);

        initiaView();

        mgListener = new MyGestureListener();
        mDetector = new GestureDetector(this, mgListener);


        GirlPhoto[] girlPhotos=GirlPhoto.getGirlPhotos();
        for(GirlPhoto photo:girlPhotos){
            flipper.addView(addImageById(photo.getUrl()));
        }
        ArrayList<String> imgUrls=new ArrayList<>();
        for(GirlPhoto girlPhoto1:girlPhotos){
            imgUrls.add(girlPhoto1.getUrl());
        }
        GirlPhoto girlPhoto = getIntent().getParcelableExtra("show");
        girlPhoto.getUrl();

        int startIndex=imgUrls.indexOf(girlPhoto.getUrl());

        Log.d("BrowseActivity","start:"+startIndex+" url:"+girlPhoto.getUrl());
        flipper.setDisplayedChild(startIndex);

    }


    private void initiaView(){


        flipper = (ViewFlipper) findViewById(R.id.flipper);
        flipper.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        flipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));


        //  autoStart.setOnClickListener(listener);
    }


    //重写onTouchEvent触发MyGestureListener里的方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(tag,"Called OnTouchEvent()");
        return mDetector.onTouchEvent(event);
    }
    public View addTextByText(String text){
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setGravity(1);
        return tv;
    }

    public View addImageById(String url){
        ImageView iv = new ImageView(this);
        Glide.with(this).load(url).into(iv);


        return iv;
    }

    //自定义一个GestureListener,这个是View类下的，别写错哦！！！
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
            if(e1.getX() - e2.getX() > MIN_MOVE){
                flipper.setInAnimation(BrowseActivity.this,R.anim.right_in);
                flipper.setOutAnimation(BrowseActivity.this, R.anim.right_out);
                flipper.showNext();

            }else if(e2.getX() - e1.getX() > MIN_MOVE){
                flipper.setInAnimation(BrowseActivity.this,R.anim.left_in);
                flipper.setOutAnimation(BrowseActivity.this, R.anim.left_out);
                flipper.showPrevious();
            }
            return true;
        }
    }
}
