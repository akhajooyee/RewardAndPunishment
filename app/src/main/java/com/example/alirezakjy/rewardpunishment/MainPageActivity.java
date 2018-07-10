package com.example.alirezakjy.rewardpunishment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class MainPageActivity extends AppCompatActivity {
    Button identityButton , usersButton , branchesButton , evaluationCriterionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        initialize();
    }

    private void initialize() {
        identityButton = (Button) findViewById(R.id.identityButton);
        usersButton = (Button) findViewById(R.id.usersButton);
        evaluationCriterionButton = (Button) findViewById(R.id.evaluationCriterionsButton);
        branchesButton = (Button) findViewById(R.id.branchesButton);

        identityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String identityString = "id:" + JSONHandler.realId +
                        "\n firstname:" + JSONHandler.realFirstName +
                        "\n lastname:" + JSONHandler.realLastName +
                        "\n personnel code:" + JSONHandler.realPersonnelCode +
                        "\n role:" + JSONHandler.realRole +
                        "\n branch id:" + JSONHandler.realBranchid +
                        "\n evaluation form type id:" + JSONHandler.realEvaluationFormTypeId +
                        "\n evaluator id:" + JSONHandler.realEvaluatorId ;

                 new MaterialDialog.Builder(MainPageActivity.this)
                        .title("your identity")
                        .content(identityString)
                        .positiveText("colse")
                        .show();

            }
        });

        usersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext() , UsersPageActivity.class);
                startActivity(intent);

            }
        });

        branchesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO inja fekonam nabas kari anjam she


            }
        });

        evaluationCriterionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext() , EvaluationCriterionsActivity.class);
                startActivity(intent);

            }
        });



    }
}

//its just a sample from our server for a login
/**
 {
 "id": 1,
 "firstName": "Jalal",
 "lastName": "Heidari",
 "personnelCode": "92106418",
 "password": "92106418",
 "token": "c0f1ee7a-149b-47dd-b65a-b3b1251321e9",
 "role": "ADMIN",
 "branchId": 1,
 "evaluationFormTypeId": null,
 "evaluatorId": null
 }
 * **/
