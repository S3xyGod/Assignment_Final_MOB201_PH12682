package com.s3xygod.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.s3xygod.assignmentfinalmob201_ph12682.R;

import java.util.List;

public class AdapterKhoaCoSan extends BaseAdapter {
    List<KhoaHoc> lstKhoaHoc;
    public AdapterKhoaCoSan(List<KhoaHoc> lstKhoaHoc){
        this.lstKhoaHoc = lstKhoaHoc;
    }
    @Override
    public int getCount() {
        return lstKhoaHoc.size();
    }

    @Override
    public Object getItem(int position) {
        return lstKhoaHoc.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.khoa_san_one, viewGroup, false);
        TextView maKhoa = view.findViewById(R.id.maKhoa);
        TextView tenKhoa = view.findViewById(R.id.tenKhoa);
        maKhoa.setText(lstKhoaHoc.get(i).getId());
        tenKhoa.setText(lstKhoaHoc.get(i).getTen());
        view.findViewById(R.id.bnt_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLKhoaHoc sqlKhoaHoc = new SQLKhoaHoc(viewGroup.getContext());
                SQLKhoaSan sqlKhoaSan = new SQLKhoaSan(viewGroup.getContext());
                String id = lstKhoaHoc.get(i).id;
                String name = lstKhoaHoc.get(i).ten;
                KhoaHoc khoaHoc = new KhoaHoc(id,name);
                boolean a = sqlKhoaHoc.check(khoaHoc);
                if (a == true){
                    sqlKhoaHoc.addKhoaHoc(khoaHoc);
                    Toast.makeText(viewGroup.getContext(),"Đăng ký môn học thành công",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(viewGroup.getContext(), "Môn học này đã được đăng ký trước đó", Toast.LENGTH_LONG).show();
                }
                sqlKhoaSan.xoaKhoaHoc(id);
                lstKhoaHoc.remove(i);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
