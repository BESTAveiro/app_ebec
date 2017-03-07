package com.example.jmfs1.ebec.schedulefragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jmfs1.ebec.R;
import com.example.jmfs1.ebec.schedulefragment.classes.DaySchedule;

import java.sql.Time;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Log.d("present", "I'm here");
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        final TabLayout tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        final ViewPager viewpager = (ViewPager) view.findViewById(R.id.viewpager);

        ScheduleFragmentPagerAdapter adapter = new ScheduleFragmentPagerAdapter(getChildFragmentManager(), getContext());

        viewpager.setAdapter(adapter);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewpager);
            }
        });

        return view;
    }

    public class ScheduleFragmentPagerAdapter extends FragmentPagerAdapter {

        final int PAGE_COUNT = 4;
        private String tabTitles[] = new String[] { "Dia 11", "Dia 12", "Dia 14", "Dia 15" };
        private DaySchedule[] schedule_days;
        private Context context;

        public ScheduleFragmentPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;

            schedule_days = new DaySchedule[4];

            /*Day 11*/
            schedule_days[0] = new DaySchedule(11);
            schedule_days[0].insertEvent("09:00", "10:00", "Check-in",
                    "Check-in dos participantes, que receberão um saco com algum merchandising, que incluirá" +
                    " a nametag que devem usar. Irá decorrer na entrada do auditório do ISCAA.");
            schedule_days[0].insertEvent("10:00", "11:00", "Opening Session",
                    "Sessão de abertura que contará com a presença de alguns representantes de empresas e entidades" +
                    "públicas. Irá decorrer no ISCAA, no auditório Joaquim José Da Cunha.");
            schedule_days[0].insertEvent("11:00", "12:00", "Apresentação da Prova",
                    "Empresa responsável pelas provas apresentará o conteúdo de cada uma delas." +
                    " Irá decorrer no ISCAA, no auditório Joaquim José Da Cunha.");
            schedule_days[0].insertEvent("12:00", "14:00", "Almoço",
                    "Almoço na cantina do Crasto.");
            schedule_days[0].insertEvent("14:00", "14:30", "Visita Guiada",
                    "Visita guiada pelo sítio da prova.");
            schedule_days[0].insertEvent("14:30", "23:59", "Prova",
                    "Provas de Case Study e Team Design, com a duração de 24 horas. Irá decorrer na" +
                    " ESSUA.");
            schedule_days[0].sortEvents();

            /*Day 12*/
            schedule_days[1] = new DaySchedule(12);
            schedule_days[1].insertEvent("00:00", "14:00", "Prova",
                    "Provas de Case Study e Team Design, com a duração de 24 horas. Irá decorrer na" +
                    " ESSUA.");
            schedule_days[1].insertEvent("14:00", "15:30", "Almoço",
                    "Almoço no sítio da prova.");
            schedule_days[1].sortEvents();

            /*Day 14*/
            schedule_days[2] = new DaySchedule(14);
            schedule_days[2].insertEvent("11:00", "16:00", "Feira de Empresas",
                    "Espaço onde irão marcar presença empresas de diversos setores e permitirá aproximar o tecido empresarial " +
                    "da comunidade académica. Os estudantes terão a oportunidade de conhecer a atividade das entidades " +
                    "presentes, interagir com elas e haverá ainda um espaço dedicado a entrevistas por parte das empresas presentes." +
                    " Irá decorrer no Complexo Pedagógico.");
            schedule_days[2].insertEvent("16:00", "17:00", "Cocktail Network",
                    "Cocktail network com a participação de ambos estudantes e colaboradores de empresas. Irá " +
                            "decorrer no Complexo Pedagógico.");
            schedule_days[2].sortEvents();

            /*Day 15*/
            schedule_days[3] = new DaySchedule(15);
            schedule_days[3].insertEvent("14:00", "17:30", "Apresentação das Provas",
                    "As apresentações das provas de Case Study e Team Design decorrerão em paralelo. " +
                    "Irão decorrer em salas a informar posteriormente.");
            schedule_days[3].insertEvent("17:30", "18:30", "Closing Session",
                    "Sessão de encerramento, onde serão anunciados os vencedores de ambas as provas, serão entregues os prémios e serão feitas " +
                    "algumas considerações relativamente ao evento. Irá decorrer no auditório no Departamento de Ambiente" +
                            " e Ordenamento.");
            schedule_days[3].sortEvents();

        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            return SchedulePageFragment.newInstance(schedule_days[position]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }
    }
}
