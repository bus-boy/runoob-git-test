//package cmy;
import java.io.*;
import java.util.*;

public class Text_one {
    Properties pro ;

    public Text_one(){
        loadDictionary();
    }
    public void loadDictionary() {
        pro = new Properties();
        try {
            File file = new File("zidian.txt");//导入字典
            if (!file.exists())
                file.createNewFile();

            FileReader fis = new FileReader(file);//以字符载入时没有乱码，以字节载入时出现了乱码
            // 乱码原因 因为中文和英文的字节数是不同的，所以以字节载入就就会导致解码错误
            pro.load(fis);
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            System.out.println("载入字典时出错");
        }
    }
    public String trans(String line,boolean langFlag){
        String [] tmp = line.split(" ");
        int flag = 1;
        String str=null;
        String Noindic=null;
        StringBuffer re = new StringBuffer();
        for(int i=0;i<tmp.length;i++){              //结果保存在文件中
            if(!langFlag) {                         //中->英
                str = pro.getProperty(tmp[i]);
            }else {                                 //英->中
                Set set = pro.keySet();
                Iterator it = set.iterator();
                while(it.hasNext()){
                    String key = (String) it.next();
                    if(tmp[i].equals(pro.getProperty(key))){
                        str = key;
                        break;
                    }
                }
            }
            if(str==null){
                flag = 0;
                Noindic = tmp[i];
                break;
            }else{
                re.append(str+" ");
            }
        }

        if(flag==1){
            return re.toString();
        }else{
            return "翻译失败！"+Noindic+"不存在，请添加到你的字典里面";
        }
    }
    public String dictionAdd(String str,boolean langFlag){
        String c[] = str.split(":");    //保存方式 中：英
        String key ;//增加了判断字典中是否存在的功能
        if(c[1]==null){
            return "添加失败，请以（中文：英文）的格式添加";
        }else {
            if (!langFlag) {
                key = c[0];
                if (pro.getProperty(key) != null && c[1].equals(pro.getProperty(key))) {
                    return "字典中已存在";
                } else {
                    pro.setProperty(c[0], c[1]);
                }
            } else {
                key = c[1];
                if (pro.getProperty(key) != null && c[0].equals(pro.getProperty(key))) {
                    return "字典中已存在";
                } else {
                    pro.setProperty(c[1], c[0]);
                }
            }
        }

        File file = new File("zidian.txt");
        try {
            pro.store(new PrintWriter(file),"tianjia");
            return "添加成功";
        }catch(Exception e){
            e.printStackTrace();
            return "添加失败";
        }
    }
}
