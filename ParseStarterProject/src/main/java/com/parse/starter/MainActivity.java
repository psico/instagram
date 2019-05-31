/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ParseObject pontuacao = new ParseObject("Pontuacao");
    pontuacao.put("nome", "Romário");
    pontuacao.put("pontos", 123);
    pontuacao.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) { //não temos erros, pois o objeto está nulo
          Log.i("salvarPontos", "Dados salvos com sucesso");
        } else {
          Log.i("salvarPontos", "Erro ao salvos os dados");
        }
      }
    });

//    ParseQuery<ParseObject> consulta = ParseQuery.getQuery("Pontuacao");
//    consulta.getInBackground("GJV9KGEqs7", new GetCallback<ParseObject>() {
//      @Override
//      public void done(ParseObject object, ParseException e) {
//
//        if (e == null) { //não temos erros, pois o objeto está nulo
//
//          object.put("pontos", 600);
//          object.saveInBackground();
//
//        } else {
//          Log.i("consultaObjeto", "Erro ao consultar objeto");
//        }
//      }
//
//    });

    ParseQuery<ParseObject> filtro = ParseQuery.getQuery("Pontuacao");

    //Aplicando filtros na listagem de objetos
    filtro.addAscendingOrder("pontos");
    filtro.setLimit(3);

    //Listar os dados
    filtro.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, ParseException e) {

        if (e == null) { //não temos erros, pois o objeto está nulo
          for ( ParseObject object:objects) {
            Log.i("ListarDados", "Objetos - " + object.get("nome") + " pontos: " + object.get("pontos"));
          }
        } else {
          Log.i("ListarDados", "Erro ao salvos os dados - " + e.getMessage());
        }
      }
    });

  }

}
