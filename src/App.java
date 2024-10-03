import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class App { //Quick warning, code is almost certainly really messy, sorry about that
    public static void main(String[] args) throws Exception {
        int size = 0;
        int [][] matrix1;
        int [][] matrix2;
        int [][] matrix3;
        int rows1 = 0;
        int cols1 = 0;
        int rows2 = 0;
        int cols2 = 0;
        int currentRow = 0;
        String currentLine;
        String mtrx1loc = "";
        String mtrx2loc = "";
        File mtrx1;
        File mtrx2;
        File mtrx3;
        boolean done = false;
        boolean looped = false;
        boolean createFiles = true;
        Scanner scnr = new Scanner(System.in);
        if(args.length > 0){
            try {
               size = Integer.valueOf(args[0]);
                matrix1 = new int[size][size];
                matrix2 = new int[size][size];
                matrix3 = new int[size][size];
                for(int i = 0; i < size; i ++){
                    for(int t = 0; t < size; t ++){
                        matrix1[i][t] = (int)((Math.random()) * 101);
                        matrix2[i][t] = (int)((Math.random()) * 101);
                    }
                }
                createFiles = true;
               done = true;
               
            } catch (Exception e) {
                done = false;
                createFiles = false;
                
            }
            if(done == false){
            try {
                mtrx1 = new File(args[0]);
                mtrx2 = new File(args[1]);
                if(mtrx1.canRead() && mtrx2.canRead()){
                    done = true;
                    BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                    while ((currentLine = reader.readLine()) != null){
                        rows1++;
                        String[] tempElements = currentLine.split(" ");
                        if (cols1 == 0){
                            cols1 = tempElements.length;
                        }
                    }
                    matrix1 = new int[rows1][cols1];
                    BufferedReader reader2 = new BufferedReader(new FileReader(args[0]));
                    while((currentLine = reader2.readLine()) != null){
                        String[] tempElements = currentLine.split(" ");
                        for(int i = 0; i < tempElements.length; i++){
                            matrix1[currentRow][i] = Integer.parseInt(tempElements[i]);
                        }
                    }
                    BufferedReader reader3 = new BufferedReader(new FileReader(args[1]));
                    while ((currentLine = reader.readLine()) != null){
                        rows2++;
                        String[] tempElements = currentLine.split(" ");
                        if (cols2 == 0){
                            cols2 = tempElements.length;
                        }
                    }
                    matrix2 = new int[rows2][cols2];
                    BufferedReader reader4 = new BufferedReader(new FileReader(args[1]));
                    while((currentLine = reader2.readLine()) != null){
                        String[] tempElements = currentLine.split(" ");
                        for(int i = 0; i < tempElements.length; i++){
                            matrix2[currentRow][i] = Integer.parseInt(tempElements[i]);
                        }
                    }
                    matrix3 = new int[rows1][cols2];
                    reader.close();
                    reader2.close();
                    reader3.close();
                    reader4.close();
                }else{
                    System.out.println("Cannot read inputted files in command line arguments");
                    done = false;
                }
            } catch (Exception e) {
                done = false;
            }
        }
        }
        while(done == false){
            if(args.length > 0 && looped == false){
               System.out.println("There was an error in the command line arguments, switching to in-program input");
            }
            System.out.print("Please enter the length/width of the desired random square matrixes. Alternatively, enter the file name of the first matrix: ");
            try {
                size = scnr.nextInt();
                done = true;
                matrix1 = new int[size][size];
                matrix2 = new int[size][size];
                for(int i = 0; i < size; i ++){
                    for(int t = 0; t < size; t ++){
                        matrix1[i][t] = (int)((Math.random()) * 101);
                        matrix2[i][t] = (int)((Math.random()) * 101);
                    }
                }
                createFiles = true;
            } catch (Exception e) {
                done = false;
                createFiles = false;
            }
            if (done == false){
            try {
                mtrx1loc = scnr.nextLine();
                System.out.print("Please enter the file name of the second matrix: ");
                mtrx2loc = scnr.nextLine();
                done = true;
                
            } catch (Exception e){
                done = false;
                scnr.nextLine();
            }
            looped = true;
        }
        
        
    }
    System.out.println(done);
    scnr.close();

    if (createFiles == true){
        matrix1 = new int[size][size];
        matrix2 = new int[size][size];
        matrix3 = new int[size][size];
        for(int i = 0; i < size; i ++){
            for(int t = 0; t < size; t ++){
                matrix1[i][t] = (int)((Math.random()) * 101);
                matrix2[i][t] = (int)((Math.random()) * 101);
            }
        }
        for(int i = 0; i < size; i++){
            for(int t = 0; t < size; t++){
                for(int k = 0; k < size; k++){
                    matrix3[i][t] += matrix1[i][k] * matrix2[k][t];
                }
            }
        }
        try{
            mtrx1 = new File("Matrix1.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(mtrx1));
            for(int[] row : matrix1){
                for(int element : row){
                    writer.write(element + " ");
                }
                writer.newLine();
            }
            writer.close();
        }catch(IOException e){
            System.err.println("An input/output error occured");
        }
        try{
            mtrx2 = new File("Matrix2.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(mtrx2));
            for(int[] row : matrix2){
                for(int element : row){
                    writer.write(element + " ");
                }
                writer.newLine();
            }
            writer.close();
        }catch(IOException e){
            System.err.println("An input/output error occured");
        }
        try{
            mtrx3 = new File("Matrix3.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(mtrx3));
            for(int[] row : matrix3){
                for(int element : row){
                    writer.write(element + " ");
                }
                writer.newLine();
            }
            writer.close();
        }catch(IOException e){
            System.err.println("An input/output error occured");
        }
    }else{
        matrix1 = new int[rows1][cols1];
        matrix2 = new int[rows2][cols2];
        matrix3 = new int[rows1][cols2];
        if (args.length > 0){
            mtrx1loc = args[0];
            mtrx2loc = args[1];
        }
        
        BufferedReader reader = new BufferedReader(new FileReader(mtrx1loc));
        cols1 = 0;
                    while ((currentLine = reader.readLine()) != null){
                        rows1++;
                        String[] tempElements = currentLine.split(" ");
                        if (cols1 == 0){
                            cols1 = tempElements.length;
                        }
                    }
                    matrix1 = new int[rows1][cols1];
                    currentRow = 0;
                    BufferedReader reader2 = new BufferedReader(new FileReader(mtrx1loc));
                    while((currentLine = reader2.readLine()) != null){
                        String[] tempElements = currentLine.split(" ");
                        for(int i = 0; i < tempElements.length; i++){
                            matrix1[currentRow][i] = Integer.parseInt(tempElements[i]);
                        }
                        currentRow++;
                    }
                    BufferedReader reader3 = new BufferedReader(new FileReader(mtrx2loc));
                    cols2 = 0;
                    while ((currentLine = reader3.readLine()) != null){
                        rows2++;
                        String[] tempElements = currentLine.split(" ");
                        if (cols2 == 0){
                            cols2 = tempElements.length;
                        }
                    }
                    matrix2 = new int[rows2][cols2];
                    currentRow = 0;
                    BufferedReader reader4 = new BufferedReader(new FileReader(mtrx2loc));
                    while((currentLine = reader4.readLine()) != null){
                        String[] tempElements = currentLine.split(" ");
                        for(int i = 0; i < tempElements.length; i++){
                            matrix2[currentRow][i] = Integer.parseInt(tempElements[i]);
                            System.out.println(matrix2[currentRow][i] + " " + matrix1[currentRow][i]);
                        }
                        currentRow++;
                    }
                    matrix3 = new int[rows1][cols2];
                    reader.close();
                    reader2.close();
                    reader3.close();
                    reader4.close();
                    for(int i = 0; i < rows1; i++){
                        for(int t = 0; t < cols2; t++){
                            for(int k = 0; k < rows2; k++){
                                matrix3[i][t] += matrix1[i][k] * matrix2[k][t];
                                //System.out.print(matrix2[k][t]);
                            }
                        }
                    }
        try{
            mtrx3 = new File("Matrix3.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(mtrx3));
            for(int[] row : matrix3){
                for(int element : row){
                    writer.write(element + " ");
                }
                writer.newLine();
            }
            writer.close();
        }catch(IOException e){
            System.err.println("An input/output error occured");
        }
    }
    }
}

