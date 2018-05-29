
// Detect the falling edge

// Include the Bounce2 library found here :
// https://github.com/thomasfredericks/Bounce-Arduino-Wiring
#include <Bounce2.h>

#include <avr/wdt.h>



#define BUTTON_PIN 2
#define LED_PIN 13

int ledState = LOW;
int Count = 0;
int motorPin = 10;
int tonePin = 3;
int targetCount = 0;
int motorSpeed = 0;
int maxMotorSpeed = 255; // set limit to motor speed
const int footSwitch = 4;
unsigned long previousMillis = 0;  // will store last time motorSpeed was updated
unsigned long interval = 100;  // time between steps up or down in motorSpeed
int speedStep = 2; // increment amount for motor acceleration
unsigned long startTime = 0;

// Instantiate a Bounce object :
Bounce debouncer = Bounce(); 

void setup() {
  
  // Setup the foot switch with an internal pull-up :
  pinMode(footSwitch,INPUT_PULLUP);
  pinMode(BUTTON_PIN,INPUT_PULLUP);

  pinMode(motorPin, OUTPUT);
  
  // After setting up the button, setup the Bounce instance :
  debouncer.attach(BUTTON_PIN);
  debouncer.interval(10);
  
  // Setup the LED :
  pinMode(LED_PIN,OUTPUT);
  digitalWrite(LED_PIN,ledState);

  Serial.begin(9600);
  delay(2000);
  Serial.println("Serial Ready");
    
      Serial.println("Enter number of winds.");
      while(Serial.available() == 0){}
      targetCount = Serial.parseInt();
      Serial.print("OK. Number of winds is set to: ");
      Serial.println(targetCount);
      Serial.read();
      Serial.read();
      //Serial.readBytesUntil('\n',char ab,2);  // make sure newline and/or carriage return are read 

      delay (2000);
      Serial.println();

      Serial.println("Enter maximum motor speed (0 - 255 range).");
      while(Serial.available() == 0){}
      maxMotorSpeed = Serial.parseInt();
      Serial.print("OK. maxMotorSpeed is set to: ");
      Serial.println(maxMotorSpeed);

  while(digitalRead(footSwitch) == 1) {}

  startTime = millis();
}

void loop() {
  if(digitalRead(footSwitch) == 0 && Count <= targetCount) {
    count();
  setMotorSpeed();
  runMotor(motorSpeed);
  playTone();
  }
  else  {
    motorSpeed = 0;
    runMotor(0);
  }
}

void setMotorSpeed()  {
  unsigned long currentMillis = millis();

  if (currentMillis - previousMillis > interval)  {
    previousMillis = currentMillis;
    if (motorSpeed < maxMotorSpeed && targetCount - Count > 50) {
      motorSpeed = motorSpeed + speedStep;
    }
    else if (motorSpeed > 50) {
      motorSpeed = motorSpeed - speedStep;
    }
  }
}

void count()  {
  // Update the Bounce instance :
   debouncer.update();
   
   // Call code if Bounce rose (transition from LOW to HIGH) :
   if ( debouncer.rose() )  {
    Count ++;
    if(Count >= targetCount)  {
      motorSpeed = 0;
      runMotor(motorSpeed);
      unsigned long endTime = millis();
      noTone(tonePin);
      Serial.println(Count);
      Serial.println("Done!");
      Serial.print("Winding took approximately ");
      Serial.print(endTime - startTime);
      Serial.println(" milliseconds.");
      delay(2000);
      return;
      
    }
    Serial.println(Count);
    ledState = !ledState;
    digitalWrite(LED_PIN, ledState);
   }
}

void runMotor(int motorSpeed) {
  analogWrite(motorPin, motorSpeed);
}

void playTone() {
  if (Count % 100 == 0) {
    tone(tonePin, 880);
  }
  else if (Count % 10 == 0) {
    tone(tonePin, 1760);
  }
  else noTone(tonePin);
}



