package com.example.lisview_basic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MonHocAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<MonHoc> monHocList;

    public MonHocAdapter(Context context, int layout, List<MonHoc> monHocList) {
        this.context = context;
        this.layout = layout;
        this.monHocList = monHocList;
    }

    //tra ve so dong hien thi vao listView
    @Override
    public int getCount() {
        return monHocList.size();//tra ve so luong du lieu theo list
    }


    //tra ve oj
    @Override
    public Object getItem(int i) {
        return null;
    }


    //tra ve id moi dong
    @Override
    public long getItemId(int i) {
        return 0;
    }

    //tra ve moi dong tren item, lay lan luot ra va gan vao view
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        //anh xa view
        TextView txt_ten_mon_hoc = (TextView) view.findViewById(R.id.txt_ten_mon_hoc);
        TextView txt_so_tin_chi = (TextView) view.findViewById(R.id.txt_so_tin_chi);

        //gan gia tri
        MonHoc monHoc = monHocList.get(i);
        txt_ten_mon_hoc.setText(monHoc.getTenMonHoc());
        txt_so_tin_chi.setText(monHoc.getSoTinChi());


        return view;
    }
}
