package com.example.cardx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbarMainActivity = findViewById(R.id.toolbar_main_activity);
        setSupportActionBar(toolbarMainActivity);
        final LinearLayout linearLayoutAddBoardMainActivity=findViewById(R.id.linearlayout_add_board_main_activity);
        final LinearLayout linearLayoutAddCardMainActivity=findViewById(R.id.linearlayout_add_card_main_activity);
        linearLayoutAddBoardMainActivity.setVisibility(View.GONE);
        linearLayoutAddCardMainActivity.setVisibility(View.GONE);
        FloatingActionButton fabAddMainActivity=findViewById(R.id.fab_add_main_activity);
        fabAddMainActivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (linearLayoutAddBoardMainActivity.getVisibility()==View.GONE&&linearLayoutAddCardMainActivity.getVisibility()==View.GONE)
                {
                    linearLayoutAddBoardMainActivity.setVisibility(View.VISIBLE);
                    linearLayoutAddCardMainActivity.setVisibility(View.VISIBLE);
                }
                else
                {
                    linearLayoutAddBoardMainActivity.setVisibility(View.GONE);
                    linearLayoutAddCardMainActivity.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId()==R.id.search_main_toolbar)
        {
            Intent intent=new Intent(MainActivity.this,SearchMainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
