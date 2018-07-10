package com.example.alirezakjy.rewardpunishment;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.alirezakjy.rewardpunishment.adaptors.evaluationCriterionsAdaptors;
import com.example.alirezakjy.rewardpunishment.models.evaluationCriterionModel;

import java.util.Collections;
import java.util.List;

public class EvaluationCriterionsActivity extends AppCompatActivity {

    private RecyclerView mRyEvaluationCriterions;
    private evaluationCriterionsAdaptors evaluationCriterionsAdaptors;
    private Button addEvaluationCriterionButton;
    public static String QNType = "QUANTITIVE" ,
            QLType = "QUALITATIVE" ,
            QQType = "QUANTITIVE_QUALITATIVE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_criterions);

        mRyEvaluationCriterions = (RecyclerView) findViewById(R.id.EvaluationCriterionsRecyclerView);
        mRyEvaluationCriterions.setLayoutManager(new LinearLayoutManager(this));
        evaluationCriterionsAdaptors = new evaluationCriterionsAdaptors(this, new evaluationCriterionsAdaptors.evaluationCriterionsEventHadnler() {

            @Override
            public void onEditEvaluationCriterion(String evaluationCriterionsId, String evaluationCriterionsName,
                                                  String evaluationCriterionsType, String evaluationCriterionsRewardMethod,
                                                  String evaluationCriterionsPunishmentMethod,
                                                  String evaluationCriterionsNoRewardPunishmentMethod, int position) {
                //TODO inja bayad edit evaluation criterion ro piade sazi konim
            }
        } , Collections.emptyList());
        setEvaluationCriterions();

        addEvaluationCriterionButton = (Button) findViewById(R.id.addEvaluationCriterionButton);
        addEvaluationCriterionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDialog dialog = new MaterialDialog.Builder(EvaluationCriterionsActivity.this)
                        .title("add evaluation criterion")
                        .customView(R.layout.add_evaluation_criterion_dialog , true)
                        .positiveText("add")
                        .negativeText("cancel")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                //TODO inja bayad add criterion implement shavad
                                String name = ((EditText) dialog.findViewById(R.id.evaluationCriterionNameEditText)).getText().toString();
                                String type = ((Spinner) dialog.findViewById(R.id.evaluationCriterionTypeSpinner)).getSelectedItem().toString();
                                String rewardPolicy = ((EditText) dialog.findViewById(R.id.rewardPolicyEditText)).getText().toString();
                                String punishmentPolicy = ((EditText) dialog.findViewById(R.id.punishmentPolicyEditText)).getText().toString();
                                String noRewardAndPunishmentpolicy = ((EditText) dialog.findViewById(R.id.noRewardAndPunishmentPolicyEditText)).getText().toString();
                                Toast.makeText(getApplicationContext() , name + " " + type + " " + noRewardAndPunishmentpolicy + "\n" + punishmentPolicy , Toast.LENGTH_LONG).show();

                            }
                        })
                        .show();
            }
        });


    }

    private void setEvaluationCriterions() {
        //TODO inja bayad listEvaluationCriterions ro implement konim
        List<evaluationCriterionModel> list = null;

        evaluationCriterionsAdaptors.updateAdapterData(list);
        evaluationCriterionsAdaptors.notifyDataSetChanged();
    }
}
