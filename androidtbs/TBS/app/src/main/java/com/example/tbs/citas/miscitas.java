package com.example.tbs.citas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tbs.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link miscitas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link miscitas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class miscitas extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  /*  private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    RecyclerView recicler ;
    ArrayList<modelsmiscitas> listarecycler;

    /**
     * Use this factory method to create a new instance of

    public miscitas() {
        // Required empty public constructor
    }
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment miscitas.
     */
    // TODO: Rename and change types and number of parameters
    /*public static miscitas newInstance(String param1, String param2) {
        miscitas fragment = new miscitas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public ArrayList<modelsmiscitas> obtencion(){
        List<modelsmiscitas> datos= new ArrayList<>();
        listarecycler.add(new modelsmiscitas("2enero","asdte","descripcion", R.drawable.coco));
        listarecycler.add(new modelsmiscitas("3s0","asdtitle","descripcion",R.drawable.coco));
        return listarecycler;

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
  //      return inflater.inflate(R.layout.fragment_miscitas, container, false);
        View vista=inflater.inflate(R.layout.fragment_miscitas, container, false);
//copiado
        listarecycler= new ArrayList<>();
        recicler=(RecyclerView)vista.findViewById(R.id.reciclermiscitas);
        recicler.setLayoutManager(new LinearLayoutManager(getContext()));
        obtencion();
        adaptersmiscitas adapter = new adaptersmiscitas(listarecycler);
        recicler.setAdapter(adapter);
        return vista;
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
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
