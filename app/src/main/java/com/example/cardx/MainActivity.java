package com.example.cardx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MyDialog.OnCenterItemClickListener {
    private  MyDialog myDialog;

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
        FloatingActionButton boardButton = (FloatingActionButton) findViewById(R.id.fab_add_board_main_activity);
        boardButton.setOnClickListener(this);
        myDialog = new MyDialog(this,R.layout.dialog_display_board,new int[]{R.id.btn_build,R.id.btn_cancel});
        myDialog.setOnCenterItemClickListener((MyDialog.OnCenterItemClickListener) this);
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

    /**
     * 自定义dialog_display_board 布局
     */
    private void diyDialog(){
        AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(MainActivity.this,R.style.MyDialog);
        alterDiaglog.setView(R.layout.dialog_display_board);
        AlertDialog dialog = alterDiaglog.create();
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab_add_board_main_activity)
        {
            myDialog.show();
        }
    }

    @Override
    public void OnCenterItemClick(MyDialog dialog, View view) {
        if (view.getId() == R.id.btn_build)
        {
            Toast.makeText(getApplicationContext(), "创建成功", Toast.LENGTH_SHORT).show();
        }
    }
}
