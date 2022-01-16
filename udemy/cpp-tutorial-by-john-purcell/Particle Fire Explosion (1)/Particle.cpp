#include "Particle.h"
#include <stdlib.h>
#include <math.h>
#include "Screen.h"

namespace caveofprogramming {

	Particle::Particle() : m_x(0), m_y(0)
	{
		m_direction = (2.0*M_PI*rand()) / RAND_MAX;
		m_speed = (0.0001*rand()) / RAND_MAX;
	}

	Particle::~Particle()
	{
	}

	void Particle::update(int interval) 
	{

		double x_speed = m_speed*cos(m_direction);
		double y_speed = m_speed*sin(m_direction);

		m_x += x_speed * interval;
		m_y += y_speed * interval;

	}
}
