package com.sgcc.bd.overallview.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtil {

    public static String getHtml(String urlStr) {
        URL url = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            url = new URL(urlStr);
            is = url.openStream();
            isr = new InputStreamReader(is,"utf-8");
            br = new BufferedReader(isr);
            char[] c = new char[1024000];
            while(br.read(c) != -1) {
                final String ss = new String(c);
                sb.append(ss);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
