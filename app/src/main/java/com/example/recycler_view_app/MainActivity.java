package com.example.recycler_view_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemsClickListner{

    RecyclerView recyclerView;
    List<model_class> list;

    custom_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        list=new ArrayList<>();

        model_class i1=new model_class(R.drawable.beverage,"beverage","Cold Drinks & Coffee ");
        model_class i2=new model_class(R.drawable.bread,"bread","Soft Delicious Bread");
        model_class i3=new model_class(R.drawable.fruit,"fruit","Juicy & flavourful");
        model_class i4=new model_class(R.drawable.milk,"milk","Pure Cow Milk");
        model_class i5=new model_class(R.drawable.popcorn,"popcorn","Sweet & Salty");
        model_class i6=new model_class(R.drawable.vegitables,"vegetables","Green & Fresh");

        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        list.add(i5);
        list.add(i6);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        adapter=new custom_adapter(list);
        recyclerView.setAdapter(adapter);

        adapter.setClickListner(this);

    }


    @Override
    public void onClick(View view, int pos) {

        if(list.get(pos).getTitle()=="milk"){
            Intent intent=new Intent(this,milk.class);
            startActivity(intent);
        }
        else if(list.get(pos).getTitle()=="beverage"){
            Intent intent=new Intent(this,beverage.class);
            startActivity(intent);
        }
        else if(list.get(pos).getTitle()=="bread"){
            Intent intent=new Intent(this,bread.class);
            startActivity(intent);
        }
        else if(list.get(pos).getTitle()=="fruit"){
            Intent intent=new Intent(this,fruit.class);
            startActivity(intent);
        }
        else if(list.get(pos).getTitle()=="popcorn"){
            Intent intent=new Intent(this,popcorn.class);
            startActivity(intent);
        }
        else if(list.get(pos).getTitle()=="vegetables"){
            Intent intent=new Intent(this,vegetables.class);
            startActivity(intent);
        }

    }

}