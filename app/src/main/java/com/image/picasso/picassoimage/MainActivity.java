package com.image.picasso.picassoimage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv;
    int i = 0;
    Button btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.iv);

        //Simple method of Picasso
        Picasso.with(this).load("http://scificoder.com/scifi-coder.PNG")
                .error(R.drawable.error)
                .placeholder(R.drawable.default_opt)
                .resize(400, 400)
                .into(iv);

        initView();
    }

    public void initView() {
        btn = (Button) findViewById(R.id.button);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);

        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            //Drawable method
            case R.id.button:
                Picasso.with(this).load(R.drawable.messenge).into(iv);
                break;

            //Placeholder method
            case R.id.btn1:
                Picasso.with(this).load("sificoder.com").placeholder(R.drawable.logo).into(iv);
                break;

            //Load Ulr method
            case R.id.btn2:
                Picasso.with(this).load("http://res.cloudinary.com/alok355/image/upload/v1499578179/image00_sdoev4.png").placeholder(R.drawable.default_opt).error(R.drawable.error).into(iv);
                break;

            //Error method
            case R.id.btn3:
                Picasso.with(this).load("scificoder.com").placeholder(R.drawable.logo).error(R.drawable.error).into(iv);
                break;

            //CallBack method
            case R.id.btn4:                                             //Below image url id wrong .jpg so error occurred
                Picasso.with(this).load("http://res.cloudinary.com/alok355/image/upload/v1512939658/xaomi-redmi-5-need-update_hnhkqy.jp").error(R.drawable.error).into(iv, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("TAG", "onSuccess");
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(getApplicationContext(), " Error occurred", Toast.LENGTH_SHORT).show();

                    }
                });
                break;

            //Resize method
            case R.id.btn5:
                Picasso.with(this).load(R.drawable.car).resize(200, 200).into(iv);
                break;

            //Rotate method
            case R.id.btn6:
                Picasso.with(this).load(R.drawable.car).rotate(90f).into(iv);
                break;

            //Scale method
            case R.id.btn7:
                if (i == 3)
                    i = 0;

                else {
                    if (i == 0) {
                        Picasso.with(this).load(R.drawable.car).fit().into(iv);
                        Toast.makeText(getApplicationContext(), "Fit", Toast.LENGTH_SHORT).show();
                    } else if (i == 1) {
                        Picasso.with(this).load(R.drawable.car).resize(200, 200).centerCrop().into(iv);
                        Toast.makeText(getApplicationContext(), "Image Crop", Toast.LENGTH_SHORT).show();

                    } else if (i == 2) {
                        Picasso.with(this).load(R.drawable.car).resize(200, 200).centerInside().into(iv);
                        Toast.makeText(getApplicationContext(), "Center Inside", Toast.LENGTH_SHORT).show();
                    }
                    i++;
                }
                break;

            //Target Method
            case R.id.btn8:
                Picasso.with(this).load("http://res.cloudinary.com/alok355/image/upload/v1512939658/xaomi-redmi-5-need-update_hnhkqy.jpg").placeholder(R.drawable.default_opt).error(R.drawable.error).into(target);
                break;
        }
    }

    private Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            iv.setImageBitmap(bitmap);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            iv.setImageDrawable(errorDrawable);
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            iv.setImageDrawable(placeHolderDrawable);
        }
    };

}
