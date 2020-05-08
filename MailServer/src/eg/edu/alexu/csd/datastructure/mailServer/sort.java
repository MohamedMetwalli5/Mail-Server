package eg.edu.alexu.csd.datastructure.mailServer;

public class sort implements ISort {
	private String sorting;
	public void setSorting(String s) {
		sorting=s;
	}
	public String getSorting() {
		return sorting;
	}
	public  void Quicksort(int[][] elements) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(elements[0].length);

        while (stack.isEmpty() == false) {
            int end = (int) stack.pop();
            int start = (int) stack.pop();
            if (end - start < 2) {
                continue;
            }
            int p = start + ((end - start) / 2);
            p = partition(elements, p, start, end);
            stack.push(p + 1);
            stack.push(end);
            stack.push(start);
            stack.push(p);

        }
    }
	
	public  void Quicksort(String[][] elements) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(elements[0].length);

        while (stack.isEmpty() == false) {
            int end = (int) stack.pop();
            int start = (int) stack.pop();
            if (end - start < 2) {
                continue;
            }
            int p = start + ((end - start) / 2);
            p = partition(elements, p, start, end);
            stack.push(p + 1);
            stack.push(end);
            stack.push(start);
            stack.push(p);

        }
    }

	public  void swap(String[][] arr, int i, int j) {
	    String temp1 = arr[0][i];
	    arr[0][i] = arr[0][j];
	    arr[0][j] = temp1;
	    String temp2 = arr[1][i];
	    arr[1][i] = arr[1][j];
	    arr[1][j] = temp2;
	}
	
	
    public  int partition(String[][] input, int p, int start, int end) {
        int low = start;
        int high = end - 2;
        String piv = input[0][p];
        swap(input,p,end-1);
        String ll=input[0][low];
    	int lenghL=ll.length();
    	String hh=input[0][high];
    	int lenghH=hh.length();
    	String pp=piv;
    	int lenghP=pp.length();
    	int lengh =lenghP;
    	if(lenghL<lengh) {
    		lengh=lenghL;
    	}
    	if(lenghH<lengh) {
    		lengh=lenghH;
    	}
        while (low < high) {
        	 ll=input[0][low];
        	 lenghL=ll.length();
        	 hh=input[0][high];
        	 lenghH=hh.length();
        	 pp=piv;
        	 lenghP=pp.length();
        	 lengh =lenghP;
        	if(lenghL<lengh) {
        		lengh=lenghL;
        	}
        	if(lenghH<lengh) {
        		lengh=lenghH;
        	}
            if (sumAscii(ll.substring(0, lengh))< sumAscii(pp.substring(0, lengh))) {
                low++;
            }  else if(sumAscii(hh.substring(0, lengh))> sumAscii(pp.substring(0, lengh))) {
                high--;
            }else if(sumAscii(hh.substring(0, lengh))== sumAscii(pp.substring(0, lengh))) {
                int full=hh.length();   if(pp.length()<full) {full=pp.length();}
                if(sumAscii(hh.substring(0, full))>= sumAscii(pp.substring(0, full))) {
                	high--;
                }else {swap(input,low,high);}
                
            }else{
                swap(input,low,high);
            }
        }
        int idx = high;
        if (sumAscii(hh.substring(0, lengh-1))< sumAscii(pp.substring(0, lengh-1))) {
            idx++;
        }
        swap(input, end - 1, idx);
        return idx;
    }
    
    
    
    public  int sumAscii(String str) {
    	int sum=0;
        for(int i=0; i<str.length(); i++)
        {
          int asciiValue = str.charAt(i);
          sum = sum+ asciiValue;}
        return sum;
    } 
    
    

  
    public  void swap(int[][] arr, int i, int j) {
        int temp1 = arr[0][i];
        arr[0][i] = arr[0][j];
        arr[0][j] = temp1;
        int temp2 = arr[1][i];
        arr[1][i] = arr[1][j];
        arr[1][j] = temp2;
   }
    
    
    public  int partition(int[][] input, int p, int start, int end) {
        int low = start;
        int high = end - 2;
        int piv = input[0][p];
        swap(input,p,end-1);
        while (low < high) {
              if (input[0][low] < piv) {
                 low++;
              } else if(input[0][high] >= piv) {
                 high--;
              }else{
                 swap(input,low,high);
        }
    }
        int idx = high;
        if (input[0][high] < piv) {
           idx++;
       }
       swap(input, end - 1, idx);
       return idx;
   }
    
    
}
