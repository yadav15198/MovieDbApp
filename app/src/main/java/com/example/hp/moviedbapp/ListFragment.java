package com.example.hp.moviedbapp;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends android.support.v4.app.Fragment implements ListLoadListener {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    TextView textView;
    Button button;
    List<Movies> movies=new ArrayList<>();
    LoadList loadList;
    Bundle bundle;
    MovieAdapter adapter;
    int page = 1;
    String type,fragment;
    long id;

    private OnFragmentInteractionListener mListener;

    public ListFragment() {
        // Required empty public constructo
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        textView = view.findViewById(R.id.textView);
        button = view.findViewById(R.id.button);
        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        bundle = getArguments();
        loadList = new LoadList(bundle, getContext(), this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fragment = bundle.getString(Contracts.FRAGMENT);
        type = bundle.getString(Contracts.TYPE);
        // id=bundle.getLong(Contracts.id,0);
        if (fragment.equals(Contracts.MOVIES_FRAGMENT)) {
            movies.addAll(loadList.getMovie(page, id));
            if (type.equals(Contracts.NOW_SHOWING_MOVIES)) {
                textView.setText("Now Showing");
            } else if (type.equals(Contracts.POPULAR_MOVIES)) {
                textView.setText("Popular");
            } else if (type.equals(Contracts.TOP_RATED_MOVIES)) {
                textView.setText("Top Rated");
            } else if (type.equals(Contracts.UPCOMING_MOVIES)) {
                textView.setText("Upcoming");
            }

            if (movies.size() > 0) {
                recyclerView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
            }
            adapter = new MovieAdapter(getContext(), movies, new RowListener() {
                @Override
                public void OnItemclick(View view, int position) {

                }
            });
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void OnMovieloded(List<Movies> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        adapter.notifyDataSetChanged();
        if(movies.size()>0)
        {
            recyclerView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }
}
