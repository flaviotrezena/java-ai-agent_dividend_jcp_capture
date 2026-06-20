@echo off

echo ==========================================
echo Starting PostgreSQL Container
echo ==========================================

docker compose up -d

IF %ERRORLEVEL% NEQ 0 (
echo ERROR: Failed to start PostgreSQL
pause
exit /b 1
)

echo.
echo ==========================================
echo Waiting PostgreSQL...
echo ==========================================

:WAIT_DB

docker exec dividend-agent-postgres pg_isready -U postgres >nul 2>&1

IF %ERRORLEVEL% NEQ 0 (
echo PostgreSQL not ready yet...
timeout /t 2 /nobreak > nul
goto WAIT_DB
)

echo PostgreSQL is ready.

echo.
echo ==========================================
echo Starting Java Dividend API
echo ==========================================

call mvn clean spring-boot:run

pause
