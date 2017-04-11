package com.jll.zoro.multitype;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.drakeet.multitype.ItemViewProvider;

/**
 * @Author : Zoro.
 * @Date : 2017/4/11.
 * @Describe :
 */

public class SongViewProvider
        extends ItemViewProvider<Song, SongViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected SongViewProvider.ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_song, null, false);
        return new SongViewProvider.ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Song song) {
        holder.title.setText(song.text);
        holder.content.setImageDrawable(ContextCompat.getDrawable(song.context,song.drawable));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @NonNull
        private final TextView title;
        private final ImageView content;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.content = (ImageView) itemView.findViewById(R.id.content_Image);
        }
    }
}
