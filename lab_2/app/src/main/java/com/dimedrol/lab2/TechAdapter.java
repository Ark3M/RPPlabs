package com.dimedrol.lab2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private static ClickListener clickListener;

    public TechAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mTextView.setText(TechData.get(i).getName());
        Picasso.get().load(TechData.get(i).getGraphicUrl()).placeholder(R.drawable.civ_icon).into(viewHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return TechData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView mImageView;
        private final TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_view);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            clickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface ClickListener
    {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ClickListener clickListener)
    {
        TechAdapter.clickListener = clickListener;
    }
}
