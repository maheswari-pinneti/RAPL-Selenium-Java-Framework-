# fix-rapl-tests.ps1
Write-Host "=== Fixing filenames (remove 'J ' prefix) ===" -ForegroundColor Cyan
$testDir = "src\test\java\tests"
if (Test-Path $testDir) {
    Get-ChildItem -Path $testDir -Filter "J *.java" | ForEach-Object {
        $oldName = $_.FullName
        $newName = $_.FullName -replace '\\J ', '\'
        if ($oldName -ne $newName) {
            Rename-Item -Path $oldName -NewName $newName -Force
            Write-Host "Renamed: $($_.Name) -> $($newName -replace '.*\\', '')" -ForegroundColor Green
        }
    }
} else { Write-Host "Directory '$testDir' not found." -ForegroundColor Yellow }

Write-Host "`n=== Fixing package & class declarations ===" -ForegroundColor Cyan
Get-ChildItem -Path $testDir -Filter "*.java" | ForEach-Object {
    $file = $_.FullName
    $content = Get-Content $file -Raw
    if ($content -notmatch '^\s*package\s+tests\s*;') {
        $content = $content -replace '(?m)^\s*package\s+.*;', ''
        $content = "package tests;`r`n`r`n$content"
        Write-Host "Added package in: $($_.Name)" -ForegroundColor Green
    }
    $className = [System.IO.Path]::GetFileNameWithoutExtension($_.Name) -replace '^J\s+', ''
    $pattern = '(?sm)(public\s+class\s+)[A-Za-z0-9_\s]+?(\s*\{)'
    $replacement = "`${1}$className`$2"
    $newContent = $content -replace $pattern, $replacement
    if ($newContent -ne $content) {
        $content = $newContent
        Write-Host "Updated class name to '$className' in: $($_.Name)" -ForegroundColor Green
    }
    Set-Content -Path $file -Value $content -NoNewline
}

Write-Host "`n Filename and package fixes completed." -ForegroundColor Green
Write-Host "`n  MANUAL STEPS STILL REQUIRED (test logic, waits, missing methods)" -ForegroundColor Magenta
