package com.clara;

import java.util.Scanner;

public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for credit card number. store number as a String.
        System.out.println("Please enter the credit card number, digits only:");
        String ccNumber = stringScanner.nextLine();
        boolean isValid = isVisaCreditCardNumberValid(ccNumber);

        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        stringScanner.close();
    }

    public static boolean isVisaCreditCardNumberValid(String cc) {

        //TODO Replace with your code to process the credit card number, and determine if it is valid.
        //TODO Make sure all the tests pass!
        boolean bResult = false;
        //loop through entered value and create int array
        int[] iCCNumbers = new int[cc.length()];
        //loop through string, parse characters into the int array
        for(int x=0;x<cc.length();x++){
            iCCNumbers[x] = Integer.parseInt(cc.substring(x,x+1));
        }

        int iTotalValue=0;
        boolean bDoubleValue = false;
        //loop through cc numbers
        for(int x=iCCNumbers.length-1;x>=0;x--){
            // if value should be doubled, do so
            if(bDoubleValue){
                int iCurrentValue = iCCNumbers[x]*2;
                // if double is less than 10 use that, otherwise add digits
                if(iCurrentValue>9){
                    int sum=0;
                    int iCurrentDigit;
                    //use remainder to get singles digits until no more remain
                    while (iCurrentValue!= 0){
                        iCurrentDigit=iCurrentValue%10;
                        sum+=iCurrentDigit;
                        iCurrentValue=iCurrentValue/10;
                    }
                    iTotalValue+=sum;
                }
                else{
                    iTotalValue+=iCurrentValue;
                }
                bDoubleValue=false;
            }
            else{
                iTotalValue+=iCCNumbers[x];
                bDoubleValue=true;
            }
        }

        //if total value divisible by 10, valid number
        if(iTotalValue%10 == 0){
            bResult=true;
        }

        return bResult;

    }




}
