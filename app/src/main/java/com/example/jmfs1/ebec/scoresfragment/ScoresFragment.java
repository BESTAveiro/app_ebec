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
import com.example.jmfs1.ebec.core.MiniCompetition;
import com.example.jmfs1.ebec.core.Order;
import com.example.jmfs1.ebec.core.Product;
import com.example.jmfs1.ebec.core.Team;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoresFragment extends Fragment {

    private DatabaseReference mDatabase;

    List<NLevelItem> list;
    ListView listView;

    private List<Team> mTeams;
    private List<String> mMembers;
    private List<MiniCompetition> mMiniProvas;
    private List<String> mKeys;

    private List<String> staticTeams;
    private List<String> staticScores;

    public ScoresFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // get database reference
        mDatabase = FirebaseDatabase.getInstance().getReference("teams");

        List<String> staticList = new ArrayList<>();
        staticList.add("Membros");
        staticList.add("Mini Provas");

        mTeams = new ArrayList();
        mKeys = new ArrayList();

        final NLevelAdapter adapter = new NLevelAdapter(list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                ((NLevelAdapter) listView.getAdapter()).toggle(arg2);
                ((NLevelAdapter) listView.getAdapter()).getFilter().filter();

            }
        });

        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Team team = dataSnapshot.getValue(Team.class);
                mTeams.add(team);

                String key = dataSnapshot.getKey();
                mKeys.add(key);

                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Team team = dataSnapshot.getValue(Team.class);

                String key = dataSnapshot.getKey();

                int index = mKeys.indexOf(key);

                mTeams.set(index, team);

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Team team = dataSnapshot.getValue(Team.class);

                String key = dataSnapshot.getKey();

                int index = mKeys.indexOf(key);

                mTeams.remove(index);

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        View view = inflater.inflate(R.layout.fragment_scores, container, false);
        list = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.listView1);
        final LayoutInflater inflater_groups = LayoutInflater.from(getActivity());

        for (Team team : mTeams) {
            final NLevelItem grandParent = new NLevelItem(team, null, new NLevelView() {
                @Override
                public View getView(NLevelItem item) {
                    View view = inflater_groups.inflate(R.layout.list_item, null);
                    TextView tname = (TextView) view.findViewById(R.id.teamname);
                    TextView tcredits = (TextView) view.findViewById(R.id.teamcredits);
                    Team t = (Team) item.getWrappedObject();
                    String mTeamName = t.getName();
                    String mTeamCredits = Integer.toString(t.getCredits());
                    tname.setText(mTeamName);
                    tcredits.setText(mTeamCredits);
                    return view;
                }
            });
            list.add(grandParent);
            for (String staticItem : staticList) {
                NLevelItem parent = new NLevelItem(staticItem, grandParent, new NLevelView() {
                    @Override
                    public View getView(NLevelItem item) {
                        View view = inflater_groups.inflate(R.layout.list_item, null);
                        TextView tv = (TextView) view.findViewById(R.id.teamname);
                        String name = "     " + (String) item.getWrappedObject();
                        tv.setText(name);
                        return view;
                    }
                });

                list.add(parent);
                for (String item : staticScores) {
                    NLevelItem child = new NLevelItem(item, parent, new NLevelView() {
                        @Override
                        public View getView(NLevelItem item) {
                            View view = inflater_groups.inflate(R.layout.list_item, null);
                            TextView tv = (TextView) view.findViewById(R.id.teamname);
                            String name = "             " + (String) item.getWrappedObject();
                            tv.setText(name);
                            return view;
                        }
                    });

                    list.add(child);
                }
            }
        }

        return view;
    }
}