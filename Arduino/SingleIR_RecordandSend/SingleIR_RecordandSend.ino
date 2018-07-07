#include <IRremote.h>
#include <EEPROM.h>
#include <EEPROMAnything.h>

#define RECV_PIN 11
#define LED_PIN 4
#define SND_PIN 5
#define PRG_PIN 6

int addr = 0;

IRrecv irrecv(RECV_PIN);
IRsend irsend;

boolean recording = true;
decode_results results;

void setup()
{
  Serial.begin(9600);
  pinMode(PRG_PIN, INPUT_PULLUP);
  pinMode(SND_PIN, INPUT_PULLUP);
  pinMode(LED_PIN, OUTPUT);
  irrecv.enableIRIn(); // Start the receiver
  irrecv.blink13(true);

  if (EEPROM.read(0) != 0xFF) {
    EEPROM_readAnything(0, results);
  }

}

void loop() {
  if (digitalRead(PRG_PIN) == LOW) {
    recording = true;
    digitalWrite(LED_PIN, HIGH);
  }
  else {
    recording = false;

    digitalWrite(LED_PIN, LOW);
  }

  if (recording) {
    if (irrecv.decode(&results)) {
      Serial.println("IR code recorded!");
      Serial.print("Value: ");
      Serial.println(results.value);
      Serial.print("Format: ");
      Serial.println(results.decode_type);
      delay(1000);
      EEPROM_writeAnything(0, results);
      irrecv.resume(); // Receive the next value
    }
  } else {
    // replay mode
    if (digitalRead(SND_PIN) == LOW) {
      Serial.println("Sending recorded IR signal!");

      for (int i = 0; i < 3; i++) {
        switch (results.decode_type) {
          case NEC:
            irsend.sendNEC(results.value, results.bits);
            break;
          case SONY:
            irsend.sendSony(results.value, results.bits);
            break;
          case RC5:
            irsend.sendRC5(results.value, results.bits);
            break;
          case RC6:
            irsend.sendRC6(results.value, results.bits);
            break;
          case SAMSUNG:
            irsend.sendSAMSUNG(results.value, results.bits);
            break;
          case LG:
            irsend.sendLG(results.value, results.bits);
            break;
          case JVC:
            irsend.sendJVC(results.value, results.bits, false);
            break;
          case SHARP:
            irsend.sendSharp(results.value, results.bits);
            break;
          case DENON:
            irsend.sendDenon(results.value, results.bits);
            break;
          case PANASONIC:
            irsend.sendPanasonic(results.value, results.bits);
            break;
          case DISH:
            irsend.sendDISH(results.value, results.bits);
            break;
          default:
            irsend.sendRaw((unsigned int*) results.rawbuf, results.rawlen, 38);
            break;
        }
        delay(40);
      }
      delay(1000);
      irrecv.enableIRIn();
    }
  }
}

