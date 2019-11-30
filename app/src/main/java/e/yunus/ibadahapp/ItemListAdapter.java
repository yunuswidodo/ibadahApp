package e.yunus.ibadahapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends ArrayAdapter<Item> {

    private static final String Tag ="ItemListAdapter";

    private Context mContext;
    int mResources;

    public ItemListAdapter(Context context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        mContext = context;
        mResources = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the Item information
        int image = getItem(position).getImage();
        String title = getItem(position).getTitle();
        String information = getItem(position).getInformation();

        //Create the Item object with the information
        Item person = new Item(image,title,information);

        LayoutInflater inflater =LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResources, parent, false);

        ImageView tvImage =(ImageView) convertView.findViewById(R.id.imageView);
        TextView tvtitle = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvInformation = (TextView) convertView.findViewById(R.id.textView3);

        tvImage.setImageResource(image);
        tvtitle.setText(title);
        tvInformation.setText(information);

        return convertView;
    }
}
