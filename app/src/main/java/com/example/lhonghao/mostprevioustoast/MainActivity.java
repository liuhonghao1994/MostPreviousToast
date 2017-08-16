package com.example.lhonghao.mostprevioustoast;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private GridView gridView;
    private GrAdapter grAdapter;
    private int[] datas = {R.drawable.default_head_man, R.drawable.default_head_woman, R.drawable.default_img,
            R.drawable.error_img, R.drawable.login_bg, R.drawable.login_shiku};
    private List<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gv);
        /*btn = (Button) findViewById(R.id.btn_main);*/
        for (int i = 0; i < datas.length; i++) {
            list.add(datas[i]);
        }
        grAdapter = new GrAdapter(this, list, R.layout.gv_item);
        gridView.setAdapter(grAdapter);


    }
}
