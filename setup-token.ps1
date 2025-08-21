# PowerShell script to set a specific GitHub token for the Problem-Solving repository
# Usage: Run this script and enter your specific GitHub token when prompted

Write-Host "Setting up specific GitHub token for Problem-Solving repository..." -ForegroundColor Cyan
Write-Host ""

$token = Read-Host "Enter your specific GitHub token" -AsSecureString
$plainToken = [Runtime.InteropServices.Marshal]::PtrToStringAuto([Runtime.InteropServices.Marshal]::SecureStringToBSTR($token))

if ([string]::IsNullOrWhiteSpace($plainToken)) {
    Write-Host "Error: No token provided!" -ForegroundColor Red
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host ""
Write-Host "Updating remote URL with the new token..." -ForegroundColor Yellow

try {
    git remote set-url origin "https://$plainToken@github.com/sahilsoni960/Problem-Solving.git"

    Write-Host ""
    Write-Host "✅ Successfully updated remote URL with specific token!" -ForegroundColor Green
    Write-Host "This token will now be used only for this repository." -ForegroundColor Green
    Write-Host ""
    Write-Host "Verifying the change..." -ForegroundColor Yellow
    git remote -v
}
catch {
    Write-Host ""
    Write-Host "❌ Failed to update remote URL!" -ForegroundColor Red
    Write-Host $_.Exception.Message -ForegroundColor Red
}

Write-Host ""
Read-Host "Press Enter to exit"
