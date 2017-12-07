package com.harlan.lhc.listviewitemedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.harlan.lhc.listviewitemedittext.adapter.AddTypeAdapter;
import com.harlan.lhc.listviewitemedittext.adapter.LSwipeAdapter;
import com.harlan.lhc.listviewitemedittext.bean.Student;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    List<Student> students = new ArrayList<>();
    @Bind(R.id.get)
    TextView get;
    @Bind(R.id.lisview)
    CustListView lisview;
    LSwipeAdapter adapter;
    @Bind(R.id.data)
    TextView data;
    Gson gson=new Gson();
    AddTypeAdapter addTypeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setValuse("测试" + i);
            students.add(student);
        }

        addTypeAdapter=new AddTypeAdapter(MainActivity.this, students);
        lisview.setAdapter(addTypeAdapter);
     /*   adapter = new LSwipeAdapter(MainActivity.this, students);
        lisview.setAdapter(adapter);*/


    }

    @OnClick(R.id.get)
    public void onViewClicked() {

      data.setText(gson.toJson(addTypeAdapter.getData()));
       // data.setText(gson.toJson(adapter.getData()));
    }
}
