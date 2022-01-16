#pragma once

namespace caveofprogramming {

	class Particle
	{
	public:
		double m_x;
		double m_y;

		double m_xSpeed;
		double m_ySpeed;

	public:
		Particle();
		~Particle();
		void update();
	};

}
