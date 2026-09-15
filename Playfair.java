import java.util.*;
public class Main{
    public static char[][] MatrixCreation() {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter The Key: ");
    String key=sc.next();
    char matrix[][] = new char[5][5];
    String alphabet = "abcdefghiklmnopqrstuvwxyz";
    String newkey = "";
    for (int i = 0; i < key.length(); i++) {
        char a = key.charAt(i);
        if (a == 'j') {
            a = 'i';
        }
        boolean found = false;
        for (int j = 0; j < newkey.length(); j++) {
            if (newkey.charAt(j) == a) {
                found = true;
                break;
            }
        }
        if (!found) {
            newkey = newkey + a;
        }
    }
    for (int i = 0; i < alphabet.length(); i++) {
        char a = alphabet.charAt(i);
        boolean found = false;
        for (int j = 0; j < newkey.length(); j++) {
            if (newkey.charAt(j) == a) {
                found = true;
                break;
            }
        }
        if (!found) {
            newkey = newkey + a;
        }
    }
    int k = 0;
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            matrix[i][j] = newkey.charAt(k);
            k++;
  }
    }
    System.out.println("The Matrix Is :");
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            System.out.print((matrix[i][j]+ " "));
  }
            System.out.println();
    }
    return matrix;
}
   public static int[] FindPosition(char matrix[][], char x) {
        int position[] = new int[2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == x) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
    return position;
}
public static String Encryption(char matrix[][], String text) {
    char cipher[] = new char[text.length()];
    int k = 0;
    for (int i = 0; i < text.length(); i = i + 2) {
        char a = text.charAt(i);
        char b = text.charAt(i + 1);
        int position1[] = FindPosition(matrix, a);
        int position2[] = FindPosition(matrix, b);
        int row1 = position1[0];
        int col1 = position1[1];
        int row2 = position2[0];
        int col2 = position2[1];
        if (row1 == row2) {
            cipher[k] = matrix[row1][(col1 + 1) % 5];
            cipher[k + 1] = matrix[row2][(col2 + 1) % 5];
        }
        else if (col1 == col2) {
            cipher[k] = matrix[(row1 + 1) % 5][col1];
            cipher[k + 1] = matrix[(row2 + 1) % 5][col2];
        }
        else {
            cipher[k] = matrix[row1][col2];
            cipher[k + 1] = matrix[row2][col1];
        }
        k = k + 2;
    }
        String ciphertext = new String(cipher);
        return ciphertext.toUpperCase();
}
public static String PrepareText(String text) {
    String newtext = "";
    for (int i = 0; i < text.length(); i++) {
        char a = text.charAt(i);
        if (a == 'j') {
            a = 'i';
        }
        newtext = newtext + a;
    }
    String result = "";
    for (int i = 0; i < newtext.length(); i++) {
        char a = newtext.charAt(i);
        if (i + 1 < newtext.length()) {
            char b = newtext.charAt(i + 1);
            if (a == b) {
              result = result + a;
                result = result + 'x';
            }
            else {
                result = result + a;
                result = result + b;
                i++;
            }
        }
        else {
            result = result + a;
            result = result + 'x';
        }
    }
    return result;
}

   public static String Decryption(char matrix[][], String text) {
    text = text.toLowerCase();
    char plain[] = new char[text.length()];
    int k = 0;
    for (int i = 0; i < text.length(); i = i + 2) {
        char a = text.charAt(i);
        char b = text.charAt(i + 1);
        int position1[] = FindPosition(matrix, a);
        int position2[] = FindPosition(matrix, b);
        int row1 = position1[0];
        int col1 = position1[1];
        int row2 = position2[0];
        int col2 = position2[1];
        if (row1 == row2) {
            plain[k] = matrix[row1][(col1 - 1 + 5) % 5];
            plain[k + 1] = matrix[row2][(col2 - 1 + 5) % 5];
        }
        else if (col1 == col2) {
            plain[k] = matrix[(row1 - 1 + 5) % 5][col1];
            plain[k + 1] = matrix[(row2 - 1 + 5) % 5][col2];
        }
        else {
            plain[k] = matrix[row1][col2];
            plain[k + 1] = matrix[row2][col1];
        }
        k = k + 2;
    }
    String plaintext = new String(plain);
    return plaintext.toLowerCase();
}
    public static void main(String s[]){
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.print ("For Encryption : 1 " + "\t For Decryption : 2" + "\t For Exit : 99" + "\nEnter Your Choice :");
            int a=sc.nextInt();
            sc.nextLine();
            if(a==1){
                char [] text;
                while(true){
                    System.out.print("Enter the Text in LowerCase : ");
                    String str=sc.nextLine();
                    text=str.toCharArray();
                    boolean valid=true;
                    for(int i=0;i<text.length;i++){
                        if (text[i]==' '){
                            continue;
                        }
                        else if(text[i]<'a' || text[i]>'z'){
                              valid = false;
                              break;
                        }
                    }
                    if(!valid || text[0]==' '){
                        System.out.println("Please Enter text only and also make sure it is in lower Case:");
                        continue;
                    }
                    else {
                        break;
                    }
                }
                String t = PrepareText(String.valueOf(text));
                char mat[][]=MatrixCreation();
                System.out.println("This is The Encrypted Text : " +  Encryption(mat,t));
            }
           else if(a==2){
                System.out.print("Enter The Encrypted Text: ");
                String encryptedText = sc.nextLine().toLowerCase();
                char mat[][] = MatrixCreation();
                   System.out.println("This is Decrypted Text : " +Decryption(mat, encryptedText));
}
            else if(a==99){
                break ;
            }
    }
    }
}
