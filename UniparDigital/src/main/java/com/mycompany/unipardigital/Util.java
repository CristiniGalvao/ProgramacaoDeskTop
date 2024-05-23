/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unipardigital;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author aluno
 */
public class Util {

    public static String converteJsonString(BufferedReader bufferedReader) throws IOException{
        String resposta = "";
        String jsonString = "";
        while((resposta = bufferedReader.readLine()) !=null){
            jsonString += resposta;
        }
        return jsonString;
    }
}
