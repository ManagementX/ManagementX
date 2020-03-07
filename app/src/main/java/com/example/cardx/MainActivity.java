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
    private  MyDialog myDialog_board;
    private  MyDialog myDialog_card;
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
        /**
         * 创建看板
         */
        FloatingActionButton boardButton = (FloatingActionButton) findViewById(R.id.fab_add_board_main_activity);
        boardButton.setOnClickListener(this);
        myDialog_board = new MyDialog(this,R.layout.dialog_display_board,new int[]{R.id.btn_build,R.id.btn_cancel});
        myDialog_board.setOnCenterItemClickListener((MyDialog.OnCenterItemClickListener) this);
        /**
         * 创建卡片
         */
        FloatingActionButton cardButton = (FloatingActionButton) findViewById(R.id.fab_add_card_main_activity);
        cardButton.setOnClickListener(this);
        myDialog_card = new MyDialog(this,R.layout.dialog_card,new int[]{R.id.btn_build_1,R.id.btn_cancel_1});
        myDialog_card.setOnCenterItemClickListener((MyDialog.OnCenterItemClickListener)this);
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
     * 点击创建看板和卡片
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab_add_board_main_activity) {
            myDialog_board.show();
        }else if(v.getId() == R.id.fab_add_card_main_activity){
            myDialog_card.show();
        }

    }

    /**
     * 接口
     * 点击dialog中创建
     * btn_build 代表看板的创建
     * btn_card 代表卡片的创建
     * @param dialog
     * @param view
     */
    @Override
    public void OnCenterItemClick(MyDialog dialog, View view) {
        if (view.getId() == R.id.btn_build) {
            Toast.makeText(getApplicationContext(), "创建看板成功", Toast.LENGTH_SHORT).show();
        }else if(view.getId() == R.id.btn_build_1){
            Toast.makeText(getApplicationContext(),"创建卡片成功",Toast.LENGTH_SHORT).show();
        }
    }
}
