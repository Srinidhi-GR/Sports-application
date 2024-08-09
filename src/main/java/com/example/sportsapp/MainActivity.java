package com.example.sportsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    ArrayList<cardModelClass> cards;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        cards = new ArrayList<>();
        cards.add(new cardModelClass(R.drawable.volley, "Volleyball"));
        cards.add(new cardModelClass(R.drawable.basketball, "Basketball"));
        cards.add(new cardModelClass(R.drawable.ping, "Ping"));
        cards.add(new cardModelClass(R.drawable.football, "Football"));
        cards.add(new cardModelClass(R.drawable.tennis, "Tennis"));

        customAdapter = new CustomAdapter(cards);
        recyclerView.setAdapter(customAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        customAdapter.setClickListener(this);

    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, cards.get(pos).getSportsName(), Toast.LENGTH_SHORT).show();
    }
}