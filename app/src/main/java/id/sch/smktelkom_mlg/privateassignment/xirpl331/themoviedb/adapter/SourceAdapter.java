package id.sch.smktelkom_mlg.privateassignment.xirpl331.themoviedb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl331.themoviedb.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl331.themoviedb.model.Result;

/**
 * Created by Savina on 5/14/2017.
 */

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.ViewHolder> {
    ArrayList<Result> list;
    ISourceAdapter mISourceAdapter;
    Context context;

    public SourceAdapter(Context context, ArrayList<Result> list) {
        this.list = list;
        this.context = context;
        mISourceAdapter = (SourceAdapter.ISourceAdapter) context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.source_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = list.get(position);
        holder.tvName.setText(result.title);
        holder.tvDesc.setText(result.overview);
        holder.tvVote.setText(result.vote_average);
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w500" + result.backdrop_path)
                .into(holder.ivPoster);
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public interface ISourceAdapter {
        void showArticles(String title, String overview, String poster_path);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPoster;
        TextView tvName;
        TextView tvDesc;
        TextView tvVote;

        public ViewHolder(View itemView) {
            super(itemView);
            ivPoster = (ImageView) itemView.findViewById(R.id.imageViewPoster);
            tvName = (TextView) itemView.findViewById(R.id.textViewName);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            tvVote = (TextView) itemView.findViewById(R.id.textViewVote);
        }
    }
}