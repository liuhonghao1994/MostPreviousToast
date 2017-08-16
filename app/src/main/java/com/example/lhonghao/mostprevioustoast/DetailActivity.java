package com.example.lhonghao.mostprevioustoast;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_showdetail;
    private TextView tv_showdetail;
    private Button btn_shopping_cart;
    private Button btn_add_shopping_cart;
    private String name;
    private int photo;
    private Button cancle_btn;
    private Button confirm_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        initData();

    }

    private void initData() {
        name = getIntent().getStringExtra("name");
        photo = getIntent().getIntExtra("photo", 0);
        tv_showdetail.setText(name);
        iv_showdetail.setImageResource(photo);
    }

    private void initView() {
        iv_showdetail = (ImageView) findViewById(R.id.iv_showdetail);
        tv_showdetail = (TextView) findViewById(R.id.tv_showdetail);
        btn_shopping_cart = (Button) findViewById(R.id.btn_shopping_cart);
        btn_add_shopping_cart = (Button) findViewById(R.id.btn_add_shopping_cart);

        btn_shopping_cart.setOnClickListener(this);
        btn_add_shopping_cart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_shopping_cart:


                break;
            case R.id.btn_add_shopping_cart:
                showPopwindow();
                break;
        }
    }
    private void showPopwindow() {

        // 1 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popupwindow_add_product, null);

        // 2下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        //把加载的view放进popupwindow里面去
        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 3 参数设置
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFFFFFFF);
        window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 5 在底部显示
        window.showAtLocation(DetailActivity.this.findViewById(R.id.ly_sec),Gravity.BOTTOM,0,0);
        cancle_btn = (Button) view.findViewById(R.id.bt_goodinfo_cancel);
        confirm_btn = (Button) view.findViewById(R.id.bt_goodinfo_confim);
        cancle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });

        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
    }




}
