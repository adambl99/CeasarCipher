package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int userChoice;
        boolean goOn = true;
        while(goOn==true){
            System.out.println("\nIndtast et tal" +
                    "\n 2 Enkrypter en besked" +
                    "\n 1 Dekrypter en besked" +
                    "\n 0 Afslutter programmet: ");

            userChoice = sc.nextInt();
            if (userChoice == 2){
                encryptCaesarMenu();
                goOn = true;
            }
            else if (userChoice == 1){
                decryptCaesarMenu();
            }
            else if (userChoice == 0){
                goOn = false;
            }
            else {
                System.out.println("Du indtastede: " + userChoice);
            }
        }
        System.out.println("Programmet er afsluttet");
    }

    //NumberCipher
    public static int letterToNumber(char letter) {
        char[] alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ".toCharArray();
        char capLet = Character.toUpperCase(letter);
        int nummer = 0;
        for (int i = 0; i < alfabet.length; i++){
            char bogstavViTjekker = alfabet[i];
            if (capLet == bogstavViTjekker){
                nummer = i;
            }
        }
        return nummer;
    }
    public static String listofNumbersToText(int[] numbers) {
        String text = "";
        for (int i = 0; i < numbers.length; ++i) {
            int number = numbers[i];

            char letter = numberToLetter(number);

            text = text + letter;
        }
        return text;
    }
    public static char numberToLetter(int number) {
        char[] alfabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ".toCharArray();
        char result = alfabet[number];
        return result;
    }
    public static int[] textToListOfNumbers(String text) {
        int[] resultat = new int[text.length()];
        for (int i = 0; i < text.length(); i++){
            char tempLetter = text.charAt(i);
            int tempNumber = letterToNumber(tempLetter);
            resultat[i] = tempNumber;
        }
        return resultat;
    }

    // CaesarCipher
    public static void encryptCaesarMenu() {
        Scanner scEncryptText = new Scanner(System.in);
        Scanner scEncryptShift = new Scanner(System.in);
        System.out.println("Indtast plaintext: ");
        String userPlaintext = scEncryptText.nextLine();
        System.out.println("Indtast shiftværdi: ");
        int userShiftVærdi = scEncryptShift.nextInt();
        String resultat = caesarEncrypt(userPlaintext, userShiftVærdi);
        System.out.println("Den enkrypterede besked er: ");
        System.out.println(resultat);

    }
    public static void decryptCaesarMenu() {
        Scanner scDecryptText = new Scanner(System.in);
        Scanner scDecryptShift = new Scanner(System.in);
        System.out.println("Indtast ciphertext: ");
        String userPlaintext = scDecryptText.nextLine();
        System.out.println("Indtast shiftværdi: ");
        int userShiftVærdi = scDecryptShift.nextInt();
        String result = caesarDecrypt(userPlaintext, (-userShiftVærdi));
        System.out.println("Den krypterede besked er: ");
        System.out.println(result);

    }
    public static String caesarDecrypt ( String ciphertext, int shift){
        int[] numberList = textToListOfNumbers(ciphertext);
        int[] numberListShifted = shiftListOfNumbers(numberList,shift);
        String result = listofNumbersToText(numberListShifted);
        return result;
    }
    public static String caesarEncrypt( String plaintext, int shift){
        int[] numberList = textToListOfNumbers(plaintext);
        int[] numberListShifted = shiftListOfNumbers(numberList,(shift));
        String result = listofNumbersToText(numberListShifted);
        return result;
    }
    public static int[] shiftListOfNumbers( int[] numbers, int shift){
        int listOfNumbers[] = new int[numbers.length];
        int i;
        for (i = 0; i < numbers.length; i++){
            listOfNumbers[i] = shiftNumber(numbers[i], shift);
        }
        return listOfNumbers;
    }
    public static int shiftNumberNegativt( int number, int shift){
        if (number == 0){
            return number;
        }
        int shiftedNumber = number + shift;
        if (shiftedNumber <= 0) {
            shiftedNumber = shiftedNumber + 29;
        }
        return shiftedNumber;
    }
    public static int shiftNumber(int number, int shift) {
        if(number == 0){
            return number;
        }

        int shiftedNumber = number + shift;
        if(shiftedNumber > 29){
            shiftedNumber = shiftedNumber - 29;
        }
        if (shiftedNumber <= 0) {
            shiftedNumber = shiftedNumber + 29;
        }

    return shiftedNumber;

    }


}