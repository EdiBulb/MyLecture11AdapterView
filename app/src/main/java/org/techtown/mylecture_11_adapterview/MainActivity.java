package org.techtown.mylecture_11_adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("B684002 강병훈");

        final String[] mid = {"피카츄", "파이리","야도란", "라이츄","이상해씨", "피존투", "꼬북이"};

        ListView list = findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mid); // 틀, 데이터 넣기

        list.setAdapter(adapter); // 리스트 뷰에 어댑터 연결

        //리스트뷰에 아이템이 눌렸을 경우
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), mid[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}