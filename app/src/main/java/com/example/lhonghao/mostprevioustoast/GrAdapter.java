package com.example.lhonghao.mostprevioustoast;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

/**
 * Created by LiuHL on 2017/8/14.
 * qq:1173111672
 */
public  class GrAdapter extends SuperAdapter<Integer> {
    private final List datas;
    private String[] lists={"男士","女士","正确","错误","登录","事库"};

    public GrAdapter(Context context, List<Integer> items, @LayoutRes int layoutResId) {
        super(context, items, layoutResId);
        this.datas=items;
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, final int layoutPosition, Integer item) {
        ImageView iv = holder.findViewById(R.id.iv_item);
        iv.setImageResource((Integer) datas.toArray()[layoutPosition]);

        TextView textView = holder.findViewById(R.id.tv_item);
        textView.setText(lists[layoutPosition]);
        LinearLayout view = holder.getView(R.id.main_item);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), lists[layoutPosition], Toast.LENGTH_SHORT).show();
                starDetailActivity( layoutPosition);

            }
        });

    }

    private void starDetailActivity(int layoutPosition) {
        Intent intent=new Intent(getContext(),DetailActivity.class);
        intent.putExtra("name",lists[layoutPosition]);
        intent.putExtra("photo",(Integer) datas.toArray()[layoutPosition]);
        getContext().startActivity(intent);





    }


}
