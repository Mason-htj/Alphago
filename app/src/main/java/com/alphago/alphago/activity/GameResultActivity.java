package com.alphago.alphago.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.alphago.alphago.NoStatusBarActivity;
import com.alphago.alphago.R;

public class GameResultActivity extends NoStatusBarActivity {

    private final int WORD_GAME = 0;
    private final int IMAGE_GAME = 1;

    private int type;
    private boolean res[] = new boolean[10];
    private int count = 0;

    private Button btn_rgame_ret;
    private Button btn_rgame_home;
    private ImageView img_rgame_result;

    private ImageView img_res1;
    private ImageView img_res2;
    private ImageView img_res3;
    private ImageView img_res4;
    private ImageView img_res5;
    private ImageView img_res6;
    private ImageView img_res7;
    private ImageView img_res8;
    private ImageView img_res9;
    private ImageView img_res10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        btn_rgame_ret = (Button)findViewById(R.id.btn_rgame_ret);
        btn_rgame_home = (Button)findViewById(R.id.btn_rgame_home);
        img_rgame_result = (ImageView)findViewById(R.id.img_rgame_result);

        img_res1 = (ImageView)findViewById(R.id.img_res1);
        img_res2 = (ImageView)findViewById(R.id.img_res2);
        img_res3 = (ImageView)findViewById(R.id.img_res3);
        img_res4 = (ImageView)findViewById(R.id.img_res4);
        img_res5 = (ImageView)findViewById(R.id.img_res5);
        img_res6 = (ImageView)findViewById(R.id.img_res6);
        img_res7 = (ImageView)findViewById(R.id.img_res7);
        img_res8 = (ImageView)findViewById(R.id.img_res8);
        img_res9 = (ImageView)findViewById(R.id.img_res9);
        img_res10 = (ImageView)findViewById(R.id.img_res10);

        ImageView img_result[] = {img_res1, img_res2, img_res3, img_res4, img_res5,
                img_res6, img_res7, img_res8, img_res9, img_res10};

        Intent intent = getIntent();
        res = intent.getBooleanArrayExtra("result");
        for (int i = 0; i < 10; i++) {
            if (res[i] == true) {
                img_result[i].setImageResource(R.drawable.img_game_res);
                count++;
            }
            else
                img_result[i].setImageResource(R.drawable.img_game_res2);
        }

        if (count > 7 && count <= 10)
            img_rgame_result.setImageResource(R.drawable.bg_result1);
        else if (count > 4 && count <= 7)
            img_rgame_result.setImageResource(R.drawable.bg_result2);
        else if (count >= 0 && count <= 4)
            img_rgame_result.setImageResource(R.drawable.bg_result3);

        Button.OnClickListener onClickListener = new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_rgame_ret :
                        intent = getIntent();
                        type = intent.getIntExtra("type", 0);
                        if (type == WORD_GAME)
                            intent = new Intent(getApplicationContext(), GameWordActivity2.class);
                        else if (type == IMAGE_GAME)
                            intent = new Intent(getApplicationContext(), GameImageActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.btn_rgame_home :
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        };
        btn_rgame_ret.setOnClickListener(onClickListener);
        btn_rgame_home.setOnClickListener(onClickListener);
    }
}