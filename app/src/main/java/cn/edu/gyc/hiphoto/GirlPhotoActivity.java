package cn.edu.gyc.hiphoto;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class GirlPhotoActivity extends Activity {

    public static final String EXTRA_GIRL_PHOTO = "GirlPhotoActivity.GIRL_PHOTO";
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl_photo);

        mImageView = (ImageView) findViewById(R.id.image);
        GirlPhoto girlPhoto = getIntent().getParcelableExtra(EXTRA_GIRL_PHOTO);

        Glide.with(this)
                .load(girlPhoto.getUrl())
                .asBitmap()
                .error(R.drawable.ic_launcher_foreground)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
    }
}
