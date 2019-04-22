package edu.gatech.cs2340.milestones.spacetraders.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.milestones.spacetraders.R;
import edu.gatech.cs2340.milestones.spacetraders.entity.Difficulty;


public class DifficultyAdaptor
        extends RecyclerView.Adapter<DifficultyAdaptor.DifficultyViewHolder> {
    private List<Difficulty> difficulties = new ArrayList<>();

    private OnDifficultyClickListener listener;

    /**
     * Set up difficulty view
     * @param parent
     * @param i
     * @return difficulty view
     */
    @Override
    public DifficultyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        //Tell the adapter what layout to use for each course in the list
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.new_game, parent, false);

        return new DifficultyViewHolder(itemView);
    }

    /**
     * Set up difficulty view
     * @param difficultyViewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull DifficultyAdaptor.DifficultyViewHolder
                                             difficultyViewHolder, int position) {
        Difficulty list = difficulties.get(position);
    }

    /**
     * Items in difficulty
     * @return difficulties list size
     */
    @Override
    public int getItemCount() {
        if (difficulties == null) return 0;
        return difficulties.size();
    }

    /**
     * Set list of difficulties
     * @param courses difficulty options
     */
    public void setDifficultyList(List<Difficulty> courses) {
        difficulties = courses;
        notifyDataSetChanged();
    }

    /**
     * Selection from list of difficulties
     * @param position selected difficulty
     * @return difficulty at position
     */
    public Difficulty getCourseAt(int position) {
        return difficulties.get(position);
    }

    class DifficultyViewHolder extends RecyclerView.ViewHolder {
        //View holder needs reference to each widget in the individual item in the list
        private TextView diff;



        /**
         * Construct a new view holder, grab all the widget references and setup the
         * listener to detect a click on this item.
         *
         * @param itemView
         */
        public DifficultyViewHolder(@NonNull View itemView) {
            super(itemView);
            diff = itemView.findViewById(R.id.difficuly_spinner);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onDifficultyClicked(difficulties.get(position));
                    }
                }
            });

        }
    }

    public interface OnDifficultyClickListener {

        /**
         * Interface method for difficulty clicked
         * @param difficulty
         */
        void onDifficultyClicked(Difficulty difficulty);
    }

    /**
     * Sets listener
     * @param listener
     */
    public void setOnDifficultyClickListener(OnDifficultyClickListener listener) {
        this.listener = listener;
    }

}
