public class ArrayOps {
    public static void main(String[] args) {
        System.out.println("----------------------------");
        
        // findMissingInt Test 
        System.out.println("findMissingInt Test:");
        int [] arr = {0};
        System.out.println("The missing integer is " + findMissingInt(arr));
        System.out.println("----------------------------");
        
        // secondMaxValue Test 
        System.out.println("secondMaxValue Test:");
        int [] arr1 = {-202, 48, 13, 7, 8};
        System.out.println("The second max value is " + secondMaxValue(arr1));
        System.out.println("----------------------------");

        // containsTheSameElements Test
        System.out.println("containsTheSameElements Test:");
        int [] array1 = new int[] {3, -4, 1, 2, 5};
        int [] array2 = new int[] {1, 3, -4, 5};
        if (containsTheSameElements(array1, array2) == true) {
            System.out.println("Both arrays contain the same numbers");
        }
        else {
            System.out.println("Both arrays DON'T contain the same numbers");
        } 
        System.out.println("----------------------------");
        

        // isSorted Test
        System.out.println("isSorted Test:");
        int [] sorted = new int[] {1, 1, 500};
        if (isSorted(sorted) == true) System.out.println("Array is sorted");
        else System.out.println("Array is NOT sorted");
        System.out.println("----------------------------");
        
    }
    
    public static int findMissingInt (int [] array) {
        int [] completeSet = new int [array.length + 1];
        int missing = 0;
        
        for (int i = 0; i < completeSet.length; i++) {
            completeSet[i] = i + 1;
        }

        for (int a = 0; a < completeSet.length; a++) {
            boolean numberExists = false;
            for (int b = 0; b < array.length; b++) {
                if (array[b] == completeSet[a]) numberExists = true;
            }
            if (numberExists == false) {
                missing = completeSet[a];
                break;
            } 
        }
        return missing;
    }

    public static int secondMaxValue(int [] array) {
        int firstMaxValue = 0;
        int secondMaxValue = 0;

        for (int i = 0; i < array.length; i++) {
            if (firstMaxValue < array[i]) firstMaxValue = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            if ((secondMaxValue < array[i]) && (array[i] != firstMaxValue)) secondMaxValue = array[i];
        }
        return secondMaxValue;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        //We will wish to start going through the largest array first if exists
        if (array1.length > array2.length) {
            for (int i = 0; i < array1.length; i++) {
                boolean sameElements1 = false;
                for (int j = 0; j < array2.length; j++) {
                    if (array1[i] == array2[j]) {
                        sameElements1 = true;
                        break;
                    }
                }
                if (sameElements1 == false) {
                    return false;
                }
            }
        }
        else {
            for (int i = 0; i < array2.length; i++) {
                boolean sameElements1 = false;
                for (int j = 0; j < array1.length; j++) {
                    if (array2[i] == array1[j]) {
                        sameElements1 = true;
                        break;
                    }
                }
                if (sameElements1 == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSorted(int [] array) {
        //Increasing check
        boolean increasing = true;
        for (int i = 0; i < (array.length - 1); i++) {
            if (array[i] > array[i+1]) increasing = false;
        }

        //Decreasing check
        boolean decreasing = true;
        for (int i = 0; i < (array.length - 1); i++) {
            if (array[i] < array[i+1]) decreasing = false;
        }
        
        if (increasing == decreasing) return false;
        else return true;
    }

}
