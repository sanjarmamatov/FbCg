package com.example.user.firebasecg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    Button bSend;
    ListView listView;
    ChatMessageAdapter chatMessageAdapter ;
    List<ChatMessage> chatMessages;
    public static final String ANONIMUS ="Sanjar";
    String userName = ANONIMUS;

    EditText et;

    private ChildEventListener childEventListener;

    //private FirebaseDatabase database = FirebaseDatabase.getInstance();
    //private DatabaseReference myRef = database.getReference("message");


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private  DatabaseReference myRef = database.getReference("message");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        init();


        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ChatMessage chatMessage = new ChatMessage(userName, et.getText().toString());
                //myRef.push().setValue(chatMessage);

                String a = et.getText().toString();
                myRef.push().setValue(a);


               // et.setText("");
            }
        });


        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

               // ChatMessage chatMessage = dataSnapshot.getValue(ChatMessage.class);
                //chatMessageAdapter.add(chatMessage);
                /*ChatMessage chatMessage = dataSnapshot.getValue(ChatMessage.class);
                chatMessageAdapter.add(chatMessage);*/

                String a = dataSnapshot.getValue(String.class);

                tv.setText(a);



            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
            myRef.addChildEventListener(childEventListener);



    }

    private void init() {
        bSend = (Button)findViewById(R.id.button2);
        et = (EditText)findViewById(R.id.editText);
        listView = (ListView)findViewById(R.id.listView);
        chatMessages = new ArrayList<>();

        chatMessageAdapter = new ChatMessageAdapter(this, R.layout.chat_message, chatMessages);
        listView.setAdapter(chatMessageAdapter);
    }
}
