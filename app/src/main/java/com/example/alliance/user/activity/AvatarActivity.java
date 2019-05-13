package com.example.alliance.user.activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alliance.R;

public class AvatarActivity extends AppCompatActivity {

    private static final String TAG = AvatarActivity.class.getCanonicalName();

    private ImageView avatar;
    private int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avatar_layout);

        avatar = findViewById(R.id.avatar);
        a = getIntent().getIntExtra("avatar",1);
        Log.e(TAG," " + a);
        avatar.setImageResource(a);
    }
}
