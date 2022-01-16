#pragma once

#include "Particle.h"

namespace caveofprogramming {

	class Swarm
	{
	public:
		const static int NPARTICLES = 5000;
	private:
		 Particle* m_pParticles;
		 int lastTime;
	public:
		Swarm();
		~Swarm();

		Particle* getParticles() { return m_pParticles; };
		void update(int elapsed);
	};

}
