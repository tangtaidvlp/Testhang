package com.example.phamf.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by phamf on 11-Jun-17.
 */

public class ParentsAdapter extends BaseExpandableListAdapter{

    Context context;
    ArrayList<String> header,child_header;
    HashMap<String,ArrayList<String>> child,child_child;
    ChildrenAdapter adapter;

    public ParentsAdapter(Context context, ArrayList<String> header, ArrayList<String> child_header, HashMap<String, ArrayList<String>> child, HashMap<String, ArrayList<String>> child_child) {
        this.context = context;
        this.header = header;
        this.child_header = child_header;
        this.child = child;
        this.child_child = child_child;
    }

    @Override
    public int getGroupCount() {
        return header.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child.get(header.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return header.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child.get(header.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String parents = (String) getGroup(groupPosition);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.parent,null);
        TextView txt_parent = (TextView) view.findViewById(R.id.txt_parent);
        txt_parent.setText("PARENT");
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.child,null);
        ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.expdb_child);
        adapter = new ChildrenAdapter(context,child_header,child_child);
        expandableListView.setAdapter(adapter);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
