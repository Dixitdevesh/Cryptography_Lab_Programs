import java.util.*;
public class Multiplicative_Cypher {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
      }
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
        while(true){
            System.out.print("Enter the Key : ");
            key=sc.nextInt();
            if(gcd(key,26)==1){
                break;
            }
            System.out.println("Invalid Key");
        }
        char cypher[]=new char[text.length];
        for(int i=0;i<text.length;i++){
                if(text[i]==' '){
                    cypher[i]=text[i];
                    continue;
                }

            	char a=text[i];
                
		        int n=(int )a -97;
		        int t=((n*key)%26) ;
		        cypher[i]=(char) (t +97);
		
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
        while(true){
        System.out.print("Enter The Key Used In Encryption: ");
        key=sc.nextInt();
        if(gcd(key,26)==1){
            break;
        }
    }
        char cypher[]=new char[text.length];
        for(int i=0;i<text.length;i++){
                if(text[i]==' '){
                    cypher[i]=' ';
                    continue;
                }
                char a=text[i];
		        int n=(int )a-97;
                int na=0;
               
                for(int j=1;j<=26;j=j+2){
                     if(j==13){
                        continue;
                    }
                    if((key*j)%26==1){
                        na=j;
                        break;
                    }
                }
                
		        int t=((n*na)%26) ;
                
		        cypher[i]=(char) (t +97);
        }
        String cyphertext=new String(cypher);
        cyphertext=cyphertext.toLowerCase();
        
        return cyphertext;
    }
    public static int Brute_force(String x,String  y){
              
                char e[]=x.toCharArray();
                char c[]=new char [e.length]; 
                int key=-1;
                for(int k=1;k<26;k=k+2){
                    if(k==13){
                        continue;
                    }
                     for(int i=0;i<e.length;i++){
                        
                        if(e[i]==' '){
                            c[i]=' ';
                            continue;
                        }
                        char a=e[i];
                        int n=(int )a-97;
                        int na=0;
                        for(int j=1;j<=26;j=j+2){
                            if(j==13){
                               continue;
                            }
                            if((k*j)%26==1){
                                na=j;
                                break;
                            }
                        }
                        int t=((n*na)%26) ;
                        c[i]=(char) (t +97);
                        
                        
                }
                String s=new String(c);
                if(y.equals(s)){
                    key=k;
                    return key;
                }
              }
            
            System.out.print(key);
           
            return -1;
     
    
                
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
                System.out.print("So First Give the Encrypted Key: ");
                sc.nextLine();
                String x=sc.nextLine();
                System.out.print("Enter The Decrypted Code :");
                String  y=sc.nextLine();
                x=x.toLowerCase();
                int r=Brute_force(x, y);
                System.out.println("Key is: " + r);

            }
            else if(a==99){
                break ;
            }

    }
    }
}

