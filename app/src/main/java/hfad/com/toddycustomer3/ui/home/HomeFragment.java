package hfad.com.toddycustomer3.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import hfad.com.toddycustomer3.R;

public class HomeFragment extends Fragment {
    public static interface Listener {
        void itemClicked();
    };
    private Listener listener;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    public void setListeners1()
    {  View view = getView();
        if (view != null) {
            final Button button = (Button) view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                     String TAG = "MyActivity";

                    Log.i(TAG, "MyClass.getView() — get item number ----------------------------" );

                    if (listener != null) {

                        listener.itemClicked();
                    }
                   // button.setText("rockll");
                    // Code here executes on main thread after user presses button
                }
            });
        }

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener)context;
    }
    @Override
    public void onStart() {
        super.onStart();
        setListeners1();

    }
}