package com.example.wojciech.partytime.Model;

/**
 * Created by Wojciech on 2015-10-03.
 */
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.wojciech.partytime.R;
import com.example.wojciech.partytime.View.Order_Activity;
import com.parse.ParseException;
import com.parse.ParseQuery;
import org.json.JSONException;

public class MyListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener
{
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MyListAdapter.position = position;

        Intent intent = new Intent(context,Order_Activity.class);
        context.startActivity(intent);

    }

    static class ViewHolder
    {
        Button button;
        ImageView imageView;
        TextView textView;
        ViewHolder() {
        }
    }
    public static int position;
    private static final String TAG = MyListAdapter.class.getSimpleName();
    private static int currentRestarant = 0;
    private static Items items[] = new Items[3];
    private final Context context;
    private LayoutInflater layoutInflater;


    public static Items getItem() {
        return items[currentRestarant];
    }

    public MyListAdapter(Context context1)
    {
        context = context1;
        layoutInflater = LayoutInflater.from(context1);
        //System.out.println("koniec ");
    }


    public static String getNameOfRestaurant(int i)
    {
        return items[i].getName();
    }

    public static void setCurrentRestaurant(int i)
    {
        currentRestarant = i;
    }

    public static void setRestaurants()
    {
        try {
            ParseQuery parsequery = ParseQuery.getQuery("Restaurants");
//            String s = new Gson().toJson(parsequery.find());
//            Restaurants[] jsonObject = new Gson().fromJson(s, Restaurants[].class);
//            System.out.println(jsonObject[0].getAmountDishes());
              items = Items.ItemsFactory(0,2,3,parsequery.find());
        }catch(ParseException | JSONException e){
            e.printStackTrace();
        }
    }
    public int getCount()
    {
        return items[currentRestarant].getSize();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ViewHolder viewHolder;
        if(view == null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.item_list,viewgroup, false);
            viewHolder.button = (Button) view.findViewById(R.id.button);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.image);
            viewHolder.textView = (TextView) view.findViewById(R.id.title);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.imageView.setImageBitmap(items[currentRestarant].getMenu()[i].getPhoto());
        viewHolder.textView.setText(items[currentRestarant].getMenu()[i].getTitle());

        return view;
    }

}
