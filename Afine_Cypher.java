import java.util.*;
public class Main
{
	
	public static int gcd(int a, int b) {
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
            System.out.print("Enter the First Key  : ");
                try {
               key = sc.nextInt();
               if(gcd(key,26)==1  && key <26 && key >=1){
                break;
            }
            
             System.out.println("Invalid Key");
               
 } 
          catch (InputMismatchException e) {
        System.out.println("Invalid input! Please enter an integer.");
        sc.next(); 
    }
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
        int key2;
        while(true){
            System.out.print("Enter The Second Key: ");
            
            try {
               key2 = sc.nextInt();
               if(key2 <=26 &&  key2 >=1){
                break;
            }
            
             System.out.println("Invalid Key");
               
 } 
          catch (InputMismatchException e) {
        System.out.println("Invalid input! Please enter an integer.");
        sc.next(); 
    }
        }
        char cypher2 []=new char [cypher.length];
        for(int i=0;i<cypher.length;i++){
            if(cypher[i]==' '){
                    cypher[i]=text[i];
                    continue;
                }
            int a=cypher[i]-97;
            int x=(a+key2)%26;
            char y=(char) (x+97) ;
            cypher2[i]=y;
        }
        String cyphertext=new String(cypher2);
        cyphertext=cyphertext.toUpperCase();
        return cyphertext;
    }
    public static String Decryption(){
        Scanner sc=new Scanner(System.in);
         int key2;
        
        char [] text;
        System.out.print("Enter The Encrypted text In UpperCase: ");
        String str=sc.nextLine();
        str=str.toLowerCase();
        
        text=str.toCharArray();
        char text2 []=new char[text.length];
        while(true){
             System.out.print("Enter The Second Key: ");
            try {
               key2 = sc.nextInt();
               if(key2 <=26 &&  key2 >=1){
                break;
            }
            
             System.out.println("Invalid Key");
               
 } 
          catch (InputMismatchException e) {
        System.out.println("Invalid input! Please enter an integer.");
        sc.next(); 
    }
        }
        
        for(int i=0;i<text.length;i++){
            if(text[i]==' '){
                    text2[i]=text[i];
                    continue;
                }
            int a=text[i]-97;
            int x=(a-key2+26)%26;
            char y=(char) (x+97);
            text2[i]=y;
        }
        int key;
        while(true){
        System.out.print("Enter First Key Used In Encryption: ");
             try {
               key = sc.nextInt();
               if(gcd(key,26)==1  && key <26 && key >=1){
                break;
            }
            
             System.out.println("Invalid Key");
               
 } 
          catch (InputMismatchException e){
        System.out.println("Invalid input! Please enter an integer.");
        sc.next(); 
     }
    }
        char cypher[]=new char[text.length];
        for(int i=0;i<text2.length;i++){
                if(text2[i]==' '){
                    cypher[i]=' ';
                    continue;
                }
                char a=text2[i];
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
    public static void Brute_force(String x,String  y){
            
            for(int m=1;m<=26;m++){ 
                char e[]=x.toCharArray();
                
                char c[]=new char [e.length];
                char cy[]=new char [e.length];
                for(int i=0;i<e.length;i++){
                    if(e[i]==' '){
                       c[i]=e[i];
                    continue;
                                 }
                    int a=e[i]-97;
                    int v=(a-m+26)%26;
                    char z=(char) (v+97);
                    c[i]=z;
        }
                 
                int key=-1;
                for(int k=1;k<26;k=k+2){
                    if(k==13){
                        continue;
                    }
                     for(int i=0;i<c.length;i++){
                        
                        if(c[i]==' '){
                            cy[i]=' ';
                            continue;
                        }
                        char a=c[i];
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
                        cy[i]=(char) (t +97);
                        
                        
                }
                String s=new String(cy);
                if(y.equals(s)){
                    System.out.println("Second Key  or Multiplacative is :" + m);
                    System.out.println("First Key  or Addative is :"+ k);
                    return ;
                }
              }
            
            
            }
            
           
            return ;
     
                
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
                Brute_force(x, y);
                

            }
            else if(a==99){
                break ;
            }

    }
    }
	
}
