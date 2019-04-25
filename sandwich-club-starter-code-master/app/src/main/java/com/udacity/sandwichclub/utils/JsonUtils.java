package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        Sandwich sandwich ;
        JSONObject jsonObject ;
        jsonObject = new JSONObject(json);

        JSONObject name = jsonObject.getJSONObject("name");

        String mainName = name.getString("mainName");

        JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");

        String placeOforigin = jsonObject.getString("placeOfOrigin");

        String description = jsonObject.getString("description");

        String image = jsonObject.getString("image");

        JSONArray ingredients = jsonObject.getJSONArray("ingredients");

        List<String> alsoKnownAsL = null;


        List<String> ingredientsL = null;

        if (alsoKnownAs != null)
        {

            alsoKnownAsL =new ArrayList<>();
            for (int i = 0; i < alsoKnownAs.length(); i++)
            {
                if (i>0 && i<ingredients.length()-2)
                {
                    alsoKnownAsL.add(alsoKnownAs.getString(i)+" , ");
                }
                else
                    alsoKnownAsL.add(alsoKnownAs.getString(i));
            }
        }
        if (ingredients != null)
        {
            ingredientsL =new ArrayList<>();
            for (int i = 0; i < ingredients.length(); i++)
            {
                if (i>0 && i<ingredients.length()-2)
                {
                    ingredientsL.add(ingredients.getString(i)+" , ");
                }
                else
                    ingredientsL.add(ingredients.getString(i));
            }

        }
        sandwich = new Sandwich(mainName,alsoKnownAsL,placeOforigin,description,image, ingredientsL);
        return sandwich;
    }
}