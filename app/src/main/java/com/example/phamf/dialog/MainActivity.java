package com.example.phamf.dialog;

import android.app.Dialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableView;
    ParentsAdapter adapter;
    HashMap<String,ArrayList<String>> parent,child_parent;
    ArrayList<String> header,child_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareData();
        expandableView = (ExpandableListView) findViewById(R.id.expandable_list);
        adapter = new ParentsAdapter(this,header,child_header,parent,child_parent);
        expandableView.setAdapter(adapter);
    }

        private void prepareData(){
            parent = new HashMap<>();
            header = new ArrayList<>();
            child_parent = new HashMap<>();
            child_header = new ArrayList<>();

            header.add("ABĐE");

            ArrayList<String> list1 = new ArrayList<>();
            list1.add("AAA");


            parent.put(header.get(0),list1);


            child_header.add("ABĐE");
            child_header.add("ABĐE");

            ArrayList<String> list2 = new ArrayList<>();
            list2.add("AAA");
            list2.add("AAA");
            list2.add("AAA");

            child_parent.put(header.get(0),list2);

        }



}
