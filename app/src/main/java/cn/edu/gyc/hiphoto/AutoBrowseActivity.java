package cn.edu.gyc.hiphoto;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;




import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

public class AutoBrowseActivity extends Activity {

        public final static int VIEW_TEXT = 0;
        public final static int VIEW_IMAGE = 1;
        boolean autoflag  =  true;
        Button previous,next,autoStart;
        ViewFlipper flipper;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_auto_browse);

            initiaView();


            GirlPhoto[] girlPhotos=GirlPhoto.getGirlPhotos();
            for(GirlPhoto girlPhoto:girlPhotos){
                flipper.addView(addImageById(girlPhoto.getUrl()));
            }

            flipper.setAutoStart(autoflag);
            flipper.startFlipping();
        }


        private void initiaView(){


            flipper = (ViewFlipper) findViewById(R.id.flipper);
            flipper.setInAnimation(AnimationUtils.loadAnimation(this,
                    android.R.anim.fade_in));
            flipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                    android.R.anim.fade_out));


          //  autoStart.setOnClickListener(listener);
        }

        private OnClickListener listener = new OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
             /*   switch(v.getId()){
                    case R.id.previousButton:
                        flipper.showPrevious();
                        break;

                    case R.id.nextButton:
                        flipper.showNext();
                        break;
                    case R.id.autoButton:

                        if(autoflag){  //自动播放
                            flipper.setAutoStart(autoflag);
                            flipper.startFlipping();
                            autoStart.setText("停止");
                            autoflag = false;
                        }else{      //取消自动播放
                            flipper.stopFlipping();
                            autoStart.setText("开始");
                            autoflag = true;
                        }
                        break;
                }//switch
                */
            }//onClick
        };//OnClickListener

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


    }

