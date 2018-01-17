/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Box
/*     */ {
/*     */   private int[][] box;
/*  44 */   private List<Tromino> tromino_list = new ArrayList();
/*     */   
/*     */ 
/*  47 */   public int[] start = new int[2];
/*     */   private int size;
/*     */   
/*     */   public Box(int size)
/*     */   {
/*  52 */     this.size = size;
/*  53 */     if (size > 0) {
/*  54 */       size = (int)Math.pow(2.0D, size);
/*     */       
/*     */ 
/*  57 */       this.box = new int[size][size];
/*     */       
/*     */ 
/*  60 */       this.start[0] = ((int)(Math.random() * size));
/*  61 */       this.start[1] = ((int)(Math.random() * size));
/*  62 */       this.box[this.start[0]][this.start[1]] = 1;
/*     */       
/*     */ 
/*     */ 
/*  66 */       int filled = 1;
/*     */       
/*  68 */       int[] origin = new int[2];
/*     */       
/*     */ 
/*  71 */       while (filled < Math.pow(size, 2.0D))
/*     */       {
/*  73 */         this.box = Solve(this.box, origin);
/*  74 */         filled = Filled(this.box);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[][] Solve(int[][] box, int[] start)
/*     */   {
/*  94 */     int size = box.length;
/*  95 */     int filled = Filled(box);
/*     */     
/*     */ 
/*  98 */     if ((filled == Math.pow(2.0D, size)) || (filled == 0)) {
/*  99 */       return box;
/*     */     }
/*     */     
/*     */ 
/* 103 */     if ((filled == 1) && (size == 2)) {
/* 104 */       int[] point = FindPoint(box);
/* 105 */       int[] A = { -1, -1 };
/* 106 */       int[] B = { -1, -1 };
/* 107 */       if (point[0] % 2 == 0) {
/* 108 */         point[0] += 1;
/* 109 */         A[1] = point[1];
/*     */       } else {
/* 111 */         point[0] -= 1;
/* 112 */         A[1] = point[1];
/*     */       }
/*     */       
/* 115 */       if (point[1] % 2 == 0) {
/* 116 */         B[0] = point[0];
/* 117 */         point[1] += 1;
/*     */       } else {
/* 119 */         B[0] = point[0];
/* 120 */         point[1] -= 1;
/*     */       }
/* 122 */       int[] C = { A[0], B[1] };
/*     */       
/* 124 */       box[A[0]][A[1]] = (box[B[0]][B[1]] = box[C[0]][C[1]] = 1);
/*     */       
/* 126 */       A = AddStart(A, start);
/* 127 */       B = AddStart(B, start);
/* 128 */       C = AddStart(C, start);
/*     */       
/* 130 */       Tromino new_tromino = new Tromino(A, B, C);
/* 131 */       this.tromino_list.add(new_tromino);
/* 132 */       return box;
/*     */     }
/*     */     
/*     */ 
/* 136 */     if (filled == Math.pow(size, 2.0D) / 4.0D) {
/* 137 */       int[] A = { -1, -1 };
/* 138 */       int[] B = { -1, -1 };
/* 139 */       int[] C = { -1, -1 };
/* 140 */       int mid_point = size / 2 - 1;
/* 141 */       if (box[mid_point][mid_point] == 1) {
/* 142 */         A[0] = (mid_point + 1);
/* 143 */         A[1] = mid_point;
/* 144 */         B[0] = mid_point;
/* 145 */         B[1] = (mid_point + 1);
/* 146 */         C[0] = (mid_point + 1);
/* 147 */         C[1] = (mid_point + 1);
/* 148 */         box[A[0]][A[1]] = (box[B[0]][B[1]] = box[C[0]][C[1]] = 1);
/*     */         
/* 150 */         A = AddStart(A, start);
/* 151 */         B = AddStart(B, start);
/* 152 */         C = AddStart(C, start);
/*     */         
/* 154 */         Tromino new_tromino = new Tromino(A, B, C);
/* 155 */         this.tromino_list.add(new_tromino);
/* 156 */       } else if (box[(mid_point + 1)][mid_point] == 1) {
/* 157 */         A[0] = mid_point;
/* 158 */         A[1] = mid_point;
/* 159 */         B[0] = (mid_point + 1);
/* 160 */         B[1] = (mid_point + 1);
/* 161 */         C[0] = mid_point;
/* 162 */         C[1] = (mid_point + 1);
/* 163 */         box[A[0]][A[1]] = (box[B[0]][B[1]] = box[C[0]][C[1]] = 1);
/*     */         
/* 165 */         A = AddStart(A, start);
/* 166 */         B = AddStart(B, start);
/* 167 */         C = AddStart(C, start);
/*     */         
/* 169 */         Tromino new_tromino = new Tromino(A, B, C);
/* 170 */         this.tromino_list.add(new_tromino);
/* 171 */       } else if (box[(mid_point + 1)][(mid_point + 1)] == 1) {
/* 172 */         A[0] = mid_point;
/* 173 */         A[1] = (mid_point + 1);
/* 174 */         B[0] = (mid_point + 1);
/* 175 */         B[1] = mid_point;
/* 176 */         C[0] = mid_point;
/* 177 */         C[1] = mid_point;
/* 178 */         box[A[0]][A[1]] = (box[B[0]][B[1]] = box[C[0]][C[1]] = 1);
/*     */         
/* 180 */         A = AddStart(A, start);
/* 181 */         B = AddStart(B, start);
/* 182 */         C = AddStart(C, start);
/*     */         
/* 184 */         Tromino new_tromino = new Tromino(A, B, C);
/* 185 */         this.tromino_list.add(new_tromino);
/* 186 */       } else if (box[mid_point][(mid_point + 1)] == 1) {
/* 187 */         A[0] = mid_point;
/* 188 */         A[1] = mid_point;
/* 189 */         B[0] = (mid_point + 1);
/* 190 */         B[1] = (mid_point + 1);
/* 191 */         C[0] = (mid_point + 1);
/* 192 */         C[1] = mid_point;
/* 193 */         box[A[0]][A[1]] = (box[B[0]][B[1]] = box[C[0]][C[1]] = 1);
/*     */         
/* 195 */         A = AddStart(A, start);
/* 196 */         B = AddStart(B, start);
/* 197 */         C = AddStart(C, start);
/*     */         
/* 199 */         Tromino new_tromino = new Tromino(A, B, C);
/* 200 */         this.tromino_list.add(new_tromino);
/*     */       }
/* 202 */       return box;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 207 */     int box_length = box.length;
/* 208 */     int[][][] split = Split(box);
/* 209 */     int[][] boxA = split[0];
/* 210 */     int[][] boxB = split[1];
/* 211 */     int[][] boxC = split[2];
/* 212 */     int[][] boxD = split[3];
/* 213 */     int[] boxA_point = { start[0], start[1] };
/* 214 */     int[] boxB_point = { start[0], box_length / 2 + start[1] };
/* 215 */     int[] boxC_point = { box_length / 2 + start[0], start[1] };
/* 216 */     int[] boxD_point = { box_length / 2 + start[0], box_length / 2 + start[1] };
/* 217 */     boxA = Solve(boxA, boxA_point);
/* 218 */     boxB = Solve(boxB, boxB_point);
/* 219 */     boxC = Solve(boxC, boxC_point);
/* 220 */     boxD = Solve(boxD, boxD_point);
/* 221 */     int[][][] box_list = { boxA, boxB, boxC, boxD };
/* 222 */     box = Union(box_list);
/* 223 */     return box;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int Filled(int[][] box)
/*     */   {
/* 231 */     int size = box.length;
/* 232 */     int filled = 0;
/* 233 */     for (int x = 0; x < size; x++) {
/* 234 */       for (int y = 0; y < size; y++) {
/* 235 */         if (box[x][y] == 1) {
/* 236 */           filled++;
/*     */         }
/*     */       }
/*     */     }
/* 240 */     return filled;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[] FindPoint(int[][] box)
/*     */   {
/* 249 */     int size = box.length;
/* 250 */     for (int x = 0; x < size; x++) {
/* 251 */       for (int y = 0; y < size; y++) {
/* 252 */         if (box[x][y] == 1) {
/* 253 */           int[] return_val = { x, y };
/* 254 */           return return_val;
/*     */         }
/*     */       }
/*     */     }
/* 258 */     int[] return_val = { -1, -1 };
/* 259 */     return return_val;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[] AddStart(int[] point, int[] start)
/*     */   {
/* 271 */     int[] new_position = { point[0] + start[0], point[1] + start[1] };
/* 272 */     return new_position;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[][][] Split(int[][] box)
/*     */   {
/* 280 */     int size = box.length;
/* 281 */     int[][] boxA = new int[size / 2][size / 2];
/* 282 */     int[][] boxB = new int[size / 2][size / 2];
/* 283 */     int[][] boxC = new int[size / 2][size / 2];
/* 284 */     int[][] boxD = new int[size / 2][size / 2];
/* 285 */     for (int x = 0; x < size; x++) {
/* 286 */       if (x < size / 2) {
/* 287 */         int[][] split_box = Splice(box[x]);
/* 288 */         boxA[x] = split_box[0];
/* 289 */         boxB[x] = split_box[1];
/*     */       } else {
/* 291 */         int[][] split_box = Splice(box[x]);
/* 292 */         boxC[(x - size / 2)] = split_box[0];
/* 293 */         boxD[(x - size / 2)] = split_box[1];
/*     */       }
/*     */     }
/* 296 */     int[][][] box_list = { boxA, boxB, boxC, boxD };
/* 297 */     return box_list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[][] Splice(int[] box_row)
/*     */   {
/* 305 */     int size = box_row.length;
/* 306 */     int[] part1 = new int[size / 2];
/* 307 */     int[] part2 = new int[size / 2];
/* 308 */     System.arraycopy(box_row, 0, part1, 0, part1.length);
/* 309 */     System.arraycopy(box_row, part1.length, part2, 0, part2.length);
/* 310 */     int[][] row_parts = { part1, part2 };
/* 311 */     return row_parts;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static int[][] Union(int[][][] box_list)
/*     */   {
/* 318 */     int part_size = box_list[0].length;
/* 319 */     int[][] box = new int[part_size * 2][part_size * 2];
/* 320 */     for (int x = 0; x < part_size; x++) {
/* 321 */       int[] temp_list = new int[part_size * 2];
/* 322 */       for (int y = 0; y < part_size; y++) {
/* 323 */         temp_list[y] = box_list[0][x][y];
/* 324 */         temp_list[(y + part_size)] = box_list[1][x][y];
/*     */       }
/* 326 */       box[x] = temp_list;
/*     */     }
/* 328 */     for (int x = 0; x < part_size; x++) {
/* 329 */       int[] temp_list = new int[part_size * 2];
/* 330 */       for (int y = 0; y < part_size; y++) {
/* 331 */         temp_list[y] = box_list[2][x][y];
/* 332 */         temp_list[(y + part_size)] = box_list[3][x][y];
/*     */       }
/* 334 */       box[(x + part_size)] = temp_list;
/*     */     }
/* 336 */     return box;
/*     */   }
/*     */   
/*     */   public int[] getStart() {
/* 340 */     return this.start;
/*     */   }
/*     */   
/* 343 */   public List<Tromino> getTrominoList() { return this.tromino_list; }
/*     */   
/*     */   public int getSize() {
/* 346 */     return this.size;
/*     */   }
/*     */ }


/* Location:              /home/mainuser/Git/Tromino/tromino.jar!/Box.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */