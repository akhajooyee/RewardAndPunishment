package com.example.alirezakjy.rewardpunishment.adaptors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.alirezakjy.rewardpunishment.R;
import com.example.alirezakjy.rewardpunishment.models.evaluationCriterionModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by alirezakjy on 10/07/2018.
 */

public class evaluationCriterionsAdaptors extends RecyclerView.Adapter<evaluationCriterionsAdaptors.evaluationCriterionsViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<evaluationCriterionModel> mData = Collections.emptyList();
    private evaluationCriterionsAdaptors.evaluationCriterionsEventHadnler mEvaluationCriterionsEventHandler;

    public evaluationCriterionsAdaptors(Context context , evaluationCriterionsEventHadnler eventHadnler , List list){

        this.mContext = context;
        this.mData = list;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mEvaluationCriterionsEventHandler = eventHadnler;
    }

    public void updateAdapterData(List<evaluationCriterionModel> list){
        this.mData = list;
    }

    @Override
    public evaluationCriterionsAdaptors.evaluationCriterionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.evaluation_criterion_recycler_row , parent , false);

        return new evaluationCriterionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(evaluationCriterionsAdaptors.evaluationCriterionsViewHolder holder, int position) {
        evaluationCriterionModel currentModel = mData.get(position);
        holder.evaluationCriterionTypeTextView.setText(currentModel.type);
        holder.evaluationCriterionNameTextView.setText(currentModel.name);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class evaluationCriterionsViewHolder extends RecyclerView.ViewHolder{

        private Button editevaluationCriterionButton;
        private TextView evaluationCriterionTypeTextView;
        private TextView evaluationCriterionNameTextView;

        public evaluationCriterionsViewHolder(View itemView) {
            super(itemView);
            editevaluationCriterionButton = (Button) itemView.findViewById(R.id.editevaluationCriterionButton);
            evaluationCriterionTypeTextView = (TextView) itemView.findViewById(R.id.evaluationCriterionTypeText);
            evaluationCriterionNameTextView = (TextView) itemView.findViewById(R.id.evaluationCriterionNametext);

            editevaluationCriterionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mEvaluationCriterionsEventHandler.onEditEvaluationCriterion(mData.get(getAdapterPosition()).id,
                            mData.get(getAdapterPosition()).name ,
                            mData.get(getAdapterPosition()).type ,
                            mData.get(getAdapterPosition()).rewardMethod ,
                            mData.get(getAdapterPosition()).punishmentMethod ,
                            mData.get(getAdapterPosition()).noRewadPunishmentMethod ,
                            getAdapterPosition());
                }
            });

        }
    }

    public interface evaluationCriterionsEventHadnler{
        void onEditEvaluationCriterion(String evaluationCriterionsId , String evaluationCriterionsName , String evaluationCriterionsType ,
                        String evaluationCriterionsRewardMethod , String evaluationCriterionsPunishmentMethod ,
                        String evaluationCriterionsNoRewardPunishmentMethod , int position);
    }
}
