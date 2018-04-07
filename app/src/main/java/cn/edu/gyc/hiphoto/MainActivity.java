package cn.edu.gyc.hiphoto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        ImageGalleryAdapter adapter = new ImageGalleryAdapter(this, GirlPhoto.getGirlPhotos());
        recyclerView.setAdapter(adapter);
    }

    private class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder>  {

        @Override
        public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View photoView = inflater.inflate(R.layout.item, parent, false);
            ImageGalleryAdapter.MyViewHolder viewHolder = new ImageGalleryAdapter.MyViewHolder(photoView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ImageGalleryAdapter.MyViewHolder holder, int position) {

            GirlPhoto girlPhoto = girlPhotos[position];
            ImageView imageView = holder.mPhotoImageView;
            Glide.with(mContext).load(girlPhoto.getUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);
        }

        @Override
        public int getItemCount() {
            return (girlPhotos.length);
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public ImageView mPhotoImageView;

            public MyViewHolder(View itemView) {

                super(itemView);
                mPhotoImageView = (ImageView) itemView.findViewById(R.id.photoiv);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {

                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    GirlPhoto girlPhoto = girlPhotos[position];
                    Intent intent = new Intent(mContext, GirlPhotoActivity.class);
                    intent.putExtra(GirlPhotoActivity.EXTRA_GIRL_PHOTO, girlPhoto);
                    startActivity(intent);
                }
            }
        }

        private GirlPhoto[] girlPhotos;
        private Context mContext;

        public ImageGalleryAdapter(Context context, GirlPhoto[] girlPhotos) {
            mContext = context;
            this.girlPhotos = girlPhotos;
        }
    }
}

