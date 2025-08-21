@echo off
REM Script to set a specific GitHub token for the Problem-Solving repository
REM Usage: Run this script and enter your specific GitHub token when prompted

echo Setting up specific GitHub token for Problem-Solving repository...
echo.

set /p TOKEN="Enter your specific GitHub token: "

if "%TOKEN%"=="" (
    echo Error: No token provided!
    pause
    exit /b 1
)

echo.
echo Updating remote URL with the new token...
git remote set-url origin https://%TOKEN%@github.com/sahilsoni960/Problem-Solving.git

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ✅ Successfully updated remote URL with specific token!
    echo This token will now be used only for this repository.
    echo.
    echo Verifying the change...
    git remote -v
) else (
    echo.
    echo ❌ Failed to update remote URL!
)

echo.
pause
