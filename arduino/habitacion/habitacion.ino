#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>
#include <SimpleDHT.h>

// Set these to run example.
#define FIREBASE_HOST "monitoreohabitaciones.firebaseio.com"
#define FIREBASE_AUTH "rcfpF1AQ7zXweCcNA8pc47thqGoqazuVOGd4YnZL"
#define WIFI_SSID "924942495175"
#define WIFI_PASSWORD "160269525472"


const int pirPin = D0;
const 
int pirPinE = D1;
const int pinPuerta = D2;
const int pinHumo  = D5;
int timepaso = 4500;

int pinDHT11 = D4;
SimpleDHT11 dht11(pinDHT11);

void setup() {
  
  Serial.begin(115200);
  // connect to wifi.
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("connecting");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }
  Serial.println();
  Serial.print("connected: ");
  Serial.println(WiFi.localIP());
  
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  pinMode(pirPin, INPUT);
  pinMode(pirPinE, INPUT);
  pinMode(pinPuerta, INPUT);
  
}
int countPIR = 0;
int countPerson = 0;
bool tperson = false;
bool auxperson = true;
int sensorHumo;
int humoCont = 0;
bool notHumo = true;
int tempCont = 0;
bool notTemp = true;  
byte temperature = 0;
byte humidity = 0;
int lapso = 0;

void loop() {
  while(!digitalRead(pinPuerta)){
    paso();
  }

  digitalTemp();
  digitalHumo();
  
  
}
void digitalHumo(){
  
     while (!digitalRead(pinHumo)){
        Firebase.setString("humo", "Alerta!!!");
     }

     Firebase.setString("humo", "OK");
  
 
}

void humo(){
  sensorHumo = analogRead(0);
  Serial.print((String)sensorHumo);
  while (sensorHumo > 200){
    sensorHumo = analogRead(0);
    Firebase.setString("humo", "Alerta "+(String)sensorHumo);
  }
  if(humoCont>5){
    Firebase.setString("humo", "Ok");
    humoCont = 0;
  }
  humoCont ++;
}

void digitalTemp(){
  byte temperature = 0;
  byte humidity = 0;
  int err = SimpleDHTErrSuccess;
  if ((err = dht11.read(&temperature, &humidity, NULL)) != SimpleDHTErrSuccess) {
    Serial.print("Read DHT11 failed, err="); Serial.println(err);delay(1000);
    return;
  }
  
  Serial.print("Sample OK: ");
  Serial.print((int)temperature); Serial.print(" *C, "); 
  Serial.print((int)humidity); Serial.println(" H");
  Firebase.setInt("temp" , (int)temperature);
  // DHT11 sampling rate is 1HZ.
  delay(1500);
  
}


void paso(){
   if(!digitalRead(pirPin)){
    while ( countPIR < timepaso && !tperson){
      //Serial.println(countPIR);
      if(!digitalRead(pirPinE)){
        Serial.println("entra");
        countPerson ++;
        tperson = true;
        Firebase.setInt("presencia", countPerson);
        countPIR = timepaso +1;
      }
    countPIR++;
    } 
  }
  countPIR=0;
  delay(100);
  tperson = false;

 if(!digitalRead(pirPinE)){
    while ( countPIR < timepaso && !tperson){
      //Serial.println(countPIR);
      if(!digitalRead(pirPin)){
        Serial.println("sale");
        countPerson --;
        tperson = true;
        Firebase.setInt("presencia", countPerson);
        countPIR =  timepaso +1;
      }
    countPIR++;
    } 
  }
 
  countPIR=0;
  delay(100);
  tperson = false;
}
