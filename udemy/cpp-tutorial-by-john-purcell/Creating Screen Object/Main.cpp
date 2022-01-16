#include <iostream>
#include <SDL.h>
#include <math.h>
#include "Screen.h"
using namespace std;
using namespace caveofprogramming;

int main(int argc, char* argv[]) {

	Screen screen;

	if (screen.init() == false) {
		cout << "Error initializing SDL: " << SDL_GetError << endl;
	}


	while (true) {
		//update particles
		//draw particles

		int elapsed = SDL_GetTicks();
		unsigned char red = (unsigned char)((sin(elapsed * 0.001) + 1) * 127.5);
		unsigned char green = (unsigned char)((sin(elapsed * 0.002) + 1) * 127.5);
		unsigned char blue = (unsigned char)((sin(elapsed * 0.003) + 1) * 127.5);


		for (int y = 0; y < Screen::SCREEN_HEIGHT; y++) {
			for (int x = 0; x < Screen::SCREEN_WIDTH; x++) {
				screen.setPixel(x, y, red, green, blue);
			}
		}

		screen.setPixel(400, 300, 255, 255, 255);

		//draw the screen

		screen.update();

		//check for messages/events

		if (screen.processEvents() == false) {
			break;
		}
	}

	screen.close();

	return 0;
}