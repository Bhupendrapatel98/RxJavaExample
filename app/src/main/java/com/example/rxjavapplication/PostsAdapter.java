package com.example.rxjavapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    Context context;
    List<Posts> postsList;

    public PostsAdapter(Context context, List<Posts> postsList) {
        this.context = context;
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        
        holder.txtAuthor.setText(String.valueOf(postsList.get(position).userId));
        holder.txtTitle.setText(String.valueOf(postsList.get(position).title));
        holder.txtContent.setText(new StringBuilder(postsList.get(position).body.substring(0, 20))
                .append("...").toString());

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtContent, txtAuthor;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtContent = itemView.findViewById(R.id.txtContent);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
        }

    }
}
