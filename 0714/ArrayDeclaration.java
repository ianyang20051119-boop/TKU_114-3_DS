public class ArrayDeclaration {
    public static void main(String[] args) {
        int[] scores= {80, 75, 92, 68, 88};
        String[] products= {"Keyboard", "Mouse", "Monitor"};
   
   System.out.println(scores[0]);
   System.out.println(scores[4]);
    scores[1] = 78;
   System.out.println(scores[1]);
   System.out.println(scores[scores.length - 1]);

   System.out.println("score : " + scores.length);
   System.out.println("Products : " + products.length);


  
   
   
    }

 }


