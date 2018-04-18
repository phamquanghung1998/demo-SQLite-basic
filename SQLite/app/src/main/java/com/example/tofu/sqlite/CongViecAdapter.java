package com.example.tofu.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CongViecAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<CongViec> congViecList;

    public CongViecAdapter(Context context, int layout, List<CongViec> congViecList) {
        this.context = context;
        this.layout = layout;
        this.congViecList = congViecList;
    }

    @Override
    public int getCount() {
        return congViecList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView txtTen;
        ImageView imgDelete,imgEdit;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ViewHolder holder;
      if(convertView ==null)
      {
          holder = new ViewHolder();
          LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          convertView = inflater.inflate(layout,null);
          holder.txtTen = (TextView) convertView.findViewById(R.id.TextViewTen);
          holder.imgDelete =(ImageView) convertView.findViewById(R.id.del);
          holder.imgEdit = (ImageView) convertView.findViewById(R.id.edit);
          convertView.setTag(holder);
      } else
      {
           holder = (ViewHolder) convertView.getTag();

      }
         CongViec congViec = congViecList.get(position);

        holder.txtTen.setText(congViec.getTenCV());




        return convertView;
    }
}
