package com.example.selfstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView postListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postListView = findViewById(R.id.postListView);

        List<post> posts = generateSamplePosts();
        postadapter adapter = new postadapter(this, posts);
        postListView.setAdapter(adapter);

    }

    private List<post> generateSamplePosts() {
        List<post> posts = new ArrayList<>();
        posts.add(new post("toolbar", "post", "fav", "message", "send", "bookmark", "comments"));
        posts.add(new post("toolbar", "post", "fav", "message", "send", "bookmark", "comments"));
        posts.add(new post("toolbar", "post", "fav", "message", "send", "bookmark", "comments"));
        return posts;
    }
}