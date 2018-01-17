/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.JPanel;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MyPanel
/*    */   extends JPanel
/*    */ {
/* 32 */   public int base_size = 64;
/* 33 */   private Box b = new Box(3);
/*    */   
/*    */   public MyPanel() {
/* 36 */     setBorder(BorderFactory.createLineBorder(Color.black));
/*    */   }
/*    */   
/*    */   public Dimension getPreferredSize() {
/* 40 */     int size = (int)Math.pow(2.0D, this.b.getSize() + 6);
/* 41 */     return new Dimension(size, size);
/*    */   }
/*    */   
/*    */   public void paintComponent(Graphics g) {
/* 45 */     super.paintComponent(g);
/* 46 */     int[][][] c2 = { { { 127, 0, 35 }, { 255, 33, 35 }, { 255, 0, 70 }, { 127, 11, 43 }, { 204, 0, 56 } }, 
/* 47 */       { { 127, 103 }, { 255, 212, 33 }, { 255, 205 }, { 127, 105, 11 }, { 204, 164 } }, 
/* 48 */       { { 24, 127, 17 }, { 120, 255, 111 }, { 48, 255, 35 }, { 84, 127, 81 }, { 38, 204, 28 } }, 
/* 49 */       { { 12, 50, 127 }, { 100, 151, 255 }, { 23, 100, 235 }, { 19, 80, 204 }, { 19, 173, 255 } }, 
/* 50 */       { { 77, 17, 127 }, { 189, 111, 255 }, { 153, 35, 255 }, { 89, 43, 127 }, { 123, 28, 204 } } };
/* 51 */     System.out.println(c2.length);
/* 52 */     int color_index = 0;
/*    */     
/* 54 */     List<Tromino> tromino_list = copyList(this.b.getTrominoList());
/* 55 */     g.setColor(Color.BLACK);
/* 56 */     g.fillRect(this.b.start[1] * this.base_size, this.b.start[0] * this.base_size, this.base_size, 
/* 57 */       this.base_size);
/* 58 */     Random rand = new Random();
/* 59 */     int[] rgbColor = new int[3];
/* 60 */     while (!tromino_list.isEmpty()) {
/* 61 */       if (color_index == c2.length - 1) {
/* 62 */         color_index = 0;
/*    */       } else
/* 64 */         color_index++;
/* 65 */       rgbColor = c2[color_index][rand.nextInt(c2[0].length - 1 + 1)];
/* 66 */       g.setColor(new Color(rgbColor[0], rgbColor[1], rgbColor[2]));
/* 67 */       paintBox(g, (Tromino)tromino_list.get(0));
/* 68 */       tromino_list.remove(0);
/*    */     }
/* 70 */     System.out.println(this.b.getTrominoList().isEmpty());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void paintBox(Graphics g, Tromino t)
/*    */   {
/* 77 */     int[] pointA = t.getA();
/* 78 */     int[] pointB = t.getB();
/* 79 */     int[] pointC = t.getC();
/* 80 */     g.fillRect(pointA[1] * this.base_size, pointA[0] * this.base_size, this.base_size, 
/* 81 */       this.base_size);
/* 82 */     g.fillRect(pointB[1] * this.base_size, pointB[0] * this.base_size, this.base_size, 
/* 83 */       this.base_size);
/* 84 */     g.fillRect(pointC[1] * this.base_size, pointC[0] * this.base_size, this.base_size, 
/* 85 */       this.base_size);
/*    */   }
/*    */   
/*    */   public List<Tromino> copyList(List<Tromino> old_list) {
/* 89 */     List<Tromino> new_list = new ArrayList();
/* 90 */     for (int x = 0; x < old_list.size(); x++) {
/* 91 */       new_list.add((Tromino)old_list.get(x));
/*    */     }
/* 93 */     return new_list;
/*    */   }
/*    */ }


/* Location:              /home/mainuser/Git/Tromino/tromino.jar!/MyPanel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */