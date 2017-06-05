package android.kunitsa.com.androidcalculator.fragments;

import android.app.Fragment;
import android.content.Context;
import android.kunitsa.com.androidcalculator.OnFragmentInteractionListener;
import android.kunitsa.com.androidcalculator.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Администратор on 05.06.2017.
 */

public class FragmentBin extends Fragment implements View.OnClickListener {

    Button allClear, equals, divide, multiply, minus, plus, backspace;
    Button one, zero;
    View v;
    TextView display;
    TextView symbolDisplay;

    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_bin, null);
        registerSimpleComponents();

        return v;
    }

    public void registerSimpleComponents() {
        display = (TextView) v.findViewById(R.id.editText1);
        symbolDisplay = (TextView) v.findViewById(R.id.editText2);
        symbolDisplay.setOnClickListener(this);
        /*allClear = (Button) v.findViewById(R.id.btnClear);
        allClear.setOnClickListener(this);*/
        equals = (Button) v.findViewById(R.id.btnResult);
        equals.setOnClickListener(this);
        one = (Button) v.findViewById(R.id.btn1);
        one.setOnClickListener(this);
        zero = (Button) v.findViewById(R.id.btn0);
        zero.setOnClickListener(this);
        divide = (Button) v.findViewById(R.id.btnDevide);
        divide.setOnClickListener(this);
        multiply = (Button) v.findViewById(R.id.btnMultiply);
        multiply.setOnClickListener(this);
        plus = (Button) v.findViewById(R.id.btnPlus);
        plus.setOnClickListener(this);
        minus = (Button) v.findViewById(R.id.btnMinus);
        minus.setOnClickListener(this);
        backspace = (Button) v.findViewById(R.id.btnBackSpace);
        backspace.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                display.append("1");
                break;
            case R.id.btn0:
                display.append("0");
                break;
            case R.id.btnPlus:
                display.append("+");
                break;
            case R.id.btnMinus:
                display.append("-");
                break;
            case R.id.btnDevide:
                display.append("/");
                break;
            case R.id.btnMultiply:
                display.append("*");
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
}