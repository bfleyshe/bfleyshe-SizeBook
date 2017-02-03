package com.example.bfleyshe.bfleyshe_sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class EditRecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_records);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        Button backButton = (Button) findViewById(R.id.backButton);

        Intent intent = getIntent();
        String message = intent.getStringExtra(SizeBook.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_edit_records);
        layout.addView(textView);

        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //TODO Save person data
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }
        });
    }

    /*public ItemClicked getItem(int position) {
        return items.get(position);
    }*/

}
