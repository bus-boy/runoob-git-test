import java.io.*;
import java.util.*;

public class Translate {
    Map<String,String> map = new HashMap<String,String>(); //为什么不用呢？
    Properties pro ;

    public Translate(){
        loadDictionary();
    }
    public void loadDictionary() {
        pro = new Properties();
        try {
            File file = new File("D:"+File.separator+"zidian.txt");
            if(!file.exists()){
                try{
                    file.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
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
        StringBuffer re = new StringBuffer(); //由于删掉文件会有延迟，所以连续翻译时还有上次的结果，并且变量就可以直接代替
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
                break;
            }else{
                re.append(str+" ");
            }
        }

        if(flag==1){
            return re.toString();
        }else{
           return "翻译失败！字典中没有这个单词！请添加！";
        }
    }
    public String dictionAdd(String str,boolean langFlag){
        String c[] = str.split(":");    //保存方式 中：英
        String key ;                            //增加了判断字典中是否存在的功能
        if(!langFlag) {
            key = c[0];
            if(pro.getProperty(key)!=null&&c[1].equals(pro.getProperty(key)))
                return "字典中已存在";
            pro.setProperty(c[0], c[1]);
        }
        else {
            key = c[1];
            if(pro.getProperty(key)!=null&&c[0].equals(pro.getProperty(key)))
                return "字典中已存在";
            pro.setProperty(c[1], c[0]);
        }

        File file = new File("D:"+File.separator+"zidian.txt");
        try {
            pro.store(new FileOutputStream(file),"tianjia");
            return "添加成功";
        }catch(Exception e){
            e.printStackTrace();
            return "添加失败";
        }
    }
}
