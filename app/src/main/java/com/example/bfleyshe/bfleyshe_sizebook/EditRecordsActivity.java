package com.example.bfleyshe.bfleyshe_sizebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class EditRecordsActivity extends AppCompatActivity {

    private EditText editNameText;
    private EditText dateText;
    private EditText neckText;
    private EditText bustText;
    private EditText chestText;
    private EditText waistText;
    private EditText hipText;
    private EditText inseamText;
    private EditText commentText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_records);

        editNameText = (EditText) findViewById(R.id.editTextName);
        dateText = (EditText) findViewById(R.id.dateText);
        neckText = (EditText) findViewById(R.id.neckText);
        bustText = (EditText) findViewById(R.id.bustText);
        chestText = (EditText) findViewById(R.id.chestText);
        waistText = (EditText) findViewById(R.id.waistText);
        hipText = (EditText) findViewById(R.id.hipText);
        inseamText = (EditText) findViewById(R.id.inseamText);
        commentText = (EditText) findViewById(R.id.commentText);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        Button backButton = (Button) findViewById(R.id.backButton);

        //Passing objects through intents, taken Feb 3rd at 17:20
        //http://stackoverflow.com/questions/2139134/how-to-send-an-object-from-one-android-activity-to-another-using-intents
        Intent intent = getIntent();
        final Person person = intent.getParcelableExtra("person");

        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    person.setName(editNameText.getText().toString());
                } catch (NameTooLongException e) {
                    e.printStackTrace();
                }
                person.setDate(new Date());//TODO string impelementation
                person.setNeck(Integer.parseInt(neckText.getText().toString()));
                person.setBust(Integer.parseInt(bustText.getText().toString()));
                person.setChest(Integer.parseInt(chestText.getText().toString()));
                person.setWaist(Integer.parseInt(waistText.getText().toString()));
                person.setHip(Integer.parseInt(hipText.getText().toString()));
                person.setInseam(Integer.parseInt(inseamText.getText().toString()));
                person.setComment(commentText.getText().toString());

                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                finish();
            }
        });
    }


}
