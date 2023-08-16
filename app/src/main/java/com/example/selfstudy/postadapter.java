package com.example.selfstudy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class postadapter extends BaseAdapter {

    private List<post> posts;
    private Context context;
    public postadapter(Context context, List<post> posts) {
        this.context = context;
        this.posts = posts;
    }


    @Override
    public int getCount() {
        if (posts != null) {
            return posts.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return posts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_items, viewGroup, false);
        }

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ImageView post = view.findViewById(R.id.post);
        ImageView fav = view.findViewById(R.id.fav);
        ImageView message = view.findViewById(R.id.letter);
        ImageView send = view.findViewById(R.id.send);
        ImageView bookmark = view.findViewById(R.id.bookmark);
        EditText comments = view.findViewById(R.id.comments);


        post p = (post) getItem(i);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Bitmap bitmap = null;
                    bitmap = BitmapFactory.decodeStream((InputStream) new URL(p.getToolbar()).getContent());
                    bitmap = BitmapFactory.decodeStream((InputStream) new URL(p.getPost()).getContent());
                    bitmap = BitmapFactory.decodeStream((InputStream) new URL(p.getFav()).getContent());
                    bitmap = BitmapFactory.decodeStream((InputStream) new URL(p.getMessage()).getContent());
                    bitmap = BitmapFactory.decodeStream((InputStream) new URL(p.getSend()).getContent());
                    bitmap = BitmapFactory.decodeStream((InputStream) new URL(p.getBookmark()).getContent());
                    bitmap = BitmapFactory.decodeStream((InputStream) new URL(p.getComments()).getContent());

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.inflate(R.menu.threedots);
            }
        });
        return view;
    }
}
