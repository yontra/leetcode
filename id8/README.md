Link: https://leetcode.com/problems/string-to-integer-atoi/description/
Name: String to Integer (atoi)
Difficulty: Medium
Description:
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the 
string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then round the integer to remain 
in the range. Specifically, integers less than -2^31 should be rounded to -2^31, and integers greater than 2^31 - 1 
should be rounded to 2^31 - 1.

Return the integer as the final result.


Submission: Accepted
Runtime: 2 ms, beats 30.43 %
Memory: 43.92 MB, beats 5.47 %
Attempts: 3