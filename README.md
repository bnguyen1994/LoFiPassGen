# LoFiPassGen
Simple Android app that consistently generates a password using a master password and a name of a service or human memorable name to generate the password. No infomation is stored in the application at all. Created for CS453 Mobile Security and Privacy class at the University of Nevada, Reno.

## Features

* Takes in a master password to generate entropy
* Perhaps a name of a service or whatever human memorable name
* Uses both of these names to generate a unique password
* Generates the password to the longest word
* Case-sensitive
* No storage required! Works on any device!

## How it works
* Uses a master key and a word of a service to generate the cypher ruleset
* For example, say the master key is “StrongPassword” and the service is “Facebook”
  * Add the ASCII characters together to generate a new string
  * If one string is longer than the other, the program will repeat the shorter string.
  * If the new ASCII value exceeds a value on the ASCII table, it will back wrap around +32
  * Generates the same password every time if both strings are the same.

## Security 
* Inspired by other password managers but worried about the issue about intercepted packets containing password hashes if transmitting to an online storage or requiring a logon.
* Since not stored in local either so a stolen phone will not result in lost passwords
* Algorithm inspired by a one-time pad cipher, except taking it one step further by not saving a rule set.

## TO DO
* Strengthen the algorithm
* Make the UI prettier
* Implement the clipboard


![alt text](https://raw.githubusercontent.com/carpathianslaughter/LoFiPassGen/master/Screenshot.png)
