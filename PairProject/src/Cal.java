import java.util.Random;
import java.util.Scanner;

public class Cal {
    static int [] d =new int [30];
    static int a,b,c,result;
    static char[] str={'+','-','*','/'};
    static int [] setchar =new int [2];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("请输入题目数量：");
        int num=sc.nextInt();
        for(int i=0;i<num;i++) {
            arithmetic();
            System.out.println(a+""+str[setchar[0]]+""+b+""+str[setchar[1]]+""+c+"= "+result);
        }
    }
//    加法运算
    public static int add( int a, int b){
        return a+b;
    }
//    减法运算
    public static int del(int a, int b){
        return a-b;
    }
//    乘法运算
    public static int times(int a, int b){
        return a*b;
    }
//    除法运算
    public static int divide(int a, int b){
        return a/b;
    }
//    算出结果
    public static void arithmetic(){
        int e;
        Random r=new Random();
        a=r.nextInt(100)+1;
        b=r.nextInt(100)+1;
        c=r.nextInt(100)+1;
        setchar[0]=r.nextInt(4);
        setchar[1]=r.nextInt(4);
        switch(str[setchar[0]]) {
            case '+':
                while (str[setchar[1]]=='+'){
                    setchar[1]=r.nextInt(3)+1;
                }
                if(str[setchar[1]]=='-'){
                    while(add(a,b)-c<=0) {
                        c=r.nextInt(100)+1;
                    }
                    result=del(add(a,b),c);
                }else if(str[setchar[1]]=='*'){
                    result=add(times(b,c),a);
                }else if(str[setchar[1]]=='/'){
                    while((e=b%c)!=0||c==0) {
                        c=r.nextInt(100)+1;
                    }
                    result=add(divide(b,c),a);
                }
                break;
            case '-':
                while (str[setchar[1]]=='-'){
                    setchar[1]=r.nextInt(4);
                }
                while(a-b<=0) {
                    a=r.nextInt(100)+1;
                    b=r.nextInt(100)+1;
                }
                if(str[setchar[1]]=='+'){
                    result=add(del(a,b),c);
                }else if(str[setchar[1]]=='*'){
                    while(a-times(b,c)<=0) {
                        a=r.nextInt(100)+1;
                    }
                    result= del(a,times(b,c));
                }else if(str[setchar[1]]=='/'){
                    while((e=b%c)!=0||c==0) {
                        c=r.nextInt(100)+1;
                    }
                    result=del(a,divide(b,c));
                }
                break;
            case '*':
                while (str[setchar[1]]=='*'){
                    setchar[1]=r.nextInt(2);
                }
                if(str[setchar[1]]=='+'){
                    result= add(times(a,b),c);
                }else if(str[setchar[1]]=='-'){
                    while(times(a,b)-c<=0) {
                        c=r.nextInt(100)+1;
                    }
                    result=del(times(a,b),c);
                }else if(str[setchar[1]]=='/'){
                    while((e=times(a,b)%c)!=0||c==0) {
                        c=r.nextInt(100)+1;
                    }
                    result=divide(times(a,b),c);
                }
                break;
            case '/':
                while (str[setchar[1]]=='/'){
                    setchar[1]=r.nextInt(3);
                }
                while((e=a%b)!=0||b==0) {
                    a=r.nextInt(100)+1;
                    b=r.nextInt(100)+1;
                }
                if(str[setchar[1]]=='+'){
                    result=add(divide(a,b),c);
                }else if(str[setchar[1]]=='-'){
                    while(divide(a,b)-c<=0) {
                        c=r.nextInt(100)+1;
                    }
                    result=del(divide(a,b),c);
                }else if(str[setchar[1]]=='*'){
                    result=times(divide(a,b),c);
                }
                break;
        }
    }
}
