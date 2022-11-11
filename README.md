# Assignment Title: File Access CA

## Authors

:man_technologist: - [@Lucas Fortunato](https://github.com/lucasfpac)

:student: - Student Number:  SBA21177

:man_teacher: - Lecturer(s): [@Sam Weiss](https://github.com/sweisscct)

:school: - College: [@CCT College Dublin](https://www.cct.ie/)

## Description

You have been given a file named “student.txt” – this contains the details of a (fictitious) student in the following format:
```
Line 1 – <First Name> <Second Name>
Line 2 – <Number of classes>
Line 3 – <Student number>
```
Tasks:

:heavy_check_mark: 1) Read the data from the file and check that it is valid. The data must obey the following rules:
  -    a) the first name must be text only;
  -    b) The second name can be text and/or numbers and must be separated from the first name by a single space;
  -    c) the max no. of classes must be an integer value between 1 and 8 (inclusive), and
  -    d) the student number must be a minimum of 6 characters with the first 2 characters being numbers, the 3rd and 4th characters (and possibly 5th ) being a letter, and everything after the last letter character being a number.

:heavy_check_mark: 2) If the data is not valid, you should output a useful error message on screen to the user.

:heavy_check_mark: 3) If the data is valid, then you have to output the data to a file named status.txt, in the following format:
```
   <Student number> - <Second Name>
    <Workload>
```
  **DISTINCTION WORK**
  
  To gain a distinction (70% or higher) you must complete tasks 1) – 3) properly AND ALSO:

:heavy_check_mark: 4) Amend the programme to include an appropriate loop that will process ALL the data in the file, even if the file contains the details of multiple students.

:heavy_check_mark: 5) Ensure that the student number year is at least 2020 (i.e. that the number starts with 20 or higher)

:heavy_check_mark: 6) Ensure that the number after the letter(s) is reasonable – i.e. that it is between 1 and 200
   
 
 Where the <Workload> is determined by the number of classes, as follows:
 <table>
  <tr>
    <th>Number of classes</th>
    <th>Workload</th>
  </tr>
  <tr>
    <td>1</td>
    <td>Very Light</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Light</td>
  </tr>
  <tr>
    <td>3, 4 or 5</td>
    <td>Part Time</td>
  </tr>
  <tr>
    <td> 6 or higher </td>
    <td> Full Time </td>
  </tr>


</table>

### Examples:

```

Input:
Sam Weiss
5
22DIP1123

Would output as:

22DIP1123 – Weiss
Part Time

and

Input:
Steve Rodgers
7
20MSC1914
      
Would output as:
20MSC1914 – Rodgers
Full Time
```
      
