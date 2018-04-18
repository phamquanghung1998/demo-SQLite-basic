package com.example.tofu.sqlite;

import android.app.Dialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    myDatabase database;
    ListView lsCongViec;
    ArrayList<CongViec> arrayCongViec;
    CongViecAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lsCongViec = (ListView)findViewById(R.id.listViewCongViec);
        arrayCongViec = new ArrayList<>();
        adapter= new CongViecAdapter(this,R.layout.dong_cong_viec,arrayCongViec);
        lsCongViec.setAdapter(adapter);
        // tạo Database ghi chú
        database = new myDatabase(this,"ghichu.sqlite",null,1);
        // tạo công việc
        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHA(200))");
        database.QueryData("INSERT INTO CongViec VALUES(null,'Viết ứng dụng ghi chú ')");
        // selec data
    GetDataCongViec();

    }
    private void GetDataCongViec(){
        arrayCongViec.clear();
        Cursor dataCongViec = database.getData("SELECT * FROM  CongViec");
        while(dataCongViec.moveToNext())
        {


            String ten = dataCongViec.getString(1);
            Toast.makeText(this,ten,Toast.LENGTH_LONG).show();
            int id=dataCongViec.getInt(0);

            arrayCongViec.add(new CongViec(id,ten));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.menuAdd)
        {
            DialogThem();
        }


        return super.onOptionsItemSelected(item);
    }
    private void DialogThem() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_job);

        final EditText edtTen = dialog.findViewById(R.id.textTenCV);
        Button btnThem = (Button)dialog.findViewById(R.id.ButtonAdd);
        Button btnHuy = (Button) dialog.findViewById(R.id.ButtonCancel);

       btnThem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String tencv = edtTen.getText().toString();
               if (tencv.equals("")){
                   //Toast.makeText(this,"Vui lòng nhập tên công việc ",Toast.LENGTH_SHORT).show();

               }
               else
               {
                   database.QueryData("INSERT INTO CongViec VALUES(null,'"+tencv+"')");
                 //  Toast.makeText(this,"Đã thêm thành công",Toast.LENGTH_SHORT).show();
                   dialog.dismiss();
                   GetDataCongViec();

               }
           }
       });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        dialog.show();
    }
}


