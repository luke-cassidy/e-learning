#include "Screen.h"
#include <iostream>

namespace caveofprogramming {

	Screen::Screen() : m_window(NULL), m_renderer(NULL), m_texture(NULL), m_buffer1(NULL), m_buffer2(NULL) {
	}

	bool Screen::init() {

		if (SDL_Init(SDL_INIT_VIDEO) < 0) {
			return false;
		}

		m_window = SDL_CreateWindow("Supernova Explosion",
			SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED,
			SCREEN_WIDTH, SCREEN_HEIGHT, SDL_WINDOW_SHOWN);

		if (m_window == NULL) {
			SDL_Quit();
			return false;
		}

		m_renderer = SDL_CreateRenderer(m_window,
			-1, SDL_RENDERER_PRESENTVSYNC);
		m_texture = SDL_CreateTexture(m_renderer,
			SDL_PIXELFORMAT_RGBA8888, SDL_TEXTUREACCESS_STATIC,
			SCREEN_WIDTH, SCREEN_HEIGHT);

		if (m_renderer == NULL) {
			SDL_DestroyWindow(m_window);
			SDL_Quit();
			return false;
		}

		if (m_texture == NULL) {
			SDL_DestroyRenderer(m_renderer);
			SDL_DestroyWindow(m_window);
			SDL_Quit();
			return false;
		}

		m_buffer1 = new Uint32[SCREEN_WIDTH*SCREEN_HEIGHT];
		m_buffer2 = new Uint32[SCREEN_WIDTH*SCREEN_HEIGHT];

		memset(m_buffer1, NULL, SCREEN_HEIGHT*SCREEN_WIDTH * sizeof(Uint32));
		memset(m_buffer2, NULL, SCREEN_HEIGHT*SCREEN_WIDTH * sizeof(Uint32));


		return true;
	}

	void Screen::setPixel(int x, int y, Uint8 red, Uint8 green, Uint8 blue) {

		if (x < 0 || x >= SCREEN_WIDTH || y < 0 || y >= SCREEN_HEIGHT)
		{
			return;
		}

		Uint32 colour = 0;

		colour += red;
		colour <<= 8;
		colour += green;
		colour <<= 8;
		colour += blue;
		colour <<= 8;
		colour += 0xFF;

		m_buffer1[(SCREEN_WIDTH * y) + x] = colour;

	}

	void Screen::boxBlur() {
		Uint32* temp = m_buffer1;
		m_buffer1 = m_buffer2;
		m_buffer2 = temp;

		for (int y = 0; y < SCREEN_HEIGHT; y++) {
			for (int x = 0; x < SCREEN_WIDTH; x++) {

				int writeRed = NULL;
				int writeGreen = NULL;
				int writeBlue = NULL;

				for (int row = -1; row <= 1; row++) {
					for (int col = -1; col <= 1; col++) {

						int currentX = x + col;
						int currentY = y + row;

						if (currentX >= 0 && currentX < SCREEN_WIDTH && currentY >= 0 && currentY < SCREEN_HEIGHT) {

							Uint32 readColour = m_buffer2[(currentY*SCREEN_WIDTH + currentX)];

							Uint8 readRed = (0xFF000000 & readColour) >> 24;
							Uint8 readGreen = (0x00FF0000 & readColour) >> 16;
							Uint8 readBlue = (0x0000FF00 & readColour) >> 8;

							writeRed += readRed;
							writeGreen += readGreen;
							writeBlue += readBlue;
						}
					}
				}

				Uint8 red = writeRed / 9.0;
				Uint8 green = writeGreen / 9.0;
				Uint8 blue = writeBlue / 9.0;

				setPixel(x, y, red, green, blue);
			}
		}

	}

	void Screen::update() {

		SDL_UpdateTexture(m_texture, NULL, m_buffer1, SCREEN_WIDTH * sizeof(Uint32));
		SDL_RenderClear(m_renderer);
		SDL_RenderCopy(m_renderer, m_texture, NULL, NULL);
		SDL_RenderPresent(m_renderer);
	}

	void Screen::clear() {
		memset(m_buffer1, NULL, SCREEN_HEIGHT*SCREEN_WIDTH * sizeof(Uint32));
		memset(m_buffer2, NULL, SCREEN_HEIGHT*SCREEN_WIDTH * sizeof(Uint32));
	}

	bool Screen::processEvents() {
		SDL_Event event;

		if (SDL_PollEvent(&event)) {
			if (event.type == SDL_QUIT) {
				return false;
			}
		}
		return true;
	}

	void Screen::close() {
		delete[] m_buffer1;
		delete[] m_buffer2;
		SDL_DestroyTexture(m_texture);
		SDL_DestroyRenderer(m_renderer);
		SDL_DestroyWindow(m_window);
		SDL_Quit();
	}

}
