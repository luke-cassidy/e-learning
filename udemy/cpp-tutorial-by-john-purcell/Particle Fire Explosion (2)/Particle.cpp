#include "Particle.h"
#include <stdlib.h>
#include <math.h>
#include "Screen.h"

namespace caveofprogramming {

	Particle::Particle()
	{
		init();
	}

	Particle::~Particle()
	{
	}

	void Particle::init()
	{
		m_x = 0;
		m_y = 0;

		m_direction = (2.0*M_PI*rand()) / RAND_MAX;
		m_speed = (0.02*rand()) / RAND_MAX;

		m_speed = pow(m_speed, 2);
	}

	void Particle::update(int interval)
	{
		m_direction += 0.0002*interval;

		double x_speed = m_speed*cos(m_direction);
		double y_speed = m_speed*sin(m_direction);

		m_x += x_speed * interval;
		m_y += y_speed * interval;

		if (m_x < -1 || m_x > 1 || m_y < -1 || m_y > 1)
		{
			init();
		}

		if (rand() < RAND_MAX / 100)
		{
			init();
		}
	}
}
