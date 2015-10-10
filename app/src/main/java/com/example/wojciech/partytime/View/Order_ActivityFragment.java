package com.example.wojciech.partytime.View;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.wojciech.partytime.Model.MyListAdapter;
import com.example.wojciech.partytime.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class Order_ActivityFragment extends Fragment {
    public Order_ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order, container, false);
        System.out.println("positon" + MyListAdapter.position + "current" + MyListAdapter.getNameOfRestaurant(0));
        ((ImageView) view.findViewById(R.id.obrazek)).setImageBitmap(MyListAdapter.getItem().getMenu()[MyListAdapter.position].getPhoto());
        ((TextView)view.findViewById(R.id.title)).setText(MyListAdapter.getItem().getMenu()[MyListAdapter.position].getTitle());
        ((TextView)view.findViewById(R.id.price)).setText(String.valueOf(MyListAdapter.getItem().getMenu()[MyListAdapter.position].getPrice()[0]));
        ((TextView)view.findViewById(R.id.describe)).setText(String.valueOf(MyListAdapter.getItem().getMenu()[MyListAdapter.position].getDescribe()));

        if(MyListAdapter.getItem().getMenu()[MyListAdapter.position].getSize().length != 0){
            ((LinearLayout) view.findViewById(R.id.linear_5)).setVisibility(View.VISIBLE);
            ((RadioGroup)view.findViewById(R.id.radio_group_1)).setVisibility(View.VISIBLE);
            ((TextView)view.findViewById(R.id.Size)).setVisibility(View.VISIBLE);
            RadioButton radioButton = (RadioButton) view.findViewById(R.id.radio_button_1);
            RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.radio_button_2);
            radioButton.setText(MyListAdapter.getItem().getMenu()[MyListAdapter.position].getSize()[0]);
            radioButton2.setText(MyListAdapter.getItem().getMenu()[MyListAdapter.position].getSize()[1]);
            radioButton.setVisibility(View.VISIBLE);
            radioButton2.setVisibility(View.VISIBLE);
        }
        int k;
        if( (k = MyListAdapter.getItem().getMenu()[MyListAdapter.position].getTaste().length) != 0){
            ((LinearLayout) view.findViewById(R.id.linear_6)).setVisibility(View.VISIBLE);
            ((RadioGroup)view.findViewById(R.id.radio_group_2)).setVisibility(View.VISIBLE);
            ((TextView)view.findViewById(R.id.Taste)).setVisibility(View.VISIBLE);
            RadioButton radioButton[] = new RadioButton[k];
            radioButton[0] = (RadioButton) view.findViewById(R.id.radio_button_3);
            radioButton[1] = (RadioButton) view.findViewById(R.id.radio_button_4);
            if(k == 3)
            radioButton[2] = (RadioButton) view.findViewById(R.id.radio_button_5);
                for(int i = 0;i < k;++i){
                    radioButton[i].setVisibility(View.VISIBLE);
                    radioButton[i].setText(MyListAdapter.getItem().getMenu()[MyListAdapter.position].getTaste()[i]);
                    System.out.println(MyListAdapter.getItem().getMenu()[MyListAdapter.position].getTaste()[i] + k);
                }

        }
        return view;
    }
}
