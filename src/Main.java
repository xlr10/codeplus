import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import Brute_force.*;
import NM.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;

public class Main{
    static ArrayList<String> croll_input_output = new ArrayList<>();
    static Boolean example_debug = Boolean.TRUE;
    //static Boolean example_debug = Boolean.FALSE;

    ///////////////////////////////////num
    //static String ex_num ="2309";
    //static String ex_num ="3085";
    //static String ex_num ="1476";
    //static String ex_num ="1107"; // ??
    //static String ex_num ="14500";
    //static String ex_num ="6064"; //???
    //static String ex_num ="1748";
    //static String ex_num ="9095";
    //static String ex_num ="15649";
    //static String ex_num ="15650";
    //static String ex_num ="15651";
    //static String ex_num ="15652";
    //static String ex_num ="15654";
    //static String ex_num ="15655";
    static String ex_num ="15656";
    ///////////////////////////////////num

    ///////////////////////////////////example
    //static Brute_force_01 example = new Brute_force_01();
    //static Brute_force_02 example = new Brute_force_02();
    //static Brute_force_03 example = new Brute_force_03();
    //static Brute_force_04 example = new Brute_force_04();
    //static Brute_force_05 example = new Brute_force_05();
    //static Brute_force_06 example = new Brute_force_06();
    //static Brute_force_07 example = new Brute_force_07();
    //static NM_01 example = new NM_01();
    //static NM_02 example = new NM_02();
    //static NM_03 example = new NM_03();
    //static NM_04 example = new NM_04();
    //static NM_05 example = new NM_05();
    //static NM_06 example = new NM_06();
    static NM_07 example = new NM_07();
    ///////////////////////////////////example


    public static void main(String args[]) throws IOException {
        //croll_ex(Boolean.TRUE);
        croll_ex(Boolean.FALSE);

        if(croll_input_output.size()%2!=0){
            System.out.println("length:" +croll_input_output.size());
            System.out.println("input size != output size");
            System.out.println("check html");
            return;
        }

        for(int a=0; a<croll_input_output.size();a+=2){
            String input = croll_input_output.get(a);
            String output = croll_input_output.get(a+1);

            input.replaceAll("\n", "\r\n");
            InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
            System.setIn(is);

            System.out.println();
            System.out.println(">>>>>>>>>load example");

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(os);
            PrintStream originalPrintStream = System.out;

            System.setOut(ps);

            example.main(null);

            System.setOut(originalPrintStream);

            if(example_debug){
                System.out.println(os.toString());
            }

            String tmp_a ="";
            String tmp_b ="";

            System.out.print("\t");
            for(String e : output.split("\n|\r\n")){
                System.out.print(e+"|");
                tmp_a+=e+"|";
            }
            System.out.println();

            System.out.print("\t");
            for(String e : os.toString().split("\n")){
                System.out.print(e+"|");
                tmp_b+=e+"|";
            }
            System.out.println();

            if(tmp_a.equals(tmp_b)){
                System.out.println(">>>>> example_"+(a+1)+" correct");
            }else{
                System.out.println(">>>>> example_"+(a+1)+" wrong");
            }
        }
    }
    private static void croll_ex(Boolean print) throws IOException{
        String URL = "https://www.acmicpc.net/problem/"+ex_num;
        Document doc = Jsoup.connect(URL).get();

        System.out.println(">>>>>load problem: "+ ex_num);

        Elements elem = doc.select("div.col-md-6");

        for(Element e : elem.select("pre")){
            if(e.className().equals("sampledata")){
                croll_input_output.add(e.text().trim());
            }
        }
        if(print){
            for(String e : croll_input_output){
                System.out.println(">>>>>");
                System.out.println(e);
            }
        }
    }
}
