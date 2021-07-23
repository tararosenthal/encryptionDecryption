# encryptionDecryption
## Program to encrypt and decrypt data using simple algorithms according to arguments specified by user

### Arguments are supplied in token and value pairs where value follows token as a separate argument. Arguments may include any or all of the following:

- -mode enc or dec            
  - specifies whether to encrypt or decrypt data
- -key any int                
  - specifies number of spaces to shift each character in data while encrypting/decrypting
- -data any string            
  - specifies data to be encrypted/decrypted
- -in .txt or .doc file path  
  - specifies file to read data from for encryption/decryption
- -out .txt or .doc file path 
  - specifies file to write encrypted/decrypted data to
- -alg shift or unicode       
  - specifies algorithm for encrypting/decrypting data

### Encryption and decryption is not true encryption but rather encoding according to key value and algorithm type provided by user.
- Shift algorithm shifts latin characters within lowercase or uppercase ranges and wraps around to min or max value if shift goes outside of this range. Non letter characters are unchanged.
- Unicode algorithm shifts latin characters within full range including non letter characters such as spaces, brackets, etc. It also wraps around if the shift goes outside of this range. Characters outside of the basic latin range are unchanged.
