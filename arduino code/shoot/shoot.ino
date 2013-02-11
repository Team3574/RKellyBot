#include <Adafruit_NeoPixel.h>

// Parameter 1 = number of pixels in strip
// Parameter 2 = pin number (most are valid)
// Parameter 3 = pixel type flags, add together as needed:
//   NEO_RGB     Pixels are wired for RGB bitstream
//   NEO_GRB     Pixels are wired for GRB bitstream
//   NEO_KHZ400  400 KHz bitstream (e.g. FLORA pixels)
//   NEO_KHZ800  800 KHz bitstream (e.g. High Density LED strip)
Adafruit_NeoPixel strip = Adafruit_NeoPixel(60, 6, NEO_GRB + NEO_KHZ800);
#include <Wire.h>
void setup() {
  strip.begin();
  strip.show(); // Initialize all pixels to 'off'
  Wire.begin(4);                // join i2c bus with address #4
  Wire.onReceive(receiveEvent); // register event  
}

int showPattern = -1;

void loop() {
//  shootColor(strip.Color(155, 0, 255));  shootColor(strip.Color(255, 0, 0));  shootColor(strip.Color(255, 255, 255));  shootColor(strip.Color(0, 0, 255));  
  //meteor(20);
  //delay(500);
  
  switch(showPattern)
  {
   case 0: meteor(20); showPattern = -1; break;
   case 1: fadePurpleGold(); showPattern = -1; break;
   case 2: marchRedWhiteBlue(); showPattern = -1; break;
   case 3: shootColor(strip.Color(155, 0, 255)); showPattern = -1; break;
  default:    solidColor(strip.Color(0, 0, 0));
  strip.show(); showPattern = -1; break;

  }
  
  //marchRedWhiteBlue();
//  delay(500);
  //fadePurpleGold();
  //delay(500);
  //solidColor(strip.Color(0, 0, 0));
  //strip.show();
  delay(50);
  
}



// function that executes whenever data is received from master
// this function is registered as an event, see setup()
void receiveEvent(int howMany)
{
  static uint8_t ct = 0;
  int x = Wire.read();
  showPattern = x;
}

void marchRedWhiteBlue()
{
  uint32_t colors[] = { strip.Color(255,0,0), strip.Color(0,0,255), strip.Color(155,155,155) };
  // Turn everything black
  solidColor(strip.Color(0, 0, 0));
  
  int frame = 0;
  
  while( frame < 50 ) {
    for (int index = 0;index<strip.numPixels();index++)
    {
      //strip.setPixelColor((index  + (frame % 15)) % 60, colors[ ((index)/5 + frame) % 3 ]);
      strip.setPixelColor((index + frame) % 60 , colors[ ((index)/5) % 3 ]);
    }
    strip.show();
    delay(50);
    frame++;
  }
  
}

uint32_t fadeColor( int r1, int g1, int b1, int r2, int g2, int b2, float weight )
{
  float r = r1 * weight + r2 * (1.0f - weight);
  float g = g1 * weight + g2 * (1.0f - weight);  
  float b = b1 * weight + b2 * (1.0f - weight);
  
//  float brightMod = 0.8f + pow(abs(weight-0.5f), 0.5f);
  float brightMod = 1;
  uint8_t r_byte = r * brightMod;
  uint8_t g_byte = g * brightMod;
  uint8_t b_byte = b * brightMod;
  
  return strip.Color(r_byte, g_byte, b_byte);
}

void fadePurpleGold()
{
  float z = 0.0f;
  
  while ( z < 55 ) {
    
  solidColor(fadeColor(80, 38, 107, 200, 143, 0, sin(z) / 2.0f + 0.5f));  
  
  strip.show();
  
  //delay(45);
  delay((abs(sin(z))*8)+1);
  z+= 0.01f;
  }
}

void shootColor(uint32_t color)
{
  colorSwipe(color, 6);
/*  for(int x=0; x<strip.numPixels()-6; x++){
    solidColor(strip.Color(0, 0, 0));
    for(int i=0; i<6; i++){
      strip.setPixelColor(i+x, uint32_t color);
    }
    strip.show();
    delay(3);
  } */
  solidColor(strip.Color(0, 0, 0));
  strip.show();
  delay(500);
  solidColor(strip.Color(50, 0, 0));
  strip.show();
  delay(500);
  solidColor(strip.Color(50, 50, 50));
  strip.show();
  delay(500);
  solidColor(strip.Color(0, 0, 50));
  strip.show();
  delay(500);
    
  solidColor(strip.Color(0, 0, 0));
  strip.show();
  delay(500);
}

void solidColor(uint32_t c){
    for(uint16_t i=0; i<strip.numPixels(); i++) {
      strip.setPixelColor(i, c);
      
    }
}

// Fill the dots one after the other with a color
void colorWipe(uint32_t c, uint8_t wait) {
  for(uint16_t i=0; i<strip.numPixels(); i++) {
      strip.setPixelColor(i, c);
      strip.show();
      delay(wait);
  }
}

// Run the length of the strip one light at a time
void colorSwipe(uint32_t color, uint8_t wait) {
  for(int i = 0; i <= strip.numPixels(); i++) {
    // going out of bounds does not break things, so checks removed for readability
    // clean up behind it
    strip.setPixelColor(i-1, 0); 
    //if (i < strip.numPixels()) 
    strip.setPixelColor(i, color);
    strip.show();
    delay(wait);
  }
}

void meteor(uint8_t wait) {
  uint32_t colors[] = { 
    strip.Color(255,255,255), 
    strip.Color(155,155,155), 
    strip.Color( 99, 99, 99), 
    strip.Color( 77, 50, 50), 
    strip.Color( 55, 20, 20) ,
    strip.Color( 33,  0,  0) 
  };
  // get array size
  int numColors (sizeof(colors)/sizeof(uint32_t));

  for(int i = 0; i < strip.numPixels() + numColors; i++) {
    solidColor(strip.Color(0, 0, 0));
    for (int c = 0; c < numColors; c++)
    {
      strip.setPixelColor(i-c, colors[c]);
    }
    strip.show();
    delay(wait);
  }
}

void rainbow(uint8_t wait) {
  uint16_t i, j;

  for(j=0; j<256; j++) {
    for(i=0; i<strip.numPixels(); i++) {
      strip.setPixelColor(i, Wheel((i+j) & 255));
    }
    strip.show();
    delay(wait);
  }
}

// Slightly different, this makes the rainbow equally distributed throughout
void rainbowCycle(uint8_t wait) {
  uint16_t i, j;

  for(j=0; j<256*5; j++) { // 5 cycles of all colors on wheel
    for(i=0; i< strip.numPixels(); i++) {
      strip.setPixelColor(i, Wheel(((i * 256 / strip.numPixels()) + j) & 255));
    }
    strip.show();
    delay(wait);
  }
}

// Input a value 0 to 255 to get a color value.
// The colours are a transition r - g - b - back to r.
uint32_t Wheel(byte WheelPos) {
  if(WheelPos < 85) {
   return strip.Color(WheelPos * 3, 255 - WheelPos * 3, 0);
  } else if(WheelPos < 170) {
   WheelPos -= 85;
   return strip.Color(255 - WheelPos * 3, 0, WheelPos * 3);
  } else {
   WheelPos -= 170;
   return strip.Color(0, WheelPos * 3, 255 - WheelPos * 3);
  }
}

