package org.techtown.mylecture_11_adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("B684002 강병훈");

        final ArrayList<String> midList = new ArrayList<>();
        ListView list = findViewById(R.id.listView1);

        //어댑터 생성
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, midList); // 틀, 데이터
        //리스트 뷰와 어댑터 연결
        list.setAdapter(adapter);

        final EditText edtItem = findViewById(R.id.edtItem);
        Button btnAdd = findViewById(R.id.btnAdd);

        //버튼 클릭 시, 리스트에 데이터 추가
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                midList.add(edtItem.getText().toString());

                //어탭터 업데이트
                adapter.notifyDataSetChanged();
            }
        });

        //아이템 길게 클릭시 삭제.
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                midList.remove(i);

                //어댑터 업데이트
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}