package org.zt.common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.csvreader.CsvReader;


public class Soucecsv {

    private Soucecsv(){}

	public static String read(int index, String headname) throws IOException {

        String rfile = "";

        // 第一参数：读取文件的路径 第二个参数：分隔符 第三个参数：字符集
        CsvReader csvReader = new CsvReader(rfile, ',', StandardCharsets.UTF_8);
        // 如果你的文件没有表头，这行不用执行
        // 这行不要是为了从表头的下一行读，也就是过滤表头
        // csvReader.readHeaders();
        // 读取每行的内容
        // String line=null;
        int line = 0;
        String data = null;
        while (csvReader.readRecord()) {
            line++;
            // 读取一整行
            // System.out.println(csvReader.getRawRecord());
            if (line == index) {
                // 1. 通过下标获取
//				data = (csvReader.get(num));
                // 2. 通过表头的文字获取
                data = csvReader.get(headname);
                // System.err.println(sdata);
            }

        }
        return data;
    }

}