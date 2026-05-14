javac src/*.java
if ($?) {
    Write-Host "Compilation successful"
} else {
    Write-Host "Compilation failed"
}
