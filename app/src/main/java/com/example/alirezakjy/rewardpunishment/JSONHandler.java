package com.example.alirezakjy.rewardpunishment;

import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alirezakjy on 21/06/2018.
 */

public class JSONHandler {
    static String test ;

    public static String id =  "id" ,
            realId, firstname = "firstName" , realFirstName ,
            lastname = "lastName", realLastName,
    personnelCode = "personnelCode", realPersonnelCode,
    password ="password",realPasword ,
    token ="token",realToken ,
    role ="role", realRole ,
    branchId ="branchId", realBranchid ,
    evaluationFormTypeId ="evaluationFormTypeId", realEvaluationFormTypeId ,
    evaluatorId ="evaluatorId" , realEvaluatorId;

    public static List<Map<String,String>> userListResponseToString(String rawJson) throws JSONException{
        JSONArray json;
        List<Map<String , String>> result = new ArrayList<>();
        /*
        har kodoom az azaaaye list yek user e k yek hash map az role o baghie sefataash
        */
        try {
            json = new JSONArray(rawJson);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        for (int i = 0 ; i < json.length() ; i++){
            Map<String , String> map = new HashMap<>();
            JSONObject jsonTempt = json.getJSONObject(i);
            map.put("id" , jsonTempt.getString(id));
            map.put(firstname , jsonTempt.getString(firstname));
            map.put(lastname , jsonTempt.getString(lastname));
            map.put(personnelCode , jsonTempt.getString(personnelCode));
            map.put(password , jsonTempt.getString(password));
            map.put(token , jsonTempt.getString(token));
            map.put(role , jsonTempt.getString(role));
            map.put(branchId , jsonTempt.getString(branchId));
            map.put(evaluationFormTypeId , jsonTempt.getString(evaluationFormTypeId));
            map.put(evaluatorId , jsonTempt.getString(evaluatorId));

            result.add(map);
        }


        return result;
    }

    public static void loginResponseToStrings(String rawJson) throws JSONException {
        JSONObject json ;

        try {

            json = new JSONObject(rawJson);

        }catch (Exception e){
            e.printStackTrace();
            return ;
        }

        test = json.getString("firstName") + " " + json.getString("lastName")+ " " + json.getString("personnelCode")
                + " " + json.getString("password") + " " + json.getString("role") + " " + json.getString("token")
                + " " + json.getString("branchId") + " " ;




        try {
            realId = json.getString(id);
            realFirstName = json.getString(firstname);
            realLastName = json.getString(lastname);
            realPersonnelCode = json.getString(personnelCode);
            realPasword = json.getString(password);
            realToken = json.getString(token);
            realRole = json.getString(role);
            realBranchid = json.getString(branchId);
            realEvaluationFormTypeId = json.getString(evaluationFormTypeId);
            realEvaluatorId = json.getString(evaluatorId);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ;
    }


}
