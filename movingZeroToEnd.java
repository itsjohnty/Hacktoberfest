public class MoveZeros   
{  
// a method that moves the zeros  
// to the end of the array inputArr  
public int[] solve(int[] inputArr)   
{  
int size = inputArr.length;  
// creating an auxiliary array for   
// storing the result  
int auxiliaryArray[] = new int[size];  
// for counting the total number   
// of elements whose value is   
// zero in the input array  
int zeroCount = 0;  
// the current index of the auxiliary array  
int outputIndex = 0;  
for(int i = 0; i < size; i++)  
{  
if(inputArr[i] != 0)  
{  
// a non-zero element is found  
// hence, we store it in the auxiliary array   
// and increase the outputIndex by 1  
auxiliaryArray[outputIndex] = inputArr[i];  
outputIndex = outputIndex + 1;  
}  
else  
{  
// a zero element is found  
// hence, increase the zeroCount by 1  
zeroCount = zeroCount + 1;  
}  
}  
  
while(zeroCount != 0)  
{  
// adding all of the zeroes at the end  
// of the auxiliary array  
auxiliaryArray[outputIndex] = 0;  
outputIndex = outputIndex + 1;  
zeroCount = zeroCount - 1;  
}  
return auxiliaryArray;  
}  
// main method  
public static void main(String[] argvs)   
{  
// creating an object of the class MoveZeros  
MoveZeros obj = new MoveZeros();  
// input 1  
int arr[] = {6, 7, 0, 2, 1, 78, 0, 56, 0, 4};  
int size = arr.length;  
int ans[] = obj.solve(arr);  
System.out.println("For the following array: ");  
for(int i = 0; i < size; i++)  
{  
System.out.print(arr[i] + " ");  
}  
System.out.println();  
System.out.println("The answer after moving the zero at the end is: ");  
for(int i = 0; i < size; i++)  
{  
System.out.print(ans[i] + " ");  
}  
System.out.println();    
}  
}  
