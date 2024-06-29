# Island Simulation Application 🌴🐾

This project is a comprehensive island simulation application developed using Java. It simulates an ecosystem where animals and plants interact based on predefined behaviors and environmental factors.

## Table of Contents

- [Technologies Used](#technologies-used) 🛠️
- [Services](#services) 🚀
- [Scheduled Jobs](#scheduled-jobs) 🕒
- [Configuration](#configuration) 📝
- [Creature Types](#creature-types) 🐻
- [Features](#features) ✨
- [Getting Started](#getting-started) 🚀
- [Contributing](#contributing) 🤝
- [License](#license) 📜

---

## Technologies Used 🛠️

- **MVC Pattern**: Used for developing user interfaces that divides the related program logic into three interconnected elements..
- **Factory Pattern**: Used to instantiate various types of animals and plants based on input parameters.
- **Lightweight (or Dependency Injection) Pattern**: Utilized throughout the application for managing component dependencies.
- **Strategy Pattern**: Implemented for defining behaviors (e.g., eating, moving) that can vary independently.
- **Microservice Architecture**: Structured as a set of loosely coupled services interacting through APIs.
- **YAML Configuration**: Configuration settings for simulation parameters (e.g., Eating chance) are defined in YAML file (`eatConfig.yml`).
- **Configuration JSON**: Configuration settings for simulation parameters (e.g., game settings, field characteristics, animals and plant parameters) are defined in JSON files (`animals.json`,`game.json`, `plants.json`, `map.json`).
- **DTOs (Data Transfer Objects)**: Used to transfer data between layers, ensuring clean separation of concerns.
- **Controllers**: RESTful endpoints defined using Spring MVC for handling HTTP requests and responses.
- **Animal and Plant Class Hierarchy**: Object-oriented design with inheritance and polymorphism to model different types of animals and plants.
- **Enums**: Used to represent types (e.g., HerbivoreType, PlantType) and categories in a type-safe manner.
- **Scheduler**: Integrated for scheduling tasks (e.g., simulation updates, feeding cycles).

---

## Services 🚀

- **ReproduceService**: Manages animal reproduction cycles based on predefined rules and environmental conditions.
- **AliveObjectFactory**: Provides method to create alive objects.
- **FeedService**: Handles feeding behaviors of animals, including interactions with plants and other animals.
- **MovingService**: Manages the moving of animals by field.
- **ConfigReader**: Util service that read parameters in configs files.
- **ViewService**: Generates graphical symbols (e.g., emojis) for displaying animals in the simulation UI.
- **FinalizerTaktService**: Checks that this creature is alive and do  acomplete logic for end takt.
- **WorldGenerator && FillAnimalsService**: Generate game field and fill it by Creatures.
- **GrowService**: Controls growth of plants within the simulation environment.
- **CountAliveObjectsInCellService**: Utility service for count number of same creature type in cell.

---

## Scheduled Jobs 🕒

- **GrowService**: Scheduled task managing grow plants in random cell.

---


## Configuration 📝

### `eatChance.yml`

File containing configurable characteristics of chance that animal will it creature.

### `animals.json`

Configuration file that contains all characteristic of animals.

### `game.json`

Configuration file that main parameters of game for example time for plants grow.

### `plants.json`

Configuration file that contains all characteristic of plants.

### `map.json`

Configuration file that contains characteristic of game field.


---

## Animal Types 🐻

- **Predators**: Bear, Boa, Eagle, Fox, Wolf
- **Plants**: Grass, Tree, Mushroom
- **Herbivores**: Buffalo, Caterpillar, Deer, Horse, Mouse, Sheep, Rabbit, Boar, Duck, Goat, Frog

---

## Features ✨

- Simulates an ecosystem with animals and plants interacting dynamically.
- Customizable simulation parameters via configuration files.
- Scheduled tasks for automated management of simulation elements.

---

## Getting Started 🚀

To run the simulation locally:

1. Clone the repository.
2. Configure `application.yml` and `animalCharacteristics.yml` to adjust simulation parameters if needed.
3. Run the application.

---

## Contributing 🤝

Contributions are welcome! Feel free to fork the repository and submit pull requests to suggest improvements or add new features.

---

## License 📜

This project is licensed under the [MIT License](LICENSE).
