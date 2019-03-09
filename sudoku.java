import java.util.Scanner;

import java.util.Random;


public class Lab2 {

  private static boolean game = true;
  public static boolean checked = true;
  public static int allChecked =0;
  public static int copies =0;
  private static int [] gameboard = new int[81];
  private static int [] grid1 = new int [9];
  private static int [] grid2 = new int [9];
  private static int [] grid3 = new int [9];
  private static int [] grid4 = new int [9];
  private static int [] grid5 = new int [9];
  private static int [] grid6 = new int [9];
  private static int [] grid7 = new int [9];
  private static int [] grid8 = new int [9];
  private static int [] grid9 = new int [9];
  private static int [] row1 = new int [9];
  private static int [] row2 = new int [9];
  private static int [] row3 = new int [9];
  private static int [] row4 = new int [9];
  private static int [] row5 = new int [9];
  private static int [] row6 = new int [9];
  private static int [] row7 = new int [9];
  private static int [] row8 = new int [9];
  private static int [] row9 = new int [9];
  private static int [] col1 = new int [9];
  private static int [] col2 = new int [9];
  private static int [] col3 = new int [9];
  private static int [] col4 = new int [9];
  private static int [] col5 = new int [9];
  private static int [] col6 = new int [9];
  private static int [] col7 = new int [9];
  private static int [] col8 = new int [9];
  private static int [] col9 = new int [9];
private static int [] canEdit;

  public static void main(String[] args) {
    // Create a thread 27 threads so each process has its own thread

    populateGame();
    tasks();

    canEdit = new int[allChecked];
    setUpEditable();
    prettyPrint();
    checked = false;

    Scanner sc = new Scanner(System.in);
    while(game) {
    System.out.println("Enter the column and row you want to change then the new number");
    int row = sc.nextInt();
    int col = sc.nextInt();

    int changed = sc.nextInt();
    while(changed > 9  || changed <1) {

      System.out.println("Added number must be a number between 1 and 9. Try again");
   changed = sc.nextInt();

    }
    while(row > 9||row <1) {
      System.out.println("Row number must be a number between 1 and 9. Try again");
   row = sc.nextInt();

    }
    while(col > 9 || col <1) {
      System.out.println("Column number must be a number between 1 and 9. Try again");
     col = sc.nextInt();

    }
    while(!editable(row,col)) {
      System.out.println("That spot already has a value. Select a different spot");
     row = sc.nextInt();
     col = sc.nextInt();
      while(row > 9||row <1) {
        System.out.println("Row number must be a number between 1 and 9. Try again");
        row = sc.nextInt();

      }
      while(col > 9 || col <1) {
        System.out.println("Column number must be a number between 1 and 9. Try again");
        col = sc.nextInt();

      }
    }

    gameboard[((row-1)*9) + (col -1)] = changed;
    System.out.println("Do you want to check your answers? y/n");
    char ans = sc.next().charAt(0);
    if(ans == 'y') {
    tasks();

    if(copies ==0) {
  System.out.println("You win! Congratulations!");
      game =false;
    }
    else {
        System.out.println("There is a wrong answer. Keep going");
      copies =0;

    }
    }
  System.out.println("Do you want to keep playing? y/n");

  if(sc.next().charAt(0) == 'n') {
    game = false;
      System.out.println("Bye bye!");
  }


    prettyPrint();




}







  }

public static void tasks() {

  // Create grid tasks
  Runnable checkGrid1 = new Correct(grid1);
  Runnable checkGrid2 = new Correct(grid2);
  Runnable checkGrid3 = new Correct(grid3);
  Runnable checkGrid4 = new Correct(grid4);
  Runnable checkGrid5 = new Correct(grid5);
  Runnable checkGrid6 = new Correct(grid6);
  Runnable checkGrid7 = new Correct(grid7);
  Runnable checkGrid8 = new Correct(grid8);
  Runnable checkGrid9 = new Correct(grid9);
  //create row tasks
  Runnable checkRow1 = new Correct(row1);
  Runnable checkRow2 = new Correct(row2);
  Runnable checkRow3 = new Correct(row3);
  Runnable checkRow4 = new Correct(row4);
  Runnable checkRow5 = new Correct(row5);
  Runnable checkRow6 = new Correct(row6);
  Runnable checkRow7 = new Correct(row7);
  Runnable checkRow8 = new Correct(row8);
  Runnable checkRow9 = new Correct(row9);
  // Create column tasks
  Runnable checkCol1 = new Correct(col1);
  Runnable checkCol2 = new Correct(col2);
  Runnable checkCol3 = new Correct(col3);
  Runnable checkCol4 = new Correct(col4);
  Runnable checkCol5 = new Correct(col5);
  Runnable checkCol6 = new Correct(col6);
  Runnable checkCol7 = new Correct(col7);
  Runnable checkCol8 = new Correct(col8);
  Runnable checkCol9 = new Correct(col9);
  //Create threads
  Thread thread1 = new Thread(checkGrid1);
  Thread thread2 = new Thread(checkGrid2);
  Thread thread3 = new Thread(checkGrid3);
  Thread thread4 = new Thread(checkGrid4);
  Thread thread5 = new Thread(checkGrid5);
  Thread thread6 = new Thread(checkGrid6);
  Thread thread7 = new Thread(checkGrid7);
  Thread thread8 = new Thread(checkGrid8);
  Thread thread9 = new Thread(checkGrid9);

  Thread thread10 = new Thread(checkRow1);
  Thread thread11 = new Thread(checkRow2);
  Thread thread12 = new Thread(checkRow3);
  Thread thread13 = new Thread(checkRow4);
  Thread thread14 = new Thread(checkRow5);
  Thread thread15 = new Thread(checkRow6);
  Thread thread16 = new Thread(checkRow7);
  Thread thread17 = new Thread(checkRow8);
  Thread thread18 = new Thread(checkRow9);

  Thread thread19 = new Thread(checkCol1);
  Thread thread20 = new Thread(checkCol2);
  Thread thread21 = new Thread(checkCol3);
  Thread thread22 = new Thread(checkCol4);
  Thread thread23 = new Thread(checkCol5);
  Thread thread24 = new Thread(checkCol6);
  Thread thread25 = new Thread(checkCol7);
  Thread thread26 = new Thread(checkCol8);
  Thread thread27 = new Thread(checkCol9);


  //loop until game is over
  //    while(game) {
        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();

        thread10.start();
        thread11.start();
        thread12.start();
        thread13.start();
        thread14.start();
        thread15.start();
        thread16.start();
        thread17.start();
        thread18.start();
        thread19.start();
        thread20.start();
        thread21.start();
        thread22.start();
        thread23.start();
        thread24.start();
        thread25.start();
        thread26.start();
        thread27.start();

}


public static void createGrids() {

//left top
grid1[0] = gameboard[0];
grid1 [1]= gameboard[1];
grid1[2]=gameboard[2];
grid1[3]= gameboard[9];
grid1[4]=gameboard[10];
grid1[5]=gameboard[11];
grid1[6]=gameboard[18];
grid1[7]=gameboard[19];
grid1[8]=gameboard[20];

//center top
grid2[0] = gameboard[3];
grid2 [1]= gameboard[4];
grid2[2]=gameboard[5];
grid2[3]= gameboard[12];
grid2[4]=gameboard[13];
grid2[5]=gameboard[14];
grid2[6]=gameboard[21];
grid2[7]=gameboard[22];
grid2[8]=gameboard[23];

//top right
grid3[0] = gameboard[6];
grid3 [1]= gameboard[7];
grid3[2]=gameboard[8];
grid3[3]= gameboard[15];
grid3[4]=gameboard[16];
grid3[5]=gameboard[17];
grid3[6]=gameboard[24];
grid3[7]=gameboard[25];
grid3[8]=gameboard[26];

//middle left
grid4[0] = gameboard[27];
grid4 [1]= gameboard[28];
grid4[2]=gameboard[29];
grid4[3]= gameboard[36];
grid4[4]=gameboard[37];
grid4[5]=gameboard[38];
grid4[6]=gameboard[45];
grid4[7]=gameboard[46];
grid4[8]=gameboard[47];

//middle center
grid5[0] = gameboard[30];
grid5 [1]= gameboard[31];
grid5[2]=gameboard[32];
grid5[3]= gameboard[39];
grid5[4]=gameboard[40];
grid5[5]=gameboard[41];
grid5[6]=gameboard[48];
grid5[7]=gameboard[49];
grid5[8]=gameboard[50];

//middle right
grid6[0] = gameboard[33];
grid6 [1]= gameboard[34];
grid6[2]=gameboard[35];
grid6[3]= gameboard[42];
grid6[4]=gameboard[43];
grid6[5]=gameboard[44];
grid6[6]=gameboard[51];
grid6[7]=gameboard[52];
grid6[8]=gameboard[53];

//bottom left
grid7[0] = gameboard[54];
grid7[1]= gameboard[55];
grid7[2]=gameboard[56];
grid7[3]= gameboard[63];
grid7[4]=gameboard[64];
grid7[5]=gameboard[65];
grid7[6]=gameboard[72];
grid7[7]=gameboard[73];
grid7[8]=gameboard[74];

//bottom center
grid8[0] = gameboard[57];
grid8 [1]= gameboard[58];
grid8[2]=gameboard[59];
grid8[3]= gameboard[66];
grid8[4]=gameboard[67];
grid8[5]=gameboard[68];
grid8[6]=gameboard[75];
grid8[7]=gameboard[76];
grid8[8]=gameboard[77];

//bottom right
grid9[0] = gameboard[60];
grid9 [1]= gameboard[61];
grid9[2]=gameboard[62];
grid9[3]= gameboard[69];
grid9[4]=gameboard[70];
grid9[5]=gameboard[71];
grid9[6]=gameboard[78];
grid9[7]=gameboard[79];
grid9[8]=gameboard[80];
}
public static void updateGrids() {

//left top
gameboard[0]=grid1[0];
gameboard[1]=grid1[1];
gameboard[2]=grid1[2];
gameboard[9]=grid1[3];
gameboard[10]=grid1[4];
gameboard[11]=grid1[5];
gameboard[18]=grid1[6];
gameboard[19]=grid1[7];
gameboard[20]=grid1[8];

//center top
gameboard[3]=grid2[0];
 gameboard[4]=grid2[1];
gameboard[5]=grid2[2];
gameboard[12]=grid2[3];
gameboard[13]=grid2[4];
gameboard[14]=grid2[5];
gameboard[21]=grid2[6];
gameboard[22]=grid2[7];
gameboard[23]=grid2[8];

//top right
gameboard[6]=grid3[0];
gameboard[7]=grid3[1];
gameboard[8]=grid3[2];
gameboard[15]=grid3[3];
gameboard[16]=grid3[4];
gameboard[17]=grid3[5];
gameboard[24]=grid3[6];
gameboard[25]=grid3[7];
gameboard[26]=grid3[8];

//middle left
gameboard[27]=grid4[0];
 gameboard[28]=grid4[1];
gameboard[29]=grid4[2];
 gameboard[36]=grid4[3];
gameboard[37]=grid4[4];
gameboard[38]=grid4[5];
gameboard[45]=grid4[6];
gameboard[46]=grid4[7];
gameboard[47]=grid4[8];

//middle center
gameboard[30]= grid5[0];
gameboard[31]=grid5[1];
gameboard[32]=grid5[2];
gameboard[39]=grid5[3];
gameboard[40]=grid5[4];
gameboard[41]=grid5[5];
gameboard[48]=grid5[6];
gameboard[49]=grid5[7];
gameboard[50]=grid5[8];

//middle right
gameboard[33]=grid6[0];
 gameboard[34]=grid6[1];
gameboard[35]=grid6[2];
 gameboard[42]=grid6[3];
gameboard[43]=grid6[4];
gameboard[44]=grid6[5];
gameboard[51]=grid6[6];
gameboard[52]=grid6[7];
gameboard[53]=grid6[8];

//bottom left
gameboard[54]=grid7[0];
 gameboard[55]=grid7[1];
gameboard[56]=grid7[2];
 gameboard[63]=grid7[3];
gameboard[64]=grid7[4];
gameboard[65]=grid7[5];
gameboard[72]=grid7[6];
gameboard[73]=grid7[7];
gameboard[74]=grid7[8];

//bottom center
gameboard[57]=grid8[0];
gameboard[58]=grid8[1];
gameboard[59]=grid8[2];
gameboard[66]=grid8[3];
gameboard[67]=grid8[4];
gameboard[68]=grid8[5];
gameboard[75]=grid8[6];
gameboard[76]=grid8[7];
gameboard[77]=grid8[8];

//bottom right
gameboard[60]=grid9[0];
 gameboard[61]=grid9[1];
gameboard[62]=grid9[2];
 gameboard[69]=grid9[3];
gameboard[70]=grid9[4];
gameboard[71]=grid9[5];
gameboard[78]=grid9[6];
gameboard[79]=grid9[7];
gameboard[80]=grid9[8];
}
public static void createRowsAndCols () {

//rows starting from top left to top right
  row1[0] = gameboard[0];
  row1[1]= gameboard[9];
  row1[2]=gameboard[18];
  row1[3]= gameboard[27];
  row1[4]=gameboard[36];
  row1[5]=gameboard[45];
  row1[6]=gameboard[54];
  row1[7]=gameboard[63];
  row1[8]=gameboard[72];

  row2[0] = gameboard[1];
  row2[1]= gameboard[10];
  row2[2]=gameboard[19];
  row2[3]= gameboard[28];
  row2[4]=gameboard[37];
  row2[5]=gameboard[46];
  row2[6]=gameboard[55];
  row2[7]=gameboard[64];
  row2[8]=gameboard[73];

  row3[0] = gameboard[2];
  row3[1]= gameboard[11];
  row3[2]=gameboard[20];
  row3[3]= gameboard[29];
  row3[4]=gameboard[38];
  row3[5]=gameboard[47];
  row3[6]=gameboard[56];
  row3[7]=gameboard[65];
  row3[8]=gameboard[74];

  row4[0] = gameboard[3];
  row4[1]= gameboard[12];
  row4[2]=gameboard[21];
  row4[3]= gameboard[30];
  row4[4]=gameboard[39];
  row4[5]=gameboard[48];
  row4[6]=gameboard[57];
  row4[7]=gameboard[66];
  row4[8]=gameboard[75];

  row5[0] = gameboard[4];
  row5[1]= gameboard[13];
  row5[2]=gameboard[22];
  row5[3]= gameboard[31];
  row5[4]=gameboard[40];
  row5[5]=gameboard[49];
  row5[6]=gameboard[58];
  row5[7]=gameboard[67];
  row5[8]=gameboard[76];

  row6[0] = gameboard[5];
  row6[1]= gameboard[14];
  row6[2]=gameboard[23];
  row6[3]= gameboard[32];
  row6[4]=gameboard[41];
  row6[5]=gameboard[50];
  row6[6]=gameboard[59];
  row6[7]=gameboard[68];
  row6[8]=gameboard[77];

  row7[0] = gameboard[6];
  row7[1]= gameboard[15];
  row7[2]=gameboard[24];
  row7[3]= gameboard[33];
  row7[4]=gameboard[42];
  row7[5]=gameboard[51];
  row7[6]=gameboard[60];
  row7[7]=gameboard[69];
  row7[8]=gameboard[78];

  row8[0] = gameboard[7];
  row8[1]= gameboard[16];
  row8[2]=gameboard[25];
  row8[3]= gameboard[34];
  row8[4]=gameboard[43];
  row8[5]=gameboard[52];
  row8[6]=gameboard[61];
  row8[7]=gameboard[70];
  row8[8]=gameboard[79];

  row9[0] = gameboard[8];
  row9[1]= gameboard[17];
  row9[2]=gameboard[26];
  row9[3]= gameboard[35];
  row9[4]=gameboard[44];
  row9[5]=gameboard[53];
  row9[6]=gameboard[62];
  row9[7]=gameboard[71];
  row9[8]=gameboard[80];

//columns starting from top to bottom
  col1[0] = gameboard[0];
  col1 [1]= gameboard[1];
  col1[2]=gameboard[2];
  col1[3]= gameboard[3];
  col1[4]=gameboard[4];
  col1[5]=gameboard[5];
  col1[6]=gameboard[6];
  col1[7]=gameboard[7];
  col1[8]=gameboard[8];

  col2[0] = gameboard[9];
  col2 [1]= gameboard[10];
  col2[2]=gameboard[11];
  col2[3]= gameboard[12];
  col2[4]=gameboard[13];
  col2[5]=gameboard[14];
  col2[6]=gameboard[15];
  col2[7]=gameboard[16];
  col2[8]=gameboard[17];

  col3[0] = gameboard[18];
  col3 [1]= gameboard[19];
  col3[2]=gameboard[20];
  col3[3]= gameboard[21];
  col3[4]=gameboard[22];
  col3[5]=gameboard[23];
  col3[6]=gameboard[24];
  col3[7]=gameboard[25];
  col3[8]=gameboard[26];

  col4[0] = gameboard[27];
  col4 [1]= gameboard[28];
  col4[2]=gameboard[29];
  col4[3]= gameboard[30];
  col4[4]=gameboard[31];
  col4[5]=gameboard[32];
  col4[6]=gameboard[33];
  col4[7]=gameboard[34];
  col4[8]=gameboard[35];

  col5[0] = gameboard[36];
  col5 [1]= gameboard[37];
  col5[2]=gameboard[38];
  col5[3]= gameboard[39];
  col5[4]=gameboard[40];
  col5[5]=gameboard[41];
  col5[6]=gameboard[42];
  col5[7]=gameboard[43];
  col5[8]=gameboard[44];

  col6[0] = gameboard[45];
  col6 [1]= gameboard[46];
  col6[2]=gameboard[47];
  col6[3]= gameboard[48];
  col6[4]=gameboard[49];
  col6[5]=gameboard[50];
  col6[6]=gameboard[51];
  col6[7]=gameboard[52];
  col6[8]=gameboard[53];

  col7[0] = gameboard[54];
  col7 [1]= gameboard[55];
  col7[2]=gameboard[56];
  col7[3]= gameboard[57];
  col7[4]=gameboard[58];
  col7[5]=gameboard[59];
  col7[6]=gameboard[60];
  col7[7]=gameboard[61];
  col7[8]=gameboard[62];

  col8[0] = gameboard[63];
  col8 [1]= gameboard[64];
  col8[2]=gameboard[65];
  col8[3]= gameboard[66];
  col8[4]=gameboard[67];
  col8[5]=gameboard[68];
  col8[6]=gameboard[69];
  col8[7]=gameboard[70];
  col8[8]=gameboard[71];

  col9[0] = gameboard[72];
  col9 [1]= gameboard[73];
  col9[2]=gameboard[74];
  col9[3]= gameboard[75];
  col9[4]=gameboard[76];
  col9[5]=gameboard[77];
  col9[6]=gameboard[78];
  col9[7]=gameboard[79];
  col9[8]=gameboard[80];
}
public static void updateRowsAndCols () {

//rows starting from top left to top right
  gameboard[0] = row1[0];
  gameboard[9]=row1[1];
  gameboard[18]=row1[2];
  gameboard[27]=row1[3];
  gameboard[36]=row1[4];
  gameboard[45]=row1[5];
  gameboard[54]=row1[6];
  gameboard[63]=row1[7];
  gameboard[72]=row1[8];

  gameboard[1]=row2[0];
  gameboard[10]=row2[1];
  gameboard[19]=row2[2];
  gameboard[28]=row2[3];
  gameboard[37]=row2[4];
  gameboard[46]=row2[5];
  gameboard[55]=row2[6];
  gameboard[64]=row2[7];
  gameboard[73]=row2[8];

  gameboard[2]=row3[0];
  gameboard[11]=row3[1];
  gameboard[20]=row3[2];
  gameboard[29]=row3[3] ;
  gameboard[38]=row3[4];
  gameboard[47]=row3[5];
  gameboard[56]=row3[6];
  gameboard[65]=row3[7];
  gameboard[74]=row3[8];

   gameboard[3]=row4[0];
  gameboard[12]=row4[1];
  gameboard[21]=row4[2];
  gameboard[38]=row4[3];
  gameboard[39]=row4[4];
  gameboard[48]=row4[5];
  gameboard[57]=row4[6];
  gameboard[66]=row4[7];
  gameboard[75]=row4[8];

  gameboard[4]=row5[0];
  gameboard[13]=row5[1];
  gameboard[22]=row5[2];
  gameboard[31]=row5[3];
  gameboard[40]=row5[4];
  gameboard[49]=row5[5];
  gameboard[58]=row5[6];
gameboard[67] = row5[7];
  gameboard[76]=row5[8];

  gameboard[5]=row6[0];
  gameboard[14]=row6[1];
gameboard[23]  =row6[2];
  gameboard[32]=row6[3] ;
  gameboard[41]=row6[4];
  gameboard[50]=row6[5];
  gameboard[59]=row6[6];
gameboard[68]=  row6[7];
  gameboard[77]=row6[8];

   gameboard[6]=row7[0];
  gameboard[15]= row7[1];
  gameboard[24]= row7[2];
   gameboard[33]= row7[3];
  gameboard[42]= row7[4];
  gameboard[51]=row7[5];
  gameboard[60]=row7[6];
  gameboard[69]=row7[7];
  gameboard[78]=row7[8];

  gameboard[7]=row8[0];
   gameboard[16]=row8[1];
  gameboard[25]=row8[2];
   gameboard[34]=row8[3];
gameboard[43]=row8[4];
  gameboard[52]=row8[5];
  gameboard[61]=row8[6];
  gameboard[70]=row8[7];
  gameboard[79]=row8[8];

  gameboard[8]= row9[0];
  gameboard[17]=row9[1];
gameboard[26]=row9[2];
 gameboard[35]=row9[3];
  gameboard[44]=row9[4];
  gameboard[53]=row9[5];
  gameboard[62]=row9[6];
gameboard[71]=row9[7];
gameboard[80]=row9[8];

//columns starting from top to bottom
     gameboard[0]=col1[0];
 gameboard[1]=col1[1];
  gameboard[2]=col1[2];
   gameboard[3]=col1[3];
  gameboard[4]=col1[4];
  gameboard[5]=col1[5];
  gameboard[6]=col1[6];
  gameboard[7]=col1[7];
  gameboard[8]=col1[8];

  gameboard[9]=col2[0];
   gameboard[10]=col2[1];
  gameboard[11]=col2[2];
   gameboard[12]=col2[3];
  gameboard[13]=col2[4];
  gameboard[14]=col2[5];
  gameboard[15]=col2[6];
  gameboard[16]=col2[7];
  gameboard[17]=col2[8];

  gameboard[18]=col3[0];
   gameboard[19]=col3[1];
  gameboard[20]=col3[2];
  gameboard[21]=col3[3];
  gameboard[22]=col3[3];
  gameboard[23]=col3[4];
  gameboard[24]=col3[5];
  gameboard[25]=col3[6];
  gameboard[26]=col3[7];

  gameboard[27]=col4[0];
 gameboard[28]=col4[1];
  gameboard[29]=col4[2];
   gameboard[30]=col4[3];
gameboard[31]=col4[4];
gameboard[32]=col4[5];
gameboard[33]=col4[6];
  gameboard[34]=col4[7];
  gameboard[35]=col4[8];

  gameboard[36]=col5[0];
   gameboard[37]=col5[1];
gameboard[38]=col5[2];
   gameboard[39]=col5[3];
  gameboard[40]=col5[4];
  gameboard[41]=col5[5];
  gameboard[42]=col5[6];
gameboard[43]=col5[7];
  gameboard[44]=col5[8];

  gameboard[45]=col6[0];
  gameboard[46]=col6[1];
gameboard[47]=col6[2];
   gameboard[48]=col6[3];
  gameboard[49]=col6[4];
gameboard[50]=col6[5];
  gameboard[51]=col6[6];
  gameboard[52]=col6[7];
  gameboard[53]=col6[8];

gameboard[54]=col7[0];
 gameboard[55]=col7[1];
gameboard[56]=col7[2];
   gameboard[57]=col7[3];
gameboard[58]=col7[4];
  gameboard[59]=col7[5];
  gameboard[60]=col7[6];
  gameboard[61]=col7[7];
  gameboard[62]=col7[8];

gameboard[63]=col8[0];
   gameboard[64]=col8[1];
gameboard[65]=col8[2];
 gameboard[66]=col8[3];
gameboard[67]=col8[4];
  gameboard[68]=col8[5];
gameboard[69]=col8[6];
  gameboard[70]=col8[7];
  gameboard[71]=col8[8];

   gameboard[72]=col9[0];
gameboard[73]=col9[1];
  gameboard[74]=col9[2];
   gameboard[75]=col9[3];
  gameboard[76]=col9[4];
  gameboard[77]=col9[5];
  gameboard[78]=col9[6];
  gameboard[79]=col9[7];
  gameboard[80]=col9[8];
}
public static void prettyPrint() {


  for(int i=0;i<81;i++) {
    if(i%9 ==0) {
      System.out.println("");
        System.out.println("_______________________________________________________");
      System.out.println("");
      System.out.print("|");
    }
    if(gameboard[i] ==0) {

      System.out.print("    |");

    }
    else {
    System.out.print("  "+ gameboard[i] + "  |");
  }

}
System.out.println("");
System.out.println("________________________________________________________");


}

public  static void populateGame() {


  for(int i=0;i<81;i++){
    Random rand=new Random();

       // nextInt is normally exclusive of the top value,
       // so add 1 to make it inclusive
       int randomNum = rand.nextInt(9+1) ;
    gameboard[i] = randomNum;

  }

  createGrids();
  createRowsAndCols();


}
public static void setUpEditable() {
int k=0;
for(int i=0; i<gameboard.length;i++) {

  if(gameboard[i] ==0){

  canEdit[k]=i;
  k++;
  }

}

}

public static boolean editable(int row, int col) {
  int count=0;
  for(int i=0;i<canEdit.length;i++) {
  if(((row-1)*9) + (col -1) == canEdit[i]) {
    count+=1;

  }
}
    return count >0;
}
}

 class Correct implements Runnable {
private int [] array;
  public Correct(int [] arr) {
    array = arr;
  }
  @Override
  public void run() {
    int [] copies = new int [9];
    boolean reset = false;
    copies = array;

for(int i=0;i<array.length;i++){
  for(int j=i+1;j<array.length;j++) {
    if(Lab2.checked) {
      if(copies[j]== array[i]) {

        array[i] = 0;
        j=array.length;
        Lab2.allChecked+=1;


      }
      Lab2.updateRowsAndCols();
      Lab2.updateGrids();
    }

  else {

    if(copies[j]== array[i]) {

      array[i] = 0;
      j=array.length;
      Lab2.copies+=1;


    }

  }

  }

}


    }



}
