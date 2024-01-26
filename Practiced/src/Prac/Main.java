package Prac;
import java.util.Arrays;
public class Main {
    public void delete(int[] arr,int ele){
        int len=arr.length;
        for(int i=0;i<len;i++){
            if(arr[i]==ele){
                for(int j=i;j<len-1;j++){
                    arr[j]=arr[j+1];
                }
                break;
            }
        }
    }
    public void display(int[] r){
        System.out.print("[ ");
        for(int i=0;i<r.length;i++){
            System.out.print(r[i]+" ");
        }
        System.out.println("]");
    }
    public static boolean isPythagoExist(int[] arr){
        int len=arr.length-1;
        int a,b,c;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                for(int k=j;k<len;k++){
                    a=arr[i]*arr[i];
                    b=arr[j]*arr[j];
                    c=arr[k]*arr[k];
                    if(a+b==c || b+c==a || c+a==b){
                       return true;
                    }
                 }
             }
        }
        return false;      
    }
    public static void equiPoint(int[] arr){
        int mid=arr.length/2;
        System.out.println("Equilibrium point is: "+arr[mid]);
        int x=0;
        for(int i=0;i<arr.length-1;i++){
            if(i==mid){
                break;              
            }
            x=x+arr[i];    
        }
        int result=0;
        int j=mid+1;
        while(j<arr.length){
            result=result+arr[j];
            j++;
        }
        if(x==result)
            System.out.println("Thus: "+x+"=="+result);
        else
            System.out.println("Thus: "+x+"!="+result);
    }
    public static int[] sumOfTwoIndic(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
           for(int j=i+1;j<arr.length;j++){
               int sum=arr[i]+arr[j];
               if(target==sum){
                  int a[]={i,j};
                  return a;
               }         
           } 
        }
        return null;
    }
    
    public static void main(String[] args) {
        Main obj=new Main();
        //Scanner sc=new Scanner(System.in);
        int[] list={5,8,8,3,7,5,4};
        obj.display(list);
        int[] x=sumOfTwoIndic(list,13);
        System.out.print(Arrays.toString(x));
    
    }
    
}
