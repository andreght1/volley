package work.andrerodrigues.volley;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.security.auth.callback.Callback;

/**
 * Created by Andre on 07/12/2015.
 */
public class AdAdapter extends RecyclerView.Adapter<AdAdapter.ViewHolder> {

    protected static final String TAG = "andrerodrigues";
    private final Context context;
    private final List<Ad> ads;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public ImageView mImageView;
        public TextView mTextName;
        public TextView mTextAge;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mTextName = (TextView) itemView.findViewById(R.id.person_name);
            mTextAge = (TextView) itemView.findViewById(R.id.person_age);
        }
    }

    public AdAdapter(Context context, List<Ad> ads) {
        this.context = context;
        this.ads = ads;
    }

    @Override
    public AdAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_ad, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.mTextView.setText(ads.get(position).getName());
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(holder.mImageView);
        holder.mTextName.setText("André");
        holder.mTextAge.setText("22");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return ads.size();
    }
}
