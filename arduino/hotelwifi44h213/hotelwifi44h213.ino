// D6T-44L test program for Arduino
// D6T_test_Arduino.ino
// 2013/03/27 http://www.switch-science.com
 
#include <Wire.h> // Comunicacion I2C con el sensor
#include <ESP8266WiFi.h>
#include <FirebaseArduino.h> //Comunicacion con firebase

#define D6T_addr 0x0A
#define D6T_cmd 0x4C
// Set these to run example de firebase.
#define FIREBASE_HOST "hotelkensybog-4dcec.firebaseio.com"
#define FIREBASE_AUTH "516zmRDbfpvjTs5wfnS2EwzbG0Mz72UDqWYKx62x"//Aqui va la clave secreta
#define WIFI_SSID "Hotel Kensy" //nombre de la red wifi entre comillas
#define WIFI_PASSWORD "hotel2020" //contrasena de la red wifi
 
int  rbuf[35];
int  TDATA[4][4];
int  PTAT;
 
void setup()
{
  Wire.begin();
  Serial.begin(9600);
  Serial.flush();

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
  
}
 
void loop()
{
  String buf = "";
  int  z = 0 ;
  int  x = 0 ;
  int  y = 0 ;
  int writeStatus;

  Wire.beginTransmission(D6T_addr);
  Wire.write(D6T_cmd);

  writeStatus = Wire.endTransmission();
  if(writeStatus != 0)
  {
    Serial.print(writeStatus);
    Serial.println(" Writing failed");
    return;
    delay(1000);
  }
  
  Serial.println("writing succeeded");
  
  delay(100);
  
  Wire.requestFrom(D6T_addr, 35);
  for  (z  =  0 ;  z  <  35 ;  z++)
  {
    rbuf [z]  =  Wire.read();
  }
  
  PTAT = (rbuf[0]+(rbuf[1] << 8));

  for(x = 3 ;  x  >=  0 ; x--)
  {
    for(y = 3 ;  y >= 0 ; y--)
    {
      TDATA [x][y] = (rbuf [((x + y*4) * 2 + 2)] + ( rbuf [((x + y*4) * 2 + 3)] << 8 ));
      Serial.print(TDATA[x][y], DEC);
      Serial.print(" ");
      Firebase.setInt("ocupacion/213/"+(String)x+(String)y,TDATA[x][y]);
    }
  }
  
  Serial.println(" ");
  Serial.println(PTAT);
  delay(1000);
  
}
 
