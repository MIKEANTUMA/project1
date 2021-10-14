package com.example.project1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GameFragment extends Fragment implements  NoticeDialogFragment.NoticeDialogListener {

    public static final String MYPREF = "My_PREF_FILE_NAME";
    public static final String ANSWER1 = "ANSWER_KEY";




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View parentView = inflater.inflate(R.layout.fragment_game, container, false);

        //question 1
        Button gq1a1 = parentView.findViewById(R.id.q1a1);
        Button gq1a2 = parentView.findViewById(R.id.q1a2);
        Button gq1a3 = parentView.findViewById(R.id.q1a3);
        Button gq1a4 = parentView.findViewById(R.id.q1a4);

        //question 2
        Button gq2a1 = parentView.findViewById(R.id.q2a1);
        Button gq2a2 = parentView.findViewById(R.id.q2a2);
        Button gq2a3 = parentView.findViewById(R.id.q2a3);
        Button gq2a4 = parentView.findViewById(R.id.q2a4);

        //question 3
        Button gq3a1 = parentView.findViewById(R.id.q3a1);
        Button gq3a2 = parentView.findViewById(R.id.q3a2);
        Button gq3a3 = parentView.findViewById(R.id.q3a3);
        Button gq3a4 = parentView.findViewById(R.id.q3a4);

        //question 4
        Button gq4a1 = parentView.findViewById(R.id.q4a1);
        Button gq4a2 = parentView.findViewById(R.id.q4a2);
        Button gq4a3 = parentView.findViewById(R.id.q4a3);
        Button gq4a4 = parentView.findViewById(R.id.q4a4);

        //question 5
        Button gq5a1 = parentView.findViewById(R.id.q5a1);
        Button gq5a2 = parentView.findViewById(R.id.q5a2);
        Button gq5a3 = parentView.findViewById(R.id.q5a3);
        Button gq5a4 = parentView.findViewById(R.id.q5a4);

        gq1a1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                DialogFragment dialog = new NoticeDialogFragment();
                dialog.show(getParentFragmentManager(), "NoticeDialogFragment");

                //Toast.makeText(getActivity(),"this sucks",Toast.LENGTH_SHORT).show();
            }
        });

        return parentView;

    }
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
     //if(dialog.getTag().toString() == "Washington"){
          Toast.makeText(getActivity(),"good job",Toast.LENGTH_SHORT).show();
      //}

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}