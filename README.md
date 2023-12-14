# Lattice Gas Automata (LGA)
Key Features:

    LGA Simulation:
    This program employs Lattice Gas Automata principles to model fluid flows. Each lattice cell represents a discrete space where fluid particles interact based on predefined rules, simulating the dynamic behavior of the fluid.

    Initialization with Particle Configurations:
    Users can initialize the simulation by setting the lattice with an initial configuration of fluid particles. This step establishes the starting conditions for the LGCA simulation, influencing the subsequent flow dynamics.

    Fluid Flow Dynamics:
    The LGA evolves over multiple iterations, capturing the dynamic movement of fluid particles. The simulation considers local interactions and collisions, leading to the emergence of macroscopic fluid flow patterns.

    Obstacle Interactions:
    The presence of obstacles in the lattice introduces collision dynamics, causing fluid particles to reflect upon encountering obstacles. This feature enhances the realism of the simulation by mimicking real-world interactions with obstacles.

    Gas Source:
    Introducing an additional feature, the program includes a gas source that injects particles into the lattice at specified intervals. This allows users to study the impact of a continuous gas source on fluid flow patterns and behavior within the lattice structure.


Sample Results:

**Example 1:**

Fixed amount of particles.<br>
Size: 375x375

Initial State:<br>
![obraz](https://github.com/DominikSabat/Lattice-Gas-Automata/assets/60387429/8c4bb5f0-a747-4745-a18d-79fb06629321)

Iteration 350:<br>
![obraz](https://github.com/DominikSabat/Lattice-Gas-Automata/assets/60387429/18b352c1-512a-43b3-bf54-56eb2d2f076a)

Iteration 700:<br>
![obraz](https://github.com/DominikSabat/Lattice-Gas-Automata/assets/60387429/2154c319-0c63-48fc-9294-fc9e095ddce8)

Iteration 2000:<br>
![obraz](https://github.com/DominikSabat/Lattice-Gas-Automata/assets/60387429/0d376e6a-1a41-407a-8a89-b1a1e5c019be)

**Example 2**

No fixed amount of particles, source spawns new particles every iteration<br>
Size: 375x375

Initial State:<br>
![obraz](https://github.com/DominikSabat/Lattice-Gas-Automata/assets/60387429/109f0fb9-a4e1-4283-8d79-b4c1e2cc29d5)

Iteration 350:<br>
![obraz](https://github.com/DominikSabat/Lattice-Gas-Automata/assets/60387429/51050058-7e54-4670-9a87-368afdc3aa6b)

Iteration 700:<br>
![obraz](https://github.com/DominikSabat/Lattice-Gas-Automata/assets/60387429/0e841edf-62d7-4d63-9c2b-957703bcf7c3)

Iteration 2000:<br>
![obraz](https://github.com/DominikSabat/Lattice-Gas-Automata/assets/60387429/e4458e62-7423-430d-af00-40f5df5523cf)

Iteration 8000:<br>
![obraz](https://github.com/DominikSabat/Lattice-Gas-Automata/assets/60387429/a6713964-edbd-4e2b-a52c-a45b2a2c9b46)

Iteration 50000:<br>
![obraz](https://github.com/DominikSabat/Lattice-Gas-Automata/assets/60387429/52c86571-e725-4d2e-b496-30fcc67d6aca)

Compatibility:
- The program is developed in Java Swing, ensuring compatibility across different platforms.
