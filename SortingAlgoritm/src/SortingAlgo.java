
public class SortingAlgo {
    public<T extends Comparable<T>>void bubleSort(T[] arr){
        T temp;
        for(int i=0;i<arr.length-1;i++){   
            for(int j=0;j<arr.length-i-1;j++){
              if(arr[j].compareTo(arr[j+1])>0){
                 temp=arr[j];
                 arr[j]=arr[j+1];
                 arr[j+1]=temp;
              }
            } 
        }
    }
    
    public <T extends Comparable<T>>void insertionSort(T[] list){
        for(int i=1;i<list.length;i++){
            T curr=list[i];
            int j=i-1;
            while(j>=0 && list[j].compareTo(curr)>0){
                list[j+1]=list[j];
                j--;
            }
            list[j+1]=curr;
        }
        
    }
    public <T extends Comparable<T>>void selectionSort(T[] arr){
        for(int i=0;i<arr.length;i++){
            int small=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j].compareTo(arr[small])<0){
                    small=j;
                }
            }
            T temp=arr[i];
            arr[i]=arr[small];
            arr[small]=temp;
        }
    }
    void mergeSort(int[] array,int start,int end){
       if(start<end){
          int mid =start+(start-end)/2;
          mergeSort(array,start,mid);
          mergeSort(array,mid+ 1,end); 
          merge(array,start,mid,end);
       }
    }
    void merge(int[] array,int start,int middle,int end){
        int[] leftArray=new int[middle-start+1];
        int[] rightArray=new int[end-middle];
        for (int i=0;i<leftArray.length;++i)
            leftArray[i]=array[start + i];
        for (int i=0;i<rightArray.length;++i)
            rightArray[i]=array[middle + 1 + i];
        int leftIndex=0,rightIndex=0;
      
        int currentIndex=start;
        while(leftIndex<leftArray.length && rightIndex<rightArray.length){
            if(leftArray[leftIndex]<=rightArray[rightIndex]){
              array[currentIndex]=leftArray[leftIndex];
                leftIndex++;
            }
            else{
              array[currentIndex]=rightArray[rightIndex];
              rightIndex++;
            }
            currentIndex++;
        }
     
        while(leftIndex < leftArray.length) array[currentIndex++]=leftArray[leftIndex++];
        
        while(rightIndex<rightArray.length) array[currentIndex++]=rightArray[rightIndex++];
    }
    public void quickSort(int[]0 arr){
        
    }
}

