# 3740 Programming Languages
## Spring 2017, University of Lethbridge
### Tyler Churchill

## About

This program emulates a register machine which enables you to write programs inside the emulated computer environment.

## How to Install/Run

(compiled jar will be available once project is feature complete)

1. Install JDK/JRE
2. Open project files in your favourite java IDE/dev environment
3. Build and run the project to begin programming inside the emulator

## Currently Supported Commands

###**Halt**: Stops the program
```
HALT  
```

###**INC**: increments the contents of register r, and moves to instruction number n
```
INC r n
```

###**DEB**: If value r is > 0, decrement register r and move to instruction number n, else move to 
instruction number x

```
DEB r n x
```
## Example Code and Console View

You are presented a console to the emulator which can execute and run programs you write

###Basic ADD program:

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
|   Reg1    |    Reg2   |
|-----------------------|
|     4     |     1     |
|     3     |     1     |
|     3     |     2     |
|     2     |     2     |
|     2     |     3     |
|     1     |     3     |
|     1     |     4     |
|     0     |     4     |
|     0     |     5     |
```
