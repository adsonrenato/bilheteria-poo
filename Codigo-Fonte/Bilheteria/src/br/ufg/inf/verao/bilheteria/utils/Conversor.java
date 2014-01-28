/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.verao.bilheteria.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Valéria
 */
public class Conversor {
    
    public static Calendar stringToCalendar(String str_data) {
        Calendar cal = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse(str_data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cal;
    }
    
    public static String calendarToString(Calendar calendar) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String a = sdf.format(cal.getTime());  

        return a;
    }
}