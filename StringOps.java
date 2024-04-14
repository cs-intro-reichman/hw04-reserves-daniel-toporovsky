public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println("-----------------------------");

        //capVowelsLowRest Test
        System.out.println("capVowelsLowRest Test:");
        String text = "yellow";
        System.out.println(capVowelsLowRest(text));
        System.out.println("-----------------------------");

        //camelCase Test
        System.out.println("camelCase Test:");
        String camel = "        Intro to  coMPUter      sCIEncE ";
        System.out.println(camelCase(camel));
        System.out.println("-----------------------------");

        //allIndexOf Test
        System.out.println("allIndexOf Test:");
        String input3 = "MMMM";
        char index = 'M';
        int [] in = allIndexOf(input3, index);
        System.out.print("{");
        for (int i = 0; i < in.length; i++) {
            System.out.print(in[i]);
            if (i+1 != in.length) System.out.print(", ");
        }
        System.out.println("}");
        System.out.println("-----------------------------");        
    }

    public static String capVowelsLowRest (String string) {
        String formated = "";

        for (int i = 0; i < string.length(); i++) {

            //If the char is a lowercase letter
            if (lower(string, i)) {
                switch (string.charAt(i)) {
                    case 97: case 101: case 105: case 111: case 117:
                        formated += (char)(string.charAt(i) - 32);
                        break;
                    default:
                        formated += string.charAt(i);
                        break;
                }
            }

            //If the char is a uppercase letter 
            else if (upper(string, i)) {
                switch (string.charAt(i)) {
                    case 97: case 101: case 105: case 111: case 117:
                        formated += string.charAt(i);
                        break;
                    default:
                        formated += (char)(string.charAt(i) + 32);
                        break;
                }
            }

            //The char is not a letter
            else formated += string.charAt(i);

        }
        return formated;
    }

    public static String camelCase (String string) {
        String tmp = "";
        int i = 0;
        //Check if the first character is space and skip
        while (string.charAt(i) == ' ') {
            i++;
            if (i >= string.length()) break;
        }
        
        //Check if the first letter is upcase and add it in lowercase
        if (upper(string, i)) {
            tmp += (char)(string.charAt(i) + 32);                
        }
        else if (lower(string, i)) {
            tmp += string.charAt(i);
        }
        i++;

        while (i < string.length()) {
            //Check if the next char is space and skip 
            while (string.charAt(i) == ' ') {
                i++;
                if (i >= string.length()) break;
            }

            if (i >= string.length()) break;
            
            //Check if the letter is the first letter of the word
            if (string.charAt(i-1) == ' '){
                if (upper(string, i)) {
                    tmp += string.charAt(i);
                    i++;                
                }
                else if (lower(string, i)) {
                    tmp += (char)(string.charAt(i) - 32);
                    i++;
                }
            }
                
            if (i >= string.length()) break;
                        
            //Check if the letter on second+ position is lower and add to tmp
            if (upper(string, i)) {
                tmp += (char)(string.charAt(i) + 32);                
            }
            else if (lower(string, i)) {
                tmp += i;
            }
            i++;
        }
        return tmp;
    }

    public static int[] allIndexOf (String string, char chr) {
        String indexList = "";
        int indexCount = 0;

        //Counting how many indexes we have + adding indexes to string 
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                indexList += i + " ";
                indexCount++;
            }
        }

        //Converting string with indexes to array of strings with one index in each
        String [] indexStrArr = new String[indexCount];
        for (int i = 0; i < indexStrArr.length; i++) {
            indexStrArr[i] = "";
        }

        int j = 0;
        for (int i = 0; i < indexStrArr.length; i++) { 
            while (indexList.charAt(j) != ' ') {
                indexStrArr[i] += + indexList.charAt(j) - 48;
                 j++;
            }
            j++;
            if (j >= indexList.length()) break; 
        }

        //Converting string array to integer array
        int [] indexArr = new int[indexStrArr.length];
        for (int i = 0; i < indexStrArr.length; i++) {
            indexArr[i] = Integer.parseInt(indexStrArr[i]);
        }
        return indexArr;
    }

    public static boolean upper (String string, int index) {
        if (64 < string.charAt(index) && string.charAt(index) < 91) return true;
        else return false;
    }
    public static boolean lower (String string, int index) {
        if (96 < string.charAt(index) && string.charAt(index) < 123) return true;
        else return false;
    }
}
