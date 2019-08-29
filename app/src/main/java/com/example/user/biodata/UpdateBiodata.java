package com.example.user.biodata;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {

    private Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1,text2,text3,text4,text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        dbHelper=new DataHelper(this);

        text1=(EditText)findViewById(R.id.edit1);
        text2=(EditText)findViewById(R.id.edit2);
        text3=(EditText)findViewById(R.id.edit3);
        text4=(EditText)findViewById(R.id.edit4);
        text5=(EditText)findViewById(R.id.edit5);

        SQLiteDatabase db=dbHelper.getReadableDatabase();
        cursor=db.rawQuery("SELECT * FROM biodata WHERE nama='"+
        getIntent().getStringExtra("nama")+"",null);

        cursor.moveToFirst();
        if(cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }

        ton1=(Button)findViewById(R.id.btn1);
        ton2=(Button)findViewById(R.id.btn2);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getReadableDatabase();

                db.execSQL("update biodata set nama='"+
                    text2.getText().toString()+"',alamat='"+
                    text2.getText().toString()+"',tanggal lahir='"+
                    text3.getText().toString()+"',Sekolah='"+
                    text4.getText().toString()+"',Hobbi='"+
                    text5.getText().toString()+"'where no='"+
                    text1.getText().toString()+"");

                Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_LONG).show();

                MainActivity.utama.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
