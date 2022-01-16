#include "Particle.h"
#include <stdlib.h>
#include "Screen.h"

namespace caveofprogramming {

	Particle::Particle(): m_x(0.0), m_y(0.0)
	{

		m_xSpeed = 0.01*(((2.0 * rand()) / RAND_MAX) - 1);
		m_ySpeed = 0.01*(((2.0 * rand()) / RAND_MAX) - 1);
	}


	Particle::~Particle()
	{
	}

	void Particle::update() {

		m_x += Particle::m_xSpeed;
		m_y += Particle::m_ySpeed;

		if (m_x <= -1.0 || m_x >= 1.0)
		{
			m_xSpeed = -m_xSpeed;
		}

		if (m_y <= -1.0 || m_y >= 1.0)
		{
			m_ySpeed = -m_ySpeed;
		}
	}
}
