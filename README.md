# News Aggregator

## About

This app consists of two microservices: NewsProducer and NewsConsumer.
* The former fetches data from the external API periodically, validates the data and sends it to NewsConsumer via Kafka.
* The latter listens for incoming news data, and saves it to the PostgreSQL database.

## To run the app

On Windows execute the `build-and-run.ps1` powershell script by running the command:

```powershell
./build-and-run.ps1
```

On Linux/Mac execute the `build-and-run.sh` bash script by running the command:

```powershell
chmod +x build-and-run.sh
./build-and-run.sh
```
