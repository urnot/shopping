package com.tutu.shopping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Vote {

	public void vote() {
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		String url = "http://a.sz-longxiang.com/api.php?op=vote&id=13";

		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();

			/*
			 * 设置通用的请求头属性
			 * 
			 */
			conn.setRequestProperty("accept", "application/json, text/javascript, */*; q=0.01");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("cookie",
					"VEUnO_auth=bfe3B7Ki9z6Fu7ZolXdpn5vaiAxf4rVBTeUnXfpPqqwBhtthgdk0vgPlohPOP_n4M1hSff3RVID7tOEoBGdFjyYS97kQnSNp3pKW4rW2taIvC6bHcl7xcZy1fn_wEKe0; VEUnO__openid=2d41rKF21zH-6PqT7NwsKwNjDLwJYAEe5_CmDqq4xZPoJAiesMrbRbL0qLcMS5kqBl3WM2iImgAf; VEUnO__nickname=c28fy34mfGPlxiJm7Xcj3CaMnhg5DHlFvi_Lg0iWMCmE");

			// 发送POST请求必须设置如下两行 否则会抛异常（java.net.ProtocolException: cannot write to a
			// URLConnection if doOutput=false - call setDoOutput(true)）
			conn.setDoOutput(true);
			conn.setDoInput(true);

			/*
			 * 获取URLConnection对象对应的输出流并开始发送参数
			 * 
			 */
			out = new PrintWriter(conn.getOutputStream());
			// 下面开始设置参数，下面是随便模拟的两个参数sign和name
			// out.print("&sign="+sign);//设置一个参数sign
			// out.print("&name="+"zhangsan");//设置一个参数name
			// flush输出流的缓冲
			out.flush();

			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 使用finally块来关闭输出流、输入流
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println(unicode2String(result.toString()));
	}
	
    public static String unicode2String(String unicode){  
        StringBuilder sb = new StringBuilder();  
        int i = -1;  
        int pos = 0;  
          
        while((i=unicode.indexOf("\\u", pos)) != -1){  
            sb.append(unicode.substring(pos, i));  
            if(i+5 < unicode.length()){  
                pos = i+6;  
                sb.append((char)Integer.parseInt(unicode.substring(i+2, i+6), 16));  
            }  
        }  
          
        return sb.toString();  
    } 

	public static void main(String[] args) {
		for (int i = 0; i < 101; i++) {
			Vote v = new Vote();
			v.vote();
			try {
				Thread.sleep((long) (2000+Math.random()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
