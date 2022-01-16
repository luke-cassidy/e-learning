#pragma once

#include "Particle.h"

namespace caveofprogramming {

	class Swarm
	{
	public:
		const static int NPARTICLES = 5000;
	private:
		 Particle* m_pParticles;
	public:
		Swarm();
		~Swarm();

		const Particle* const getParticles() { return m_pParticles; };
		void update();
	};

}
