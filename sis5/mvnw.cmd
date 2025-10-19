@ECHO OFF
where mvn >NUL 2>&1
IF %ERRORLEVEL% EQU 0 (
  mvn %*
) ELSE (
  ECHO Apache Maven not found in PATH. Please install Maven.
  EXIT /B 1
)
