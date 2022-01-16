#include <iostream>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <SDL.h>
#include "Screen.h"
#include "Swarm.h"

using namespace std;
using namespace caveofprogramming;

int main(int argc, char* argv[]) {

	srand((unsigned int)(time(NULL)));

	Screen screen;

	if (screen.init() == false) {
		cout << "Error initializing SDL: " << SDL_GetError << endl;
	}

	Swarm swarm;

	while (true) {
		//update particles
		//draw particles

		screen.clear();
		swarm.update();

		int elapsed = SDL_GetTicks();
		unsigned char red = (unsigned char)((sin(elapsed * 0.001) + 1) * 127.5);
		unsigned char green = (unsigned char)((sin(elapsed * 0.002) + 1) * 127.5);
		unsigned char blue = (unsigned char)((sin(elapsed * 0.003) + 1) * 127.5);

		const Particle* const pParticles = swarm.getParticles();

		for (int i = 0; i < Swarm::NPARTICLES; i++) {

			int x = ((pParticles[i].m_x) + 1) * Screen::SCREEN_WIDTH / 2;
			int y = ((pParticles[i].m_y) + 1) * Screen::SCREEN_HEIGHT / 2;

			screen.setPixel(x, y, blue, red, green);
		}

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