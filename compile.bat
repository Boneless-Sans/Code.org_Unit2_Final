@echo off

:: Set the source and destination paths
set sourcePath=.
set destPath=%USERPROFILE%\desktop\Store_Management_Project

:: Check if /d argument is provided for detailed compilation output
set enableDebugging=false

for %%i in (%*) do (
    if "%%i"=="/d" set enableDebugging=true
)

:: Compile the Java code
if "%enableDebugging%"=="true" (
    javac -d . -Xlint:unchecked src\com\boneless\unit2Final\*.java src\com\boneless\unit2Final\util\*.java
) else (
    javac -d . src\com\boneless\unit2Final\*.java src\com\boneless\unit2Final\util\*.java
)

:: Create a manifest file in the META-INF directory
echo Manifest-Version: 1.0 > META-INF\MANIFEST.MF
echo Main-Class: com.boneless.unit2Final.Main >> META-INF\MANIFEST.MF

:: Create the JAR file
jar cfm Main.jar META-INF\MANIFEST.MF -C . .

:: Move the JAR file to the desktop\Store_Management_Project
move Main.jar "%destPath%"

:: Copy all files from src\resource\ to desktop\Store_Management_Project\src\resource\
xcopy /s /e src\resource\ "%destPath%\src\resource\"

:: Clean up the directory by deleting .class and .jar files
del /s /q *.class
del /s /q *.jar
