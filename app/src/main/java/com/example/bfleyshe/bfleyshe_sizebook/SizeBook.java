package com.example.bfleyshe.bfleyshe_sizebook;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * The primary class that runs this application. In this class, user interaction and
 * data manipulation are performed.
 *
 * @author bfleyshe
 * @version 1.0
 * @see Person
 * @since 1.0
 */
public class SizeBook extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView RecordsList;
    private Integer recordCount;

    private ArrayList<Person> personList;
    private ArrayAdapter<Person> adapter;
    private Integer interactMode = 0; // 0 is view, 1 is edit mode, 2 is delete: //TODO should be changed to enumeration



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size_book);

        //bodyText = (EditText) findViewById(R.id.body);
        RecordsList = (ListView) findViewById(R.id.personList);
        Button addButton = (Button) findViewById(R.id.add);
        final Button editButton = (Button) findViewById(R.id.edit);
        final Button deleteButton = (Button) findViewById(R.id.delete);
        final TextView recordText = (TextView) findViewById(R.id.recordsView);

        RecordsList.setAdapter(adapter);

        // ListView on item selected listener.
        RecordsList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               if(interactMode == 1){
                   editButton.setBackgroundResource(android.R.drawable.btn_default);
                   Intent intent = new Intent(SizeBook.this, EditRecordsActivity.class);
                   intent.putExtra("person", personList.get(position));
                   interactMode = 0;
                   startActivity(intent);

/*
                   Intent i = getIntent();
                   final Person person = i.getParcelableExtra("person");

                   personList.remove(position);
                   personList.add(position, person);
*/
               }
               else if(interactMode == 2){
                   personList.remove(position);
                   recordCount--;
                   recordText.setText("Records:" + recordCount, TextView.BufferType.EDITABLE);
                   saveInFile();
               }

               else if(interactMode == 0){
                   Intent intent = new Intent(SizeBook.this, ViewRecordsActivity.class);
                   intent.putExtra("person", personList.get(position));
                   startActivity(intent);
               }

               adapter.notifyDataSetChanged();
           }
        });

        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                interactMode = 0;   // returns to view mode
                String name = "Name";//bodyText.getText().toString();    // to change later

                try {
                    Person person = new Person(name);
                    personList.add(person);
                } catch (NameTooLongException e) {
                    e.printStackTrace();
                }

                adapter.notifyDataSetChanged();

                recordCount++;
                recordText.setText("Records:" + recordCount, TextView.BufferType.EDITABLE);

                editButton.setBackgroundResource(android.R.drawable.btn_default);
                deleteButton.setBackgroundResource(android.R.drawable.btn_default);

                saveInFile();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                if(interactMode == 1){
                    interactMode = 0;
                    //Button colors taken Feb 3rd, 2017 at 15:46.
                    //http://stackoverflow.com/questions/14802354/how-to-reset-a-buttons-background-color-to-default
                    editButton.setBackgroundResource(android.R.drawable.btn_default);
                }
                else {
                    interactMode = 1;
                    editButton.setBackgroundColor(Color.DKGRAY);
                    deleteButton.setBackgroundResource(android.R.drawable.btn_default);
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                setResult(RESULT_OK);
                if(interactMode == 2){
                    interactMode = 0;
                    deleteButton.setBackgroundResource(android.R.drawable.btn_default);
                }
                else {
                    interactMode = 2;
                    editButton.setBackgroundResource(android.R.drawable.btn_default);
                    deleteButton.setBackgroundColor(Color.DKGRAY);
                }

            }
        });

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Person>(this,
                android.R.layout.simple_list_item_1, personList);
        RecordsList.setAdapter(adapter);
        recordCount = personList.size();
    }


    /**
     * Loads records from specified file.
     *
     * @exception FileNotFoundException if the file is not created first.
     */
    private void loadFromFile() {

        //personList = new ArrayList<Person>();

        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            // 2017-01-24 18:19
            Type listType = new TypeToken<ArrayList<Person>>(){}.getType();
            personList = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            personList = new ArrayList<Person>();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    /**
     * Saves records into specified file.
     *
     * @throws FileNotFoundException if there is no file folder to be found
     */

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(personList, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO: Handle the Exception
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
