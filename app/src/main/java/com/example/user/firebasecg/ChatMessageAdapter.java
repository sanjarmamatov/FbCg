package com.example.user.firebasecg;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 08.04.2017.
 */

public class ChatMessageAdapter extends ArrayAdapter<ChatMessage>{

    public ChatMessageAdapter(Context context, int resource, List<ChatMessage> object){
        super(context,resource,object);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        if (convertView == null){
            convertView = ((Activity) getContext())
                    .getLayoutInflater()
                    .inflate(R.layout.chat_message, parent, false);
        }

        ChatMessage currentChatMessage = getItem(position);

        TextView tvName = (TextView)convertView.findViewById(R.id.tvName);
        TextView tvMessage = (TextView)convertView.findViewById(R.id.tvMessage);

        tvMessage.setText(currentChatMessage.getMessage());
        tvName.setText(currentChatMessage.getName());



        return convertView;


    }
}
