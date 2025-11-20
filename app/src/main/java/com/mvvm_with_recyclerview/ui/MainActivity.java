package com.mvvm_with_recyclerview.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvm_with_recyclerview.R;
import com.mvvm_with_recyclerview.viewMpdel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_userslist;
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rv_userslist = findViewById(R.id.rv_userslist);

        rv_userslist.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv_userslist.setHasFixedSize(true);


        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUsers().observe(this, users -> {

            UserAdapter adapter = new UserAdapter(MainActivity.this, users);
            rv_userslist.setAdapter(adapter);

        });
    }
}