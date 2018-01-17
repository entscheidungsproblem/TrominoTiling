/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.SwingUtilities;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GUI
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 15 */     SwingUtilities.invokeLater(new Runnable()
/*    */     {
/*    */       public void run() {}
/*    */     });
/*    */   }
/*    */   
/*    */   private static void createAndShowGUI()
/*    */   {
/* 23 */     JFrame f = new JFrame("Tromino");
/* 24 */     f.setDefaultCloseOperation(3);
/* 25 */     f.add(new MyPanel());
/* 26 */     f.pack();
/* 27 */     f.setVisible(true);
/*    */   }
/*    */ }


/* Location:              /home/mainuser/Git/Tromino/tromino.jar!/GUI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */