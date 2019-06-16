
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       //1、找到aeio的个数countChar；
        // 2、其他字母的个数countOthers；
        //3、如果其他字母的个数小于chountChar-1返回0；
        //4、如果其他字母大于 1、先分割 2、插空
        int num,i ;
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        in.nextLine();
        for (i=0;i<num;i++){
            int j;
            String str  = in.nextLine();
            long  sum = 1;
            char[] ch = str.toCharArray();
            int len = ch.length;
            int numChar = countChar(ch);
            int numOther = len-numChar;

            int tt= 2*numChar;
            if(numChar ==0)
                tt=1;
            if((numChar-1)>numOther){
                System.out.print(0);
            }
            else{
                for(j=1;j<numChar;j++){
                    sum=numOther*sum;
                    numOther =numOther-1;
                }
                for(;numOther>0;numOther--)
                {
                    sum = sum*tt;
                    tt++;
                }
                System.out.println(sum);
            }

        }


    }
    public static  int countChar(char[] ch){
        int len = ch.length;
        int i,count =0;
        for(i=0;i<len;i++){
            if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o')
                count++;
        }
        return count;
    }
}