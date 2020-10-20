REM LUIS J. BRAVO ZUNIGA
REM WORKING WITH THREADS

REM COMPILING FILES .JAVA
cd model
javac *.java

REM MOVING FILES .CLASS
cd ..
move /Y model\*.class build
cd build

REM INIT PROGRAM
java ModelExtendsThread

pause

exit