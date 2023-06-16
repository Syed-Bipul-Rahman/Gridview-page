package com.recyclerview.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    String name;
    String image;
    int imageResourceId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView2);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        imageResourceId = intent.getIntExtra("image", 0);


        textView.setText(name);


        imageView.setImageResource(imageResourceId);

    }
}
