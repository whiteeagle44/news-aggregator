# Read the .env file and set environment variables
get-content .env | foreach {
    $name, $value = $_.split('=')
    set-content env:\$name $value
}

$currentDir = Get-Location
Set-Location -Path ".\newsproducer"
./gradlew build
docker build --tag=newsproducer:latest .
Set-Location -Path $currentDir
docker-compose up -d