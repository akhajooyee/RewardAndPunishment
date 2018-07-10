package com.example.alirezakjy.rewardpunishment;

import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.alirezakjy.rewardpunishment.adaptors.usersAdaptors;
import com.example.alirezakjy.rewardpunishment.models.userModel;
import com.example.alirezakjy.rewardpunishment.services.userListService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UsersPageActivity extends AppCompatActivity {
    private RecyclerView mRyUsers;
    private usersAdaptors usersAdaptors;
    private Button addUserButton;
    private String[] roles={"role1" , "role2"};
    private String[] units = {"unit1" , "unit2"};
    private String[] evaluators = {"eval1" , "eval2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_page);






        mRyUsers = (RecyclerView) findViewById(R.id.usersRecyclerView);
        mRyUsers.setLayoutManager(new LinearLayoutManager(this));
        usersAdaptors = new usersAdaptors(this , new usersAdaptors.usersEventHadnler(){

            @Override
            public void onEditUser(String userId, String userFirstName, String userLastName,
                                   String userPersonnelCode, String userPassword, String userToken,
                                   String userRole, String userBranchId, String userEvaluationFormTypeId,
                                   String userEvaluatorId, int position) {
                //TODO inja bayad edit user to implement konim

            }
        } , Collections.emptyList());
        mRyUsers.setAdapter(usersAdaptors);
        setUsers();

        //set the add btn
        addUserButton = (Button) findViewById(R.id.addUserButton);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner rolespinner;
                Spinner unitspinner;
                Spinner evaluatorspinner;

                MaterialDialog dilg = new MaterialDialog.Builder(UsersPageActivity.this)
                        .title("add user")
                        .customView(R.layout.add_user_dialog_view , true)
                        .positiveText("add")
                        .negativeText("cancel")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                EditText nameedit = (EditText) dialog.findViewById(R.id.addUserName);
                                EditText lastNameedit = (EditText) dialog.findViewById(R.id.addUserLastName);
                                EditText personnelCodeedit = (EditText) dialog.findViewById(R.id.addUserPersonnelCode);
                                EditText passwordedit = (EditText) dialog.findViewById(R.id.addUserPassword);
                                String name = nameedit.getText().toString();
                                String lastName = lastNameedit.getText().toString();
                                String personnelCode = personnelCodeedit.getText().toString();
                                String password = passwordedit.getText().toString();
                                Spinner roleSpinner = (Spinner) dialog.findViewById(R.id.addUserRole);
                                Spinner unitSpinner = (Spinner) dialog.findViewById(R.id.addUserUnit);
                                Spinner evaluatorSpinner = (Spinner) dialog.findViewById(R.id.addUserEvaluator);
                                String role = roleSpinner.getSelectedItem().toString();
                                String unit = unitSpinner.getSelectedItem().toString();
                                String evaluator = evaluatorSpinner.getSelectedItem().toString() ;
                                Toast.makeText(getApplicationContext() , "service add user", Toast.LENGTH_LONG).show();


                            }
                        })
                        .show();
                rolespinner = (Spinner) dilg.findViewById(R.id.addUserRole);
                List<String> roleList = new ArrayList<String>();
                for (int i = 0 ; i< roles.length ; i++){
                    roleList.add(roles[i]);
                }
                ArrayAdapter<String> dataAdapterRole = new ArrayAdapter<String>
                        (UsersPageActivity.this, android.R.layout.simple_spinner_item, roleList);
                dataAdapterRole.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                rolespinner.setAdapter(dataAdapterRole);


                unitspinner = (Spinner) dilg.findViewById(R.id.addUserUnit);
                List<String> unitList = new ArrayList<String>();
                for (int i = 0 ; i< units.length ; i++){
                    unitList.add(units[i]);
                }
                ArrayAdapter<String> dataAdapterUnit = new ArrayAdapter<String>
                        (UsersPageActivity.this, android.R.layout.simple_spinner_item, unitList);
                dataAdapterUnit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                unitspinner.setAdapter(dataAdapterUnit);


                evaluatorspinner = (Spinner) dilg.findViewById(R.id.addUserEvaluator);
                List<String> evaluatorList = new ArrayList<String>();
                for (int i = 0 ; i< evaluators.length ; i++){
                    evaluatorList.add(evaluators[i]);
                }
                ArrayAdapter<String> dataAdapterEvaluator = new ArrayAdapter<String>
                        (UsersPageActivity.this, android.R.layout.simple_spinner_item, evaluatorList);
                dataAdapterEvaluator.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                evaluatorspinner.setAdapter(dataAdapterEvaluator);






            }
        });


        //azin ghesmat b paiin ta akhare onCreate baraye teste





    }

    private void setUsers() {
        //TODO inja bayad service listUser ejra shavad va userAdaptor update o notify beshe
        userListService service = new userListService();
        String userListUrl = MainLogin.mainUrl;

        List<userModel> list = null;

        userModel a = new userModel();
        a.id = "1";
        a.firstName = "1";
        a.lastName = "1";
        a.token = "1";
        a.branchId = "1";
        a.role = "1";
        a.password = "1";
        a.evaluationFormTypeId = "1";
        a.evaluatorId = "1";
        a.personnelCode = "1";
        userModel b = new userModel();
        b.id = "2";
        b.firstName = "2";
        b.lastName = "2";
        b.token = "2";
        b.branchId = "2";
        b.role = "2";
        b.password = "2";
        b.evaluationFormTypeId = "2";
        b.evaluatorId = "2";
        b.personnelCode = "2";
        List<userModel> myList = new ArrayList<>();
        myList.add(b);
        myList.add(a);
        myList.add(a);
        myList.add(a);

        list = myList;



        usersAdaptors.updateAdapterData(list);
        usersAdaptors.notifyDataSetChanged();
    }


}
