package com.ball.newglideproject;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.drawee.view.SimpleDraweeView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 　　Fresco官方中文介绍文档：https://www.fresco-cn.org/
 *
 * 　　Fresco GitHub 地址：https://github.com/facebook/fresco
 *
 *    Glide:https://github.com/bumptech/glide
 */
public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    SimpleDraweeView mImageView2;
    private String mImagePath = "http://bmob-cdn-24653.bmobpay.com/2019/07/04/e73fc6c6836e44c69944ee2b1949a9d0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.im_main);

        mImageView2 = findViewById(R.id.im_main2);

        //新版Glide(4.6.0 之后)  需要设置options
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide.with(this).load(mImagePath)
                .transforms(new CenterCrop(), new RoundedCorners(20))
                .apply(options).into(mImageView);

        mImageView2.setImageURI(mImagePath);
    }
}
