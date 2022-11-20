package com.wahyudif55121078.mylistview;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.wahyudif55121078.mylistview.Hero;
import com.wahyudif55121078.mylistview.HeroAdapter;
import com.wahyudif55121078.mylistview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] datadescription;
    private TypedArray dataPhoto;
    private HeroAdapter adapter;
    private ArrayList<Hero> heroes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter= new HeroAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long l) {
                if (position == 0) {
                    //clicked Ahmad Dahlan
                    startActivity(new Intent(MainActivity.this, ahmad_dahlan.class));
                } else if (position == 1) {
                    //clicked Ahmad Yani
                    startActivity(new Intent(MainActivity.this, ahmad_yani.class));
                } else if (position == 2) {
                    //clicked Sutomo
                    startActivity(new Intent(MainActivity.this, sutomo.class));
                } else if (position == 3) {
                    //clicked Gatot Soebroto
                    startActivity(new Intent(MainActivity.this, gatot_soebroto.class));
                } else if (position == 4) {
                    //clicked Ki Hadjar Dewantara
                    startActivity(new Intent(MainActivity.this, ki_hajar_dewantara.class));
                } else if (position == 5) {
                    //clicked Mohammad Hatta
                    startActivity(new Intent(MainActivity.this, mohammad_hatta.class));
                } else if (position == 6) {
                    //clicked Soedirman
                    startActivity(new Intent(MainActivity.this, soedirman.class));
                } else if (position == 7) {
                    //clicked Soepomo
                    startActivity(new Intent(MainActivity.this, soekarno.class));
                } else if (position == 8){
                    startActivity(new Intent(MainActivity.this, soepomo.class));
                } else {
                    startActivity(new Intent(MainActivity.this, tan_malaka.class));


                }
            }
        });
    }
    private void prepare() {
        dataName =
                getResources().getStringArray(R.array.data_name);
        datadescription =
                getResources().getStringArray(R.array.data_description);
        dataPhoto =
                getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem(){
        heroes = new ArrayList<>();

        for (int i=0; i<dataName.length; i++) {
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(datadescription[i]);
            heroes.add(hero);

        }
        adapter.setHeroes(heroes);
    }
}