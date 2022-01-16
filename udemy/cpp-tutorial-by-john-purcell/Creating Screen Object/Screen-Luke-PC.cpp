#include "Screen.h"

namespace caveofprogramming {

	Screen::Screen() : m_window(NULL), m_renderer(NULL), m_texture(NULL), m_buffer(NULL) {
	}

	bool Screen::init() {

		if (SDL_Init(SDL_INIT_VIDEO) < 0) {
			return false;
		}

		m_window = SDL_CreateWindow("Particle Fire Explosion",
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

		m_buffer = new Uint32[SCREEN_WIDTH*SCREEN_HEIGHT];

		return true;
	}

	void Screen::setPixel(int x, int y, Uint8 red, Uint8 green, Uint8 blue) {

		Uint32 colour = 0;

		colour += red;
		colour <<= 8;
		colour += green;
		colour <<= 8;
		colour += blue;
		colour <<= 8;
		colour += 0xFF;

		m_buffer[(SCREEN_WIDTH * y) + x] = colour;
	}

	void Screen::update() {

		SDL_UpdateTexture(m_texture, NULL, m_buffer, SCREEN_WIDTH * sizeof(Uint32));
		SDL_RenderClear(m_renderer);
		SDL_RenderCopy(m_renderer, m_texture, NULL, NULL);
		SDL_RenderPresent(m_renderer);
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
		delete[] m_buffer;
		SDL_DestroyTexture(m_texture);
		SDL_DestroyRenderer(m_renderer);
		SDL_DestroyWindow(m_window);
		SDL_Quit();
	}

}
