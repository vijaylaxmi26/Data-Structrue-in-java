public class SortingTime {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Sort obj = new Sort();
        
        int[] a1 = {2, 23, 12, 4, 101, 42, 67, 88};
       obj.BubbleSort(a1);
       
         int[] a2 = {2, 23, 12, 4, 101, 42, 67, 88};
        obj.SeclectionSort(a2);
        
         int[] a3 = {2, 23, 12, 4, 101, 42, 67, 88};
        obj.InsertionSort(a3);

        int[] a4 = {2, 23, 12, 4, 101, 42, 67, 88};
        long start = System.nanoTime();
        obj.QuickSort(a4, 0, 7);
         long end = System.nanoTime();
        System.out.println("Time Taken by Quick sort: " + (end - start));
        
    

    }

}

class Sort {

    public void InsertionSort(int[] array) {
        long start = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }

            array[j+1] = temp;
        }

        
        
        long end = System.nanoTime();
        System.out.println("Time Taken by Insetion sort: " + (end - start));

    }

    public void BubbleSort(int[] array) {

        long start = System.nanoTime();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        long end = System.nanoTime();
        System.out.println("Time Taken by Bubble sort: " + (end - start));

    }

    public void SeclectionSort(int[] array) {

        long start = System.nanoTime();

        for (int i = 0; i < array.length - 1; i++) {
            int min_ind = i;
            for (int j = i; j < array.length; j++) {
                if (array[min_ind] > array[j]) {
                    min_ind = j;
                }
            }
            int temp = array[min_ind];
            array[min_ind] = array[i];
            array[i] = temp;

        }
        long end = System.nanoTime();
        System.out.println("Time Taken by Selection sort: " + (end - start));

    }

    public void QuickSort(int[] array, int lb, int ub){
         
        if (lb < ub) {
                 int loc=partition(array,lb,ub);
                 if(loc>0){
                    QuickSort(array,lb,loc-1);
                 }
                 if(loc<array.length-1){
                     QuickSort(array,loc+1,ub);
                 }
        }
    }

    public int  partition(int[] array, int lb, int ub) {
        
        int pivot = array[lb];
        int start = lb;
        int end = ub;
        
        while (start < end) {
            
           while (array[start] <= pivot && start<ub) {
                start++;
           }
            
           while (pivot < array[end] && end>lb) {
                end--;
           }
            
           if(start<end){
               int temp=array[start];
               array[start]=array[end];
               array[end]=temp;
           }
                                  
        }
         int temp=array[lb];
          array[lb]=array[end];
          array[end]=temp;
          
          return end;
    }
   

}
