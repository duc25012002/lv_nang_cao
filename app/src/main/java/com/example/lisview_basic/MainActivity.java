package com.example.lisview_basic;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_mon_hoc;
    ArrayList<MonHoc> arrMonHoc;
    MonHocAdapter monHocAdapter;
    String luuTruTamThoi, monHoc, soTinChi;

    EditText edt_nhap_ten_mon_hoc, edt_nhap_so_tin_chi;

    Button btn_them_mon_hoc, btn_sua_mon_hoc;

    int viTriTamThoi = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        xuLySuKien();

    }

    private void xuLySuKien() {
        arrMonHoc = new ArrayList<>();
        arrMonHoc.add(new MonHoc("Toán cao cấp", "3"));
        arrMonHoc.add(new MonHoc("Lập trình hướng đối tương", "3"));
        arrMonHoc.add(new MonHoc("Lập trình cho thiết bị di động", "3"));
        arrMonHoc.add(new MonHoc("Cấu trúc dữ liệu và giải thuật", "3"));
        arrMonHoc.add(new MonHoc("Triết học Mac_lenin", "2"));
        arrMonHoc.add(new MonHoc("Tư tưởng Hồ Chí Minh", "2"));
        arrMonHoc.add(new MonHoc("Giáo dục thể chất 1", "1"));

        monHocAdapter = new MonHocAdapter(this, R.layout.item_mon_hoc, arrMonHoc);
        lv_mon_hoc.setAdapter(monHocAdapter);


        //xoa du lieu
        lv_mon_hoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                luuTruTamThoi = String.valueOf(arrMonHoc.get(i).getTenMonHoc() + " " + "\nSố tín chỉ: " + arrMonHoc.get(i).getSoTinChi());
                Toast.makeText(MainActivity.this, "Xóa thành công\n" + luuTruTamThoi, Toast.LENGTH_SHORT).show();
                arrMonHoc.remove(i);
                monHocAdapter.notifyDataSetChanged();
                return false;
            }
        });


        //them du lieu
        btn_them_mon_hoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monHoc = edt_nhap_ten_mon_hoc.getText().toString();
                soTinChi = edt_nhap_so_tin_chi.getText().toString();
                arrMonHoc.add(new MonHoc(monHoc, soTinChi));
                Toast.makeText(MainActivity.this, "Thêm môn học thành công", Toast.LENGTH_SHORT).show();
                monHocAdapter.notifyDataSetChanged();
            }
        });


        //sua du lieu
        lv_mon_hoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edt_nhap_ten_mon_hoc.setText(arrMonHoc.get(i).getTenMonHoc());
                edt_nhap_so_tin_chi.setText(arrMonHoc.get(i).getSoTinChi());
                viTriTamThoi = i;
            }
        });
        btn_sua_mon_hoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrMonHoc.set(viTriTamThoi, new MonHoc(edt_nhap_ten_mon_hoc.getText().toString(), edt_nhap_so_tin_chi.getText().toString()));

            }
        });


    }


    private void anhXa() {
        lv_mon_hoc = findViewById(R.id.lv_mon_hoc);
        edt_nhap_ten_mon_hoc = findViewById(R.id.edt_nhap_ten_mon_hoc);
        edt_nhap_so_tin_chi = findViewById(R.id.edt_nhap_so_tin_chi);
        btn_them_mon_hoc = findViewById(R.id.btn_them_mon_hoc);
        btn_sua_mon_hoc = findViewById(R.id.btn_sua_mon_hoc);


    }


}