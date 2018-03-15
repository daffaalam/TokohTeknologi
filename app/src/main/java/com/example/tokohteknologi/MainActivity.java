package com.example.tokohteknologi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] judul_main = {
            "Andy Rubin",
            "Bill Gates",
            "James Gosling",
            "Larry Page",
            "Linus Torvalds",
            "Mark Zuckerberg",
            "Steve Jobs",
            "Tim Berners"
    };
    String http_main = "http://192.168.2.61/PRAKTIKUM-ABIYYU/";
    String[] item_main = {
            "andy-rubin.html",
            "bill-gates.html",
            "james-gosling.html",
            "larry-page.html",
            "linus-torvalds.html",
            "mark-zuckerberg.html",
            "steve-jobs.html",
            "tim-berners.html"
    };
    Integer[] logo_main = {
            R.drawable.android,
            R.drawable.microsoft,
            R.drawable.java,
            R.drawable.google,
            R.drawable.linux,
            R.drawable.facebook,
            R.drawable.apple,
            R.drawable.www
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("List Of Figure Of Teknologi");

        Dialog();
        List_View();
    }

    public void Dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle(R.string.app_name)
                .setIcon(R.mipmap.ic_launcher_round)
                .setMessage("Ini adalah aplikasi Para Tokoh Teknologi, hasil dari implementasi Web Server ke Aplikasi Android.\n\nBuild: 08 Februari 2018\n\nBy: Abiyyu Daffa' Alam")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();
    }

    public void List_View() {
        ListView listView = findViewById(R.id.list_main);
        listView.setAdapter(new Adapter(this, judul_main, logo_main));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder
                        .setTitle(judul_main[position])
                        .setIcon(logo_main[position])
                        .setMessage("Anda yakin ingin membuka halaman selanjutnya untuk " + judul_main[position] + "?")
                        .setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setPositiveButton("YA", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(MainActivity.this, DetailActivity.class).putExtra("LINK", http_main + item_main[position]));
                            }
                        }).show();
            }
        });
    }
}
