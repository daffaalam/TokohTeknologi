package com.example.tokohteknologi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<String> {
    private Activity activity;
    private String[] judul_adapter;
    private Integer[] gambar_adapter;

    Adapter(Activity activity, String[] judul_adapter, Integer[] gambar_adapter) {
        super(activity, R.layout.item_list, judul_adapter);
        this.activity = activity;
        this.judul_adapter = judul_adapter;
        this.gambar_adapter = gambar_adapter;
    }

    @NonNull
    public View getView(int posisi, View view, @NonNull ViewGroup parent) {
        @SuppressLint({"ViewHolder", "InflateParams"}) View v = activity.getLayoutInflater().inflate(R.layout.item_list, null, true);
        ImageView gambar = v.findViewById(R.id.image_item);
        gambar.setImageResource(gambar_adapter[posisi]);
        TextView judul = v.findViewById(R.id.text_item);
        judul.setText(judul_adapter[posisi]);
        return v;
    }
}
