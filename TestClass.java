// You can print the values to stdout for debugging
public class TestClass

{

    public static int getDigitSum(int arr[])

    {

        int result,len=arr.length;
        int min = arr[0];

        for(int i=0;i<len;i++)

        {

            if(arr[i]<min)

                min=arr[i];

        }

        result=getSum(min);

        if(result%2==0)

            return 1;

        else

            return 0;

    }



    public static int getSum(int num)

    {

        int sum=0;

        while(num!=0)

        {

            sum=sum+(num%10);

            num=num/10;

        }

        return sum;

    }
public static void main(String[] args){
        int[] arr= {23,18,11,3};
        System.out.print(getDigitSum(arr));
}
}

