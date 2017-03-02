package com.example.jmfs1.ebec.scoresfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jmfs1.ebec.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoresFragment extends Fragment {

    List<NLevelItem> list;
    ListView listView;

    private List<String> teams = new ArrayList<>();
    private List<String> memAndProvas = new ArrayList<>();
    private List<String> testing = new ArrayList<>();

    public ScoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("score fragment", "lol");

        View view = inflater.inflate(R.layout.fragment_scores, container, false);
        list = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.listView1);
        final LayoutInflater inflater_groups = LayoutInflater.from(getActivity());

        populateLists();

        for (String team : teams) {
            final NLevelItem grandParent = new NLevelItem(team, null, new NLevelView() {
                @Override
                public View getView(NLevelItem item) {
                    View view = inflater_groups.inflate(R.layout.list_item, null);
                    TextView tv = (TextView) view.findViewById(R.id.textView);
                    String name = (String) item.getWrappedObject();
                    tv.setText(name);
                    return view;
                }
            });
            list.add(grandParent);
            for (String memPro : memAndProvas) {
                NLevelItem parent = new NLevelItem(memPro, grandParent, new NLevelView() {
                    @Override
                    public View getView(NLevelItem item) {
                        View view = inflater_groups.inflate(R.layout.list_item, null);
                        TextView tv = (TextView) view.findViewById(R.id.textView);
                        String name = (String) item.getWrappedObject();
                        tv.setText(name);
                        return view;
                    }
                });

                list.add(parent);
                for (String item : testing) {
                    NLevelItem child = new NLevelItem(item, parent, new NLevelView() {
                        @Override
                        public View getView(NLevelItem item) {
                            View view = inflater_groups.inflate(R.layout.list_item, null);
                            TextView tv = (TextView) view.findViewById(R.id.textView);
                            String name = (String) item.getWrappedObject();
                            tv.setText(name);
                            return view;
                        }
                    });

                    list.add(child);
                }
            }
        }

        NLevelAdapter adapter = new NLevelAdapter(list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                ((NLevelAdapter)listView.getAdapter()).toggle(arg2);
                ((NLevelAdapter)listView.getAdapter()).getFilter().filter();

            }
        });

        return view;
    }

    private void populateLists(){
        teams.add("Team A");
        teams.add("Team B");
        teams.add("Team C");

        memAndProvas.add("Membros");
        memAndProvas.add("Mini Provas");

        testing.add("item1");
        testing.add("item2");
    }
}