/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

/**
 *
 * @author 1234
 */

   import java.io.Serializable;
   import java.util.regex.Matcher;
   import java.util.regex.Pattern;


   public class Validator implements Serializable{ 

   //Credit Card validation
   private String expiryDatePattern="([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))"; //expiry date YYYY-MM-DD
   private String cardNumberPattern="^[0-9]{16}$"; //max of 16 digits
   private String holderNamePattern="^[a-zA-z ]{2,30}$"; //max of 30 letters
   private String cvvPattern="^[0-9]{3}$"; //max of 3 digits
   
   //Payment validation
   private String paymentTypePattern="^[12]{1}$"; //either 1 or 2
   
   //PayPal validation
   private String paypalUsernamePattern="^.{2,50}$"; //max of 50 characters
   private String paypalPasswordPattern="^.{2,50}$"; //max of 50 characters
              
   public Validator(){    }
   
   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       

      return match.matches(); 

   }
   
   //Validate methods for Credit Card

   public boolean validateExpiryDate(String expiryDate) {
       return validate(expiryDatePattern, expiryDate);
   }
   
   public boolean validateCardNumber(String cardNumber) {
       return validate(cardNumberPattern, cardNumber);
   }
   
   public boolean validateHolderName(String holderName) {
       return validate(holderNamePattern, holderName);
   }
   
   public boolean validateCVV(String cvv) {
       return validate(cvvPattern, cvv);
   }
   
   //Validate methods for Payment
   
   public boolean validatePaymentType(String paymentType) {
       return validate(paymentTypePattern, paymentType);
   }

   //Validate methods for PayPal
   
   public boolean validatePaypalUsername(String paypalUsername) {
       return validate(paypalUsernamePattern, paypalUsername);
   }
   
   public boolean validatePaypalPassword(String paypalPassword) {
       return validate(paypalPasswordPattern, paypalPassword);
   }

}
