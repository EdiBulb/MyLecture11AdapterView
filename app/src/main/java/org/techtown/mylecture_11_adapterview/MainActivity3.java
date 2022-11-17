package org.techtown.mylecture_11_adapterview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity {
    Integer[] posterID = {
            R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,
            R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,
            R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,
            R.drawable.mov10,
            R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,
            R.drawable.mov14,R.drawable.mov15,R.drawable.mov16,
            R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,
            R.drawable.mov20,
            R.drawable.mov21,R.drawable.mov22,R.drawable.mov23,
            R.drawable.mov24,R.drawable.mov25,R.drawable.mov26,
            R.drawable.mov27,R.drawable.mov28,R.drawable.mov29,
            R.drawable.mov30 };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("그리드듀 영화 포스터");

        final GridView gv =(GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);

    }

    public class MyGridAdapter extends BaseAdapter{
        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            final int pos = position;

            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5,5,5,5);

            imageview.setImageResource(posterID[position]);

            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = View.inflate(MainActivity3.this,
                            R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity3.this);
                    ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle("큰 포스터");
                    dlg.setIcon(R.drawable.ic_launcher);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageview;
        }
    }
}
