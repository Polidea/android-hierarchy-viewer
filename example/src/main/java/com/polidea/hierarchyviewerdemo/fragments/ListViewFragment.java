package com.polidea.hierarchyviewerdemo.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

public class ListViewFragment extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add("Test " + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, stringList);
        setListAdapter(adapter);
    }
}
