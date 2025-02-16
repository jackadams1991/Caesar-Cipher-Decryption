# Caesar-Cipher-Decryption

The program has 2 solutions implemented. It also has a simple command line interaction so that the user can enter the desired text and the key for the decryption.

## Solution 1:

A simple for loop implementaion to loop through the characters in the supplied string. We get the position of the char in the alphabet and the key value. From here we can get the character that maps to the supplied character from the string entered by the user and appeneded to a string that is returned once we reach the end of the loop.

The solution also incorporates a fast fail check for an empty string or skip key that has a value less than 1. And can handle white space in the middle of the supplied string.

## Solution 2:

This solution is similiar to the first, however we use the Stream API from Java instead of a for loop. It is also broken up into 3 smaller methods for readability and maintainability.

This solution also immplements a fast fail check for empty string or skip key that has a value less than 1. As well as handling white space in the middle of the supplied string.

## Production Proposal:

I would propose that this program has a web application for user interaction, allowing multiple users, potentially from various offices, to enter the desired text and the skip key in a simple form that gives back the result from the back end.

For the back end, I would suggest a simple controller layer serving a REST API. With this we can serve an endpoint for our web application along with pre-authorisation for users to ensure only authorised users can use the endpoint.

The core business logic can be then be handled in a simple service layer that takes and processes the supplied values and then returns the decrypted value.

