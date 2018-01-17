/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Tromino
/*    */ {
/* 18 */   private int[] pointA = new int[2];
/* 19 */   private int[] pointB = new int[2];
/* 20 */   private int[] pointC = new int[2];
/*    */   private int type;
/*    */   
/*    */   public Tromino(int[] A, int[] B, int[] C)
/*    */   {
/* 25 */     this.pointA = A;
/* 26 */     this.pointB = B;
/* 27 */     this.pointC = C;
/*    */     
/* 29 */     if ((this.pointA[1] < this.pointC[1]) && (this.pointB[0] < this.pointC[0])) {
/* 30 */       this.type = 1;
/*    */     }
/* 32 */     else if ((this.pointA[0] < this.pointC[0]) && (this.pointC[1] < this.pointB[1])) {
/* 33 */       this.type = 2;
/*    */     }
/* 35 */     else if ((this.pointA[1] < this.pointC[1]) && (this.pointC[0] < this.pointB[0])) {
/* 36 */       this.type = 3;
/*    */     }
/* 38 */     else if ((this.pointC[0] < this.pointB[0]) && (this.pointC[1] < this.pointB[1])) {
/* 39 */       this.type = 4;
/*    */     }
/*    */   }
/*    */   
/*    */   public int[] getA() {
/* 44 */     return this.pointA;
/*    */   }
/*    */   
/*    */   public int[] getB() {
/* 48 */     return this.pointB;
/*    */   }
/*    */   
/*    */   public int[] getC() {
/* 52 */     return this.pointC;
/*    */   }
/*    */ }


/* Location:              /home/mainuser/Git/Tromino/tromino.jar!/Tromino.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */