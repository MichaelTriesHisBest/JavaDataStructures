package edu.belmont.csc.src.stacks;

import java.io.*;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Postfix {

    private static Float evaluatePostfix(String expression) {

        StackClass<Float> stacks_on_Stacks = new StackClass<>();
        try {
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);

                if (Character.isWhitespace(c)) {

                } else if (Character.isDigit(c)) {

                    float o = 0;
                    while (Character.isDigit(c)) {
                        //c-'0' is using the ASCII key to change the char to a digit, and ngl I feel like this should give me extra credit for being a GENIUS
                        o = o * 10 + (float) (c - '0');
                        i++;
                        c = expression.charAt(i);
                    }
                    i--;
                    stacks_on_Stacks.push(o);
//                if(stacks_on_Stacks.size() > 2){
//                    System.out.println("Error: Sorry, this Computer Science student doesn't know what to do for this edge case, so this print out is my 'edge handling'");
//                }
                } else {
                    if (stacks_on_Stacks.size() > 2 || stacks_on_Stacks.size() < 1) {
                      //  System.out.println("========");
                        throw new Exception("==ERR==");                    }

                    float aye = stacks_on_Stacks.pop();
                    if (stacks_on_Stacks.peek() == null) {
                        return null;

                    }
                    float bee = stacks_on_Stacks.pop();
                    if (stacks_on_Stacks.peek() != null) {
                        System.out.println("=====ERROR======ERROR======ERROR======ERROR====");
                        break;
                    }
                    switch (c) {
                        case '+':

                            stacks_on_Stacks.push(bee + aye);

                            break;

                        case '-':
                            stacks_on_Stacks.push(bee - aye);
                            break;

                        case '/':
                            if (aye == 0) {
                                throw new ArithmeticException();
                            }
                            stacks_on_Stacks.push(bee / aye);
                            break;

                        case '*':
                            stacks_on_Stacks.push(bee * aye);
                            break;
                        case '^':
                            stacks_on_Stacks.push((float) Math.pow(bee, aye));
                            break;
                    }
                }
            }
            return stacks_on_Stacks.pop();

        } catch (Exception e) {
            return null;
        }

    }

    public static void main(String[] args) throws NoSuchElementException {
        try {
            URL deWay =
                    //why does Java have 5k ways to read a file xd
                    ClassLoader.getSystemResource("sample.txt");

            File f = new File(deWay.getFile());
            Scanner reader = new Scanner(new FileReader(f));

            if (!reader.hasNextLine()) {
                System.out.println("Your File Has Ended and the Process Will Be Terminated");
                //System.out.println("A final message for those willing to listen");
//                System.out.println("Do not go gentle into that good night,\n" +
//                        "Old age should burn and rave at close of day;\n" +
//                        "Rage, rage against the dying of the light.\n" +
//                        "Though wise men at their end know dark is right,\n" +
//                        "Because their words had forked no lightning they\n" +
//                        "Do not go gentle into that good night.\n" +
//                        "Good men, the last wave by, crying how bright\n" +
//                        "Their frail deeds might have danced in a green bay,\n" +
//                        "Rage, rage against the dying of the light.\n" +
//                        "Wild men who caught and sang the sun in flight,\n" +
//                        "And learn, too late, they grieved it on its way,\n" +
//                        "Do not go gentle into that good night.\n" +
//                        "Grave men, near death, who see with blinding sight\n" +
//                        "Blind eyes could blaze like meteors and be gay,\n" +
//                        "Rage, rage against the dying of the light.\n" +
//                        "And you, my father, there on the sad height,\n" +
//                        "Curse, bless, me now with your fierce tears, I pray.\n" +
//                        "Do not go gentle into that good night.\n" +
//                        "Rage, rage against the dying of the light.");
            }
            while (reader.hasNextLine()) {
                String a = reader.nextLine();
                if (a.isBlank()){
                    continue;
                }
               System.out.println(a + " == " + evaluatePostfix(a));
            }
        } catch (FileNotFoundException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}

