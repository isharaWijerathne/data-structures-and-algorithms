// public class QUS01 {
//     public static void main(String[] args) {
//         int arr[] = {12,15,13,9,3,28,7};
//         //int arr[] = {5,9,3,2,9,41,3};

//         // int newArr[] = new int[arr.length];
//         // for (int i = 0; i < arr.length; i++) {
            
//         //     for (int j = i; j < arr.length; j++) {
                
//         //         if(arr[i] < arr[j]){
//         //             newArr[i] = arr[j];
//         //             break;
//         //         }else{
//         //             newArr[i] = -1;
//         //         }
//         //     }
//         // }

//         // for (int x = 0; x < newArr.length; x++) {
//         //     System.out.print(newArr[x] + " ");
//         // }

//         int x [] = QUS01.GetNextGreaterElement(arr);

//         for (int i : x) {
//             System.out.print( i + " " );
//         }
//     }



//     public static int[] GetNextGreaterElement(int arr[])
//     {
//         int[] newArr = new int[arr.length];

//         Stack stack = new Stack(newArr.length);

//         for (int i = arr.length -1; i >= 0; i--) {
//             if(stack.IsEmpty()){
//                 newArr[i] = -1;
//                 stack.push(arr[i]);
//             }else{

//                 while ( !stack.IsEmpty() && stack.Peek() < arr[i] ) {
//                     stack.pop();
//                 }

//                 if(stack.IsEmpty()){
//                     newArr[i] = -1;
//                 }else{
//                     newArr[i] = stack.Peek();
//                 }
//                 stack.push(arr[i]);

                
//             }
//         }

//         return newArr;
        
//     }
// }
