# RSA-algorithm

The objective of the exercise is to emulate the RSA algorithm. Your program must accept two prime numbers, p and q, and determine the public and private keys. Then it must accept a plaintext message, represented by an integer m, and determine the ciphertext c. It should then decrypt the ciphertext c to get back the original integer m. 

Your program should be implemented from first principles without using standard libraries for RSA.

Design the program to accept user input from the console and display the output to the console.

A sample dialog is given below:

``` 
  Enter the prime numbers, p and q: 11 17 
  Calculating RSA values ….
  Public RSA key is (3, 187)
  Private RSA key is (107, 187)
  Enter the plaintext message m (an integer): 5
  Encrypting m…
  The ciphertext c is 125
  Decrypting c ….
  The plaintext m is 5
```
The following RSA steps were used: 

1. Choose two primes p and q (these are the input values).
2. Find their product n = pq
3. Choose an integer e that is < n and relatively prime to (p-1)(q-1), that is, e and (p-1)(q-1) do not have common factors.
4. Find an integer d such that ed mod (p-1)(q-1) = 1

Then the public RSA key is (e,n) and the private RSA key is (d, n).
Encryption formula is c = me mod n
Decryption formula is d = cd mod n

For calculating cd mod n where cd can be a large number, use the modular exponentiation method. 
