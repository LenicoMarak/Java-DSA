package LBSearch;
import java.util.*;

class Searching{
    int com=0;
    public <T extends Comparable <T>> int linearSearch(T[] arr,T target){
        int index=0;
        for(int i=0;i<arr.length;i++){
            com++;
            if(arr[i].compareTo(target)==0){
                return index;
            }
            index++;
        }
        return -1;
    }
    public <T extends Comparable<T>> int binarySearch(T[] arr,T target){
        int startIndex=0;
        int endIndex=arr.length-1;
        int mid=startIndex+(endIndex-startIndex)/2;
        for(int i=0;i<=endIndex;i++){
            com++;
            if(arr[mid].compareTo(target)==0){
                return mid;
            }
            if(arr[mid].compareTo(target)>0){
                endIndex=mid-1;
            }
            else if(arr[mid].compareTo(target)<0){
                startIndex=mid+1;
            }
            mid=startIndex+(endIndex-startIndex)/2;
        }
        return -1;
    }
    public <T> void display(T[] arr){
      int i;
      System.out.print("Displaying elements----->[ ");
        for(i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[i]+" ]");
    }
    public static void main(String[] args) {
        Searching obj=new Searching();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the size: ");
        Integer size=scan.nextInt();
        System.out.println("Enter the elements: ");
        Character[] elements=new Character[size];
        for(int i=0;i<size;i++){         
            elements[i]=scan.next().charAt(0);
        }
        obj.<Character>display(elements);

        System.out.println("1:Linear Search.");
        System.out.println("2:Binary Search.");
        System.out.print("Enter your choise: ");
        char choise=scan.next().charAt(0);
        switch(choise){
            case '1':  
                System.out.println("Linear Searching::");
                System.out.print("Enter the element you want to search for: ");
                Character x=scan.next().charAt(0);
                int pos=obj.<Character>linearSearch(elements,x);
                if(pos==-1){
                   System.out.println("Element not found!!");
                }
                else{
                System.out.println("Target found at index: "+pos);
                System.out.println("Number of iteration:- "+obj.com);
                }
                break;
            case '2':
                System.out.println("Binary Searching::");
                System.out.print("Enter the element you want to search for: ");
                Character y=scan.next().charAt(0);
                int index=obj.<Character>binarySearch(elements,y);
                if(index==-1){
                   System.out.println("Element not found!!");
                }
                else{
                System.out.println("Target found at index: "+index);
                System.out.println("Number of iteration:- "+obj.com);
                }
                break;
            default:
                System.out.println("Wrong choise!!");         
        }
        scan.close();
    }
}