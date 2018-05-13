package com.example.q8big.maksab;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by q8big on 13/03/2018.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ProjectViewHolder> {

    public static class ProjectViewHolder extends RecyclerView.ViewHolder{
        private static final String LOG_TAG = CardAdapter.class.getSimpleName();

        CardView cv;
        TextView name;
        ImageView photoId;



        ProjectViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            name = (TextView) itemView.findViewById(R.id.project_name);
            photoId = (ImageView) itemView.findViewById(R.id.project_photo);
            Log.i(LOG_TAG, "adding listener");



        }


    }

    List< Project> projects;

    CardAdapter(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item_view, viewGroup, false);
        ProjectViewHolder pvh = new ProjectViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder projectViewHolder, int position) {

        final Project project = projects.get(position);
        projectViewHolder.name.setText(project.getName());
        projectViewHolder.photoId.setImageResource(project.getPhotoId());


        projectViewHolder.cv.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(view.getContext(), EmptyActivity.class);
                i.putExtra("name", project.getName());
                i.putExtra("photoId", project.getPhotoId());

                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }


}