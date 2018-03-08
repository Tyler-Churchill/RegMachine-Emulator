# 3740 Programming Languages
## Spring 2017, University of Lethbridge
### Tyler Churchill

## About

This program emulates a register machine which enables the writing and executing of programs

## How to Install/Run

1. Install JDK/JRE
2. Open project files in your favourite java IDE/dev environment
3. Build and run the project to begin programming inside the emulator

## Currently Supported Commands

###**Halt**: Stops the program
```
HALT  
```

###**INC**: Increments the contents of register r, and moves to instruction number n
```
INC r n
```

###**DEB**: If value r is > 0, decrement contents of register r and move to instruction number n, else move to instruction number x

```
DEB r n x
```
## Example Code and Console View

You are presented a console to the emulator which can execute and run programs you write

###Basic ADD program:

R1 = 4, R2 = 1  // Adds R1 to R2 and stores it in R2
```
Enter your program code
Type RUN on a new line to run the program

1     DEB 1 2 3
2     INC 2 1
3     HALT
4     RUN

```
###The machine will display its states as it runs the given program

```
Reg1    Reg2
4       1
3       1
3       2
2       2
2       3
1       3
1       4
0       4
0       5
```
