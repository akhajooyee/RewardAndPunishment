package com.example.alirezakjy.rewardpunishment.adaptors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.alirezakjy.rewardpunishment.R;
import com.example.alirezakjy.rewardpunishment.models.userModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by alirezakjy on 22/06/2018.
 */

public class usersAdaptors extends RecyclerView.Adapter<usersAdaptors.usersViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<userModel> mData = Collections.emptyList();
    private usersEventHadnler mUserEventHandler;

    public usersAdaptors(Context context , usersEventHadnler userseventHadnler , List modelList){
        this.mContext = context;
        mData = modelList;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mUserEventHandler = userseventHadnler;
    }

    public void updateAdapterData(List<userModel> data) {
        this.mData = data;
    }

    @Override
    public usersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.users_recycler_row , parent , false);


        return new usersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(usersAdaptors.usersViewHolder holder, int position) {

        userModel currentModel = mData.get(position);
        holder.firstNameTextView.setText(currentModel.firstName);
        holder.lastNameTextView.setText(currentModel.lastName);
        holder.userRoleTextView.setText(currentModel.role);
        holder.personnelCodeTextView.setText(currentModel.personnelCode);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class usersViewHolder extends RecyclerView.ViewHolder{
        private Button editUserButton;
        private TextView userRoleTextView;
        private TextView personnelCodeTextView;
        private TextView firstNameTextView;
        private TextView lastNameTextView;

        public usersViewHolder(View itemView) {
            super(itemView);
            editUserButton = (Button) itemView.findViewById(R.id.editUserButton);
            userRoleTextView = (TextView) itemView.findViewById(R.id.userRoleText);
            personnelCodeTextView = (TextView) itemView.findViewById(R.id.personnelCodetext);
            firstNameTextView = (TextView) itemView.findViewById(R.id.firstNameText);
            lastNameTextView = (TextView) itemView.findViewById(R.id.lastNameText);

            editUserButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mUserEventHandler != null){
                        mUserEventHandler.onEditUser(mData.get(getAdapterPosition()).id,
                                mData.get(getAdapterPosition()).firstName,
                                mData.get(getAdapterPosition()).lastName,
                                mData.get(getAdapterPosition()).personnelCode,
                                mData.get(getAdapterPosition()).password,
                                mData.get(getAdapterPosition()).token,
                                mData.get(getAdapterPosition()).role,
                                mData.get(getAdapterPosition()).branchId,
                                mData.get(getAdapterPosition()).evaluationFormTypeId,
                                mData.get(getAdapterPosition()).evaluatorId,getAdapterPosition());
                    }
                }
            });

        }

    }

    public interface usersEventHadnler{
        void onEditUser(String userId , String userFirstName , String userLastName ,
                        String userPersonnelCode , String userPassword , String userToken ,
                        String userRole , String userBranchId , String userEvaluationFormTypeId ,
                        String userEvaluatorId , int position);
    }
}
