package com.example.ls.myvideoview.stu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ls.myvideoview.R;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Student> studentList;

    private Button btnSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        btnSelection = (Button) findViewById(R.id.btnShow);

        studentList = new ArrayList<Student>();

        for (int i = 1; i <= 50; i++) {
            Student st = new Student("Student " + i, "androidstudent" + i
                    + "@gmail.com", false);

            studentList.add(st);
        }


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new CardViewDataAdapter(studentList);

        mRecyclerView.setAdapter(mAdapter);

        btnSelection.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String data = "";
                List<Student> stList = ((CardViewDataAdapter) mAdapter).getStudentist();
                for (int i = 0; i < stList.size(); i++) {
                    Student singleStudent = stList.get(i);
                    if (singleStudent.isSelected() == true) {
                        data = data + "\n" + singleStudent.getName().toString();
                    }
                }


                Toast.makeText(Main5Activity.this,
                        "Selected Students: \n" + data, Toast.LENGTH_LONG)
                        .show();
            }
        });

    }

}
