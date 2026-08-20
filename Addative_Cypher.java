import java.util.*;
public class Main{
    public static String Encryption(){
        Scanner sc=new Scanner(System.in);
        int key;
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

            if(!valid){
                System.out.println("Please Enter text only and also make sure it is in lower Case:");
                continue;
            }
            else {
                break;
            }

        }
        System.out.print("Enter the Key : ");
        key=sc.nextInt();
        char cypher[]=new char[text.length];
        for(int i=0;i<text.length;i++){
             if (text[i]==' '){
                    cypher[i]=text[i];
                    continue;
                }
            int x=text[i]-97;
            cypher[i]= (char)( ((x+key)%26)+97);
        }
        String cyphertext=new String(cypher);
        cyphertext=cyphertext.toUpperCase();
        
        return cyphertext;
    }
    public static String Decryption(){
        Scanner sc=new Scanner(System.in);
        int key;
        char [] text;
        System.out.print("Enter The Encrypted text In UpperCase: ");
        String str=sc.nextLine();
        str=str.toLowerCase();
        text=str.toCharArray();
       
        System.out.print("Enter The Key: ");
        key=sc.nextInt();
        char cypher[]=new char[text.length];
        for(int i=0;i<text.length;i++){
             if (text[i]==' '){
                 cypher[i]=text[i];
                    continue;
                }
            int m=text[i]-97;
            cypher[i]= (char) ((((m-key)+26)%26)+97);
        }
        String cyphertext=new String(cypher);
        cyphertext=cyphertext.toLowerCase();
        
        return cyphertext;
    }
    public static int Brute_force(char x,char y){
                int i=1;
                x=Character.toLowerCase(x);
                while(true){
                    if ((((x-97)-i)%26)+26==y) {
                        return i;
                    }
                    else {
                        i++;
                    }
                    if(i>26){
                        return 0;
                    }
                }
    }
    public static void main(String s[]){
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.print ("For Encryption : 1 " + "\t For Decryption : 2" + "\nFor Bruteforce : 3" + "\t For Exit : 99" + "\nEnter Your Choice :");
            int a=sc.nextInt();
            if(a==1){
                System.out.println("This is The Encrypted Text : " + Encryption());
            }
            else if(a==2){
                System.out.println("This is Decrypted Text : "+Decryption());
            }
            else if(a==3){
                System.out.print("We Have two Option 1st is Key Finding : 1 " + " \tSecond Is UnAvailable \n");
                System.out.println("So Directly We are using 1st option :");
                System.out.print("So First Give the Encrypted Key: ");
                char x=sc.next().charAt(0);
                System.out.print("Enter The Decrypted Code :");
                char y=sc.next().charAt(0);
                int r=Brute_force(x, y);
                if(r==0){
                    System.out.print("The Key is bigger then 26");

                }
                System.out.println("The key is :" + r);

            }
            else if(a==99){
                break ;
            }

    }
    }
}
