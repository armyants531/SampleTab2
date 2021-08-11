package org.techtown.tab;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class Fragment1 extends Fragment {

    Context context;

    OnTabItemSelectedListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        if (context instanceof OnTabItemSelectedListener) {
            listener = (OnTabItemSelectedListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (context != null) {
            context = null;
            listener = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_1, container, false);

        initUI(rootView);

        return rootView;
    }

    private void initUI(ViewGroup rootView) {
        EditText editText1, editText2;
        editText1 = rootView.findViewById(R.id.editText1);
        editText2 = rootView.findViewById(R.id.editText2);

        String ID, PW;
        ID = editText1.getText().toString();
        PW = editText2.getText().toString();

        Button LoginButton = rootView.findViewById(R.id.button);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ID.length() == 0) {
                    Toast.makeText(getContext(), "ID를 다시 입력해주세요", Toast.LENGTH_LONG).show();
                }
                else if (PW.length() == 0) {
                    Toast.makeText(getContext(), "PW를 다시 입력해주세요", Toast.LENGTH_LONG).show();
                }
                else {
                    if (listener != null) {
                        listener.onTabSelected(1);
                    }
                }
            }
        });
    }
}