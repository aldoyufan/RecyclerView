package com.example.recyclerview;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Button buttonReset = findViewById(R.id.buttonReset);

        List<ListItem> itemList = new ArrayList<>();
        itemList.add(new ListItem("1. nasi hitam"));
        itemList.add(new ListItem("2. kopi pait"));
        itemList.add(new ListItem("3. rawrrrrrrrrrrrrrrr"));
        itemList.add(new ListItem("4. mabar epep"));
        itemList.add(new ListItem("5. laptop Rusak"));
        itemList.add(new ListItem("6. mikir skit"));
        itemList.add(new ListItem("7. turu"));
        itemList.add(new ListItem("8. warnet"));
        itemList.add(new ListItem("9. lostrek"));
        itemList.add(new ListItem("10. iwak tempe"));

        adapter = new MyAdapter(itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        buttonReset.setOnClickListener(v -> adapter.resetAll());
    }
}
