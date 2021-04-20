package sg.edu.rp.c346.s19047241.demolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FoodAda extends ArrayAdapter<Food> {

    private ArrayList<Food> food;
    private Context context;
    private TextView tvFoodName;
    private ImageView ivStar;

    public FoodAda(@NonNull Context context, int resource, @NonNull ArrayList<Food> objects) {
        super(context, resource, objects);

        // Store the food that is passed to this adapter
        food = objects;

        // Store Context object as we would need to use it later
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout, parent, false);

        tvFoodName = (TextView) rowView.findViewById(R.id.tvFoodName);
        ivStar = (ImageView) rowView.findViewById(R.id.ivStar);

        Food currentFood = food.get(position);


        tvFoodName.setText(currentFood.getName());

        if(currentFood.isStar()){
            ivStar.setImageResource(R.drawable.star);
        }else{
            ivStar.setImageResource(R.drawable.nostar);
        }

        return rowView;

    }
}
